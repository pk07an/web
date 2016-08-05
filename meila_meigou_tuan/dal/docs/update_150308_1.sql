ALTER TABLE `vdlm_order_refund`
ADD COLUMN `admin_status`  varchar(50) NULL AFTER `sign_time`,
ADD COLUMN `admin_remark`  varchar(256) NULL AFTER `admin_status`,
ADD COLUMN `admin_op_time`  datetime NULL AFTER `admin_remark`;
