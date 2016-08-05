-- db migrate sql
/**
* 解决弱网环境下同一用户连续请求发生CookieTheftException异常问题
*/
update persistent_logins set token=concat_ws(',','new',token);