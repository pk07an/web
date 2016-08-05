-- added by ahlon at 2014-08-19 13:30 for external user login
alter table vdlm_user add COLUMN partner VARCHAR(20);
alter table vdlm_user add COLUMN ext_user_id VARCHAR(50);

-- added by ladon at 2014-08-19 20:05 for 想去客服信息
drop table if exists `vdlm_customer_service`;
create table `vdlm_customer_service` (
  `id` bigint(20) not null primary key auto_increment,
  `name` varchar(30) not null comment '客服姓名',
  `tel_phone` varchar(30) not null comment '联系方式',
  `qq_id`     varchar(20)  comment '客服qq号',
  `weixin_id` varchar(20)  comment '客服微信号',
  `service_area` varchar(50) comment '服务范围',
  `note`      varchar(128) comment  '备注信息',
  `archive` tinyint(1)  not null default 0,
  `created_at` datetime not null,
  `updated_at` datetime not null
) engine=innodb default charset=utf8mb4 
comment='客服信息表';

-- added by ahlon at 2014-08-19 15:00 for 促销活动
CREATE TABLE `vdlm_promotion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `discount` decimal(10,2) NOT NULL,
  `details` text,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `archive` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

alter table vdlm_order add column promotion_id varchar(20);
alter table vdlm_order add column coupon_id varchar(20);

--  added by ladon at 2014-08-19 20:05 for 商品同步配置 (按商户id为单位)
drop table if exists `vdlm_prodsync`;
create table `vdlm_prodsync` (
  `id` bigint(20) not null primary key auto_increment,
  `shop_id` bigint(20) not null, 
  `name` varchar(20), 
  `synced`  tinyint(1)  not null default 0  comment '是否已同步',
  `archive` tinyint(1)  not null default 0,
  `created_at` datetime not null,
  `updated_at` datetime not null
) engine=innodb  default charset=utf8mb4
comment='商户商品同步配置表';

CREATE TABLE `vdlm_coupon_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `details` text,
  `min_price` decimal(10,0) DEFAULT NULL,
  `discount` decimal(10,0) DEFAULT NULL,
  `valid` tinyint(1) DEFAULT 1,
  `auto_use` tinyint(1) DEFAULT 0,
  `valid_from` datetime DEFAULT NULL,
  `valid_to` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
insert into vdlm_coupon_activity(title, discount, created_at, updated_at) value('新用户首单减5元', 5, now(), now());

CREATE TABLE `vdlm_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `activity_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `valid_from` datetime DEFAULT NULL,
  `valid_to` datetime DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

alter table `vdlm_address` add column `hash_code` varchar(100); 

insert into vdlm.vdlm_message values (101, '喜讯 - 交易完成可以收款啦', '', 'SYSTEM', 'VALID', '6a27aecc-2a5a-484e-b19f-ac7aeb5a874e', null, now(), now());
insert into vdlm.vdlm_message values (102, '喜讯 - 有宝贝被购买啦', '', 'SYSTEM', 'VALID', '6a27aecc-2a5a-484e-b19f-ac7aeb5a874a', null, now(), now());			
			
ALTER TABLE `vdlm_order` ADD INDEX idx_order_seller (`seller_id`);
ALTER TABLE `vdlm_shop` modify COLUMN commision_rate DECIMAL(5,4) DEFAULT 0;

-- 增加店铺操作运营备注
ALTER TABLE `vdlm_shop` ADD COLUMN `op_remark`  varchar(100) NULL AFTER `archive`;