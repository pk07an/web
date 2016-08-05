ALTER TABLE `vdlm_withdraw_apply`
ADD COLUMN `op_remark`  varchar(100) NULL AFTER `type`;

-- 更新cancel的订单的关闭时间
ALTER TABLE `vdlm_order` ADD COLUMN `cancelled_at` datetime NULL AFTER `checking_at`;
update vdlm_order set cancelled_at = updated_at where status = 'CANCELLED' or status = 'CLOSED';

-- 更新succeed的订单成功时间
ALTER TABLE `vdlm_order` ADD COLUMN `succeed_at` datetime NULL AFTER `cancelled_at`;
update vdlm_order set succeed_at = updated_at where status = 'SUCCESS';

-- added by ladon for 订单留言
DROP TABLE IF EXISTS `vdlm_order_message`;
CREATE TABLE `vdlm_order_message` (
  `id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `buyer_id` bigint(20) NOT NULL,
  `seller_id` bigint(20) NOT NULL,
  `group_id` bigint(20), 
  `content` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `has_read`  tinyint(1) default false,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_msg_id` USING BTREE (`order_id`,`buyer_id`,`seller_id`,`group_id`)
) ENGINE=InnoDB;
