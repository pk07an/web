-- by ladon  2014-08-13 12:44
drop table if exists vdlm.vdlm_postconf;
CREATE TABLE vdlm.vdlm_postconf (
  `id` bigint(20) not null auto_increment,
  `name` varchar(20), 
  `associate_id` bigint(20) not null,
  `region_type` int(2) not null default 0 comment '0:常用地区, 1:省级, 2:市级',
  `archive` tinyint(1)  not null default 0,
  `created_at` datetime not null,
  `updated_at` datetime not null,
   primary key (`id`)
) engine=innodb auto_increment=26436 default charset=utf8 comment='店铺免邮费区域配置列表';

ALTER TABLE `vdlm_sub_account`
MODIFY COLUMN `balance`  decimal(14,4) UNSIGNED NOT NULL COMMENT '用户的余额' AFTER `account_type`;

-- by ladon  2014-08-13 12:44
alter table `vdlm_order` add column `vip` tinyint(1) default 0 not null;
alter table `vdlm_shop` add column `free_zone` varchar(50);

-- by ladon  2014-08-14 10:00
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'长沙',1985,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'长春',630,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'成都',2507,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'重庆',2465,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'大连',516,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'东莞',2275,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'佛山',2183,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'福州',1260,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'贵阳',2730,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'合肥',1122,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'金华',1074,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'济南',1487,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'嘉兴',1050,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'昆明',2833,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'宁波',1024,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'南昌',1364,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'南京',882,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'青岛',1499,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'泉州',1304,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'沈阳',501,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'苏州',926,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'天津',20,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'温州',1037,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'无锡',895,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'武汉',1855,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'西安',3070,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'厦门',1275,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'郑州',1660,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'中山',2276,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'石家庄',40,1,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'哈尔滨',708,1,false,now(), now());  -- city:31

Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'安徽',1121,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'福建',1259,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'甘肃',3197,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'广东',2134,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'贵州',2729,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'海南',2435,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'河北',39,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'河南',1659,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'湖北',1854,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'湖南',1984,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'江苏',881,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'江西',1363,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'吉林',629,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'辽宁',500,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'青海',3310,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'山东',1486,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'山西',234,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'陕西',3069,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'云南',2832,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'四川',2506,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'黑龙江',707,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'浙江',1008,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'台湾',3513,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'澳门',3515,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'香港',3514,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'内蒙古',376,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'广西',2296,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'西藏',2986,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'新疆',3396,2,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'宁夏',3363,2,false,now(), now());  -- province:30

Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'北京',2,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'上海',861,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'广州',2135,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'深圳',2161,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'杭州',1009,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'江浙沪',881,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'江浙沪',1008,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'江浙沪',861,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'珠三角',2135,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'珠三角',2161,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'珠三角',2169,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'珠三角',2183,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'珠三角',2190,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'珠三角',2275,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'珠三角',2276,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'珠三角',2228,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'珠三角',2218,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'京津冀',2,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'京津冀',20,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'京津冀',39,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'东三省',707,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'东三省',500,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'东三省',629,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'港澳台',3514,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'港澳台',3515,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'港澳台',3513,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'江浙沪皖',881,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'江浙沪皖',1008,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'江浙沪皖',861,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'江浙沪皖',1121,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'海外',3516,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'海外',3518,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'海外',3519,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'海外',3520,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'海外',3521,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'海外',3522,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'海外',3523,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'海外',3524,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'海外',3525,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'海外',3526,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'海外',3527,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'海外',3528,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'海外',3529,0,false,now(), now());
Insert into vdlm.vdlm_postconf (id,name,associate_id,region_type,archive,created_at,updated_at) values (null,'海外',3530,0,false,now(), now()); -- common:44


-- added by ahlon at 2014-08-13 14:32 for path updates
update `vdlm_zone` t set parent_id = (select parent_id from `vdlm_zone_copy` v where v.id = t.parent_id) where t.parent_id in (SELECT id FROM `vdlm_zone_copy` where name like '市辖区');
update vdlm_zone set archive = 1 where name like '市辖区';

-- added by ahlon at 2014-08-14 15:00 for path shop styles
CREATE TABLE `vdlm_shop_style` (
  `shop_id` bigint(20) NOT NULL,
  `bg_color` varchar(20) DEFAULT NULL,
  `font_family` varchar(30) DEFAULT NULL,
  `font_color` varchar(20) DEFAULT NULL,
  `avatar_style` varchar(20) DEFAULT NULL,
  `list_view` varchar(20) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`shop_id`)
) ENGINE=innodb;



