CREATE TABLE `vdlm_activity_sp` (
	`id` BIGINT(20) NOT NULL ,
	`name` VARCHAR(100) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`shop_id` BIGINT(20) NOT NULL,
	`start_time` DATETIME NOT NULL,
	`end_time` DATETIME NOT NULL,
	`max_qty` INT(11) NOT NULL COMMENT '一个用户可以购买最大量 0 表示不限制',
	`creator_id` BIGINT(20) NULL DEFAULT NULL,
	`created_at` DATETIME NULL DEFAULT NULL,
	UNIQUE INDEX `IDX_ACT_SP` (`shop_id`, `start_time`),
	INDEX `PK_act_sp` (`id`)
)
COMMENT='特价商品活动'
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB;


insert into vdlm_activity_sp(id, name, shop_id, start_time, end_time,max_qty) 
  values(1,'20150116抢购',851688, ‘2015-01-16 10:00', '2015-01-23', 1);


insert into vdlm_activity_sp(id, name, shop_id, start_time, end_time,max_qty) 
  values(1,'20150116抢购',851688, ‘2015-01-16 10:00', '2015-01-23', 1);
  


CREATE TABLE `vdlm_activity_sp_product` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`activity_id` BIGINT(20) NOT NULL,
	`product_id` BIGINT(20) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `IDX_ACT_SP_PROD` (`activity_id`, `product_id`)
)
COMMENT='特价商品活动  关联商品'
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB;



insert into vdlm_activity_sp_product(activity_id, product_id) 
  values(1,3032636),
  values(1,3030834),
  values(1,3031119);  

ALTER TABLE `vdlm_cart_item`
ADD INDEX `idx1` (`user_id`, `sku_id`, `archive`) ;

ALTER TABLE `vdlm_coupon`
ADD INDEX `idx2` (`user_id`, `status`) ;

ALTER TABLE `vdlm_order_item`
ADD INDEX `idx1` (`order_id`) ;

ALTER TABLE `vdlm_product`
ADD INDEX `idx3` (`shop_id`, `status`) ;

ALTER TABLE `vdlm_image`
ADD INDEX `idx1` (`img_key`) ;

ALTER TABLE `vdlm_user`
ADD INDEX `idx1` (`roles`) ;

ALTER TABLE `persistent_logins`
ADD INDEX `idx1` (`username`) ;

alter table `vdlm_activity` add column `closed_time` datetime;

INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (1, '180601', '庞举', 'KKKD', '000002');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (2, '136116', '庞举', 'XIANGQU', '000002');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (3, '80641', '陈阿隆', 'KKKD', '000003');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (4, '138585', '陈阿隆', 'XIANGQU', '000003');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (5, '102481', '张晓', 'KKKD', '000004');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (6, '137542', '张晓', 'XIANGQU', '000004');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (7, '1239001', '金丹平', 'KKKD', '000005');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (8, '136246', '金丹平', 'XIANGQU', '000005');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (9, '111721', '胡晓阳', 'KKKD', '000006');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (10, '136292', '胡晓阳', 'XIANGQU', '000006');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (11, '12718441', '王远', 'KKKD', '000007');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (12, '166', '王远', 'XIANGQU', '000007');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (13, '4562881', '吕永明 ', 'KKKD', '000008');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (14, '136267', '吕永明 ', 'XIANGQU', '000008');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (15, '14278321', '刘晓龙', 'KKKD', '000009');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (16, '136094', '刘晓龙', 'XIANGQU', '000009');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (17, '13051921', '钱妙晓', 'KKKD', '000010');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (18, '137515', '钱妙晓', 'XIANGQU', '000010');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (19, '44521', '王磊', 'KKKD', '000011');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (20, '136591', '王磊', 'XIANGQU', '000011');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (21, '12857041', '张洋', 'KKKD', '000012');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (22, '138635', '张洋', 'XIANGQU', '000012');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (23, '280561', '李敏', 'KKKD', '000013');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (24, '142488', '李敏', 'XIANGQU', '000013');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (25, '42001', '梅楚鹏', 'KKKD', '000014');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (26, '136095', '梅楚鹏', 'XIANGQU', '000014');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (27, '13034281', '蒋冬冬', 'KKKD', '000015');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (28, '136331', '蒋冬冬', 'XIANGQU', '000015');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (29, '45361 ', '宋薇薇', 'KKKD', '000016');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (30, '135546', '宋薇薇', 'XIANGQU', '000016');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (31, '11639881', '夏振水', 'KKKD', '000017');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (32, '138064', '夏振水', 'XIANGQU', '000017');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (33, '42841', '吴华琴', 'KKKD', '000018');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (34, '135073', '吴华琴', 'XIANGQU', '000018');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (35, '12728521', '胡冠中', 'KKKD', '000019');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (36, '134910', '胡冠中', 'XIANGQU', '000019');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (37, '12678961', '冯振兴', 'KKKD', '000020');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (38, '136605', '冯振兴', 'XIANGQU', '000020');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (39, '16618432', '裴烨烽', 'KKKD', '000021');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (40, '141298', '裴烨烽', 'XIANGQU', '000021');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (41, '2474641', '严钻', 'KKKD', '000022');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (42, '135079', '严钻', 'XIANGQU', '000022');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (43, '17160028', '邹露', 'KKKD', '000023');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (44, '136285', '邹露', 'XIANGQU', '000023');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (45, '16640079', '宋涛', 'KKKD', '000024');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (46, '136047', '宋涛', 'XIANGQU', '000024');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (47, '807241', '王如雷', 'KKKD', '000025');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (48, '137987', '王如雷', 'XIANGQU', '000025');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (49, '4059721', '郭飞燕', 'KKKD', '000026');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (50, '140778', '郭飞燕', 'XIANGQU', '000026');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (51, '16618509', '潘继东', 'KKKD', '000027');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (52, '158418', '潘继东', 'XIANGQU', '000027');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (53, '263761', '李圣斌', 'KKKD', '000028');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (54, '136091', '李圣斌', 'XIANGQU', '000028');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (55, '12858721', '卞孝明', 'KKKD', '000029');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (56, '136245', '卞孝明', 'XIANGQU', '000029');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (57, '14586601', '汪业平', 'KKKD', '000030');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (58, '137957', '汪业平', 'XIANGQU', '000030');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (59, '3086161', '殷晨煜', 'KKKD', '000031');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (60, '136554', '殷晨煜', 'XIANGQU', '000031');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (61, '13465201', '邵志强', 'KKKD', '000032');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (62, '139825', '邵志强', 'XIANGQU', '000032');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (63, '11350921', '丰芬芳', 'KKKD', '000033');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (64, '183053', '丰芬芳', 'XIANGQU', '000033');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (65, '3941281', '辛丽娜', 'KKKD', '000034');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (66, '158057', '辛丽娜', 'XIANGQU', '000034');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (67, '12706681', '王伟', 'KKKD', '000035');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (68, '137070', '王伟', 'XIANGQU', '000035');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (69, '9161041', '崔会正', 'KKKD', '000036');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (70, '137009', '崔会正', 'XIANGQU', '000036');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (71, '17004744', '余晓旭', 'KKKD', '000037');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (72, '148846', '余晓旭', 'XIANGQU', '000037');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (73, '16606805', '朱昌锦', 'KKKD', '000038');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (74, '138401', '朱昌锦', 'XIANGQU', '000038');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (75, '16610735', '郭中平', 'KKKD', '000039');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (76, '139566', '郭中平', 'XIANGQU', '000039');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (77, '16612602', '杨钧婷', 'KKKD', '000040');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (78, '137674', '杨钧婷', 'XIANGQU', '000040');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (79, '16634135', '王宇岛', 'KKKD', '000041');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (80, '16716', '王宇岛', 'XIANGQU', '000041');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (81, '16637330', '夏杰', 'KKKD', '000042');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (82, '158129', '夏杰', 'XIANGQU', '000042');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (83, '17168822', '陶健', 'KKKD', '000043');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (84, '139680', '陶健', 'XIANGQU', '000043');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (85, '17254726', '伊俊全', 'KKKD', '000044');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (86, '160603', '伊俊全', 'XIANGQU', '000044');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (87, '16707679', '陈贤良', 'KKKD', '000045');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (88, '159561', '陈贤良', 'XIANGQU', '000045');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (89, '17166910', '姜志强', 'KKKD', '000046');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (90, '172578', '姜志强', 'XIANGQU', '000046');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (91, '16884872', '缪宇晨', 'KKKD', '000047');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (92, '178346', '缪宇晨', 'XIANGQU', '000047');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (93, '17194647', '冯辉', 'KKKD', '000048');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (94, '192272', '冯辉', 'XIANGQU', '000048');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (95, '17249176', '陈森樑', 'KKKD', '000049');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (96, '188642', '陈森樑', 'XIANGQU', '000049');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (97, '16990379', '张士东', 'KKKD', '000050');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (98, '176971', '张士东', 'XIANGQU', '000050');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (99, '16990124', '应汝鸳', 'KKKD', '000051 ');
INSERT INTO vdlm_personnel (id, ext_user_id, name, partner, inner_id) VALUES (100, '143086', '应汝鸳', 'XIANGQU', '000051');

ALTER TABLE `vdlm_campaign_product`
ADD UNIQUE INDEX `idx1` (`ticket_id`, `product_id`) ;