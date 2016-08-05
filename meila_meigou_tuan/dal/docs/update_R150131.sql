/**
 * 增加sku多维度概念
 */
ALTER TABLE `vdlm_sku`
ADD COLUMN `spec1`  varchar(200) NULL AFTER `archive`,
ADD COLUMN `spec2`  varchar(200) NULL AFTER `spec1`,
ADD COLUMN `spec3`  varchar(200) NULL AFTER `spec2`,
ADD COLUMN `spec4`  varchar(200) NULL AFTER `spec3`,
ADD COLUMN `spec5`  varchar(200) NULL AFTER `spec4`;

/**
 * sku映射表
 */
CREATE TABLE `vdlm_sku_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `spec_key` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '对应sku表中的spec1、spec2、spec3、spec4',
  `spec_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '对sku表中的spec1、spec2、spec3、spec4的描述，如颜色、尺寸等',
  `spec_order` int(11) DEFAULT NULL COMMENT '排序',
  `archive` tinyint(1) DEFAULT '0',
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sku_map_key` (`product_id`,`spec_key`,`spec_name`),
  KEY `idx_sku_map_product` (`product_id`)
) ENGINE=InnoDB;



/*
*新增图片类型字段
*150121
*/
ALTER TABLE vdlm_product_image
ADD COLUMN type INT NULL;ADD COLUMN `spec5`  varchar(50) NULL AFTER `spec4`;

ALTER TABLE `vdlm_pay_request`
ADD INDEX `idx_pay_request_no` (`pay_no`) ;

insert into vdlm_message(id, title, content, type, status, created_at, updated_at)
values(2009, '您有一笔订单发货提醒', '您有一笔订单%s未及时发货，买家正在催促您发货，如果您不能在72小时内正常发货，请务必及时主动联系买家说明。', 'SYSTEM', 'VALID', now(), now());

ALTER TABLE `vdlm_order`
ADD INDEX `idx_order_buyer` (`buyer_id`);

/*
 * 第三方同步商品id
 */
alter table vdlm_product
add column third_item_id bigint(20) null;

/**
 * 市场价 
 */
ALTER TABLE `vdlm_order_item`
ADD COLUMN `market_price`  decimal(12,2) NULL AFTER `price`;
update vdlm_order_item set market_price = price where market_price is null;

/**
 * 初始化老的sku全部为一维
 */
insert into vdlm_sku_mapping(product_id, spec_key, spec_name, created_at)
select id, 'spec1', '型号', now() from vdlm_product;
update vdlm_sku set spec1 = spec where spec1 is null;
