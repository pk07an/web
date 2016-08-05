DROP TABLE IF EXISTS `vdlm_sms_tpl`;
CREATE TABLE `vdlm_sms_tpl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sms_event` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '发短信事件',
  `country_code` varchar(10) NOT NULL default 'CN' comment '国家码',
  `format_var` varchar(512) COLLATE utf8mb4_unicode_ci comment '对应vdlm_sms_var_tpl表,为空说明模板内容没有变量, 逗号分隔',
  `content` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL comment '模板内容',
  `plan_form`  varchar(64)  COLLATE utf8mb4_unicode_ci NOT NULL comment '目标平台,比如快店,想去等',
  `status`  varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL comment '模板记录状态是否生效',
  `archive` tinyint(1)  not null default 0,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
	-- INDEX `idx_sms_event` USING BTREE (`sms_event`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO `vdlm_sms_tpl` (`sms_event`, `country_code`, `format_var`, `content`, `plan_form`, `status`, `archive`, `created_at`, `updated_at`) 
	VALUES ('SUBMITTED_BUYER', 'CN', 'prodName,orderInfo,sellerName,sellerName', '恭喜亲,您的宝贝%s已下单成功,订单地址: %s , 卖家:%s. 请忙完成付款,如有疑问通过订单号联系%s查询', 'KKKD', 'VALID', false, now(), now());
INSERT INTO `vdlm_sms_tpl` (`sms_event`, `country_code`, `format_var`, `content`, `plan_form`, `status`, `archive`, `created_at`, `updated_at`) 
	VALUES ('PAID_BUYER', 'CN', 'prodName,orderInfo,sellerName,sellerName', '恭喜亲,您的宝贝%s购买成功,订单地址: %s ,卖家:%s,卖家将会尽快发货,如有疑问可通过订单号联系%s查询', 'KKKD', 'VALID', false, now(), now());
INSERT INTO `vdlm_sms_tpl` (`sms_event`, `country_code`, `format_var`, `content`, `plan_form`, `status`, `archive`, `created_at`, `updated_at`) 
	VALUES ('PAID_SELLER', 'CN', 'prodName,orderInfo,buyerName', '恭喜亲,您的宝贝%s被购买成功,订单地址: %s ,买家:%s已付款,请尽快发货', 'KKKD', 'INVALID', false, now(), now());
INSERT INTO `vdlm_sms_tpl` (`sms_event`, `country_code`, `format_var`, `content`, `plan_form`, `status`, `archive`, `created_at`, `updated_at`) 
	VALUES ('PAID_SELLER', 'CN', 'prodName,orderInfo,buyerWeichat,buyerName', '恭喜亲,您的宝贝%s被购买成功,订单地址: %s ,买家:%s(微信号:%s)已付款,请尽快发货', 'KKKD', 'VALID', false, now(), now());
INSERT INTO `vdlm_sms_tpl` (`sms_event`, `country_code`, `format_var`, `content`, `plan_form`, `status`, `archive`, `created_at`, `updated_at`) 
	VALUES ('SHIPPED_BUYER', 'CN', 'prodName,orderInfo,logisticsInc,logisticsOrderNo', '亲,您已购买的宝贝%s,订单地址: %s ,正由%s快马加鞭送来,快递单号:%s,请注意查收', 'KKKD', 'VALID', false, now(), now());
INSERT INTO `vdlm_sms_tpl` (`sms_event`, `country_code`, `format_var`, `content`, `plan_form`, `status`, `archive`, `created_at`, `updated_at`) 
	VALUES ('SHIPPED_BUYER', 'CN', 'prodName,orderInfo', '亲,您已购买的宝贝%s,订单地址: %s ,已经发货,稍后请注意查收', 'KKKD', 'INVALID', false, now(), now());
INSERT INTO `vdlm_sms_tpl` (`sms_event`, `country_code`, `format_var`, `content`, `plan_form`, `status`, `archive`, `created_at`, `updated_at`) 
	VALUES ('CANCELLED_SELLER', 'CN', 'prodName,orderInfo', '亲,您已被拍下的宝贝%s,订单地址: %s ,由于买家超时未付款,已被系统自动取消', 'KKKD', 'VALID', false, now(), now());
INSERT INTO `vdlm_sms_tpl` (`sms_event`, `country_code`, `format_var`, `content`, `plan_form`, `status`, `archive`, `created_at`, `updated_at`) 
	VALUES ('CANCELLED_BUYER', 'CN', 'prodName,orderInfo', '亲,您已拍下的宝贝%s,订单地址: %s ,由于超时未付款,已被系统自动取消', 'KKKD', 'VALID', false, now(), now());
INSERT INTO `vdlm_sms_tpl` (`sms_event`, `country_code`, `format_var`, `content`, `plan_form`, `status`, `archive`, `created_at`, `updated_at`) 
	VALUES ('MOVE_PRODUCT', 'CN', '', '您刚刚授权的淘宝店铺搬家已经完成，快去管理商品吧！', 'KKKD', 'INVALID', false, now(), now());
INSERT INTO `vdlm_sms_tpl` (`sms_event`, `country_code`, `format_var`, `content`, `plan_form`, `status`, `archive`, `created_at`, `updated_at`) 
	VALUES ('FREE_ORDER', 'CN', 'orderInfo,freeFee', '恭喜您获得了想去免单奖励! 免单订单地址: %s , 免单金额:%s元将在7天后打到您的账户!继续购买赢更多惊喜哟!', 'KKKD', 'VALID', false, now(), now());
INSERT INTO `vdlm_sms_tpl` (`sms_event`, `country_code`, `format_var`, `content`, `plan_form`, `status`, `archive`, `created_at`, `updated_at`) 
	VALUES ('FREE_ORDER_FINISH', 'CN', 'orderInfo,freeFee', '您在想去的双十一名单订单地址: %s , 免单金额:%s元已打入您的账户,请注意查收哦~', 'KKKD', 'VALID', false, now(), now());
	
INSERT INTO `vdlm_message` (`id`, `title`, `content`, `type`, `status`, `sess_id`, `reply_to`, `created_at`, `updated_at`) 
	VALUES ('2008', '延迟签收', '您的订单被延迟签收%s天', 'SYSTEM', 'VALID', 'b5a5b054-313d-4e85-b24e-8ad041c6fcad', NULL, now(), now());



DROP TABLE IF EXISTS `vdlm_sms_var_tpl`;
CREATE TABLE `vdlm_sms_var_tpl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `var_name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '变量名',
  `var_note` varchar(128) COLLATE utf8mb4_unicode_ci comment '变量备注说明',
	`archive` tinyint(1)  not null default 0,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

 insert into vdlm_sms_var_tpl values (null, 'prodName', '商品名称', false, now(), now());
 insert into vdlm_sms_var_tpl values (null, 'prodShortName', '商品短名称', false, now(), now());
 insert into vdlm_sms_var_tpl values (null, 'sellerName', '卖家', false, now(), now());
 insert into vdlm_sms_var_tpl values (null, 'buyerName', '买家名称', false, now(), now());
 insert into vdlm_sms_var_tpl values (null, 'buyerWeichat', '买家微信号', false, now(), now());
 insert into vdlm_sms_var_tpl values (null, 'orderInfo', '订单信息', false, now(), now());
 insert into vdlm_sms_var_tpl values (null, 'logisticsOrderNo', '运单号', false, now(), now());
 insert into vdlm_sms_var_tpl values (null, 'logisticsInc', '快递公司', false, now(), now());
 insert into vdlm_sms_var_tpl values (null, 'freeFee', '活动免单金额', false, now(), now());
 
CREATE TABLE vdlm_user_signin_log
    (
        id bigint NOT NULL AUTO_INCREMENT,
        user_id bigint NOT NULL,
        ip VARCHAR(30) COLLATE utf8mb4_unicode_ci,
        client VARCHAR(30) COLLATE utf8mb4_unicode_ci,
        browser VARCHAR(30) COLLATE utf8mb4_unicode_ci,
        os VARCHAR(30) COLLATE utf8mb4_unicode_ci,
        created_at DATETIME NOT NULL,
        partner VARCHAR(30) COLLATE utf8mb4_unicode_ci,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB;
 
alter table `vdlm_prodsync` add column `commission_rate` decimal(10, 2) not null default 0.00 after `union_id`;
alter table `vdlm_prodsync` add column `audit_sts` varchar(20) not null default 'PASS' after `commission_rate`;
alter table `vdlm_prodsync` add column `audit_note` varchar(128) default null after `audit_sts`;
update vdlm.vdlm_prodsync vp set commission_rate = (select commision_rate from vdlm.vdlm_shop vs where vs.id = vp.shop_id);

ALTER TABLE `vdlm_activity`
ADD COLUMN `img`  varchar(60) NULL AFTER `name`,
ADD COLUMN `type`  varchar(20) NULL AFTER `banner`,
ADD COLUMN `start_time`  datetime NULL AFTER `type`,
ADD COLUMN `end_time`  datetime NULL AFTER `start_time`,
ADD COLUMN `status`  varchar(20) NULL AFTER `end_time`,
ADD COLUMN `remind`  tinyint(1) NULL AFTER `status`,
ADD COLUMN `summary`  varchar(40) NULL AFTER `remind`,
ADD COLUMN `details`  text NULL AFTER `summary`;
ADD COLUMN `creator_id`  text NULL AFTER `details`;


ALTER TABLE `vdlm_sku` ADD INDEX `idx_product_id` (`product_id`);

ALTER TABLE `vdlm_activity`
ADD COLUMN `preferential_type`  tinyint(2) NULL AFTER `remind`,
ADD COLUMN `discount`  float NULL AFTER `preferential_type`,
ADD COLUMN `reduction`  float NULL AFTER `discount`;

ALTER TABLE `vdlm_activity`
MODIFY COLUMN `act_date`  datetime NULL AFTER `creator_id`;

ALTER TABLE `vdlm_activity`
MODIFY COLUMN `banner`  varchar(60) NULL;

ALTER TABLE `vdlm_order` ADD COLUMN `latest_sign_at` datetime default NULL COMMENT '默认超时自动签收时间' AFTER `succeed_at`;
update vdlm.vdlm_order set latest_sign_at = DATE_ADD(shipped_at,INTERVAL 7 DAY) where type = 'DANBAO' and shipped_at is not null;

ALTER TABLE `vdlm_activity`
ADD COLUMN `updated_at`  datetime NULL AFTER `created_at`;

CREATE TABLE `vdlm_campaign_product` (
  `ticket_id` varchar(20),
  `activity_id` varchar(20) NOT NULL,
  `product_id` varchar(20) NOT NULL,
  `discount` float DEFAULT NULL,
  `reduction` float DEFAULT NULL,
  `activity_amount` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`activity_id`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `vdlm_activity_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `shop_id` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `audit_status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` varchar(20) COLLATE utf8mb4_unicode_ci not null,
  `created_at` datetime DEFAULT NULL,
  `archive` tinyint(1)  not null default 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

ALTER TABLE `vdlm_activity_product`
ADD COLUMN `ticket_id` bigint NULL AFTER `id`,

-- 增加商品，sku的市场价，原价字段
ALTER TABLE `vdlm_product`
ADD COLUMN `market_price`  decimal(14,4) NULL AFTER `status`;
ALTER TABLE `vdlm_sku`
ADD COLUMN `market_price`  decimal(14,4) NULL AFTER `spec`;

--想去优惠码
ALTER TABLE `vdlm_coupon_activity`
ADD COLUMN `partner_id`  bigint(20) NULL AFTER `valid_to`;
ALTER TABLE `vdlm_coupon_activity`
ADD COLUMN `act_code`  varchar(20) NULL COMMENT '活动code' AFTER `id`;
insert into vdlm_coupon_activity(act_code, title, discount, valid, partner_id, created_at, updated_at)
value('XQ.COUPONCODE', '优惠码', 0, 1, 16630961, now(), now());
insert into vdlm_coupon_activity(title, discount, valid, partner_id, created_at, updated_at)
value('XQ.HONGBAO', '红包', 0, 1, 16630961, now(), now());
update vdlm_coupon_activity set partner_id = 16630961, act_code = 'XQ.FIRST' where id = 1;

--增加单个优惠券金额
ALTER TABLE `vdlm_coupon`
MODIFY COLUMN `id`  bigint(20) NULL AUTO_INCREMENT FIRST ,
ADD COLUMN `discount`  decimal(10,0) NULL AFTER `user_id`;
ALTER TABLE `vdlm_coupon`
ADD COLUMN `ext_coupon_id`  varchar(100) NULL COMMENT '外部优惠券ID，如想去' AFTER `valid_to`;
ALTER TABLE `vdlm_cashieritem`
MODIFY COLUMN `third_vouchers`  decimal(10,2) NULL DEFAULT NULL COMMENT '已无用、待删除' AFTER `amount`,
MODIFY COLUMN `third_voucher_name`  varchar(50) COMMENT '已无用、待删除' AFTER `created_at`,
MODIFY COLUMN `third_voucher_id`  varchar(30) NULL DEFAULT NULL COMMENT '已无用、待删除' AFTER `third_voucher_name`,
ADD COLUMN `coupon_id`  bigint NULL COMMENT '优惠券ID' AFTER `third_voucher_id`;
ALTER TABLE `vdlm_cashieritem`
MODIFY COLUMN `third_voucher_name`  varchar(50) NULL COMMENT '已无用、待删除' AFTER `created_at`;
ALTER TABLE `vdlm_coupon_activity`
ADD UNIQUE INDEX `idx_coupon_act_code` (`act_code`) ;

--所有首次5元优惠，初始化成5元
update vdlm_coupon set discount = 5 where activity_id = 1;

ALTER TABLE `vdlm_product`
ADD COLUMN `update_lock`  tinyint(1) NOT NULL DEFAULT 0 AFTER `delayDays`;

ALTER TABLE `vdlm_activity`
ADD COLUMN `closed_at`  datetime NULL AFTER `created_at`;

--把所有店铺开通担保交易
update vdlm_shop set danbao = 1 where danbao is null or danbao = 0;