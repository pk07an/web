ALTER TABLE `vdlm_sms_message`
MODIFY COLUMN `type`  varchar(50) NOT NULL AFTER `content`;

/*
*添加详情字段
*20150119
*/
ALTER TABLE spider.item
ADD COLUMN details mediumtext NULL;

/*
*添加图片类型字段
*20150120
*/
ALTER TABLE spider.img
ADD COLUMN type INT NULL;

insert into vdlm_message(id, title, content, type, status, created_at, updated_at)
values(3001, '退款申请消息', '您的店铺有一笔订单{orderNo}买家已经申请退款，请及时联系买家协商处理，如果您拒绝，则买家可以申请平台介入，如果您超时无响应，系统会打款给到买家。', 'SYSTEM', 'VALID', now(), now());

insert into vdlm_message(id, title, content, type, status, created_at, updated_at)
values(3002, '退款申请消息', '卖家已经拒绝您关于订单{orderNo}的售后申请，请您联系卖家协商处理，如果不能达成一致，您可以申请平台介入。', 'SYSTEM', 'VALID', now(), now());

insert into vdlm_message(id, title, content, type, status, created_at, updated_at)
values(3003, '退款申请消息', '卖家已经同意您关于订单{orderNo}的退货/换货申请，请您及时联系卖家，按约定将商品寄回，并上传物流单号，如果您超时无响应，退货申请将自动关闭。', 'SYSTEM', 'VALID', now(), now());

insert into vdlm_message(id, title, content, type, status, created_at, updated_at)
values(3004, '退款申请消息', '卖家已经同意您的订单{orderNo}退款申请，系统已经安排退款给您，三个工作日内到账，请您注意查收。', 'SYSTEM', 'VALID', now(), now());


CREATE TABLE `vdlm_order_refund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apply_no` varchar(30) NOT NULL COMMENT '申请编号',
  `order_id` bigint(20) NOT NULL,
  `order_fee` decimal(10,0) DEFAULT NULL,
  `product_name` varchar(60) DEFAULT NULL,
  `img` varchar(60) DEFAULT NULL,
  `order_status` varchar(20) NOT NULL,
  `refund_fee` decimal(10,2) NOT NULL,
  `buyer_require` int(11) DEFAULT NULL COMMENT '买家要求  1仅退款，2退货并退款',
  `buyer_received` tinyint(1) DEFAULT NULL COMMENT '买家是否收到货1是 0否',
  `refund_reason` varchar(50) DEFAULT NULL COMMENT '退款原因',
  `refund_memo` varchar(2000)  DEFAULT NULL COMMENT '退款备注',
  `return_address` varchar(200) DEFAULT NULL,
  `return_name` varchar(100) DEFAULT NULL,
  `return_phone` varchar(50) DEFAULT NULL,
  `return_memo` varchar(1000) DEFAULT NULL,
  `refuse_detail` varchar(1000) DEFAULT NULL,
  `refuse_reason` varchar(200) DEFAULT NULL,
  `reject_return_time` datetime DEFAULT NULL,
  `status` varchar(20) NOT NULL COMMENT '退款申请状态',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `logistics_company` varchar(50) DEFAULT NULL,
  `logistics_no` varchar(50) DEFAULT NULL,
  `logistics_memo` varchar(1000) DEFAULT NULL,
  `reject_time` datetime DEFAULT NULL,
  `confirm_time` datetime DEFAULT NULL,
  `ship_time` datetime DEFAULT NULL,
  `sign_time` datetime DEFAULT NULL,
  `archive` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_order_refund_orderId` (`order_id`)
) ENGINE=InnoDB;


ALTER TABLE `vdlm_cashieritem`
ADD INDEX `idx_cashieritem_batch_biz_nos` (`batch_biz_nos`) ;
