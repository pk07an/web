--店铺是否使用片段功能
ALTER TABLE vdlm_shop ADD (fragment_status TINYINT DEFAULT '0' NOT NULL);

CREATE TABLE vdlm_fragment
    (
        id bigint NOT NULL AUTO_INCREMENT,
        shop_id bigint NOT NULL,
        name VARCHAR(30),
        description mediumtext,
        show_model TINYINT,
        created_at DATETIME NOT NULL,
        updated_at DATETIME NOT NULL,
        idx INT NOT NULL,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB;


CREATE TABLE vdlm_fragment_image
    (
        id bigint NOT NULL AUTO_INCREMENT,
        fragment_id bigint NOT NULL,
        img VARCHAR(60),
        created_at DATETIME NOT NULL,
        idx INT,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB;


/*
  小助手表 vdlm_helper
  2014.11.28
*/
CREATE TABLE vdlm_helper
(
	id TINYINT(2) NOT NULL AUTO_INCREMENT,
	title VARCHAR(30) NOT NULL,
	intro VARCHAR(50) NULL DEFAULT NULL,
    icon VARCHAR(200) NULL DEFAULT NULL,
	url VARCHAR(100) NULL DEFAULT NULL,
	archive TINYINT(1) NOT NULL DEFAULT 0,
	sort TINYINT(2) NULL DEFAULT 0,
	PRIMARY KEY(id)  
)
ENGINE=InnoDB;

/*
  新增字段-审核同步渠道来源
  2014.12.1
*/
ALTER TABLE vdlm_product
ADD COLUMN synchronousFlag VARCHAR(20) DEFAULT NULL;

/*
 添加优惠码唯一约束
 2014.12.10
 */
ALTER TABLE vdlm_coupon ADD UNIQUE(code);

/*
新增字段-订单卖家端备注
2014.12.16
*/
ALTER TABLE vdlm_order ADD COLUMN remark_admin varchar(200) NULL

/*
新增字段-活动商品表删除标记
 */
alter table vdlm_campaign_product add column archive tinyint(1) not null default 0

/*
*新增上传图片字段（订单留言）
*/
ALTER TABLE vdlm_order_message ADD COLUMN upload_pic varchar(600) NULL

/*
*更新邮资为空的旧数据
*/
UPDATE vdlm_order SET logistics_fee = 0 WHERE logistics_fee IS NULL

/*
 *更新物流公司旧数据
 */
update vdlm_order set logistics_company = '顺丰速运' where logistics_company = '顺丰';
update vdlm_order set logistics_company = '顺丰速运' where logistics_company = '顺丰快递';
update vdlm_order set logistics_company = '顺丰速运' where logistics_company = 'SF_EXPRESS';
update vdlm_order set logistics_company = '圆通速递' where logistics_company = '圆通';
update vdlm_order set logistics_company = '圆通速递' where logistics_company = '圆通快递';
update vdlm_order set logistics_company = '圆通速递' where logistics_company = 'YTO';
update vdlm_order set logistics_company = '申通快递' where logistics_company = '申通';
update vdlm_order set logistics_company = '申通快递' where logistics_company = 'STO';
update vdlm_order set logistics_company = '中通快递' where logistics_company = '中通';
update vdlm_order set logistics_company = '中通快递' where logistics_company = 'ZTO';
update vdlm_order set logistics_company = '汇通快运' where logistics_company = '百世汇通';
update vdlm_order set logistics_company = '汇通快运' where logistics_company = 'BESTEX';
update vdlm_order set logistics_company = '韵达快递' where logistics_company = '韵达';
update vdlm_order set logistics_company = '天天快递' where logistics_company = '天天';
update vdlm_order set logistics_company = '全峰快递' where logistics_company = '全峰';
update vdlm_order set logistics_company = 'EMS' where logistics_company = '邮政EMS';
update vdlm_order set logistics_company = 'EMS' where logistics_company = '中国邮政';
update vdlm_order set logistics_company = '其他物流' where logistics_company = 'OTHER';

/*
 *初始化小助手数据 
 */
insert into vdlm_helper (title, intro, icon, url, archive, sort) value ('没有商品也可以赚钱哦~', '转发其他商家的商品赚取佣金！', 'http://kk-other.qiniudn.com/FmG6SxWKXjYUjJI4PCPqMNVqN306?imageView2/2/w/480/q/100', '/static/push/subCommission.html', 0, 0);
insert into vdlm_helper (title, intro, icon, url, archive, sort) value ('重复发布宝贝很苦逼？', '一键搬家帮你快速丰富商品！', 'http://kk-other.qiniudn.com/FlHzr1PX863ryJaUkx7MQmOoxWeH?imageView2/2/w/480/q/100', '/static/push/moveHouse.html', 0, 0);
insert into vdlm_helper (title, intro, icon, url, archive, sort) value ('商品定时发布的秘密！', '商品可以指定发布时间来上新~', 'http://kk-other.qiniudn.com/Fsl7vt6p8WmNx-mTfie4suagAfJC?imageView2/2/w/480/q/100', '/static/push/timedRelease.html', 0, 0);
insert into vdlm_helper (title, intro, icon, url, archive, sort) value ('邮费你she了么~', '小助手带你快速搞定邮费设置小窍门！', 'http://kk-other.qiniudn.com/FjYPEpLShibLQ-0jE6l2qOB3SQhy?imageView2/2/w/480/q/100', '/static/push/postageSettings.html', 0, 0);

/*
 *更新产品库数量与sku库存保持一致
 */
update vdlm_product a set a.amount = (select sum(b.amount) from vdlm_sku b where b.product_id = a.id);
/*
 *删除产品已不存在的无效sku数据
 */
delete from vdlm_sku where id in
(
select * from (select a.id from vdlm_sku a left join vdlm_product b on a.product_id = b.id where b.id is null) p
)

CREATE TABLE vdlm_product_fragment
    (
        id bigint NOT NULL AUTO_INCREMENT,
        product_id bigint NOT NULL,
        fragment_id bigint NOT NULL,
        idx INT NOT NULL,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB;

	
ALTER TABLE `vdlm_cart_item`
ADD COLUMN `shop_id`  bigint(20) NOT NULL AFTER `sku_id`,
ADD COLUMN `seller_id`  bigint(20) NOT NULL AFTER `shop_id`;

update vdlm_cart_item ci, vdlm_product p
set ci.shop_id = p.shop_id, ci.seller_id = p.user_id
where ci.product_id = p.id;

INSERT INTO `vdlm_message` (`id`, `title`, `content`, `type`, `status`, `sess_id`, `reply_to`, `created_at`, `updated_at`) 
VALUES ('2508', '签收到期提醒', '您的订单%s明天担保交易就要到期，如果还没有收到货，请您申请延长收货，否则可能会财物两空哦！', 'SYSTEM', 'VALID', 'b5a5b054-413d-4e85-b27e-8aa041c6dcad', NULL, now(), now()); 

--删除无用字段
ALTER TABLE `vdlm_order`
DROP COLUMN `partner_coin`,
DROP COLUMN `partner_fee`;

--增加退款细分（商品、邮费），优惠不退
ALTER TABLE `vdlm_order`
ADD COLUMN `refund_goods_fee`  decimal(10,2) NULL COMMENT '退款(商品价格)' AFTER `refund_fee`,
ADD COLUMN `refund_logistics_fee`  decimal(10,2) NULL COMMENT '退款（邮费）' AFTER `refund_goods_fee`;

--内部员工表
CREATE TABLE vdlm_personnel
    (
        id BIGINT NOT NULL AUTO_INCREMENT,
        ext_user_id VARCHAR(30) NOT NULL,
        name VARCHAR(30) NOT NULL,
        partner VARCHAR(30) NOT NULL,
        inner_id VARCHAR(30) NOT NULL,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB;
    
ALTER TABLE vdlm_personnel ADD CONSTRAINT vdlm_personnel_ix1 UNIQUE (partner, inner_id);

ALTER TABLE `vdlm_sku`
MODIFY COLUMN `market_price`  decimal(14,2) NULL DEFAULT NULL AFTER `spec`,
MODIFY COLUMN `price`  decimal(14,2) NOT NULL AFTER `market_price`;

ALTER TABLE `vdlm_product`
MODIFY COLUMN `market_price`  decimal(14,2) NULL DEFAULT NULL AFTER `status`,
MODIFY COLUMN `price`  decimal(14,2) NOT NULL AFTER `market_price`;


update `vdlm_zone` set zone_tag = '华东' where id in (861, 881, 1121, 1008, 1363);
update `vdlm_zone` set zone_tag = '东北' where id in (500, 707, 629);
update `vdlm_zone` set zone_tag = '华北' where id in (2, 20, 39, 1486, 234, 376);
update `vdlm_zone` set zone_tag = '华南' where id in (1259, 2134, 2296, 2435);
update `vdlm_zone` set zone_tag = '华中' where id in (1854, 1984, 1659);
update `vdlm_zone` set zone_tag = '西北' where id in (3069, 3197, 3363, 3310);
update `vdlm_zone` set zone_tag = '西南' where id in (2506, 2832, 2465, 2729);
update `vdlm_zone` set zone_tag = '疆藏' where id in (3396, 2986);
update `vdlm_zone` set zone_tag = '港澳台' where id in (3513, 3514,3515);
update `vdlm_zone` set zone_tag = '海外' where id in (3516, 3518, 3519, 3520, 3521, 3522, 3523, 3524, 3525, 3526, 3527, 3528, 3529, 3530);
update `vdlm_zone` set zone_tag = '常用城市' where id in (1985, 630, 2507, 516, 2275, 2183, 1260, 2730, 1122, 1074, 1487, 1050, 2833, 1024, 1364, 882, 1499, 1304, 501, 926, 1037, 895, 1855, 3070, 1275, 1660, 2276, 2135, 2161, 1009, 40, 708);

DROP TABLE IF EXISTS `vdlm_postage_set`;
CREATE TABLE `vdlm_postage_set` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NOT NULL,
  `postage_set` varchar(4096) COLLATE utf8mb4_unicode_ci,
	`created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;


ALTER TABLE `vdlm_user_signin_log`
MODIFY COLUMN `ip`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL AFTER `user_id`,
MODIFY COLUMN `browser`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL AFTER `ua_content`,
MODIFY COLUMN `os`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL AFTER `browser`;

------------下迭代 活动相关------------
ALTER TABLE vdlm_activity ADD (apply_start_time DATETIME);
ALTER TABLE vdlm_activity ADD (apply_end_time DATETIME);
ALTER TABLE vdlm_activity ADD (channel VARCHAR(30));
ALTER TABLE vdlm_activity ADD (tag_image VARCHAR(60));

ALTER TABLE vdlm_activity_ticket ADD (feedback VARCHAR(200));
ALTER TABLE vdlm_activity_ticket ADD (reason VARCHAR(200));
--将活动的优惠信息写到ticket表，用于兼容活动下店铺不同折扣的需求
ALTER TABLE vdlm_activity_ticket ADD (preferential_type TINYINT(2));
ALTER TABLE vdlm_activity_ticket ADD (discount float);
ALTER TABLE vdlm_activity_ticket ADD (reduction float);
--初始化现有数据
update vdlm_activity_ticket t INNER JOIN vdlm_activity a on t.activity_id=a.id 
set t.preferential_type=a.preferential_type, t.discount=a.discount, t.reduction=a.reduction;

ALTER TABLE vdlm_activity DROP COLUMN preferential_type;
ALTER TABLE vdlm_activity DROP COLUMN discount;
ALTER TABLE vdlm_activity DROP COLUMN reduction;

update vdlm_activity set channel='PRIVATE';

ALTER TABLE vdlm_activity DROP COLUMN preferential_type;
ALTER TABLE vdlm_activity DROP COLUMN discount;
ALTER TABLE vdlm_activity DROP COLUMN reduction;

--收银台
ALTER TABLE `vdlm_cashieritem`
ADD COLUMN `batch`  tinyint NULL DEFAULT 0 COMMENT '1为批量付款，0为单个真正的请求' AFTER `updated_at`;

ALTER TABLE `vdlm_outpay`
MODIFY COLUMN `detail`  blob NULL AFTER `out_status_ex`;
ALTER TABLE `vdlm_cashieritem`
ADD COLUMN `product_name`  varchar(60) NULL AFTER `batch`,
ADD COLUMN `product_id`  bigint(20) NULL AFTER `product_name`;
ALTER TABLE `vdlm_cashieritem`
ADD COLUMN `partner_type`  varchar(40) NULL AFTER `product_id`;
ALTER TABLE `vdlm_cashieritem`
ADD COLUMN `batch_biz_nos`  varchar(1000) NULL AFTER `partner_type`;

--在订单里增加支付单号
ALTER TABLE `vdlm_order`
ADD COLUMN `pay_no`  varchar(40) NULL COMMENT '支付编号' AFTER `order_no`;

update vdlm_order set pay_no = order_no where paid_at is not null;
ALTER TABLE `vdlm_cashieritem` ADD COLUMN `user_id`  bigint(20) NULL AFTER `coupon_id`;

ALTER TABLE `vdlm_order`
ADD COLUMN `refund_platform_fee`  decimal(10,2) NULL AFTER `refund_logistics_fee`;

