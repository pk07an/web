/**
 * DAL层
 * <ul>
 * <li>id必須為String型，db主鍵為long型，在mybatis上指定id專門的<code>{@link IdTypeHandler}</code></li>
 * <li>一般情况下，除主键外键以外的其他基本数据类型，全部使用primary type</li>
 * <li>默认返回list,map,set等不允许null</li>
 * </ul>
 */package com.vdlm.service;

