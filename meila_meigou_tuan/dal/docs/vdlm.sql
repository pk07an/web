/*
Navicat MySQL Data Transfer

Source Server         : mogujie
Source Server Version : 50173
Source Host           : 10.8.100.2:3306
Source Database       : vdlm

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2014-06-16 16:04:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `persistent_logins`
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
`username`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`series`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`token`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`last_used`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`series`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `vdlm_access_report`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_access_report`;
CREATE TABLE `vdlm_access_report` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`date`  date NOT NULL ,
`shop_id`  bigint(20) NOT NULL ,
`uv`  int(11) NOT NULL ,
`img`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=26816

;

-- ----------------------------
-- Table structure for `vdlm_account`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_account`;
CREATE TABLE `vdlm_account` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`user_id`  bigint(20) NULL DEFAULT NULL ,
`balance`  decimal(10,4) NOT NULL DEFAULT 0.0000 ,
`freeze_balance`  decimal(10,4) NULL DEFAULT 0.0000 ,
`archive`  tinyint(1) NOT NULL DEFAULT 0 ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=264701

;

-- ----------------------------
-- Table structure for `vdlm_address`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_address`;
CREATE TABLE `vdlm_address` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`user_id`  bigint(20) NOT NULL ,
`zone_id`  bigint(20) NOT NULL ,
`street`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`consignee`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`phone`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`weixin_id`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`common`  tinyint(1) NOT NULL ,
`archive`  tinyint(1) NOT NULL DEFAULT 0 ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=16486

;

-- ----------------------------
-- Table structure for `vdlm_app_version`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_app_version`;
CREATE TABLE `vdlm_app_version` (
`id`  bigint(20) NOT NULL ,
`name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`version`  int(10) NOT NULL ,
`file_size`  int(10) NOT NULL ,
`md5`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`url`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`created_at`  datetime NULL DEFAULT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
`msg`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `vdlm_cart_item`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_cart_item`;
CREATE TABLE `vdlm_cart_item` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`client_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_id`  bigint(20) NULL DEFAULT NULL ,
`product_id`  bigint(20) NOT NULL ,
`sku_id`  bigint(20) NOT NULL ,
`amount`  int(11) NOT NULL ,
`status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive`  tinyint(1) NOT NULL DEFAULT 0 ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=63229

;

-- ----------------------------
-- Table structure for `vdlm_deal`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_deal`;
CREATE TABLE `vdlm_deal` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`deal_no`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`order_id`  bigint(20) NULL DEFAULT NULL ,
`withdraw_id`  bigint(20) NULL DEFAULT NULL COMMENT '提现交易ID' ,
`pay_deal_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`deal_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`account_from`  bigint(20) NULL DEFAULT NULL ,
`account_to`  bigint(20) NULL DEFAULT NULL ,
`fee`  decimal(10,2) NULL DEFAULT NULL ,
`status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=204427

;

-- ----------------------------
-- Table structure for `vdlm_deal_log`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_deal_log`;
CREATE TABLE `vdlm_deal_log` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`deal_id`  bigint(20) NOT NULL ,
`title`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`account_id`  bigint(20) NOT NULL ,
`fee`  decimal(10,0) NOT NULL ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=242558

;

-- ----------------------------
-- Table structure for `vdlm_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_feedback`;
CREATE TABLE `vdlm_feedback` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`user_id`  bigint(20) NULL DEFAULT NULL ,
`content`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`contact`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1970

;

-- ----------------------------
-- Table structure for `vdlm_image`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_image`;
CREATE TABLE `vdlm_image` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`name`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`suffix`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`size`  int(11) NULL DEFAULT NULL ,
`image22`  mediumblob NULL COMMENT '原图' ,
`archive`  tinyint(4) NOT NULL DEFAULT 0 ,
`type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`belong`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`img_key`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`created_at`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=186468

;

-- ----------------------------
-- Table structure for `vdlm_message`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_message`;
CREATE TABLE `vdlm_message` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`title`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`content`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`sess_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`reply_to`  bigint(20) NULL DEFAULT NULL ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=9226

;

-- ----------------------------
-- Table structure for `vdlm_order`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_order`;
CREATE TABLE `vdlm_order` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`order_no`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`pay_type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`buyer_id`  bigint(20) NOT NULL ,
`shop_id`  bigint(20) NOT NULL ,
`seller_id`  bigint(20) NOT NULL ,
`logistics_fee`  decimal(10,2) NULL DEFAULT NULL ,
`total_fee`  decimal(10,2) NOT NULL ,
`paid_fee`  decimal(10,2) NULL DEFAULT 0.00 ,
`discount_fee`  decimal(10,2) NULL DEFAULT NULL ,
`goods_fee`  decimal(10,2) NULL DEFAULT NULL ,
`paid_at`  datetime NULL DEFAULT NULL ,
`paid_status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`shipped_at`  datetime NULL DEFAULT NULL ,
`logistics_company`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`logistics_order_no`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`remark`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive`  tinyint(1) NOT NULL DEFAULT 0 ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=131869

;

-- ----------------------------
-- Table structure for `vdlm_order_address`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_order_address`;
CREATE TABLE `vdlm_order_address` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`order_id`  bigint(20) NOT NULL ,
`zone_id`  bigint(20) NOT NULL ,
`street`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`consignee`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`phone`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`weixin_id`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive`  tinyint(1) NOT NULL DEFAULT 0 ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=132718

;

-- ----------------------------
-- Table structure for `vdlm_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_order_item`;
CREATE TABLE `vdlm_order_item` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`order_id`  bigint(20) NOT NULL ,
`product_id`  bigint(20) NOT NULL ,
`sku_id`  bigint(20) NOT NULL ,
`product_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sku_str`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`product_img`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`price`  decimal(10,2) NOT NULL ,
`amount`  int(11) NOT NULL ,
`archive`  tinyint(1) NOT NULL DEFAULT 0 ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=126702

;

-- ----------------------------
-- Table structure for `vdlm_payment`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_payment`;
CREATE TABLE `vdlm_payment` (
`type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`img`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`description`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`pay_url`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`archive`  tinyint(1) NOT NULL ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NOT NULL 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `vdlm_product`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_product`;
CREATE TABLE `vdlm_product` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`user_id`  bigint(20) NOT NULL ,
`shop_id`  bigint(20) NOT NULL ,
`name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`img`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`desc_img`  varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存放商品描述的图片， 包含img的值，以逗号相隔' ,
`description`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`price`  decimal(10,2) NOT NULL ,
`amount`  bigint(10) NOT NULL ,
`sales`  bigint(10) NOT NULL ,
`archive`  tinyint(1) NOT NULL DEFAULT 0 ,
`recommend`  tinyint(4) NULL DEFAULT 0 ,
`recommend_at`  datetime NULL DEFAULT NULL ,
`forsale_at`  datetime NULL DEFAULT NULL ,
`onsale_at`  datetime NULL DEFAULT NULL ,
`instock_at`  datetime NULL DEFAULT NULL ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=267895

;

-- ----------------------------
-- Table structure for `vdlm_product_image`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_product_image`;
CREATE TABLE `vdlm_product_image` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`product_id`  bigint(20) NOT NULL ,
`img`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`order`  tinyint(4) NULL DEFAULT NULL ,
`archive`  tinyint(4) NOT NULL DEFAULT 0 ,
`created_at`  datetime NOT NULL ,
PRIMARY KEY (`id`),
INDEX `idx_product_img_productId` USING BTREE (`product_id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=103198

;

-- ----------------------------
-- Table structure for `vdlm_product_tag`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_product_tag`;
CREATE TABLE `vdlm_product_tag` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`shop_id`  bigint(20) NOT NULL COMMENT '目前阶段做冗余字段，建索引，方便本店内查找。可扩展成店铺索引' ,
`product_id`  bigint(20) NOT NULL ,
`archive`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '标志删除，定期删除' ,
`tag_id`  bigint(20) NOT NULL ,
`created_at`  datetime NOT NULL ,
PRIMARY KEY (`id`),
INDEX `fk_tag_ref_tag` USING BTREE (`tag_id`) ,
INDEX `fk_tag_ref_shop` USING BTREE (`shop_id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=94220

;

-- ----------------------------
-- Table structure for `vdlm_push_message`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_push_message`;
CREATE TABLE `vdlm_push_message` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`user_id`  bigint(20) NULL DEFAULT NULL ,
`title`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`description`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`image_url`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`detail_url`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`device_type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`count`  int(10) NULL DEFAULT NULL ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=740

;

-- ----------------------------
-- Table structure for `vdlm_shop`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_shop`;
CREATE TABLE `vdlm_shop` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`owner_id`  bigint(20) NOT NULL ,
`name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`wechat`  varchar(40) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '微信号' ,
`banner`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '店铺招牌' ,
`description`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '店铺说明' ,
`img`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bulletin`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bulletin_at`  datetime NULL DEFAULT NULL ,
`status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`archive`  tinyint(1) NOT NULL DEFAULT 0 ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
INDEX `fk_shop_ref_image` USING BTREE (`img`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=127315

;

-- ----------------------------
-- Table structure for `vdlm_shop_access`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_shop_access`;
CREATE TABLE `vdlm_shop_access` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`date`  date NOT NULL ,
`hour`  tinyint(4) NOT NULL ,
`pv`  int(255) NOT NULL ,
`user_id`  bigint(100) NOT NULL ,
`shop_id`  bigint(20) NOT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`shop_id`) REFERENCES `vdlm_shop` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `idx_shop_access` USING BTREE (`date`, `hour`, `user_id`, `shop_id`) ,
INDEX `fk_shop_access_ref_shop` USING BTREE (`shop_id`) ,
INDEX `idx_shop_access_date` USING BTREE (`date`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=14639

;

-- ----------------------------
-- Table structure for `vdlm_sku`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_sku`;
CREATE TABLE `vdlm_sku` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`product_id`  bigint(20) NOT NULL ,
`spec`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`price`  decimal(10,2) NOT NULL ,
`amount`  int(10) NOT NULL ,
`sku_order`  int(11) NULL DEFAULT NULL ,
`archive`  tinyint(1) NOT NULL DEFAULT 0 ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=617708

;

-- ----------------------------
-- Table structure for `vdlm_sms_message`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_sms_message`;
CREATE TABLE `vdlm_sms_message` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`phone`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`content`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`count`  int(10) NULL DEFAULT NULL ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=9719

;

-- ----------------------------
-- Table structure for `vdlm_tag`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_tag`;
CREATE TABLE `vdlm_tag` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`tag`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`created_at`  datetime NOT NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `IDX_TAG` USING BTREE (`tag`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=9596

;

-- ----------------------------
-- Table structure for `vdlm_tinyurl`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_tinyurl`;
CREATE TABLE `vdlm_tinyurl` (
`url_key`  char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`url_md5`  char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`url`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`created_at`  datetime NOT NULL ,
PRIMARY KEY (`url_key`),
INDEX `url_md5_index` USING BTREE (`url_md5`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `vdlm_user`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_user`;
CREATE TABLE `vdlm_user` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`phone`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`loginname`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`email`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`avatar`  varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`password`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`shop_id`  bigint(20) NULL DEFAULT NULL ,
`archive`  tinyint(1) NOT NULL DEFAULT 0 ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
`admin`  tinyint(1) NULL DEFAULT 0 ,
PRIMARY KEY (`id`),
UNIQUE INDEX `unique_phone` USING BTREE (`phone`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=760891

;

-- ----------------------------
-- Table structure for `vdlm_user_bank`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_user_bank`;
CREATE TABLE `vdlm_user_bank` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`user_id`  bigint(20) NOT NULL ,
`account_number`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`account_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`opening_bank`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive`  tinyint(1) NOT NULL DEFAULT 0 ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NOT NULL ,
PRIMARY KEY (`id`),
INDEX `idx_user_bank_user` USING BTREE (`user_id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=3077

;

-- ----------------------------
-- Table structure for `vdlm_user_message`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_user_message`;
CREATE TABLE `vdlm_user_message` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`from_user_id`  bigint(20) NULL DEFAULT NULL ,
`to_user_id`  bigint(20) NOT NULL ,
`msg_id`  bigint(20) NOT NULL ,
`status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=5659

;

-- ----------------------------
-- Table structure for `vdlm_withdraw_apply`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_withdraw_apply`;
CREATE TABLE `vdlm_withdraw_apply` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`user_id`  bigint(20) NOT NULL ,
`bank_id`  bigint(20) NOT NULL ,
`account_number`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`account_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`opening_bank`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`apply_money`  decimal(14,2) NOT NULL ,
`confirm_money`  decimal(14,2) NULL DEFAULT NULL ,
`archive`  tinyint(4) NULL DEFAULT 0 ,
`status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`pay_at`  datetime NULL DEFAULT NULL ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NOT NULL ,
PRIMARY KEY (`id`),
INDEX `FK_widthdraw_apply_ref_bank` USING BTREE (`bank_id`) ,
INDEX `IDX_WITHDRAW_APPLY_USERID` USING BTREE (`user_id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4922

;

-- ----------------------------
-- Table structure for `vdlm_zone`
-- ----------------------------
DROP TABLE IF EXISTS `vdlm_zone`;
CREATE TABLE `vdlm_zone` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`zip_code`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`path`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`parent_id`  bigint(20) NULL DEFAULT 0 ,
`creator_id`  int(11) NULL DEFAULT NULL ,
`archive`  tinyint(4) NOT NULL DEFAULT 0 ,
`created_at`  datetime NOT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=3531

;

-- ----------------------------
-- Auto increment value for `vdlm_access_report`
-- ----------------------------
ALTER TABLE `vdlm_access_report` AUTO_INCREMENT=26816;

-- ----------------------------
-- Auto increment value for `vdlm_account`
-- ----------------------------
ALTER TABLE `vdlm_account` AUTO_INCREMENT=264701;

-- ----------------------------
-- Auto increment value for `vdlm_address`
-- ----------------------------
ALTER TABLE `vdlm_address` AUTO_INCREMENT=16486;

-- ----------------------------
-- Auto increment value for `vdlm_cart_item`
-- ----------------------------
ALTER TABLE `vdlm_cart_item` AUTO_INCREMENT=63229;

-- ----------------------------
-- Auto increment value for `vdlm_deal`
-- ----------------------------
ALTER TABLE `vdlm_deal` AUTO_INCREMENT=204427;

-- ----------------------------
-- Auto increment value for `vdlm_deal_log`
-- ----------------------------
ALTER TABLE `vdlm_deal_log` AUTO_INCREMENT=242558;

-- ----------------------------
-- Auto increment value for `vdlm_feedback`
-- ----------------------------
ALTER TABLE `vdlm_feedback` AUTO_INCREMENT=1970;

-- ----------------------------
-- Auto increment value for `vdlm_image`
-- ----------------------------
ALTER TABLE `vdlm_image` AUTO_INCREMENT=186468;

-- ----------------------------
-- Auto increment value for `vdlm_message`
-- ----------------------------
ALTER TABLE `vdlm_message` AUTO_INCREMENT=9226;

-- ----------------------------
-- Auto increment value for `vdlm_order`
-- ----------------------------
ALTER TABLE `vdlm_order` AUTO_INCREMENT=131869;

-- ----------------------------
-- Auto increment value for `vdlm_order_address`
-- ----------------------------
ALTER TABLE `vdlm_order_address` AUTO_INCREMENT=132718;

-- ----------------------------
-- Auto increment value for `vdlm_order_item`
-- ----------------------------
ALTER TABLE `vdlm_order_item` AUTO_INCREMENT=126702;

-- ----------------------------
-- Auto increment value for `vdlm_product`
-- ----------------------------
ALTER TABLE `vdlm_product` AUTO_INCREMENT=267895;

-- ----------------------------
-- Auto increment value for `vdlm_product_image`
-- ----------------------------
ALTER TABLE `vdlm_product_image` AUTO_INCREMENT=103198;

-- ----------------------------
-- Auto increment value for `vdlm_product_tag`
-- ----------------------------
ALTER TABLE `vdlm_product_tag` AUTO_INCREMENT=94220;

-- ----------------------------
-- Auto increment value for `vdlm_push_message`
-- ----------------------------
ALTER TABLE `vdlm_push_message` AUTO_INCREMENT=740;

-- ----------------------------
-- Auto increment value for `vdlm_shop`
-- ----------------------------
ALTER TABLE `vdlm_shop` AUTO_INCREMENT=127315;

-- ----------------------------
-- Auto increment value for `vdlm_shop_access`
-- ----------------------------
ALTER TABLE `vdlm_shop_access` AUTO_INCREMENT=14639;

-- ----------------------------
-- Auto increment value for `vdlm_sku`
-- ----------------------------
ALTER TABLE `vdlm_sku` AUTO_INCREMENT=617708;

-- ----------------------------
-- Auto increment value for `vdlm_sms_message`
-- ----------------------------
ALTER TABLE `vdlm_sms_message` AUTO_INCREMENT=9719;

-- ----------------------------
-- Auto increment value for `vdlm_tag`
-- ----------------------------
ALTER TABLE `vdlm_tag` AUTO_INCREMENT=9596;

-- ----------------------------
-- Auto increment value for `vdlm_user`
-- ----------------------------
ALTER TABLE `vdlm_user` AUTO_INCREMENT=760891;

-- ----------------------------
-- Auto increment value for `vdlm_user_bank`
-- ----------------------------
ALTER TABLE `vdlm_user_bank` AUTO_INCREMENT=3077;

-- ----------------------------
-- Auto increment value for `vdlm_user_message`
-- ----------------------------
ALTER TABLE `vdlm_user_message` AUTO_INCREMENT=5659;

-- ----------------------------
-- Auto increment value for `vdlm_withdraw_apply`
-- ----------------------------
ALTER TABLE `vdlm_withdraw_apply` AUTO_INCREMENT=4922;

-- ----------------------------
-- Auto increment value for `vdlm_zone`
-- ----------------------------
ALTER TABLE `vdlm_zone` AUTO_INCREMENT=3531;
