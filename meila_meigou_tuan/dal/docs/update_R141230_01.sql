/**
 *	再次部署时重新执行的sql语句
 */

--更新pay_no，兼容老数据
update vdlm_order set pay_no = order_no where paid_at is not null and pay_no is null;
update vdlm_cashieritem set batch_biz_nos = biz_no where batch_biz_nos is null;

update vdlm_cart_item ci, vdlm_product p
set ci.shop_id = p.shop_id, ci.seller_id = p.user_id
where ci.product_id = p.id;

update vdlm_activity_ticket t INNER JOIN vdlm_activity a on t.activity_id=a.id 
set t.preferential_type=a.preferential_type, t.discount=a.discount, t.reduction=a.reduction;

update vdlm_order set logistics_company = '顺丰速运' where logistics_company = '顺丰';
update vdlm_order set logistics_company = '顺丰速运' where logistics_company = '顺丰快递';
update vdlm_order set logistics_company = '顺丰速运' where logistics_company = 'SF_EXPRESS';
update vdlm_order set logistics_company = '圆通速递' where logistics_company = '圆通';
update vdlm_order set logistics_company = '圆通速递' where logistics_company = '圆通快递';
update vdlm_order set logistics_company = '圆通速递' where logistics_company = 'YTO';
update vdlm_order set logistics_company = '申通快递' where logistics_company = '申通';
update vdlm_order set logistics_company = '申通快递' where logistics_company = 'STO';
update vdlm_order set logistics_company = '中通快递' where logistics_company = '中通';
update vdlm_order set logistics_company = '中通快递' where logistics_company = 'ZTO';
update vdlm_order set logistics_company = '汇通快运' where logistics_company = '百世汇通';
update vdlm_order set logistics_company = '汇通快运' where logistics_company = 'BESTEX';
update vdlm_order set logistics_company = '韵达快递' where logistics_company = '韵达';
update vdlm_order set logistics_company = '天天快递' where logistics_company = '天天';
update vdlm_order set logistics_company = '全峰快递' where logistics_company = '全峰';
update vdlm_order set logistics_company = 'EMS' where logistics_company = '邮政EMS';
update vdlm_order set logistics_company = 'EMS' where logistics_company = '中国邮政';
update vdlm_order set logistics_company = '其他物流' where logistics_company = 'OTHER';

update vdlm_activity_ticket t INNER JOIN vdlm_activity a on t.activity_id=a.id 
set t.preferential_type=a.preferential_type, t.discount=a.discount, t.reduction=a.reduction;

update vdlm_activity set channel='PRIVATE';
