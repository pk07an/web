-- 2014-07-07 by ahlon
alter table `vdlm_user` add UNIQUE KEY `loginname` (`name`);
alter table `vdlm_user` add UNIQUE KEY `loginname` (`loginname`);

ALTER TABLE `vdlm_product`
MODIFY COLUMN `price`  decimal(12,2) NOT NULL AFTER `status`;

ALTER TABLE `vdlm_product`
MODIFY COLUMN `price`  decimal(12,2) NOT NULL AFTER `status`;

ALTER TABLE `vdlm_sku`
MODIFY COLUMN `price`  decimal(12,2) NOT NULL AFTER `spec`;

ALTER TABLE `vdlm_order_item`
MODIFY COLUMN `price`  decimal(12,2) NOT NULL AFTER `product_img`;



