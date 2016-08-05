
-- ----------------------------
-- Table structure for vdlm_tag
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_tag`;
CREATE TABLE `vdlm_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag` varchar(20) NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_TAG` (`tag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `vdlm_tag`
DROP INDEX `IDX_TAG`,
ADD UNIQUE INDEX `IDX_TAG` (`tag`) ;


-- ----------------------------
-- Table structure for vdlm_product_tag
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_product_tag`;
CREATE TABLE `vdlm_product_tag` (
  `id` bigint(20) NOT NULL,
  `shop_id` bigint(20) NOT NULL COMMENT '目前阶段做冗余字段，建索引，方便本店内查找。可扩展成店铺索引',
  `product_id` bigint(20) NOT NULL,
  `archive` tinyint(1) NOT NULL COMMENT '标志删除，定期删除',
  `tag_id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tag_ref_shop` (`shop_id`),
  KEY `fk_tag_ref_product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--ALTER TABLE `vdlm_product_tag`
--ADD UNIQUE INDEX `IDX_product_tag` (`product_id`, `tag_id`) ;

ALTER TABLE `vdlm_product_tag` ADD CONSTRAINT `fk_tag_ref_product` FOREIGN KEY (`product_id`) REFERENCES `vdlm_product` (`id`);

ALTER TABLE `vdlm_product_tag` ADD CONSTRAINT `fk_tag_ref_shop` FOREIGN KEY (`shop_id`) REFERENCES `vdlm_shop` (`id`);

ALTER TABLE `vdlm_product_tag` ADD CONSTRAINT `fk_tag_ref_tag` FOREIGN KEY (`tag_id`) REFERENCES `vdlm_tag` (`id`);

ALTER TABLE `vdlm_product`
DROP COLUMN `forsale_at`,
ADD COLUMN `forsale_at`  datetime NULL COMMENT '待发布时间' AFTER `archive`;

ALTER TABLE `vdlm_product`
ADD COLUMN `desc_img`  varchar(400) NULL AFTER `img`;
ALTER TABLE `vdlm_product`
MODIFY COLUMN `desc_img`  varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存放商品描述的图片， 包含img的值，以逗号相隔' AFTER `img`;


-- ----------------------------
-- Table structure for vdlm_product_image
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_product_image`;
CREATE TABLE `vdlm_product_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `img` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `vdlm_product_image` ADD CONSTRAINT `fk_image_ref_product` FOREIGN KEY (`product_id`) REFERENCES `vdlm_product` (`id`);


ALTER TABLE `vdlm_shop`
MODIFY COLUMN `img`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL AFTER `name`,
ADD COLUMN `wechat`  varchar(40) NULL COMMENT '微信号' AFTER `name`,
ADD COLUMN `banner`  varchar(40) NULL COMMENT '店铺招牌' AFTER `wechat`,
ADD COLUMN `description`  varchar(200) NULL COMMENT '店铺说明' AFTER `banner`;

ALTER TABLE `vdlm_product`
MODIFY COLUMN `img`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL AFTER `name`;

-- 2014-05-16 by ahlon
alter table `vdlm_order` add column `type` varchar(20) not null after `order_no`;

-- 2014-05-20 by ahlon
alter table `vdlm_order` add column `cancelled_at` datetime after `paid_at`;
alter table `vdlm_order` add column `shipped_at` datetime after `cancelled_at`;
alter table `vdlm_order` add column `succeed_at` datetime after `shipped_at`;
