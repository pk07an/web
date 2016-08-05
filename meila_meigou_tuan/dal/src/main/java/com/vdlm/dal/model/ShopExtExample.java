package com.vdlm.dal.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopExtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopExtExample() {
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

        protected List<Criterion> shopIdCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            idCriteria = new ArrayList<Criterion>();
            shopIdCriteria = new ArrayList<Criterion>();
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

        public List<Criterion> getShopIdCriteria() {
            return shopIdCriteria;
        }

        protected void addShopIdCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            shopIdCriteria.add(new Criterion(condition, value, "idHandler"));
            allCriteria = null;
        }

        protected void addShopIdCriterion(String condition, String value1, String value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            shopIdCriteria.add(new Criterion(condition, value1, value2, "idHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                || idCriteria.size() > 0
                || shopIdCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(idCriteria);
                allCriteria.addAll(shopIdCriteria);
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

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(String value) {
            addShopIdCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(String value) {
            addShopIdCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(String value) {
            addShopIdCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(String value) {
            addShopIdCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(String value) {
            addShopIdCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(String value) {
            addShopIdCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<String> values) {
            addShopIdCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<String> values) {
            addShopIdCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(String value1, String value2) {
            addShopIdCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(String value1, String value2) {
            addShopIdCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Short value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Short value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Short value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Short value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Short value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Short> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Short> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Short value1, Short value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Short value1, Short value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayAccountIsNull() {
            addCriterion("pay_account is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountIsNotNull() {
            addCriterion("pay_account is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountEqualTo(String value) {
            addCriterion("pay_account =", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotEqualTo(String value) {
            addCriterion("pay_account <>", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountGreaterThan(String value) {
            addCriterion("pay_account >", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountGreaterThanOrEqualTo(String value) {
            addCriterion("pay_account >=", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountLessThan(String value) {
            addCriterion("pay_account <", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountLessThanOrEqualTo(String value) {
            addCriterion("pay_account <=", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountLike(String value) {
            addCriterion("pay_account like", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotLike(String value) {
            addCriterion("pay_account not like", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountIn(List<String> values) {
            addCriterion("pay_account in", values, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotIn(List<String> values) {
            addCriterion("pay_account not in", values, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountBetween(String value1, String value2) {
            addCriterion("pay_account between", value1, value2, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotBetween(String value1, String value2) {
            addCriterion("pay_account not between", value1, value2, "payAccount");
            return (Criteria) this;
        }

        public Criteria andShortIntroIsNull() {
            addCriterion("short_intro is null");
            return (Criteria) this;
        }

        public Criteria andShortIntroIsNotNull() {
            addCriterion("short_intro is not null");
            return (Criteria) this;
        }

        public Criteria andShortIntroEqualTo(String value) {
            addCriterion("short_intro =", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroNotEqualTo(String value) {
            addCriterion("short_intro <>", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroGreaterThan(String value) {
            addCriterion("short_intro >", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroGreaterThanOrEqualTo(String value) {
            addCriterion("short_intro >=", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroLessThan(String value) {
            addCriterion("short_intro <", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroLessThanOrEqualTo(String value) {
            addCriterion("short_intro <=", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroLike(String value) {
            addCriterion("short_intro like", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroNotLike(String value) {
            addCriterion("short_intro not like", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroIn(List<String> values) {
            addCriterion("short_intro in", values, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroNotIn(List<String> values) {
            addCriterion("short_intro not in", values, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroBetween(String value1, String value2) {
            addCriterion("short_intro between", value1, value2, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroNotBetween(String value1, String value2) {
            addCriterion("short_intro not between", value1, value2, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andSellerTypeIsNull() {
            addCriterion("seller_type is null");
            return (Criteria) this;
        }

        public Criteria andSellerTypeIsNotNull() {
            addCriterion("seller_type is not null");
            return (Criteria) this;
        }

        public Criteria andSellerTypeEqualTo(Short value) {
            addCriterion("seller_type =", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeNotEqualTo(Short value) {
            addCriterion("seller_type <>", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeGreaterThan(Short value) {
            addCriterion("seller_type >", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("seller_type >=", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeLessThan(Short value) {
            addCriterion("seller_type <", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeLessThanOrEqualTo(Short value) {
            addCriterion("seller_type <=", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeIn(List<Short> values) {
            addCriterion("seller_type in", values, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeNotIn(List<Short> values) {
            addCriterion("seller_type not in", values, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeBetween(Short value1, Short value2) {
            addCriterion("seller_type between", value1, value2, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeNotBetween(Short value1, Short value2) {
            addCriterion("seller_type not between", value1, value2, "sellerType");
            return (Criteria) this;
        }

        public Criteria andIsRealSellerIsNull() {
            addCriterion("is_real_seller is null");
            return (Criteria) this;
        }

        public Criteria andIsRealSellerIsNotNull() {
            addCriterion("is_real_seller is not null");
            return (Criteria) this;
        }

        public Criteria andIsRealSellerEqualTo(Boolean value) {
            addCriterion("is_real_seller =", value, "isRealSeller");
            return (Criteria) this;
        }

        public Criteria andIsRealSellerNotEqualTo(Boolean value) {
            addCriterion("is_real_seller <>", value, "isRealSeller");
            return (Criteria) this;
        }

        public Criteria andIsRealSellerGreaterThan(Boolean value) {
            addCriterion("is_real_seller >", value, "isRealSeller");
            return (Criteria) this;
        }

        public Criteria andIsRealSellerGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_real_seller >=", value, "isRealSeller");
            return (Criteria) this;
        }

        public Criteria andIsRealSellerLessThan(Boolean value) {
            addCriterion("is_real_seller <", value, "isRealSeller");
            return (Criteria) this;
        }

        public Criteria andIsRealSellerLessThanOrEqualTo(Boolean value) {
            addCriterion("is_real_seller <=", value, "isRealSeller");
            return (Criteria) this;
        }

        public Criteria andIsRealSellerIn(List<Boolean> values) {
            addCriterion("is_real_seller in", values, "isRealSeller");
            return (Criteria) this;
        }

        public Criteria andIsRealSellerNotIn(List<Boolean> values) {
            addCriterion("is_real_seller not in", values, "isRealSeller");
            return (Criteria) this;
        }

        public Criteria andIsRealSellerBetween(Boolean value1, Boolean value2) {
            addCriterion("is_real_seller between", value1, value2, "isRealSeller");
            return (Criteria) this;
        }

        public Criteria andIsRealSellerNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_real_seller not between", value1, value2, "isRealSeller");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueIsNull() {
            addCriterion("total_revenue is null");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueIsNotNull() {
            addCriterion("total_revenue is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueEqualTo(BigDecimal value) {
            addCriterion("total_revenue =", value, "totalRevenue");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueNotEqualTo(BigDecimal value) {
            addCriterion("total_revenue <>", value, "totalRevenue");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueGreaterThan(BigDecimal value) {
            addCriterion("total_revenue >", value, "totalRevenue");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_revenue >=", value, "totalRevenue");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueLessThan(BigDecimal value) {
            addCriterion("total_revenue <", value, "totalRevenue");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_revenue <=", value, "totalRevenue");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueIn(List<BigDecimal> values) {
            addCriterion("total_revenue in", values, "totalRevenue");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueNotIn(List<BigDecimal> values) {
            addCriterion("total_revenue not in", values, "totalRevenue");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_revenue between", value1, value2, "totalRevenue");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_revenue not between", value1, value2, "totalRevenue");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andShipmentCountIsNull() {
            addCriterion("shipment_count is null");
            return (Criteria) this;
        }

        public Criteria andShipmentCountIsNotNull() {
            addCriterion("shipment_count is not null");
            return (Criteria) this;
        }

        public Criteria andShipmentCountEqualTo(Integer value) {
            addCriterion("shipment_count =", value, "shipmentCount");
            return (Criteria) this;
        }

        public Criteria andShipmentCountNotEqualTo(Integer value) {
            addCriterion("shipment_count <>", value, "shipmentCount");
            return (Criteria) this;
        }

        public Criteria andShipmentCountGreaterThan(Integer value) {
            addCriterion("shipment_count >", value, "shipmentCount");
            return (Criteria) this;
        }

        public Criteria andShipmentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("shipment_count >=", value, "shipmentCount");
            return (Criteria) this;
        }

        public Criteria andShipmentCountLessThan(Integer value) {
            addCriterion("shipment_count <", value, "shipmentCount");
            return (Criteria) this;
        }

        public Criteria andShipmentCountLessThanOrEqualTo(Integer value) {
            addCriterion("shipment_count <=", value, "shipmentCount");
            return (Criteria) this;
        }

        public Criteria andShipmentCountIn(List<Integer> values) {
            addCriterion("shipment_count in", values, "shipmentCount");
            return (Criteria) this;
        }

        public Criteria andShipmentCountNotIn(List<Integer> values) {
            addCriterion("shipment_count not in", values, "shipmentCount");
            return (Criteria) this;
        }

        public Criteria andShipmentCountBetween(Integer value1, Integer value2) {
            addCriterion("shipment_count between", value1, value2, "shipmentCount");
            return (Criteria) this;
        }

        public Criteria andShipmentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("shipment_count not between", value1, value2, "shipmentCount");
            return (Criteria) this;
        }

        public Criteria andDistribTypeIsNull() {
            addCriterion("distrib_type is null");
            return (Criteria) this;
        }

        public Criteria andDistribTypeIsNotNull() {
            addCriterion("distrib_type is not null");
            return (Criteria) this;
        }

        public Criteria andDistribTypeEqualTo(Short value) {
            addCriterion("distrib_type =", value, "distribType");
            return (Criteria) this;
        }

        public Criteria andDistribTypeNotEqualTo(Short value) {
            addCriterion("distrib_type <>", value, "distribType");
            return (Criteria) this;
        }

        public Criteria andDistribTypeGreaterThan(Short value) {
            addCriterion("distrib_type >", value, "distribType");
            return (Criteria) this;
        }

        public Criteria andDistribTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("distrib_type >=", value, "distribType");
            return (Criteria) this;
        }

        public Criteria andDistribTypeLessThan(Short value) {
            addCriterion("distrib_type <", value, "distribType");
            return (Criteria) this;
        }

        public Criteria andDistribTypeLessThanOrEqualTo(Short value) {
            addCriterion("distrib_type <=", value, "distribType");
            return (Criteria) this;
        }

        public Criteria andDistribTypeIn(List<Short> values) {
            addCriterion("distrib_type in", values, "distribType");
            return (Criteria) this;
        }

        public Criteria andDistribTypeNotIn(List<Short> values) {
            addCriterion("distrib_type not in", values, "distribType");
            return (Criteria) this;
        }

        public Criteria andDistribTypeBetween(Short value1, Short value2) {
            addCriterion("distrib_type between", value1, value2, "distribType");
            return (Criteria) this;
        }

        public Criteria andDistribTypeNotBetween(Short value1, Short value2) {
            addCriterion("distrib_type not between", value1, value2, "distribType");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIsNull() {
            addCriterion("verify_status is null");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIsNotNull() {
            addCriterion("verify_status is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusEqualTo(String value) {
            addCriterion("verify_status =", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotEqualTo(String value) {
            addCriterion("verify_status <>", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusGreaterThan(String value) {
            addCriterion("verify_status >", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("verify_status >=", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusLessThan(String value) {
            addCriterion("verify_status <", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusLessThanOrEqualTo(String value) {
            addCriterion("verify_status <=", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusLike(String value) {
            addCriterion("verify_status like", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotLike(String value) {
            addCriterion("verify_status not like", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIn(List<String> values) {
            addCriterion("verify_status in", values, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotIn(List<String> values) {
            addCriterion("verify_status not in", values, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusBetween(String value1, String value2) {
            addCriterion("verify_status between", value1, value2, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotBetween(String value1, String value2) {
            addCriterion("verify_status not between", value1, value2, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitCheckTimeIsNull() {
            addCriterion("submit_check_time is null");
            return (Criteria) this;
        }

        public Criteria andSubmitCheckTimeIsNotNull() {
            addCriterion("submit_check_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitCheckTimeEqualTo(Date value) {
            addCriterion("submit_check_time =", value, "submitCheckTime");
            return (Criteria) this;
        }

        public Criteria andSubmitCheckTimeNotEqualTo(Date value) {
            addCriterion("submit_check_time <>", value, "submitCheckTime");
            return (Criteria) this;
        }

        public Criteria andSubmitCheckTimeGreaterThan(Date value) {
            addCriterion("submit_check_time >", value, "submitCheckTime");
            return (Criteria) this;
        }

        public Criteria andSubmitCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submit_check_time >=", value, "submitCheckTime");
            return (Criteria) this;
        }

        public Criteria andSubmitCheckTimeLessThan(Date value) {
            addCriterion("submit_check_time <", value, "submitCheckTime");
            return (Criteria) this;
        }

        public Criteria andSubmitCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("submit_check_time <=", value, "submitCheckTime");
            return (Criteria) this;
        }

        public Criteria andSubmitCheckTimeIn(List<Date> values) {
            addCriterion("submit_check_time in", values, "submitCheckTime");
            return (Criteria) this;
        }

        public Criteria andSubmitCheckTimeNotIn(List<Date> values) {
            addCriterion("submit_check_time not in", values, "submitCheckTime");
            return (Criteria) this;
        }

        public Criteria andSubmitCheckTimeBetween(Date value1, Date value2) {
            addCriterion("submit_check_time between", value1, value2, "submitCheckTime");
            return (Criteria) this;
        }

        public Criteria andSubmitCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("submit_check_time not between", value1, value2, "submitCheckTime");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNull() {
            addCriterion("video_url is null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNotNull() {
            addCriterion("video_url is not null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlEqualTo(String value) {
            addCriterion("video_url =", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotEqualTo(String value) {
            addCriterion("video_url <>", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThan(String value) {
            addCriterion("video_url >", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("video_url >=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThan(String value) {
            addCriterion("video_url <", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThanOrEqualTo(String value) {
            addCriterion("video_url <=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLike(String value) {
            addCriterion("video_url like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotLike(String value) {
            addCriterion("video_url not like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIn(List<String> values) {
            addCriterion("video_url in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotIn(List<String> values) {
            addCriterion("video_url not in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlBetween(String value1, String value2) {
            addCriterion("video_url between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotBetween(String value1, String value2) {
            addCriterion("video_url not between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoImgIsNull() {
            addCriterion("video_img is null");
            return (Criteria) this;
        }

        public Criteria andVideoImgIsNotNull() {
            addCriterion("video_img is not null");
            return (Criteria) this;
        }

        public Criteria andVideoImgEqualTo(String value) {
            addCriterion("video_img =", value, "videoImg");
            return (Criteria) this;
        }

        public Criteria andVideoImgNotEqualTo(String value) {
            addCriterion("video_img <>", value, "videoImg");
            return (Criteria) this;
        }

        public Criteria andVideoImgGreaterThan(String value) {
            addCriterion("video_img >", value, "videoImg");
            return (Criteria) this;
        }

        public Criteria andVideoImgGreaterThanOrEqualTo(String value) {
            addCriterion("video_img >=", value, "videoImg");
            return (Criteria) this;
        }

        public Criteria andVideoImgLessThan(String value) {
            addCriterion("video_img <", value, "videoImg");
            return (Criteria) this;
        }

        public Criteria andVideoImgLessThanOrEqualTo(String value) {
            addCriterion("video_img <=", value, "videoImg");
            return (Criteria) this;
        }

        public Criteria andVideoImgLike(String value) {
            addCriterion("video_img like", value, "videoImg");
            return (Criteria) this;
        }

        public Criteria andVideoImgNotLike(String value) {
            addCriterion("video_img not like", value, "videoImg");
            return (Criteria) this;
        }

        public Criteria andVideoImgIn(List<String> values) {
            addCriterion("video_img in", values, "videoImg");
            return (Criteria) this;
        }

        public Criteria andVideoImgNotIn(List<String> values) {
            addCriterion("video_img not in", values, "videoImg");
            return (Criteria) this;
        }

        public Criteria andVideoImgBetween(String value1, String value2) {
            addCriterion("video_img between", value1, value2, "videoImg");
            return (Criteria) this;
        }

        public Criteria andVideoImgNotBetween(String value1, String value2) {
            addCriterion("video_img not between", value1, value2, "videoImg");
            return (Criteria) this;
        }

        public Criteria andVideoSlugIsNull() {
            addCriterion("video_slug is null");
            return (Criteria) this;
        }

        public Criteria andVideoSlugIsNotNull() {
            addCriterion("video_slug is not null");
            return (Criteria) this;
        }

        public Criteria andVideoSlugEqualTo(String value) {
            addCriterion("video_slug =", value, "videoSlug");
            return (Criteria) this;
        }

        public Criteria andVideoSlugNotEqualTo(String value) {
            addCriterion("video_slug <>", value, "videoSlug");
            return (Criteria) this;
        }

        public Criteria andVideoSlugGreaterThan(String value) {
            addCriterion("video_slug >", value, "videoSlug");
            return (Criteria) this;
        }

        public Criteria andVideoSlugGreaterThanOrEqualTo(String value) {
            addCriterion("video_slug >=", value, "videoSlug");
            return (Criteria) this;
        }

        public Criteria andVideoSlugLessThan(String value) {
            addCriterion("video_slug <", value, "videoSlug");
            return (Criteria) this;
        }

        public Criteria andVideoSlugLessThanOrEqualTo(String value) {
            addCriterion("video_slug <=", value, "videoSlug");
            return (Criteria) this;
        }

        public Criteria andVideoSlugLike(String value) {
            addCriterion("video_slug like", value, "videoSlug");
            return (Criteria) this;
        }

        public Criteria andVideoSlugNotLike(String value) {
            addCriterion("video_slug not like", value, "videoSlug");
            return (Criteria) this;
        }

        public Criteria andVideoSlugIn(List<String> values) {
            addCriterion("video_slug in", values, "videoSlug");
            return (Criteria) this;
        }

        public Criteria andVideoSlugNotIn(List<String> values) {
            addCriterion("video_slug not in", values, "videoSlug");
            return (Criteria) this;
        }

        public Criteria andVideoSlugBetween(String value1, String value2) {
            addCriterion("video_slug between", value1, value2, "videoSlug");
            return (Criteria) this;
        }

        public Criteria andVideoSlugNotBetween(String value1, String value2) {
            addCriterion("video_slug not between", value1, value2, "videoSlug");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIsNull() {
            addCriterion("display_order is null");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIsNotNull() {
            addCriterion("display_order is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderEqualTo(Integer value) {
            addCriterion("display_order =", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotEqualTo(Integer value) {
            addCriterion("display_order <>", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderGreaterThan(Integer value) {
            addCriterion("display_order >", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("display_order >=", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderLessThan(Integer value) {
            addCriterion("display_order <", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderLessThanOrEqualTo(Integer value) {
            addCriterion("display_order <=", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIn(List<Integer> values) {
            addCriterion("display_order in", values, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotIn(List<Integer> values) {
            addCriterion("display_order not in", values, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderBetween(Integer value1, Integer value2) {
            addCriterion("display_order between", value1, value2, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("display_order not between", value1, value2, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNull() {
            addCriterion("delivery_type is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNotNull() {
            addCriterion("delivery_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeEqualTo(Byte value) {
            addCriterion("delivery_type =", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotEqualTo(Byte value) {
            addCriterion("delivery_type <>", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThan(Byte value) {
            addCriterion("delivery_type >", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("delivery_type >=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThan(Byte value) {
            addCriterion("delivery_type <", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThanOrEqualTo(Byte value) {
            addCriterion("delivery_type <=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIn(List<Byte> values) {
            addCriterion("delivery_type in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotIn(List<Byte> values) {
            addCriterion("delivery_type not in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeBetween(Byte value1, Byte value2) {
            addCriterion("delivery_type between", value1, value2, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("delivery_type not between", value1, value2, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeIsNull() {
            addCriterion("balance_type is null");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeIsNotNull() {
            addCriterion("balance_type is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeEqualTo(Byte value) {
            addCriterion("balance_type =", value, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeNotEqualTo(Byte value) {
            addCriterion("balance_type <>", value, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeGreaterThan(Byte value) {
            addCriterion("balance_type >", value, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("balance_type >=", value, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeLessThan(Byte value) {
            addCriterion("balance_type <", value, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeLessThanOrEqualTo(Byte value) {
            addCriterion("balance_type <=", value, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeIn(List<Byte> values) {
            addCriterion("balance_type in", values, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeNotIn(List<Byte> values) {
            addCriterion("balance_type not in", values, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeBetween(Byte value1, Byte value2) {
            addCriterion("balance_type between", value1, value2, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("balance_type not between", value1, value2, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceBankIdIsNull() {
            addCriterion("balance_bank_id is null");
            return (Criteria) this;
        }

        public Criteria andBalanceBankIdIsNotNull() {
            addCriterion("balance_bank_id is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceBankIdEqualTo(Byte value) {
            addCriterion("balance_bank_id =", value, "balanceBankId");
            return (Criteria) this;
        }

        public Criteria andBalanceBankIdNotEqualTo(Byte value) {
            addCriterion("balance_bank_id <>", value, "balanceBankId");
            return (Criteria) this;
        }

        public Criteria andBalanceBankIdGreaterThan(Byte value) {
            addCriterion("balance_bank_id >", value, "balanceBankId");
            return (Criteria) this;
        }

        public Criteria andBalanceBankIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("balance_bank_id >=", value, "balanceBankId");
            return (Criteria) this;
        }

        public Criteria andBalanceBankIdLessThan(Byte value) {
            addCriterion("balance_bank_id <", value, "balanceBankId");
            return (Criteria) this;
        }

        public Criteria andBalanceBankIdLessThanOrEqualTo(Byte value) {
            addCriterion("balance_bank_id <=", value, "balanceBankId");
            return (Criteria) this;
        }

        public Criteria andBalanceBankIdIn(List<Byte> values) {
            addCriterion("balance_bank_id in", values, "balanceBankId");
            return (Criteria) this;
        }

        public Criteria andBalanceBankIdNotIn(List<Byte> values) {
            addCriterion("balance_bank_id not in", values, "balanceBankId");
            return (Criteria) this;
        }

        public Criteria andBalanceBankIdBetween(Byte value1, Byte value2) {
            addCriterion("balance_bank_id between", value1, value2, "balanceBankId");
            return (Criteria) this;
        }

        public Criteria andBalanceBankIdNotBetween(Byte value1, Byte value2) {
            addCriterion("balance_bank_id not between", value1, value2, "balanceBankId");
            return (Criteria) this;
        }

        public Criteria andBalanceAccountIsNull() {
            addCriterion("balance_account is null");
            return (Criteria) this;
        }

        public Criteria andBalanceAccountIsNotNull() {
            addCriterion("balance_account is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceAccountEqualTo(String value) {
            addCriterion("balance_account =", value, "balanceAccount");
            return (Criteria) this;
        }

        public Criteria andBalanceAccountNotEqualTo(String value) {
            addCriterion("balance_account <>", value, "balanceAccount");
            return (Criteria) this;
        }

        public Criteria andBalanceAccountGreaterThan(String value) {
            addCriterion("balance_account >", value, "balanceAccount");
            return (Criteria) this;
        }

        public Criteria andBalanceAccountGreaterThanOrEqualTo(String value) {
            addCriterion("balance_account >=", value, "balanceAccount");
            return (Criteria) this;
        }

        public Criteria andBalanceAccountLessThan(String value) {
            addCriterion("balance_account <", value, "balanceAccount");
            return (Criteria) this;
        }

        public Criteria andBalanceAccountLessThanOrEqualTo(String value) {
            addCriterion("balance_account <=", value, "balanceAccount");
            return (Criteria) this;
        }

        public Criteria andBalanceAccountLike(String value) {
            addCriterion("balance_account like", value, "balanceAccount");
            return (Criteria) this;
        }

        public Criteria andBalanceAccountNotLike(String value) {
            addCriterion("balance_account not like", value, "balanceAccount");
            return (Criteria) this;
        }

        public Criteria andBalanceAccountIn(List<String> values) {
            addCriterion("balance_account in", values, "balanceAccount");
            return (Criteria) this;
        }

        public Criteria andBalanceAccountNotIn(List<String> values) {
            addCriterion("balance_account not in", values, "balanceAccount");
            return (Criteria) this;
        }

        public Criteria andBalanceAccountBetween(String value1, String value2) {
            addCriterion("balance_account between", value1, value2, "balanceAccount");
            return (Criteria) this;
        }

        public Criteria andBalanceAccountNotBetween(String value1, String value2) {
            addCriterion("balance_account not between", value1, value2, "balanceAccount");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
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