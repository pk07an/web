(function($) {
    'use strict';
    var page = {
        init: function() {
            var _this = this;

            if (!M.user.isLogin()) {
                if(M.is.inWechat){
                    location.href = '/login/weixin/?url=' + encodeURIComponent(location.href);
                }else{
                    M.user.login();
                }
                return;
            }

            this.info = {
                userInfo: null,
                groupInfo: null
            };
            $.when(this.initUserInfo(), this.initGroupInfo()).done(function() {
                $('.small-loading').remove();
                _this.initEvents();
                // 添加deliveryType，进行身份证渲染
                console.log(_this.info.groupInfo.data.deliveryType);
                if (!!_this.info.userInfo.data) {
                    _this.info.userInfo.data.deliveryType = _this.info.groupInfo.data.deliveryType;
                }
                _this.utils().rendered('#userInfo', _this.info.userInfo, '.userInfo');
                _this.utils().rendered('#group-info', _this.info.groupInfo, '.group-info');
                var htm = $('#toobar').html();
                $(doT.template(htm)(_this.info.groupInfo)).insertAfter('.wrapper');
                M.opt.lazyload();
            });
            // 隐藏微信分享按钮
            if(M.is.inWechat){
                window.Wechat.init({
                    jsApiList: ['hideOptionMenu'],
                    callback: function(){
                        window.Wechat.wx.hideOptionMenu();
                    }
                });
            } 
        },
        initUserInfo: function() {
            var url,
                deferred = $.Deferred(),
                _this = this;

            if (M.url.getParam('addressId')) {
                url = location.origin + '/ptuan/service/getaddress.json?addressId=' + M.url.getParam('addressId') + '&time=' + new Date().getTime();
            } else {
                url = location.origin + '/ptuan/service/getaddress.json' + '?time=' + new Date().getTime();
            }
            $.getJSON(url).done(function(data) {
                if (data.ret == 0) {
                    _this.info.userInfo = data;
                    if (data.data != null && data.data.addressId) {
                        _this.info.addressId = data.data.addressId;
                    }
                    deferred.resolve();
                } else if (data.ret == 1 && data.errCode == -99) {
                    M.user.login();
                } else {
                    M.layer.msg({
                        content: data.msg,
                        btn: ['确定']
                    });
                }
            }).fail(function(data) {
                M.layer.msg({
                    content: '获取"用户地址"数据失败，请稍后重试~',
                    btn: ['确定']
                });
            });
            return deferred;
        },
        initGroupInfo: function() {
            var url,
                deferred = $.Deferred(),
                _this = this;
            url = location.origin + '/ptuan/service/getOrderProduct.json?actId=' + M.url.getParam('actId') + '&time=' + new Date().getTime() + '&orderType=' + M.url.getParam('orderType');
            $.getJSON(url).done(function(data) {
                if (data.ret == 0) {
                    _this.info.groupInfo = data;
                    if (data.data.id) {
                        _this.info.actId = data.data.id;
                    }
                    deferred.resolve();
                } else {
                    M.layer.msg({
                        content: data.msg,
                        btn: ['确定']
                    });
                }
            }).fail(function(data) {
                M.layer.msg({
                    content: '获取"商品详情"数据失败，请稍后重试~',
                    btn: ['确定']
                });
            });
            return deferred;
        },
        postOrder: function() {
            var _this = this;
            _this.info.isPosting = true;
            M.layer.msg({
                content: '<img class="small-loading" src="../resources/images/small-loading.gif" height="32" width="32">'
            });
            // 需要订单号
            var url = '/ptuan/service/submitorder.json';
            var data = {
                actId: _this.info.actId,
                addressId: _this.info.addressId,
                orderType: M.url.getParam('orderType'),
                remark: $('.sayToSeller').val()
            };
            if (M.url.getParam('tuanNo')) {
                $.extend(data, {
                    tuanNo: M.url.getParam('tuanNo')
                });
            }
            $.post(url, data)
                .done(function(data) {
                    if (data.ret == 0) {
                        setTimeout(function() {
                            M.layer.closeAll();
                            window.history.replaceState(null, null, location.origin + '/ptuan/group/group-status.html?tuanNo=' + data.data.tuanNo);
                            // 跳转支付页面
                            location.href = location.origin + '/wareorder/pay/?trade_no=' + data.data.payNo;
                        }, 500);
                    } else if (data.ret == 1 && data.errCode == -99) {
                        M.user.login();
                    } else {
                        _this.info.isPosting = false;
                        // code不为0的错误
                        M.layer.msg({
                            content: data.msg,
                            btn: ['确定']
                        });
                    }
                })
                .fail(function(data) {
                    _this.info.isPosting = false;
                    M.layer.msg({
                        content: '提交"拼团订单"数据失败，请稍后重试~',
                        btn: ['确定']
                    });
                });
        },
        initEvents: function() {
            var _this = this;
            // 修改地址
            $(document).on('click', '.userInfo a', function(e) {
                e.preventDefault();
                if ($(this).attr('id') !== 'no-address') {
                    var url = location.origin + '/ptuan/address/list.xhtml?addressId=' + _this.info.userInfo.data.addressId;
                    localStorage.setItem('referer', location.href);
                    if (/\bBONDED_AREA_ML\b|\bBONDED_AREA\b/g.test(_this.info.groupInfo.data.deliveryType)) {
                        location.href = url + '&needIdCard=1';
                    } else {
                        location.href = url;
                    }
                } else {
                    localStorage.setItem('referer', location.href);
                    if (/\bBONDED_AREA_ML\b|\bBONDED_AREA\b/g.test(_this.info.groupInfo.data.deliveryType)) {
                        location.href = location.origin + '/ptuan/address/add.xhtml?needIdCard=1';
                    } else {
                        location.href = location.origin + '/ptuan/address/add.xhtml';
                    }
                }
            });

            // 提交
            $(document).on('click', '.toCommit', function() {
                if (_this.info.isPosting) {
                    return;
                }
                var isValid = validateForm();
                if (isValid) {
                    _this.postOrder();
                } else {
                    return false;
                }

                function validateForm() {
                    // 需要地址id
                    var isValid = true;
                    if (!_this.info.addressId) {
                        M.layer.msg({
                            content: '亲 请填写收货人地址',
                            btn: ['确定'],
                            yes: function() {
                                localStorage.setItem('referer', location.href);
                                if (/\bBONDED_AREA_ML\b|\bBONDED_AREA\b/g.test(_this.info.groupInfo.data.deliveryType)) {
                                    location.href = location.origin + '/ptuan/address/add.xhtml?needIdCard=1';
                                } else {
                                    location.href = location.origin + '/ptuan/address/add.xhtml';
                                }
                            }
                        });
                        return isValid = false;
                    }
                    if ($.trim($('.sayToSeller').val()).length > 100) {
                        M.layer.msg({
                            content: '亲 给卖家留言太长',
                            btn: ['确定']
                        });
                        return isValid = false;
                    }
                    if (/\bBONDED_AREA_ML\b|\bBONDED_AREA\b/g.test(_this.info.groupInfo.data.deliveryType)) {
                        if (!_this.utils().validateIdCard($('.idcard span').text())) {
                            M.layer.msg({
                                content: '由于清关所需，请填写身份证号',
                                btn: ['确定']
                            });
                            return isValid = false;
                        }
                    }
                    return isValid;
                }
            });
        },
        utils: function() {
            var tools = {};
            tools.rendered = function(el, data, container) {
                var htm = $(el).html();
                var temp = doT.template(htm);
                $(container).html(temp(data));
            };

            tools.validateIdCard = function(idCard) {
                var isValid = false;
                //15位和18位身份证号码的正则表达式
                var regIdCard = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;

                //如果通过该验证，说明身份证格式正确，但准确性还需计算
                if (regIdCard.test(idCard)) {
                    if (idCard.length == 18) {
                        var idCardWi = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2); //将前17位加权因子保存在数组里
                        var idCardY = new Array(1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2); //这是除以11后，可能产生的11位余数、验证码，也保存成数组
                        var idCardWiSum = 0; //用来保存前17位各自乖以加权因子后的总和
                        for (var i = 0; i < 17; i++) {
                            idCardWiSum += idCard.substring(i, i + 1) * idCardWi[i];
                        }

                        var idCardMod = idCardWiSum % 11; //计算出校验码所在数组的位置
                        var idCardLast = idCard.substring(17); //得到最后一位身份证号码

                        //如果等于2，则说明校验码是10，身份证号码最后一位应该是X
                        if (idCardMod == 2) {
                            if (idCardLast == "X" || idCardLast == "x") {
                                isValid = true;
                                console.info("恭喜通过验证啦！");
                            } else {
                                isValid = false;
                                console.info("身份证号码错误！");
                            }
                        } else {
                            //用计算出的验证码与最后一位身份证号码匹配，如果一致，说明通过，否则是无效的身份证号码
                            if (idCardLast == idCardY[idCardMod]) {
                                isValid = true;
                                console.info("恭喜通过验证啦！");
                            } else {
                                isValid = false;
                                console.info("身份证号码错误！");
                            }
                        }
                    }
                } else {
                    isValid = false;
                    console.info("身份证格式不正确!");
                }
                return isValid;
            };
            return tools;
        }
    };
    page.init();
})(Zepto);