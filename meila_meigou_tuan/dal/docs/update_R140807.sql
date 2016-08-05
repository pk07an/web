ALTER TABLE `vdlm_shop` drop index `fk_shop_ref_image`;

-- start of added by ahlon on 2014-08-07 15:46
ALTER TABLE `vdlm_tag` drop index `IDX_TAG`;
alter table `vdlm_tag` add column `creator_id` bigint;
alter table `vdlm_tag` add column `updated_at` datetime;
ALTER TABLE `vdlm_tag` ADD INDEX `idx1` (tag, creator_id);

-- 分类/类目
CREATE TABLE `vdlm_term` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `vdlm_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `term_id` bigint(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `taxonomy` varchar(30) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `tree_path` varchar(200) DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx1` (`term_id`,`taxonomy`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `vdlm_term_relationship` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) DEFAULT NULL,
  `obj_type` varchar(20) DEFAULT NULL,
  `obj_id` varchar(50) DEFAULT NULL,
  `tree_path` varchar(200) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx1` (`category_id`,`obj_type`,`obj_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 海报
CREATE TABLE `vdlm_poster` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `img_code` varchar(100) NOT NULL,
  `url` varchar(200) DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `vdlm_poster_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `poster_id` bigint(20) NOT NULL,
  `term_id` bigint(20) NOT NULL,
  `creator_id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 海报数据初始化
--insert into `vdlm_term`(name) value('首页海报');

insert into `vdlm_poster`(img_code, url) value('qn|ixp-resources|FlnpAMpSXdiRiq5NThaQq7OFhygk', 'http://www.kkkd.com/market/b8qp/c1cp');
insert into `vdlm_poster`(img_code, url) value('qn|ixp-other|FojFq0cNd653rEWkQT9D5sigSlck', 'http://www.kkkd.com/about/kk_start.html');
insert into `vdlm_poster`(img_code, url) value('qn|ixp-other|Fvl8Avw6Kj-4h2HpvQSItcCZ9bMj', 'http://www.kkkd.com/static/activity/banner.html');

insert into `vdlm_poster_tag`(poster_id, term_id) value('1', '1');
insert into `vdlm_poster_tag`(poster_id, term_id) value('841', '1');
insert into `vdlm_poster_tag`(poster_id, term_id) value('1681', '1');
-- end of added by ahlon on 2014-08-07 15:46
 
-- start of added by ahlon on 2014-08-08 11:22
-- 添加虚假销量
alter table `vdlm_product` add column `fake_sales` bigint;
-- end of added by ahlon on 2014-08-08 11:22

-- repair crash on android plantform  by ladon on 2014-08-08 12:10
INSERT INTO `vdlm_shop` ( owner_id, NAME, STATUS, archive, created_at, updated_at ) SELECT id, loginname, 'ACTIVE', FALSE, now() AS created_at, now() AS updated_at FROM `vdlm_user` vu WHERE id NOT IN ( SELECT owner_id FROM `vdlm_shop` vs ) AND vu.loginname NOT LIKE 'CID%' AND vu.id > 0;

ALTER TABLE `vdlm_sub_account`
MODIFY COLUMN `balance`  decimal(14,4) UNSIGNED NOT NULL COMMENT '用户的余额' AFTER `account_type`;
