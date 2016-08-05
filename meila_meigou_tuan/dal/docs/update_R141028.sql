--新增订单支付方式组合的详情表
CREATE TABLE `vdlm_cashieritem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `biz_no` varchar(30) NOT NULL,
  `payment_channel` varchar(30) NOT NULL,
  `payment_mode` varchar(30) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `third_vouchers` decimal(10,2) DEFAULT NULL,
  `agreement_id` bigint(20) DEFAULT NULL,
  `bankCode` varchar(15) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `third_voucher_name` varchar(50) NOT NULL,
  `third_voucher_id` varchar(30) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `updated_at` datetime NOT NULL,
  `bankName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `vdlm_activity_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `seller_id` bigint(20) NOT NULL,
  `buyer_id` bigint(20) NOT NULL,
  `total_fee` decimal(10,2) NOT NULL,
  `activity_id` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
    
   INSERT INTO `vdlm`.`vdlm_message` (`id`, `title`, `content`, `type`, `status`, `sess_id`, `reply_to`, `created_at`, `updated_at`) 
   VALUES ('2007', '订单手续费', '当前订单金额大于%s，会收取相应手续费', 'SYSTEM', 'VALID', 'b5a5b054-313d-4e85-b27e-8aa041c6dcad', NULL, now(), now()); 
   
   INSERT INTO `vdlm`.`vdlm_message` (`id`, `title`, `content`, `type`, `status`, `sess_id`, `reply_to`, `created_at`, `updated_at`) 
   VALUES ('2507', '免单通知', '恭喜你获得免单奖励! 免单金额: %s 元!', 'SYSTEM', 'VALID', 'b5a5b044-313d-4e85-b27e-8aa041c6dcad', NULL, now(), now()); 

ALTER TABLE `vdlm_outpay`
MODIFY COLUMN `trade_no` varchar(128) NULL COMMENT '第三方交易号' AFTER `bill_no`;

--初始化收银台数据，所有的order表里的数据，都放入收银台 by yangjia 20141028
insert into vdlm_cashieritem(biz_no, payment_channel, payment_mode, amount, third_vouchers, bankCode, created_at, third_voucher_name, third_voucher_id,
status, updated_at, bankName)
select order_no, 'PLATFORM', pay_type, total_fee, 0, '', created_at, '', '', 'SUCCESS', paid_at, ''
from vdlm_order where paid_status = 'SUCCESS';

insert into vdlm_cashieritem(biz_no, payment_channel, payment_mode, amount, third_vouchers, bankCode, created_at, third_voucher_name, third_voucher_id,
status, updated_at, bankName)
select order_no, 'PLATFORM', pay_type, total_fee, 0, '', created_at, '', '', 'PENDING', paid_at, ''
from vdlm_order where paid_status is null;

update vdlm_cashieritem set updated_at = created_at where updated_at = '0000-00-00 00:00:00' or updated_at is null;
