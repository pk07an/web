-- added by ahlon for 订单留言
CREATE TABLE `vdlm_order_message` (
  `id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `user_type` tinyint(1) NOT NULL,
  `group_id` bigint(20), 
  `content` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_msg_id` USING BTREE (`order_id`, `user_id`)
) ENGINE=InnoDB;

ALTER TABLE `vdlm_category` ADD COLUMN `shop_id` bigint(20) NULL AFTER `parent_id`;
ALTER TABLE `vdlm_category` ADD COLUMN `idx` int NULL AFTER `shop_id`;

-- 新增商品属性：是否延迟发货商品、延迟天数
ALTER TABLE vdlm_product ADD (isDelay TINYINT DEFAULT '0' NOT NULL);
ALTER TABLE vdlm_product ADD (delayDays INT DEFAULT '0' NOT NULL);

-- added by ahlon at 2014-09-15 15:42 for 分类在店铺范围内的唯一性
ALTER TABLE `vdlm_category`
DROP INDEX `idx1` ,
ADD UNIQUE INDEX `idx1` (`term_id`, `taxonomy`, `shop_id`) USING BTREE ;

-- 用户支付宝信息表
CREATE TABLE vdlm_user_alipay
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    account_no VARCHAR(64) NOT NULL,
    account_name VARCHAR(64) NOT NULL,
    archive TINYINT DEFAULT '0' NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 新增提现类型字段：withdraw_type，0：无，1：银行卡，2：支付宝
ALTER TABLE vdlm_user ADD (withdraw_type INT DEFAULT '0' NOT NULL);
-- 初始化原有已绑定银行卡用户的默认提现类型

update vdlm_user u set withdraw_type=1 where exists (select 1 from vdlm_user_bank b where u.id=b.user_id) and withdraw_type=0;

-- 订单增加退款金额，退款时间记录
ALTER TABLE `vdlm_order`
ADD COLUMN `refund_fee`  decimal(10,2) NULL AFTER `total_fee`,
ADD COLUMN `refund_at`  datetime NULL AFTER `shipped_at`;

update vdlm_user u set withdraw_type=1 where exists (select 1 from vdlm_user_bank b where u.id=b.user_id and b.archive=false) and withdraw_type=0;

-- 除去原有的alipayAccount字段
ALTER TABLE
    vdlm_withdraw_apply DROP COLUMN alipayAccount;
-- 新增提现类型
ALTER TABLE
    vdlm_withdraw_apply ADD (type INT DEFAULT '0' NOT NULL);
-- 初始化
update vdlm_withdraw_apply w set type=1 where exists (select 1 from vdlm_user_bank b where w.user_id=b.user_id and b.archive=false);


--扩展U付协字段
ALTER TABLE `vdlm_outpay_agreement`
CHANGE COLUMN `gate_id` `bank_code`  varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '银行代码(ICBC,CCB等)' AFTER `card_type`;

ALTER TABLE `vdlm_outpay_agreement`
ADD COLUMN `account_num`  varchar(40) NULL COMMENT '银行账号后四位' AFTER `bank_code`,
ADD COLUMN `identity_type`  varchar(40) NULL COMMENT '证件类型' AFTER `account_num`,
ADD COLUMN `identity_no`  varchar(40) NULL COMMENT '证件号' AFTER `identity_type`,
ADD COLUMN `account_name`  varchar(40) NULL COMMENT '持卡人姓名' AFTER `identity_no`,
ADD COLUMN `media_type`  varchar(20) NULL COMMENT '媒介类型MOBILE（手机号） EMAIL（邮箱地址）' AFTER `account_name`,
ADD COLUMN `media_no`  varchar(40) NULL COMMENT '支付使用的手机号' AFTER `media_type`;

--增加索引
ALTER TABLE `vdlm_outpay_agreement`
ADD INDEX `idx_pay_agreement_gate_id` (`bank_code`) ;   
ALTER TABLE `vdlm_paybank_cardmode`
ADD INDEX `idx_bank_cardmode_bankCode` (`bankCode`) ;
ALTER TABLE `vdlm_outpay_agreement`
ADD INDEX `idx_pay_agreement_cart_type` (`card_type`) ;
ALTER TABLE `vdlm_paybank_cardmode`
ADD INDEX `idx_bank_cardmode_cartType` (`cardType`) ;

-- 用户访问某个url的日志表
CREATE TABLE vdlm_apivisitor_log
    (
        id BIGINT NOT NULL AUTO_INCREMENT,
        user_id BIGINT NOT NULL,
        url VARCHAR(64) NOT NULL,
        created_at DATETIME NOT NULL,
        updated_at DATETIME NOT NULL,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
    
--新增对账时间及初始化
ALTER TABLE vdlm_order ADD (checking_at DATETIME);
update vdlm_order set checking_at = paid_at where type='DIRECT' and (status='PAID' or status='SUCCESS');
update vdlm_order set checking_at = updated_at where type='DANBAO' and status='SUCCESS';

--渠道商品表
CREATE TABLE
    vdlm_union_product
    (
        id bigint NOT NULL AUTO_INCREMENT,
        partner_userId bigint NOT NULL,
        product_id bigint NOT NULL,
        archive TINYINT(1) DEFAULT '0' NOT NULL,
        created_at TIMESTAMP  NOT NULL,
        updated_at TIMESTAMP NOT NULL,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
    
-- 分润账号    
alter table `vdlm_prodsync` add column `union_id` bigint(20) default 0 after synced;
update `vdlm_prodsync` set union_id = (select id from `vdlm_user` where phone = 'xiangqu' and name = '想去分润账户');

--考虑到查看shop时，可能未登录，先设置可为空
ALTER TABLE `vdlm_shop_access`
MODIFY COLUMN `user_id`  bigint(100) NULL AFTER `pv`;

ALTER TABLE `vdlm_order`
MODIFY COLUMN `logistics_company`  varchar(40) DEFAULT NULL;

ALTER TABLE `vdlm_order`
MODIFY COLUMN `logistics_order_no`  varchar(40) DEFAULT NULL;


INSERT INTO `vdlm_message` VALUES ('200', '您的有新留言', '您的有新留言了', 'SYSTEM', 'VALID', '6a27aecc-2a5a-484e-b19f-ac7aeb5a8744', NULL, now(), now());

INSERT INTO `vdlm_message` VALUES ('2002', '您有新订单', '买家已下单,但还没有付款哦', 'SYSTEM', 'VALID', '6a27aecc-2a5a-484e-b19f-ac7aeb5a874b', NULL, now(), now());
INSERT INTO `vdlm_message` VALUES ('2003', '付款成功', '买家已付款,您可以发货了', 'SYSTEM', 'VALID', '6a27aecc-2a5a-484e-b19f-ac7aeb5a874c', NULL, now(), now());
INSERT INTO `vdlm_message` VALUES ('2004', '交易完成', '交易已完成,您的财富又增加了', 'SYSTEM', 'VALID', '6a27aecc-2a5a-484e-b19f-ac7aeb5a874d', NULL, now(), now());
INSERT INTO `vdlm_message` VALUES ('2005', '交易关闭', '因买家未付款订单已自动关闭', 'SYSTEM', 'VALID', '6a27aecc-2a5a-484e-b19f-ac7aeb5a874e', NULL, now(), now());

INSERT INTO `vdlm_message` VALUES ('2502', '已发货', '您的%s商品已发货,请注意查收', 'SYSTEM', 'VALID', '6a27aecc-2a5a-484e-b19f-ac7aeb5a874g', NULL, now(), now());
INSERT INTO `vdlm_message` VALUES ('2503', '待发货', '您的%s商品已经付款,等待卖家发货', 'SYSTEM', 'VALID', 'd04f9a7c-18d9-4a16-94bb-7f7c8dc078ds', NULL, now(), now());
INSERT INTO `vdlm_message` VALUES ('2504', '交易成功', '您的%s商品已经完成交易', 'SYSTEM', 'VALID', '8072695e-99a6-42bf-b787-643951f095cc', NULL, now(), now());
INSERT INTO `vdlm_message` VALUES ('2505', '交易关闭', '您的%s商品已终止交易', 'SYSTEM', 'VALID', '6a27aecc-2a5a-484e-b19f-ac7aeb5a874j', NULL, now(), now());
INSERT INTO `vdlm_message` VALUES ('2506', '未付款', '您的%s商品订单已生成,尚未付款', 'SYSTEM', 'VALID', '6a27aecc-2a5a-484e-b19f-ac7aeb5a874f', NULL, now(), now());

ALTER TABLE vdlm_apivisitor_log ADD CONSTRAINT vdlm_apivisitor_log_idx1 UNIQUE (user_id, url);

-- added by taiyi for 短信发送记录
CREATE TABLE `vdlm_sms_send_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `app_id` int(3) DEFAULT NULL,
  `mobile` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `content` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;





