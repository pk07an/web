/**
 * Domain Service。
 * 
 * Domain Service层的命名规范
 * <ul>
 * <li>服务接口命名要求以*Service结尾</li>
 * <li>单纯查询相关的method，不要用get*，以免与bean property混淆</li>
 * <li>单纯查询相关的method，推荐使用load*, find*, list*, query*, exists*, count*, 方便事务管理</li>
 * <li>写相关的method，推荐使用add*, insert*, save*, update*, persist*, remove*, delete*等，方便事务管理</li>
 * </ul>
 * 
 * Domain Service层的参数/返回值规范
 * <ul>
 * <li>尽量别用代码校验，除非是很复杂的校验</li>
 * <li>使用基于jsr303规范的annotation或validation.xml自定义/配置校验规则，利于重用</li>
 * <li>默认返回list,map,set等不允许null</li>
 * </ul>
 */
package com.vdlm.service;

