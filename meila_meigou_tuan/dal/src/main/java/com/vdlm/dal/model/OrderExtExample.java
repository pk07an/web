package com.vdlm.dal.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExtExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> idCriteria;

        protected List<Criterion> orderIdCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            idCriteria = new ArrayList<Criterion>();
            orderIdCriteria = new ArrayList<Criterion>();
        }

        public List<Criterion> getIdCriteria() {
            return idCriteria;
        }

        protected void addIdCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            idCriteria.add(new Criterion(condition, value, "idHandler"));
            allCriteria = null;
        }

        protected void addIdCriterion(String condition, String value1, String value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            idCriteria.add(new Criterion(condition, value1, value2, "idHandler"));
            allCriteria = null;
        }

        public List<Criterion> getOrderIdCriteria() {
            return orderIdCriteria;
        }

        protected void addOrderIdCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            orderIdCriteria.add(new Criterion(condition, value, "idHandler"));
            allCriteria = null;
        }

        protected void addOrderIdCriterion(String condition, String value1, String value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            orderIdCriteria.add(new Criterion(condition, value1, value2, "idHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                || idCriteria.size() > 0
                || orderIdCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(idCriteria);
                allCriteria.addAll(orderIdCriteria);
            }
            return allCriteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
            allCriteria = null;
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addIdCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addIdCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addIdCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addIdCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addIdCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addIdCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addIdCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addIdCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addIdCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addIdCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addOrderIdCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addOrderIdCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addOrderIdCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addOrderIdCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addOrderIdCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addOrderIdCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addOrderIdCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addOrderIdCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addOrderIdCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addOrderIdCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNoIsNull() {
            addCriterion("express_company_no is null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNoIsNotNull() {
            addCriterion("express_company_no is not null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNoEqualTo(Integer value) {
            addCriterion("express_company_no =", value, "expressCompanyNo");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNoNotEqualTo(Integer value) {
            addCriterion("express_company_no <>", value, "expressCompanyNo");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNoGreaterThan(Integer value) {
            addCriterion("express_company_no >", value, "expressCompanyNo");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("express_company_no >=", value, "expressCompanyNo");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNoLessThan(Integer value) {
            addCriterion("express_company_no <", value, "expressCompanyNo");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNoLessThanOrEqualTo(Integer value) {
            addCriterion("express_company_no <=", value, "expressCompanyNo");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNoIn(List<Integer> values) {
            addCriterion("express_company_no in", values, "expressCompanyNo");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNoNotIn(List<Integer> values) {
            addCriterion("express_company_no not in", values, "expressCompanyNo");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNoBetween(Integer value1, Integer value2) {
            addCriterion("express_company_no between", value1, value2, "expressCompanyNo");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNoNotBetween(Integer value1, Integer value2) {
            addCriterion("express_company_no not between", value1, value2, "expressCompanyNo");
            return (Criteria) this;
        }

        public Criteria andMcodeIsNull() {
            addCriterion("mcode is null");
            return (Criteria) this;
        }

        public Criteria andMcodeIsNotNull() {
            addCriterion("mcode is not null");
            return (Criteria) this;
        }

        public Criteria andMcodeEqualTo(String value) {
            addCriterion("mcode =", value, "mcode");
            return (Criteria) this;
        }

        public Criteria andMcodeNotEqualTo(String value) {
            addCriterion("mcode <>", value, "mcode");
            return (Criteria) this;
        }

        public Criteria andMcodeGreaterThan(String value) {
            addCriterion("mcode >", value, "mcode");
            return (Criteria) this;
        }

        public Criteria andMcodeGreaterThanOrEqualTo(String value) {
            addCriterion("mcode >=", value, "mcode");
            return (Criteria) this;
        }

        public Criteria andMcodeLessThan(String value) {
            addCriterion("mcode <", value, "mcode");
            return (Criteria) this;
        }

        public Criteria andMcodeLessThanOrEqualTo(String value) {
            addCriterion("mcode <=", value, "mcode");
            return (Criteria) this;
        }

        public Criteria andMcodeLike(String value) {
            addCriterion("mcode like", value, "mcode");
            return (Criteria) this;
        }

        public Criteria andMcodeNotLike(String value) {
            addCriterion("mcode not like", value, "mcode");
            return (Criteria) this;
        }

        public Criteria andMcodeIn(List<String> values) {
            addCriterion("mcode in", values, "mcode");
            return (Criteria) this;
        }

        public Criteria andMcodeNotIn(List<String> values) {
            addCriterion("mcode not in", values, "mcode");
            return (Criteria) this;
        }

        public Criteria andMcodeBetween(String value1, String value2) {
            addCriterion("mcode between", value1, value2, "mcode");
            return (Criteria) this;
        }

        public Criteria andMcodeNotBetween(String value1, String value2) {
            addCriterion("mcode not between", value1, value2, "mcode");
            return (Criteria) this;
        }

        public Criteria andCoinIsNull() {
            addCriterion("coin is null");
            return (Criteria) this;
        }

        public Criteria andCoinIsNotNull() {
            addCriterion("coin is not null");
            return (Criteria) this;
        }

        public Criteria andCoinEqualTo(Integer value) {
            addCriterion("coin =", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotEqualTo(Integer value) {
            addCriterion("coin <>", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinGreaterThan(Integer value) {
            addCriterion("coin >", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinGreaterThanOrEqualTo(Integer value) {
            addCriterion("coin >=", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinLessThan(Integer value) {
            addCriterion("coin <", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinLessThanOrEqualTo(Integer value) {
            addCriterion("coin <=", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinIn(List<Integer> values) {
            addCriterion("coin in", values, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotIn(List<Integer> values) {
            addCriterion("coin not in", values, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinBetween(Integer value1, Integer value2) {
            addCriterion("coin between", value1, value2, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotBetween(Integer value1, Integer value2) {
            addCriterion("coin not between", value1, value2, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinPriceIsNull() {
            addCriterion("coin_price is null");
            return (Criteria) this;
        }

        public Criteria andCoinPriceIsNotNull() {
            addCriterion("coin_price is not null");
            return (Criteria) this;
        }

        public Criteria andCoinPriceEqualTo(BigDecimal value) {
            addCriterion("coin_price =", value, "coinPrice");
            return (Criteria) this;
        }

        public Criteria andCoinPriceNotEqualTo(BigDecimal value) {
            addCriterion("coin_price <>", value, "coinPrice");
            return (Criteria) this;
        }

        public Criteria andCoinPriceGreaterThan(BigDecimal value) {
            addCriterion("coin_price >", value, "coinPrice");
            return (Criteria) this;
        }

        public Criteria andCoinPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("coin_price >=", value, "coinPrice");
            return (Criteria) this;
        }

        public Criteria andCoinPriceLessThan(BigDecimal value) {
            addCriterion("coin_price <", value, "coinPrice");
            return (Criteria) this;
        }

        public Criteria andCoinPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("coin_price <=", value, "coinPrice");
            return (Criteria) this;
        }

        public Criteria andCoinPriceIn(List<BigDecimal> values) {
            addCriterion("coin_price in", values, "coinPrice");
            return (Criteria) this;
        }

        public Criteria andCoinPriceNotIn(List<BigDecimal> values) {
            addCriterion("coin_price not in", values, "coinPrice");
            return (Criteria) this;
        }

        public Criteria andCoinPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coin_price between", value1, value2, "coinPrice");
            return (Criteria) this;
        }

        public Criteria andCoinPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coin_price not between", value1, value2, "coinPrice");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNull() {
            addCriterion("refund_status is null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNotNull() {
            addCriterion("refund_status is not null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusEqualTo(Integer value) {
            addCriterion("refund_status =", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotEqualTo(Integer value) {
            addCriterion("refund_status <>", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThan(Integer value) {
            addCriterion("refund_status >", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_status >=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThan(Integer value) {
            addCriterion("refund_status <", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThanOrEqualTo(Integer value) {
            addCriterion("refund_status <=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIn(List<Integer> values) {
            addCriterion("refund_status in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotIn(List<Integer> values) {
            addCriterion("refund_status not in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusBetween(Integer value1, Integer value2) {
            addCriterion("refund_status between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_status not between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andUtmChannelIsNull() {
            addCriterion("utm_channel is null");
            return (Criteria) this;
        }

        public Criteria andUtmChannelIsNotNull() {
            addCriterion("utm_channel is not null");
            return (Criteria) this;
        }

        public Criteria andUtmChannelEqualTo(String value) {
            addCriterion("utm_channel =", value, "utmChannel");
            return (Criteria) this;
        }

        public Criteria andUtmChannelNotEqualTo(String value) {
            addCriterion("utm_channel <>", value, "utmChannel");
            return (Criteria) this;
        }

        public Criteria andUtmChannelGreaterThan(String value) {
            addCriterion("utm_channel >", value, "utmChannel");
            return (Criteria) this;
        }

        public Criteria andUtmChannelGreaterThanOrEqualTo(String value) {
            addCriterion("utm_channel >=", value, "utmChannel");
            return (Criteria) this;
        }

        public Criteria andUtmChannelLessThan(String value) {
            addCriterion("utm_channel <", value, "utmChannel");
            return (Criteria) this;
        }

        public Criteria andUtmChannelLessThanOrEqualTo(String value) {
            addCriterion("utm_channel <=", value, "utmChannel");
            return (Criteria) this;
        }

        public Criteria andUtmChannelLike(String value) {
            addCriterion("utm_channel like", value, "utmChannel");
            return (Criteria) this;
        }

        public Criteria andUtmChannelNotLike(String value) {
            addCriterion("utm_channel not like", value, "utmChannel");
            return (Criteria) this;
        }

        public Criteria andUtmChannelIn(List<String> values) {
            addCriterion("utm_channel in", values, "utmChannel");
            return (Criteria) this;
        }

        public Criteria andUtmChannelNotIn(List<String> values) {
            addCriterion("utm_channel not in", values, "utmChannel");
            return (Criteria) this;
        }

        public Criteria andUtmChannelBetween(String value1, String value2) {
            addCriterion("utm_channel between", value1, value2, "utmChannel");
            return (Criteria) this;
        }

        public Criteria andUtmChannelNotBetween(String value1, String value2) {
            addCriterion("utm_channel not between", value1, value2, "utmChannel");
            return (Criteria) this;
        }

        public Criteria andUtmUserIdIsNull() {
            addCriterion("utm_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUtmUserIdIsNotNull() {
            addCriterion("utm_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUtmUserIdEqualTo(Integer value) {
            addCriterion("utm_user_id =", value, "utmUserId");
            return (Criteria) this;
        }

        public Criteria andUtmUserIdNotEqualTo(Integer value) {
            addCriterion("utm_user_id <>", value, "utmUserId");
            return (Criteria) this;
        }

        public Criteria andUtmUserIdGreaterThan(Integer value) {
            addCriterion("utm_user_id >", value, "utmUserId");
            return (Criteria) this;
        }

        public Criteria andUtmUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("utm_user_id >=", value, "utmUserId");
            return (Criteria) this;
        }

        public Criteria andUtmUserIdLessThan(Integer value) {
            addCriterion("utm_user_id <", value, "utmUserId");
            return (Criteria) this;
        }

        public Criteria andUtmUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("utm_user_id <=", value, "utmUserId");
            return (Criteria) this;
        }

        public Criteria andUtmUserIdIn(List<Integer> values) {
            addCriterion("utm_user_id in", values, "utmUserId");
            return (Criteria) this;
        }

        public Criteria andUtmUserIdNotIn(List<Integer> values) {
            addCriterion("utm_user_id not in", values, "utmUserId");
            return (Criteria) this;
        }

        public Criteria andUtmUserIdBetween(Integer value1, Integer value2) {
            addCriterion("utm_user_id between", value1, value2, "utmUserId");
            return (Criteria) this;
        }

        public Criteria andUtmUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("utm_user_id not between", value1, value2, "utmUserId");
            return (Criteria) this;
        }

        public Criteria andStatusUpdateTimeIsNull() {
            addCriterion("status_update_time is null");
            return (Criteria) this;
        }

        public Criteria andStatusUpdateTimeIsNotNull() {
            addCriterion("status_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andStatusUpdateTimeEqualTo(Date value) {
            addCriterion("status_update_time =", value, "statusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStatusUpdateTimeNotEqualTo(Date value) {
            addCriterion("status_update_time <>", value, "statusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStatusUpdateTimeGreaterThan(Date value) {
            addCriterion("status_update_time >", value, "statusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStatusUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("status_update_time >=", value, "statusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStatusUpdateTimeLessThan(Date value) {
            addCriterion("status_update_time <", value, "statusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStatusUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("status_update_time <=", value, "statusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStatusUpdateTimeIn(List<Date> values) {
            addCriterion("status_update_time in", values, "statusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStatusUpdateTimeNotIn(List<Date> values) {
            addCriterion("status_update_time not in", values, "statusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStatusUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("status_update_time between", value1, value2, "statusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStatusUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("status_update_time not between", value1, value2, "statusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusIsNull() {
            addCriterion("settlement_status is null");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusIsNotNull() {
            addCriterion("settlement_status is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusEqualTo(Integer value) {
            addCriterion("settlement_status =", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusNotEqualTo(Integer value) {
            addCriterion("settlement_status <>", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusGreaterThan(Integer value) {
            addCriterion("settlement_status >", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("settlement_status >=", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusLessThan(Integer value) {
            addCriterion("settlement_status <", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusLessThanOrEqualTo(Integer value) {
            addCriterion("settlement_status <=", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusIn(List<Integer> values) {
            addCriterion("settlement_status in", values, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusNotIn(List<Integer> values) {
            addCriterion("settlement_status not in", values, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusBetween(Integer value1, Integer value2) {
            addCriterion("settlement_status between", value1, value2, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("settlement_status not between", value1, value2, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}