-- added by ahlon at 2014-08-18 15:00 for 更新用户表，设置用户的店铺字段
update `vdlm_user` u set u.shop_id = (select id from vdlm_shop s where s.owner_id = u.id)
where (u.shop_id is null or u.shop_id = '') and u.loginname not like 'CID%';
