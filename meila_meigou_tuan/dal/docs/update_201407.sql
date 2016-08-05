-- 2014-07-04 by ahlon
alter table `vdlm_shop` add unique dx_shop_name(`name`);
-- 2014-07-09 by ahlon
alter table `vdlm_order` add column union_id bigint(20) default null;
alter table `vdlm_shop` add column commision_rate decimal(10,2) default null;

alter table `vdlm_user` add column `roles` bigint(20) default null;
update vdlm_user set roles=1 where admin=true;


-- 2014-07-11 by ahlon
CREATE TABLE `vdlm_commission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_item_id` bigint(20) NOT NULL,
  `sku_id` bigint(20) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `rate` decimal(4,2) NOT NULL,
  `amount` int(11) NOT NULL,
  `fee` decimal(20,4) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 2014-07-21 by cuihz
ALTER TABLE `vdlm_feedback`
ADD COLUMN `name`  varchar(20) NULL AFTER `user_id`;

ALTER TABLE `vdlm_feedback`
ADD COLUMN `status`  varchar(20) NOT NULL COMMENT '处理状态' AFTER `name`;

ALTER TABLE `vdlm_feedback`
ADD COLUMN `replay`  text NULL COMMENT '回复内容' AFTER `status`;

ALTER TABLE `vdlm_withdraw_apply`
ADD COLUMN `apply_no`  varchar(40) NOT NULL COMMENT '提现申请编号' AFTER `id`;

-- 2014-07-21 by thanatoz
ALTER TABLE `vdlm_app_version`
ADD COLUMN `force_update`  tinyint(1) DEFAULT NULL ;

ALTER TABLE `vdlm_app_version`
ADD COLUMN `os`  varchar(20) DEFAULT NULL ;

ALTER TABLE `vdlm_app_version`
ADD COLUMN `os_min_ver`  varchar(20) DEFAULT NULL ;

update vdlm_app_version set os = 'ANDROID', os_min_ver = 8;

-- 2014-07-25 by cuihz
ALTER TABLE `vdlm_order`
ADD COLUMN `refund_type`  varchar(20) NULL COMMENT '退款是否成功' AFTER `union_id`;

-- 2017-07-20 by yangjian
ALTER TABLE `vdlm_image` DROP COLUMN `image22`;
ALTER TABLE `vdlm_image` ADD COLUMN `height` int NULL AFTER `img_key`;
ALTER TABLE `vdlm_image` ADD COLUMN `width` int NULL AFTER `height`;
ALTER TABLE `vdlm_image` ADD COLUMN `image_ave` varchar(256) NULL AFTER `suffix`;

-- 2014-07-07 by ahlon
alter table `vdlm_user` add UNIQUE KEY `loginname` (`loginname`);

ALTER TABLE `vdlm_product_image`
CHANGE COLUMN `order` `img_order`  int(4) NULL DEFAULT NULL AFTER `img`;

ALTER TABLE `vdlm_product`
ADD COLUMN `discount`  decimal(3,2) NULL AFTER `recommend_at`;

ALTER TABLE `vdlm_product`
ADD COLUMN `img_width`  int NULL AFTER `img`,
ADD COLUMN `img_height`  int NULL AFTER `img_width`,
ADD COLUMN `commission_rate`  decimal(3,2) NULL DEFAULT 0 AFTER `discount`;

insert into vdlm_user(id, name, phone, loginname)
value(-1001, '支付宝支付账户', 'alipay', 'alipay');

insert into vdlm_user(id, name, phone, loginname)
value(-1003, '微信支付支付账户', 'weixin', 'weixin');

insert into vdlm_user(id, name, phone, loginname)
value(-101, '快快支付账户', 'kkkd', 'kkkd');


CREATE TABLE `vdlm_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `banner` varchar(60) NOT NULL,
  `act_date` datetime NOT NULL,
  `archive` tinyint(4) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_act_name_date` (`name`,`act_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `vdlm_activity_product` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(11) NOT NULL,
  `activity_id` bigint(11) NOT NULL,
  `product_order` int(11) DEFAULT '999',
  `archive` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_act_prod` (`product_id`,`activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 


--2014-07-31 by odin 注册后新增注册消息推送
ALTER TABLE vdlm_push_message ADD baidu_tag_name varchar(30) NULL AFTER `count`;
ALTER TABLE vdlm_push_message ADD baidu_channel_id bigint(20) NULL AFTER `baidu_tag_name`;
ALTER TABLE vdlm_push_message ADD baidu_user_id varchar(30) NULL AFTER `baidu_channel_id`;
INSERT INTO `vdlm_message` VALUES ('100', '快快开店欢迎你', '亲爱的，欢迎加入快快开店。在这里，你可以快速上传宝贝，一键分享宝贝到朋友圈，随时关注小店交易动态，打造自己的商业圈。如果你在使用过程中有任何问题或者建议，请记得及时反馈给我们哦。了解更多快快开店动态，请关注我们的微信公众号：快快开店。', 'SYSTEM', 'VALID', '6a27aecc-2a5a-484e-b19f-ac7aeb5a874f', null, '2014-05-28 14:08:53', '2014-05-28 15:40:59');


CREATE TABLE `vdlm_pay_request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pay_no` varchar(40) NOT NULL DEFAULT '0' COMMENT '父请求Id',
  `level` tinyint(4) DEFAULT NULL COMMENT '请求级别，Level 1 为真正PayRequest， level 0 为 批量请求',
  `biz_id` varchar(100) NOT NULL COMMENT '业务编号 orderid等等',
  `biz_type` varchar(20) NOT NULL COMMENT '业务类型 ORDER:订单,REFUND:订单退款,BATCH_PAY:批量付款',
  `pay_type` varchar(20) NOT NULL COMMENT '资金操作类型,RECHARGE 充值、INSTANT即时转账、DANBAO担保转账、REFUND即时转账 退款、WITHDRAW提现、FROZEN冻结、UNFROZEN解冻、AVAILABLE2CONSUME从自己的可用账户转到消费账户,HONGBAO2CONSUME从自己的红包账户到可消费账户,CONSUME2AVAILABLE从自己',
  `amount` decimal(12,4) NOT NULL COMMENT '涉及金额',
  `from_sub_account_id` bigint(20) NOT NULL,
  `to_sub_account_id` bigint(20) NOT NULL,
  `status` varchar(20) NOT NULL COMMENT '支付状态  本次支付的状态 SUBMITTED提交  FAILED支付失败 IN_PROGRESS支付中 PAID支付成功、担保中 SUCCESS支付完成 CANCEL取消',
  `statusEx` varchar(20) DEFAULT NULL COMMENT '支付子状态 用于对status的进一步描述，失败后提示,担保转账失败，担保确认失败等等',
  `outPay_type` varchar(20) DEFAULT NULL COMMENT '外部充值类型，ALIPAY支付宝,TENPAY财付通,UNION银联,WEIXIN微信',
  `outPay_info` varchar(255) DEFAULT NULL COMMENT '提现和充值需要用到外部帐号信息',
  `for_request_id` bigint(20) DEFAULT NULL COMMENT '关联的支付请求',
  `callback_status` varchar(20) DEFAULT NULL COMMENT '回调状态  \r\nSUBMITTED接受  FAILED支付失败  SUCCESS成功 EXCEPTION异常',
  `callback` varchar(200) DEFAULT NULL COMMENT '回调',
  `callback_type` int(11) DEFAULT '1' COMMENT '回调类型 1:return,2:函数动态调用',
  `callback_param` varchar(200) DEFAULT NULL COMMENT '回调参数',
  `comment` varchar(200) DEFAULT NULL COMMENT '备注',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付内部请求表';


CREATE TABLE `vdlm_sub_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) NOT NULL COMMENT 'user_account表里的主键id',
  `account_type` varchar(200) NOT NULL COMMENT '账户类别，AVAILABLE可用账户，DANBAO担保账户，FROZEN冻结账户，WITHDRAW提现账户，CREDIT信用账户，HONGBAO红包账户,  CONSUME消费账户',
  `balance` decimal(12,2) unsigned NOT NULL COMMENT '用户的余额',
  `lock` tinyint(1) DEFAULT '0' COMMENT '是否锁定',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_balance_user_account` (`account_id`,`account_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `vdlm_sub_account_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `op_type` varchar(20) NOT NULL COMMENT '资金操作类型,RECHARGE 充值、INSTANT即时转账、DANBAO_ING担保转账中，DANBAO_DONE担保转账完成，DANBAO_CANCEL担保转账取消，REFUND即时转账 退款，WITHDRAW_ING提现中，WITHDRAW_DONE提现完成，WITHDRAW_CANCEL取消，FROZEN冻结，UNFROZEN解冻，DANBAO_REFUND担保退款',
  `request_id` bigint(20) NOT NULL COMMENT '账务记账凭证，关联支付请求表的ID',
  `sub_account_id` bigint(20) NOT NULL COMMENT 'vdlm_account里的主键ID',
  `amount` decimal(12,2) DEFAULT NULL,
  `comment` varchar(200) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账务明细记录表, 某个账号(userId)的某个账户(payAccountId)因为某次支付请求(requestId)发';


CREATE TABLE `vdlm_sub_account_snapshot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sub_account_log_id` bigint(20) NOT NULL COMMENT '关联vdlm_account_detail表的自增主键',
  `account_id` bigint(20) NOT NULL COMMENT '冗余字段',
  `snapshot` varchar(1000) NOT NULL COMMENT 'json串，key为vdlm_sub_account里的主键id，value为账户余额',
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账务余额快照表, 某一笔记账vdlm_account_detail之前的一刻，用户userId的余额快照信息';

ALTER TABLE `vdlm_feedback`
MODIFY COLUMN `created_at`  datetime NOT NULL AFTER `contact`,
MODIFY COLUMN `updated_at`  datetime NULL DEFAULT NULL AFTER `created_at`,
ADD COLUMN `type` varchar(20) NULL AFTER `contact`;

-- 2014-08-06 by ahlon 分类


