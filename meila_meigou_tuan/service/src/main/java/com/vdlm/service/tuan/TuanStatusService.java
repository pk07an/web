package com.vdlm.service.tuan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.meila.dal.slave.dao.TuanActivitySlaveDao;
import com.meila.dal.slave.dao.TuanOrderSlaveDao;
import com.meila.dal.slave.dao.TuanStatusSlaveDao;
import com.meila.meigou.cachehelper.RedisAdapter;
import com.vdlm.dal.model.TuanActivity;
import com.vdlm.dal.model.TuanOrder;
import com.vdlm.dal.model.TuanStatus;
import com.vdlm.dal.status.OrderStatus;
import com.vdlm.meila.client.MeilaClient;
import com.vdlm.meila.client.MeilaUser;
import com.vdlm.service.tuan.status.TuanType;
import com.vdlm.service.tuan.status.UserTuanCode;
import com.vdlm.service.tuan.vo.TuanActivityVo;
import com.vdlm.service.tuan.vo.TuanInfoVo;
import com.vdlm.service.tuan.vo.TuanJoinStatusVo;
import com.vdlm.service.tuan.vo.TuanUserVo;

/**
 * ***********************************************************
 * 
 * @类名 : TuanStatusService
 *
 * @DESCRIPTION : 团购状态页面拼装
 * @AUTHOR : Dan
 * @DATE : 2016-03-02 ***********************************************************
 */
@Service
public class TuanStatusService {

    @Autowired
    private TuanStatusSlaveDao tuanStatusSlaveDao;

    @Autowired
    private TuanOrderSlaveDao tuanOrderSlaveDao;

    @Autowired
    private TuanActivitySlaveDao tuanActivitySlaveDao;

    @Autowired
    private MeilaClient meilaClient;

    @Autowired
    private TuanActivityService tuanActivityService;
    @Value("${tuan.majia.user.id:''}")
    private String maJiaUserIds;

    @Autowired
    private RedisAdapter redisAdapter;

    /**
     * 拼装页面数据
     * 
     * @param tuanNo
     * @return
     */
    public TuanInfoVo assemblyGroupBuying(String tuanNo, Long userId) {
        TuanInfoVo tuanInfoVo = new TuanInfoVo();
        // 获取团信息,如果获取不到则返回不正确
        TuanStatus tuanStatus = tuanStatusSlaveDao.selectTuanStatusByTuanNo(tuanNo);
        if (tuanStatus == null) {
            throw new RuntimeException("找不到团");
        }
        // 是否已过期
        if (isEnd(tuanStatus)) {
            tuanInfoVo.setExpire(true);
        }

        TuanActivity tuanActivity = tuanActivitySlaveDao.selectById(tuanStatus.getActId());
        if (tuanActivity == null) {
            throw new RuntimeException("找不到活动");
        }

        List<TuanOrder> orders = tuanOrderSlaveDao.findTuanOrder(tuanStatus.getId());
        // 排序，按订单生成时间从先到后排
        Collections.sort(orders, new Comparator<TuanOrder>() {

            @Override
            public int compare(TuanOrder o1, TuanOrder o2) {
                int value = 0;
                if (o1.getCreatedAt().equals(o2.getCreatedAt())) {
                    value = 0;
                } else if (o1.getCreatedAt().before(o2.getCreatedAt())) {
                    value = -1;
                } else {
                    value = 1;
                }
                return value;
            }
        });
        // 人数是否已满
        if (orders.size() >= tuanStatus.getMemberNum()) {
            tuanInfoVo.setMemberFull(true);
        }

        // 如果已经到期并且为马甲模式的
        if (tuanInfoVo.getIsExpire() && TuanType.MAJIA.name().equals(tuanStatus.getTuanType())) {
            for (TuanOrder tuanOrder : orders) {
                // 如果存在支付的订单，视为拼团成功
                if (OrderStatus.PAID.name().equals(tuanOrder.getOrderStatus()) || OrderStatus.PART_SHIPPED.name().equals(tuanOrder.getOrderStatus())
                        || OrderStatus.SHIPPED.name().equals(tuanOrder.getOrderStatus())
                        || OrderStatus.SUCCESS.name().equals(tuanOrder.getOrderStatus())) {
                    tuanInfoVo.setMemberFull(true);
                    break;
                }
            }
        }

        boolean joinIn = false;
        // 订单状态
        String orderStatus = "";
        if (userId != 0 && userId != null) {
            // 1.检查是否团长
            if (userId.equals(tuanStatus.getUserId())) {
                tuanInfoVo.setChief(true);
            }

            // 2. 除已取消的订单，找到当前团参加的订单记录
            TuanOrder currentTuanOrder = tuanOrderSlaveDao.findOrderByUserNotInCancelled(tuanStatus.getId(), userId);

            if (null != currentTuanOrder) {
                joinIn = true;
                tuanInfoVo.setPayNo(currentTuanOrder.getPayNo());
                orderStatus = currentTuanOrder.getOrderStatus();
            }

            // 3.是否已支付
            if (isPaid(currentTuanOrder)) {
                tuanInfoVo.setPaid(true);
            }
        }

        // 设置团的状态
        this.assemblyMessage(tuanInfoVo, joinIn, orderStatus);
        this.createGroupBuyingStatus(tuanStatus.getId(), tuanInfoVo, tuanStatus, tuanActivity, orders);

        return tuanInfoVo;
    }

    private void assemblyMessage(TuanInfoVo tuanInfoVo, boolean joinIn, String orderStatus) {
        boolean isChief = tuanInfoVo.getIsChief();
        boolean isExpire = tuanInfoVo.getIsExpire();
        boolean isPaid = tuanInfoVo.getIsPaid();
        boolean isMemberFull = tuanInfoVo.getIsMemberFull();
        // boolean isOversold = tuanInfoVo.getIsOversold();

        if (isChief) {

            if (isPaid) {
                if (isExpire) {
                    // 团已到期情况
                    if (isMemberFull) {
                        // 如果已经满团，代表成团
                        // ================开团人拼团成功================
                        tuanInfoVo.setUserStatus(UserTuanCode.CHIEF_SUCCESS.name());
                        return;
                    } else {
                        // ================本人已开团，该团已过期，退款中================
                        if (OrderStatus.REFUNDING.name().equals(orderStatus)) {
                            tuanInfoVo.setUserStatus(UserTuanCode.CHIEF_REFUNDING.name());
                            return;
                        } else if (OrderStatus.CLOSED.name().equals(orderStatus)) {
                            // ================ 本人已开团，该团已过期，已退款================
                            tuanInfoVo.setUserStatus(UserTuanCode.CHIEF_REFUNDED.name());
                        } else {
                            // ================本人已开团，该团已过期，待确认退款================
                            tuanInfoVo.setUserStatus(UserTuanCode.CHIEF_REUND_WAIT.name());
                        }
                    }
                } else {
                    // 团未已过期
                    if (isMemberFull) {
                        // ================开团人拼团成功================
                        tuanInfoVo.setUserStatus(UserTuanCode.CHIEF_SUCCESS.name());
                        return;
                    } else {
                        // ================ 开团成功，未满员================
                        tuanInfoVo.setUserStatus(UserTuanCode.CHIEF_PROCESS.name());
                        return;
                    }
                }
            } else {
                if (joinIn) {
                    // 已参加,但未支付，代表订单还没有被取消
                    // 未支付情况
                    if (isExpire) {
                        // ================团长开团，没有支付，订单被取消了================
                        tuanInfoVo.setUserStatus(UserTuanCode.CHIEF_CANCEL.name());
                        return;
                    } else {
                        // ================开团人已开团，但是未支付================
                        tuanInfoVo.setUserStatus(UserTuanCode.CHIEF_UNPAID.name());
                        return;
                    }
                } else {
                    // 未参加，也没有支付，代表订单已取消
                    // 已过期
                    // ================团长开团，没有支付，订单被取消了================
                    tuanInfoVo.setUserStatus(UserTuanCode.CHIEF_CANCEL.name());
                    return;
                }

            }
        } else {
            // 不是团长参团状态
            if (joinIn) {
                // 已参加
                if (isExpire) {
                    // 已过期
                    if (isPaid) {
                        // 已支付
                        if (isMemberFull) {
                            // 满团代表成团
                            tuanInfoVo.setUserStatus(UserTuanCode.MEMBER_SUCCESS.name());
                            return;
                        } else {
                            // 还没满团，无法成团，参团失败

                            // ================参团人已支付，但支付时该团已过期，待确认退款================
                            if (OrderStatus.REFUNDING.name().equals(orderStatus)) {
                                tuanInfoVo.setUserStatus(UserTuanCode.MEMBER_EXPIRE_REFUNDING.name());
                                return;
                            } else if (OrderStatus.CLOSED.name().equals(orderStatus)) {
                                // ================参团人已支付，但支付时该团已过期，已退款================
                                tuanInfoVo.setUserStatus(UserTuanCode.MEMBER_EXPIRE_REFUNDED.name());
                                return;
                            } else {
                                // ================参团人已支付，但支付时该团已过期，待确认退款================
                                tuanInfoVo.setUserStatus(UserTuanCode.MEMBER_EXPIRE_REFUND_WAIT.name());
                                return;
                            }
                        }
                    } else {
                        // 未支付
                        if (isMemberFull) {
                            // 已满团，当前无法参团
                            tuanInfoVo.setUserStatus(UserTuanCode.MEMBER_FULL_UNJOIN.name());
                            return;
                        } else {
                            // 代表不成团
                            // =======================参团者，已生成订单，未支付，并且团过期=============================
                            tuanInfoVo.setUserStatus(UserTuanCode.MEMBER_EXPIRE_JOIN.name());
                            return;
                        }

                    }
                } else {
                    // 未过期
                    if (isPaid) {
                        // 已支付
                        if (isMemberFull) {
                            // 满团，代表提早成团
                            tuanInfoVo.setUserStatus(UserTuanCode.MEMBER_SUCCESS.name());
                            return;
                        } else {
                            // 未满图，代表拼团进行中
                            // =======================参团成功，未满员=============================
                            tuanInfoVo.setUserStatus(UserTuanCode.MEMBER_PROCESS_JOIN.name());
                            return;
                        }
                    } else {
                        // 未支付
                        if (isMemberFull) {
                            // 已满团，当前无法参团
                            tuanInfoVo.setUserStatus(UserTuanCode.MEMBER_FULL_UNJOIN.name());
                            return;
                        } else {
                            // 未满团，可以加入，需要支付
                            // =======================参团人已参团，但是未支付=============================
                            tuanInfoVo.setUserStatus(UserTuanCode.MEMBER_PROCESS_UNPAID.name());
                            return;
                        }
                    }
                }
            } else {
                // 未参加
                if (isMemberFull) {
                    // 团已满，代表提前成团，已不可以再参加
                    // ================团已满员，但参团者未参团================
                    tuanInfoVo.setUserStatus(UserTuanCode.MEMBER_FULL_UNJOIN.name());
                    return;
                } else {
                    // 团未满
                    if (isExpire) {
                        // 已过期
                        // ================团已过期，但参团者未参团================
                        tuanInfoVo.setUserStatus(UserTuanCode.MEMBER_EXPIRE_UNJOIN.name());
                        return;
                    } else {
                        // 未过期
                        // 团可以参加
                        // ================已开团，团进行中，但是未登录态================
                        // ================已开团，团进行中，但是参团人未参团================
                        tuanInfoVo.setUserStatus(UserTuanCode.MEMBER_PROCESS_UNJOIN.name());
                        return;
                    }
                }
            }
        }
    }

    /**
     * 
     *
     * 功能描述：判断该团是否已结束
     * 
     * @param tuanStatus
     * @return boolean
     *
     */
    private boolean isEnd(TuanStatus tuanStatus) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(tuanStatus.getStartTime());
        calendar.add(Calendar.HOUR, tuanStatus.getAliveTime());
        Date endDate = calendar.getTime();
        // 团状态为成功，取消，或者进行中但当前时间在结束时间之后的，视为这个团已经结束
        if (tuanStatus.getStatus().equals("SUCCESS") || tuanStatus.getStatus().equals("CANCEL")
                || endDate.before(new Date()) && tuanStatus.getStatus().equals("PROCESS")) {
            return true;
        }
        return false;
    }

    private boolean isPaid(TuanOrder currentTuanOrder) {
        if (currentTuanOrder == null) {
            return false;
        }
        // 不是待支付或者已取消，视为已支付过
        if (!OrderStatus.SUBMITTED.name().equals(currentTuanOrder.getOrderStatus())
                && !OrderStatus.CANCELLED.name().equals(currentTuanOrder.getOrderStatus())) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param groupBuyingId
     * @param tuanInfoVo
     * @param tuanStatus
     * @param userCode 团长的id
     * @param tuanActivity
     * @param orders 该团下拥有的订单
     */
    private void createGroupBuyingStatus(Long groupBuyingId, TuanInfoVo tuanInfoVo, TuanStatus tuanStatus, TuanActivity tuanActivity,
        List<TuanOrder> orders) {
        TuanActivityVo tuanActivityVo = new TuanActivityVo();
        BeanUtils.copyProperties(tuanActivity, tuanActivityVo);
        tuanActivityService.initTuanActStatus(tuanActivity, tuanActivityVo);
        // 状态页里的成团人数应该取团记录里的成团人数，即时开团后后台人员把活动的成团人数改了
        tuanActivityVo.setMemberNum(tuanStatus.getMemberNum());
        tuanInfoVo.setProductInfo(tuanActivityVo);

        List<TuanUserVo> tuanUserVos = new ArrayList<TuanUserVo>();

        Set<String> joinUserId = new HashSet<String>();
        Map<String, String> userRoleMap = new HashMap<String, String>();
        final Map<String, Date> userPaidMap = new HashMap<String, Date>();
        for (TuanOrder tuanOrder : orders) {
            joinUserId.add(String.valueOf(tuanOrder.getUserId()));
            userRoleMap.put(String.valueOf(tuanOrder.getUserId()), tuanOrder.getRole());
            userPaidMap.put(String.valueOf(tuanOrder.getUserId()), tuanOrder.getPaidAt());
        }

        if (TuanType.MAJIA.name().equals(tuanStatus.getTuanType()) && orders.size() < tuanStatus.getMemberNum()
                && (UserTuanCode.MEMBER_SUCCESS.name().equals(tuanInfoVo.getUserStatus())
                        || UserTuanCode.MEMBER_FULL_UNJOIN.name().equals(tuanInfoVo.getUserStatus())
                        || UserTuanCode.CHIEF_SUCCESS.name().equals(tuanInfoVo.getUserStatus()))) {

            int needNum = tuanStatus.getMemberNum() - orders.size();
            Set<String> maJiaUserIdSet = this.getMaJiaUserSet(tuanStatus.getTuanNo(), needNum);
            if (CollectionUtils.isNotEmpty(maJiaUserIdSet)) {
                for (String maJiaUserId : maJiaUserIdSet) {
                    joinUserId.add(maJiaUserId);
                    userRoleMap.put(maJiaUserId, "MEMBER");
                    userPaidMap.put(maJiaUserId, new Date());
                }
            }
        }

        if (CollectionUtils.isNotEmpty(joinUserId)) {
            List<MeilaUser> userList = meilaClient.getUserInfoListFromCache(joinUserId);
            if (CollectionUtils.isNotEmpty(userList)) {
                for (MeilaUser user : userList) {
                    TuanUserVo tuanUserVo = new TuanUserVo();
                    tuanUserVo.setId(user.getId());
                    tuanUserVo.setUserCode(user.getSlug());
                    tuanUserVo.setUserRole(userRoleMap.get(user.getId()));
                    tuanUserVo.setNickName(user.getNickname());
                    tuanUserVo.setUserImg(user.getAvatar());
                    tuanUserVos.add(tuanUserVo);
                }
            }
        }
        // 对用户按支付时间从先到后排序
        Collections.sort(tuanUserVos, new Comparator<TuanUserVo>() {

            @Override
            public int compare(TuanUserVo o1, TuanUserVo o2) {
                Date o1PaidAt = userPaidMap.get(o1.getId());
                Date o2PaidAt = userPaidMap.get(o2.getId());
                long o1Time = null != o1PaidAt ? o1PaidAt.getTime() : 0;
                long o2Time = null != o2PaidAt ? o2PaidAt.getTime() : 0;
                return Long.valueOf((o1Time - o2Time)).intValue();
            }

        });
        tuanInfoVo.setTuanUser(tuanUserVos);
        tuanInfoVo.setTuanAliveTime(Long.valueOf(tuanStatus.getAliveTime()));
        tuanInfoVo.setTuanBeginTime(tuanStatus.getStartTime().getTime());
        tuanInfoVo.setTuanId(groupBuyingId);
        tuanInfoVo.setTuanNo(tuanStatus.getTuanNo());

        // 计算结束时间
        Date endDate = DateUtils.addHours(new Date(tuanInfoVo.getTuanBeginTime()), tuanInfoVo.getTuanAliveTime().intValue());
        long endSec = (endDate.getTime() - System.currentTimeMillis()) / 1000;
        tuanInfoVo.setEndSec(endSec > 0 ? endSec : 0);
    }

    /**
     *
     * 功能描述：非退款模式的时候获取马甲用户id方法
     * 
     * @param tuanNo
     * @param needNum
     * @return Set<String>
     *
     */
    @SuppressWarnings("unchecked")
    public Set<String> getMaJiaUserSet(String tuanNo, int needNum) {
        final String tuanMaJiaUserKey = "TUAN_STATUS_MAJIA_USER_" + tuanNo;
        Set<String> maJiaUserIdSet = new HashSet<String>();
        if (redisAdapter.exists(tuanMaJiaUserKey)) {
            maJiaUserIdSet = redisAdapter.get(tuanMaJiaUserKey, Set.class);
        } else {
            // 如果是 1.非退款模式 2.团实际人数没有满，3.团已经到期
            if (StringUtils.isNotBlank(maJiaUserIds)) {
                String[] maJiaUserArray = maJiaUserIds.split(",");
                if (maJiaUserArray.length >= 2) {
                    String min = maJiaUserArray[0];
                    String max = maJiaUserArray[1];
                    for (int i = 0; i < needNum; i++) {
                        String randomUserId = String.valueOf(RandomUtils.nextInt(Integer.valueOf(min), Integer.valueOf(max)));
                        int count = 0;
                        while (true) {
                            // 10次都找重复的，随便在找一个
                            if (count == 10) {
                                randomUserId = String.valueOf(RandomUtils.nextInt(Integer.valueOf(min), Integer.valueOf(max)));
                                break;
                            }
                            // 如果在马甲列表已经有的，重新取一次
                            if (maJiaUserIdSet.contains(randomUserId)) {
                                randomUserId = String.valueOf(RandomUtils.nextInt(Integer.valueOf(min), Integer.valueOf(max)));
                            } else {
                                // 马甲列表没有的，结束该循环
                                break;
                            }
                            count++;
                        }
                        maJiaUserIdSet.add(randomUserId);
                    }

                    if (CollectionUtils.isNotEmpty(maJiaUserIdSet)) {
                        redisAdapter.set(tuanMaJiaUserKey, maJiaUserIdSet);
                    }
                }
            }
        }
        return maJiaUserIdSet;
    }

    /**
     * 根据id获取记录
     * 
     * @param id
     * @return
     */
    public TuanStatus getTuanStatusById(Long id) {
        return tuanStatusSlaveDao.selectTuanStatus(id);
    }

    /**
     * 
     *
     * 功能描述：获取可参团的列表，如果userId !=0,需要过滤掉自己开的团
     * 
     * @param actId
     * @param limit
     * @param userId
     * @return List<TuanStatus>
     *
     */
    public List<TuanStatus> selectCanJoinTuanListByActId(long actId, int limit, long userId) {
        List<TuanStatus> canJoinTuanStatusList = tuanStatusSlaveDao.selectCanJoinTuanListByActId(actId, limit, userId);
        return canJoinTuanStatusList;
    }

    /**
     * 
     *
     * 功能描述：获取可参团的列表，如果userId !=0,需要过滤掉自己开的团,转化为前端的vo
     * 
     * @param actId
     * @param limit
     * @param userId
     * @return List<TuanJoinStatusVo>
     *
     */
    public List<TuanJoinStatusVo> getCanTuanJoinStatusVo(long actId, int limit, long userId) {
        List<TuanJoinStatusVo> canJoinTuanStatusVoList = new ArrayList<TuanJoinStatusVo>();

        TuanActivity tuanActivity = tuanActivitySlaveDao.selectById(actId);
        if (null == tuanActivity || tuanActivity.getHideJoin()) {
            // 如果找不到活动信息或者设置了隐藏可参团列表
            return canJoinTuanStatusVoList;
        }

        List<TuanStatus> canJoinTuanStatusList = this.selectCanJoinTuanListByActId(actId, limit, userId);
        if (CollectionUtils.isNotEmpty(canJoinTuanStatusList)) {
            Set<String> userIds = new HashSet<String>();
            for (TuanStatus tuanStatus : canJoinTuanStatusList) {
                userIds.add(String.valueOf(tuanStatus.getUserId()));

            }
            List<MeilaUser> userList = meilaClient.getUserInfoListFromCache(userIds);

            for (TuanStatus tuanStatus : canJoinTuanStatusList) {
                TuanJoinStatusVo tuanJoinStatusVo = new TuanJoinStatusVo();
                BeanUtils.copyProperties(tuanStatus, tuanJoinStatusVo);
                if (CollectionUtils.isNotEmpty(userList)) {
                    for (MeilaUser user : userList) {
                        if (user.getId().equals(String.valueOf(tuanStatus.getUserId()))) {
                            tuanJoinStatusVo.setNickName(user.getNickname());
                            tuanJoinStatusVo.setUserImg(user.getAvatar());
                            break;
                        }
                    }
                }
                canJoinTuanStatusVoList.add(tuanJoinStatusVo);
            }
        }
        return canJoinTuanStatusVoList;
    }
}
