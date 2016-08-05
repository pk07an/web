ALTER TABLE `vdlm_outpay`
ADD INDEX `idx_outpay_billNo` (`bill_no`) ;

CREATE TABLE `vdlm_outpay_agreement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '对应vdlm_user表里id',
  `pay_mode` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '支付方式(ALIPAY,UMPAY)',
  `biz_agree_id` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户业务协议号',
  `pay_agree_id` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付协议号',
  `card_type` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '银行卡类型（CREDITCARD，DEBITCARD）',
  `gate_id` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '银行代码(ICBC,CCB等)',
  `created_at` datetime NOT NULL,
  `bind_status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT 'BIND' COMMENT 'UNBIND,BIND',
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


ALTER TABLE vdlm_withdraw_apply ADD (alipayAccount VARCHAR(64));


CREATE TABLE
    vdlm_paybank
    (
        id bigint NOT NULL AUTO_INCREMENT,
        bankName VARCHAR(30) NOT NULL,
        startWith VARCHAR(4) NOT NULL,
        img VARCHAR(50) NOT NULL,
        isHot INT DEFAULT '0' NOT NULL,
        status VARCHAR(15) DEFAULT 'TRUE' NOT NULL,
        PRIMARY KEY (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE
    vdlm_paybank_cardmode
    (
        paybank_id bigint NOT NULL,
        cardType VARCHAR(15) NOT NULL,
        paymentMode VARCHAR(15) NOT NULL,
        bankCode VARCHAR(15),
        status VARCHAR(15),
        PRIMARY KEY (paybank_id, cardType, paymentMode)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (1, '中国工商银行', 'g', '/_resources/images/bank/icbc.png', 1, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (2, '中国建设银行', 'j', '/_resources/images/bank/ccb.png', 1, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (3, '中国农业银行', 'n', '/_resources/images/bank/abc.png', 1, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (4, '中国银行', 'z', '/_resources/images/bank/boc.png', 1, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (5, '邮政储蓄银行', 'y', '/_resources/images/bank/psbc.png', 1, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (6, '中信银行', 'z', '/_resources/images/bank/citic.png', 1, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (7, '光大银行', 'g', '/_resources/images/bank/ceb.png', 1, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (8, '华夏银行', 'h', '/_resources/images/bank/hxb.png', 1, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (9, '民生银行', 'm', '/_resources/images/bank/cmbc.png', 1, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (10, '招商银行', 'z', '/_resources/images/bank/cmb.png', 1, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (11, '上海银行', 's', '/_resources/images/bank/shb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (12, '北京银行', 'b', '/_resources/images/bank/bjb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (13, '东亚银行', 'd', '/_resources/images/bank/bea.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (14, '兴业银行', 'x', '/_resources/images/bank/cib.png', 1, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (15, '宁波银行', 'n', '/_resources/images/bank/nbb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (16, '浦发银行', 'p', '/_resources/images/bank/spdb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (17, '广发银行', 'g', '/_resources/images/bank/gdb.png', 1, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (18, '平安银行', 'p', '/_resources/images/bank/spab.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (19, '包商银行', 'b', '/_resources/images/bank/bsb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (20, '长沙银行', 'c', '/_resources/images/bank/cscb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (21, '承德银行', 'c', '/_resources/images/bank/cdb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (22, '成都农商银行', 'c', '/_resources/images/bank/cdrcb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (23, '重庆农商银行', 'c', '/_resources/images/bank/crcb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (24, '大连银行', 'd', '/_resources/images/bank/dlb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (25, '重庆银行', 'c', '/_resources/images/bank/cqb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (26, '东营市商业银行', 'd', '/_resources/images/bank/dyccb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (27, '鄂尔多斯银行', 'e', '/_resources/images/bank/orbank.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (28, '福建农村信用社', 'f', '/_resources/images/bank/fjnxb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (29, '贵阳银行', 'g', '/_resources/images/bank/gyb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (30, '广州银行', 'g', '/_resources/images/bank/gcb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (31, '广州农村商业银行', 'g', '/_resources/images/bank/grcb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (32, '哈尔滨银行', 'h', '/_resources/images/bank/hebb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (33, '湖南省农村信用社', 'h', '/_resources/images/bank/hnnxb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (34, '徽商银行', 'h', '/_resources/images/bank/hsb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (35, '河北银行', 'h', '/_resources/images/bank/bhb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (36, '杭州银行', 'h', '/_resources/images/bank/hzcb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (37, '锦州银行', 'j', '/_resources/images/bank/bojz.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (38, '江苏常熟农村商业银行', 'j', '/_resources/images/bank/csrcb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (39, '江苏银行', 'j', '/_resources/images/bank/jsb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (40, '江阴农村商业银行', 'j', '/_resources/images/bank/jrcb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (41, '九江银行', 'j', '/_resources/images/bank/jjccb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (42, '兰州银行', 'l', '/_resources/images/bank/lzb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (43, '龙江银行', 'l', '/_resources/images/bank/daqingb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (44, '青海银行', 'q', '/_resources/images/bank/qhb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (45, '上饶银行', 's', '/_resources/images/bank/srb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (46, '顺德农村商业银行', 's', '/_resources/images/bank/sdeb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (47, '台州银行', 't', '/_resources/images/bank/tzcb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (48, '威海市商业银行', 'w', '/_resources/images/bank/whshb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (49, '潍坊银行', 'w', '/_resources/images/bank/wfccb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (50, '温州银行', 'w', '/_resources/images/bank/wzcb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (51, '乌鲁木齐商业银行', 'w', '/_resources/images/bank/urmqccb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (52, '无锡农村商业银行', 'w', '/_resources/images/bank/wrcb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (53, '宜昌市商业银行', 'y', '/_resources/images/bank/yccb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (54, '鄞州银行', 'y', '/_resources/images/bank/yzb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (55, '浙江稠州商业银行', 'z', '/_resources/images/bank/czcb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (56, '浙江泰隆商业银行', 'z', '/_resources/images/bank/zjtlcb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (57, '浙江民泰商业银行', 'z', '/_resources/images/bank/mtbank.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (58, '南京银行', 'n', '/_resources/images/bank/njcb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (59, '南昌银行', 'n', '/_resources/images/bank/ncb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (60, '齐鲁银行', 'q', '/_resources/images/bank/qlbank.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (61, '尧都农村商业银行', 'y', '/_resources/images/bank/ydrcb.png', 0, 'TRUE');
INSERT INTO vdlm_paybank (id, bankName, startWith, img, isHot, status) VALUES (62, '上海农商银行', 's', '/_resources/images/bank/shrcb.png', 0, 'TRUE');



INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (1, 'CREDITCARD', 'UMPAY', 'ICBC', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (2, 'CREDITCARD', 'UMPAY', 'CCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (2, 'DEBITCARD', 'UMPAY', 'ICBC', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (3, 'CREDITCARD', 'UMPAY', 'ABC', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (3, 'DEBITCARD', 'UMPAY', 'ICBC', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (4, 'CREDITCARD', 'UMPAY', 'BOC', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (4, 'DEBITCARD', 'UMPAY', 'ICBC', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (5, 'CREDITCARD', 'UMPAY', 'PSBC', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (6, 'CREDITCARD', 'UMPAY', 'CITIC', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (6, 'DEBITCARD', 'UMPAY', 'ICBC', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (7, 'CREDITCARD', 'UMPAY', 'CEB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (7, 'DEBITCARD', 'UMPAY', 'ICBC', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (8, 'CREDITCARD', 'UMPAY', 'HXB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (9, 'CREDITCARD', 'UMPAY', 'CMBC', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (10, 'CREDITCARD', 'UMPAY', 'CMB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (11, 'CREDITCARD', 'UMPAY', 'SHB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (12, 'CREDITCARD', 'UMPAY', 'BJB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (13, 'CREDITCARD', 'UMPAY', 'BEA', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (14, 'CREDITCARD', 'UMPAY', 'CIB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (14, 'DEBITCARD', 'UMPAY', 'ICBC', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (15, 'CREDITCARD', 'UMPAY', 'NBB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (16, 'CREDITCARD', 'UMPAY', 'SPDB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (17, 'CREDITCARD', 'UMPAY', 'GDB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (18, 'CREDITCARD', 'UMPAY', 'SPAB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (19, 'CREDITCARD', 'UMPAY', 'BSB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (20, 'CREDITCARD', 'UMPAY', 'CSCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (21, 'CREDITCARD', 'UMPAY', 'CDB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (22, 'CREDITCARD', 'UMPAY', 'CDRCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (23, 'CREDITCARD', 'UMPAY', 'CRCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (24, 'CREDITCARD', 'UMPAY', 'CQB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (25, 'CREDITCARD', 'UMPAY', 'DLB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (26, 'CREDITCARD', 'UMPAY', 'DYCCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (27, 'CREDITCARD', 'UMPAY', 'ORBANK', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (28, 'CREDITCARD', 'UMPAY', 'FJNXB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (29, 'CREDITCARD', 'UMPAY', 'GYB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (30, 'CREDITCARD', 'UMPAY', 'GCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (31, 'CREDITCARD', 'UMPAY', 'GRCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (32, 'CREDITCARD', 'UMPAY', 'HEBB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (33, 'CREDITCARD', 'UMPAY', 'HNNXB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (34, 'CREDITCARD', 'UMPAY', 'HSB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (35, 'CREDITCARD', 'UMPAY', 'BHB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (36, 'CREDITCARD', 'UMPAY', 'HZCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (37, 'CREDITCARD', 'UMPAY', 'BOJZ', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (38, 'CREDITCARD', 'UMPAY', 'CSRCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (39, 'CREDITCARD', 'UMPAY', 'JSB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (40, 'CREDITCARD', 'UMPAY', 'JRCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (41, 'CREDITCARD', 'UMPAY', 'JJCCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (42, 'CREDITCARD', 'UMPAY', 'LZB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (43, 'CREDITCARD', 'UMPAY', 'DAQINGB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (44, 'CREDITCARD', 'UMPAY', 'QHB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (45, 'CREDITCARD', 'UMPAY', 'SRB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (46, 'CREDITCARD', 'UMPAY', 'SDEB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (47, 'CREDITCARD', 'UMPAY', 'TZCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (48, 'CREDITCARD', 'UMPAY', 'WHSHB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (49, 'CREDITCARD', 'UMPAY', 'WFCCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (50, 'CREDITCARD', 'UMPAY', 'WZCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (51, 'CREDITCARD', 'UMPAY', 'URMQCCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (52, 'CREDITCARD', 'UMPAY', 'WRCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (53, 'CREDITCARD', 'UMPAY', 'YCCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (54, 'CREDITCARD', 'UMPAY', 'YZB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (55, 'CREDITCARD', 'UMPAY', 'CZCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (56, 'CREDITCARD', 'UMPAY', 'ZJTLCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (57, 'CREDITCARD', 'UMPAY', 'MTBANK', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (58, 'CREDITCARD', 'UMPAY', 'NJCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (59, 'CREDITCARD', 'UMPAY', 'NCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (60, 'CREDITCARD', 'UMPAY', 'QLBANK', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (61, 'CREDITCARD', 'UMPAY', 'YDRCB', 'TRUE');
INSERT INTO vdlm_paybank_cardmode (paybank_id, cardType, paymentMode, bankCode, status) VALUES (62, 'CREDITCARD', 'UMPAY', 'SHRCB', 'TRUE');

