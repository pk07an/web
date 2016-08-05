(function($) {
    var page = {
        init: function() {
            var _this = this;
            this.info = {
                groupInfo: null,
                wareInfo: null,
                userExt:null
            };
            this.opts = [];
            // 初始团基本信息
            $.when(this.initUserExt()).done(function(){
                _this.initGroupDetails(function() {
                    $('.small-loading').remove();
                    var data = {
                        group: _this.info.groupInfo,
                        ware: _this.info.wareInfo,
                        userExt:_this.info.userExt
                    }
                    _this.utils().rendered('#main', data, '.main');
                    window.Wechat.setShare(
                        {
                            'url': location.href,
                            'img': _this.info.groupInfo.data.img2 || M.url.currentScriptOrigin + "/ptuan/resources/images/logo.png",
                            'title': '【美啦拼团】' + _this.info.groupInfo.data.productName + _this.info.groupInfo.data.tuanPrice || '美啦拼团，便宜、便宜、便宜，购了吗？',
                            'des': '美啦拼团，' + _this.info.groupInfo.data.productName + '现在只售' + _this.info.groupInfo.data.tuanPrice + '元，错过这次要等很久哦！' || '低价的歪果零食、爆款美妆！错过了要等很久！'
                        }
                    );
                    M.opt.lazyload();
                });
            });
            this.btnEvent();
            this.initShare();
        },
        initWareDetails: function(productCode, callback) {
            var url = location.origin + '/ptuan/service/getProductDesc.json?productCode=' + productCode + '&time=' + new Date().getTime(),
                _this = this;
            $.getJSON(url).done(function(res) {
                // 图文详情
                if (res.ret != 0) {
                    M.layer.msg({
                        content: res.msg,
                        btn: ['确定']
                    });
                } else {
                    _this.info.wareInfo = res.data.fragments;
                    callback();
                }
            }).fail(function(res) {
                M.layer.msg({
                    content: '获取"图文详情"数据失败，请稍后重试~',
                    btn: ['确定']
                });
            });
        },
        initUserExt:function(){
            var url = location.origin + '/ptuan/service/getTuanDetailUserExtInfo.json?actId=' + M.url.getParam('skuId'),
                _this = this;
            var deferred = $.Deferred();
            $.getJSON(url).done(function(res) {
                // 图文详情
                if (res.ret != 0) {
                    M.layer.msg({
                        content: res.msg,
                        btn: ['确定']
                    });
                } else {
                    _this.info.userExt = res.data;
                    res.data.tuanOrderVoList.forEach(function(obj){
                        var opt = {};
                        opt.url = location.origin + '/ptuan/group/group-status.html?tuanNo=' + obj.tuanNo;
                        opt.img = obj.tuanActivity.img2;
                        opt.title = '我参加了美啦拼团——' +obj.tuanActivity.productName;
                        opt.des = '拼团中，还差' + obj.count + '人即可拼团成功，原价' + obj.tuanActivity.skuPrice + '，拼团价' + obj.tuanActivity.tuanPrice + '，快来和ta一起享受优惠吧~';
                        _this.opts.push(opt);
                    });
                    deferred.resolve();
                }
            }).fail(function(res) {
                M.layer.msg({
                    content: '获取"图文详情"数据失败，请稍后重试~',
                    btn: ['确定']
                });
            });
            return deferred;
        },
        initGroupDetails: function(callback) {
            var _this = this;
            $.getJSON(location.origin + '/ptuan/service/getActivityProduct.json?actId=' + M.url.getParam('skuId') + '&time=' + new Date().getTime())
                .done(function(data) {
                    if (data.ret == 0) {
                        _this.info.groupInfo = data;
                        _this.initWareDetails(data.data.productCode, callback);
                    } else {
                        M.layer.msg({
                            content: data.msg,
                            btn: ['确定']
                        });
                    }
                })
                .fail(function(data) {
                    M.layer.msg({
                        content: '获取"商品详情"数据失败，请稍后重试~',
                        btn: ['确定']
                    });
                });
        },
        btnEvent: function() {
            var _this = this;
            $(document).on('click', '.group-bottom-fixed a', function(e) {
                if (!M.user.isLogin() && !$(this).hasClass('originprice-buy')) {
                    e.preventDefault();
                    if(M.is.inWechat){
                        location.href = '/login/weixin/?url=' + encodeURIComponent(location.href);
                    }else{
                        M.user.login();
                    }
                }
            });
            $(document).on('click','.join-ptuan',function(){
                $.getJSON(location.origin + '/ptuan/service/autoJoinTuan.json?actId=' + M.url.getParam('skuId')).done(function(res){
                    if(res.ret == 0 && res.data){
                        location.href = '/ptuan/group/group-order.html?actId=' + M.url.getParam('skuId') + '&orderType=1&tuanNo='+res.data;
                    }else{
                        M.layer.msg({
                            content: '参团失败:(，所有团已满员，你自己开个团吧',
                            time:3000
                        });
                    }
                }).fail(function(){
                    M.layer.msg({
                        content: '获取数据失败，请稍后重试~',
                        time:2000
                    });
                });
            });
        },
        utils: function() {
            var tools = {};
            tools.rendered = function(el, data, container) {
                var htm = $(el).html();
                var temp = doT.template(htm);
                $(container).html(temp(data));
            };
            return tools;
        },
        setDefaultShare: function(opt){
            var self = this,
                content = {
                    url: location.href,
                    img: M.url.currentScriptOrigin + "/ptuan/resources/images/logo.png",
                    title: '美啦拼团，便宜、便宜、便宜，购了吗？',
                    des: '低价的歪果零食、爆款美妆！错过了要等很久！'
                };
            $.extend(content, opt || {});
            if (self.info.groupInfo && self.info.groupInfo.data && !window.Utils.isEmptyObj(self.info.groupInfo.data)){
                $.extend(
                    content,
                    {
                        'url': location.href,
                        'img': self.info.groupInfo.data.img2,
                        'title': '【美啦拼团】' + self.info.groupInfo.data.productName + self.info.groupInfo.data.tuanPrice,
                        'des': '美啦拼团，' + self.info.groupInfo.data.productName + '现在只售' + self.info.groupInfo.data.tuanPrice + '元，错过这次要等很久哦！'
                    }
                );
            }
            if(M.is.inWechat){
                window.Wechat.setShare(content);
            }else{
                M.app.getShareData(
                    function(data) {}, 
                    {
                        url: content.url,
                        imageUrl: concent.img,
                        title: content.title,
                        des: content.des
                    }
                );
            }

        },
        initShare: function(opt) {
            var self = this,
                content = {};
            $.extend(content, opt || {});
            $('body').on("click", ".share", function(e){
                e.preventDefault();
                var $this = $(this),
                    index = $this.parents('li').index(),
                    opt = self.opts[index],
                    typeChaMap = {
                        wechat: 1,
                        qq: 3,
                        qzone: 4,
                        weibo: 5
                    };
                if (M.is.inApp) {
                    window.CustomAppShare.show({
                        click: function(type){
                            M.app.share(
                                function(){},
                                $.extend({cha: typeChaMap[type] || typeChaMap.wechat}, opt)
                            );
                        }
                    });
                } else {
                    M.layer.msg({
                        content: '请从美啦app分享本活动哦~',
                        btn: ['确定']
                    });
                }
            });
            

            if (M.is.inWechat){
                window.Wechat.init({
                    jsApiList: [
                        'onMenuShareTimeline',
                        'onMenuShareAppMessage',
                        'onMenuShareQQ',
                        'onMenuShareWeibo',
                        'onMenuShareQZone'
                    ],
                    callback: function(){
                        self.setDefaultShare(content);
                    }
                });
            }else{
                M.app.controlSharePlatform({
                    wechat: 1,
                    qq: 1,
                    qzone: 1,
                    sina: 1
                },function(){
                    self.setDefaultShare(content);
                });
            }   
        }
    };
    page.init();
})(Zepto);