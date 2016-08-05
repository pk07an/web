(function($) {
    var page = {
        init: function() {
            this.shareOption = {};
            this.rendered();
            this.initEvents();
            this.initShare();
        },
        renderedWareMod: function() {
            this.utils().rendered('#wareInfo', this.wareInfo, '.wrapper');
            M.opt.lazyload();
        },
        rendered: function() {
            var url,
                _this = this;
            url = '/ptuan/service/gettuaninfo.json?tuanNo=' + M.url.getParam('tuanNo') + '&time=' + new Date().getTime();
            $.getJSON(url).done(function(data) {
                data.data.isWechat = M.is.inWechat;
                _this.initWareDetails(data.data.productInfo.productCode,_this.renderedWareMod);
                if (data.ret == 0) {
                    if (data.data.userStatus == -1) {
                        M.layer.msg({
                            content: data.data.reason,
                            btn: ['确定']
                        });
                    } else {
                        _this.utils().rendered('#main', data, '.wrapper');
                        Array.prototype.contain = function(n) {
                            var i,
                                length = this.length,
                                index = -1;
                            for (i = 0; i < length; i++) {
                                if (this[i] === n) {
                                    index = i;
                                    break;
                                }
                            }
                            return index;
                        }

                        // 获取当前值在数组中的索引
                        function getContainIdx(arrays, n) {
                            var i,
                                size = arrays.length,
                                index = -1;
                            for (i = 0; i < size; i++) {
                                if (arrays[i].contain(n) > -1) {
                                    index = i;
                                    break;
                                }
                            }
                            return index;
                        }

                        var i = getContainIdx([
                            [3, 4, 5, 6, 8, 9, 12, 13, 18],
                            [7, 11, 16],
                            [1, 2],
                            [14]
                        ], data.data.userStatus);

                        $('.list-process li').removeClass('cur').filter(function() {
                            return $(this).index() <= i;
                        }).addClass('cur');

                        if (data.data.userStatus == 'CHIEF_PROCESS' || data.data.userStatus == 'MEMBER_PROCESS_UNJOIN' || data.data.userStatus == 'MEMBER_PROCESS_UNPAID' || data.data.userStatus == 'MEMBER_PROCESS_JOIN') {
                            var timer;
                            // 设置倒计时
                            var t = Math.floor(data.data.endSec);
                            timer = _this.setCountBack('.ft span em', t, function() {
                                // 倒计时结束回调
                                // $.removeCookie('shareGuide' + M.url.getParam('tuanNo'));
                                // $('.share-guide').length && _this.share_guide.hide();
                                $('.ft span').removeAttr('class').addClass('finish').text('已结束');
                                $('.result-tips .icon-tips').removeClass('icon-success icon-processing').addClass('icon-fail')
                                    .siblings('span').html('<em>活动已结束</em>活动已过期，您可以参加其他的活动');
                                // 底部按钮修改
                                $('.group-bottom-fixed .inner').html('<a href="./group-zone.html" class="link flex1"><div><span class="sp-2">查看更多拼团商品</span></div></a>');
                            });

                            // 更新状态
                            if (data.data.productInfo.memberNum == data.data.tuanUser.length) {
                                $('.list-process li').addClass('cur');
                                $('.ft').html('<span class="success">拼团成功<em></em></span>');
                                $('.inner').html('<a href="./group-zone.html" class="link flex1"><div><span class="sp-2">查看更多拼团商品</span></div></a>');
                                clearInterval(timer);
                            }
                            _this.shareOption = {
                                'url': location.origin + '/ptuan/group/group-status.html?tuanNo=' + M.url.getParam('tuanNo'),
                                'img': data.data.productInfo.img2,
                                'title': '我参加了美啦拼团——' + data.data.productInfo.productName + '',
                                'des': '还差' + ((data.data.productInfo.memberNum - data.data.tuanUser.length)>0?(data.data.productInfo.memberNum - data.data.tuanUser.length):0) + '人即可拼团成功，原价' + data.data.productInfo.skuPrice + '，拼团价' + data.data.productInfo.tuanPrice + '，快来和ta一起享受优惠吧~'
                            };
                            window.Wechat.setShare(
                                {
                                    'url': _this.shareOption.url || location.href,
                                    'img': _this.shareOption.img || M.url.currentScriptOrigin + "/ptuan/resources/images/logo.png",
                                    'title': _this.shareOption.title || '美啦拼团，便宜、便宜、便宜，购了吗？',
                                    'des': _this.shareOption.des || '低价的歪果零食、爆款美妆！错过了要等很久！'
                                }
                            );
                        }
                    }
                } else if (data.ret == 1 && data.errCode == -99) {
                    if(M.is.inWechat){
                        location.href = '/login/weixin/?url=' + encodeURIComponent(location.href);
                    }else{
                        M.user.login();
                    }
                } else {
                    M.layer.msg({
                        content: data.msg,
                        btn: ['确定']
                    });
                }
            }).fail(function(data) {
                M.layer.msg({
                    content: '获取"拼团状态"数据失败，请稍后重试~',
                    btn: ['确定']
                });
            }).always(function() {
                $('.small-loading').remove();
            });
        },
        setCountBack: function(el, t, callback) {
            var timer;
            if (t) {
                timer = setInterval(function() {
                    t -= 1;
                    if (/^[1-9]\d*|0$/g.test(t)) {
                        var txt = countBack(t);
                        if (txt === '时间设置过长') {
                            clearInterval(timer);
                        }
                        $(el).html(txt);
                    } else {
                        clearInterval(timer);
                        callback();
                    }
                }, 1000);
            } else {
                callback();
            }

            function countBack(ss) {
                // 当前月份，年份，来判断一个月的时间
                var opt = '',
                    s = 1,
                    m = 60,
                    h = m * 60,
                    d = h * 24,
                    M = d * 30;
                if ((ss / d) > 31) {
                    console.error('时间设置过长');
                    return '时间设置过长';
                }

                function prefix(n, m) {
                    m = m || 2;
                    return n > 9 ? n : Array(m).join('0') + n;
                }
                var dd = Math.floor(ss / d);
                var hh = Math.floor((ss - dd * d) / h);
                var mm = Math.floor((ss - dd * d - hh * h) / m);
                var sss = Math.floor((ss - dd * d - hh * h - mm * m) / s);
                if (dd) {
                    opt = prefix(dd) + '天' + prefix(hh) + '时' + prefix(mm) + '分' + prefix(sss) + '秒';
                } else {
                    opt = prefix(hh) + '时' + prefix(mm) + '分' + prefix(sss) + '秒';
                }
                return opt;
            }
            return timer;
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
                    _this.wareInfo = {};
                    _this.wareInfo.ware = res.data.fragments;
                    callback.apply(_this);
                }
            }).fail(function(res) {
                M.layer.msg({
                    content: '获取"图文详情"数据失败，请稍后重试~',
                    btn: ['确定']
                });
            });
        },
        initEvents: function() {
            var _this = this;
            var curUrl = location.href;
            //配合邀请好友页面
            window.onpopstate = function(e){
                if(e.state.url && e.state.url !== curUrl){
                    location.href = e.state.url;
                }
            }
            
            // 禁点击事件
            $(document).on('click', '.disabled', function(e) {
                e.preventDefault();
                e.stopPropagation();
                return;
            });
        },
        utils: function() {
            var tools = {};
            tools.rendered = function(el, data, container) {
                var htm = $(el).html();
                var temp = doT.template(htm);
                $(container).append(temp(data));
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
            if (window.Utils.isEmptyObj(opt || {})){
                $.extend(content, self.shareOption || {});
            }else{
                $.extend(content, opt);
            }
            if(M.is.inWechat){
                window.Wechat.setShare(content);
            }else{
                M.app.getShareData(
                    function(data) {}, 
                    {
                        url: content.url,
                        imageUrl: content.img,
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
                var typeChaMap = {
                        wechat: 1,
                        qq: 3,
                        qzone: 4,
                        weibo: 5
                    },
                    html;
                e.preventDefault();
                if (M.is.inApp) {
                    if (window.Utils.isEmptyObj(content)){
                        $.extend(content, self.shareOption || {});
                        self.shareOption.title;
                    }
                    window.CustomAppShare.show({
                        click: function(type){
                            M.app.share(
                                function(){},
                                $.extend({cha: typeChaMap[type] || typeChaMap.wechat}, content || {})
                            );
                        }
                    });
                } else if (M.is.inWechat){
                    html = '<div class="nidongde"><img src="../resources/images/status-share.png" alt=""/><p>右上角，你懂的！</p></div>'
                    M.layer.msg({
                        content: html,
                        className: "tuan-prompt"
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