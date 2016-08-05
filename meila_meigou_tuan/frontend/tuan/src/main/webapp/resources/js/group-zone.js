(function($) {
    var page = {
        init: function() {
            var self = this;
            this.pageNo = [{
                num: 1,
                hasMore: true,
                isLoading: false
            }, {
                num: 1,
                hasMore: true,
                isLoading: false
            }];
            this.opts = [];
            this.groupListHasLoaded = false;
            this.myGroupHasLoaded = false;
            this.isWechatShareInited = false;
            if (location.hash === "#myGroup"){
                this.pageInit().myGroup();
                $('.nav-mygroup').addClass('cur');
                $('.myGroup').removeClass('hidden');
            }else{
                this.pageInit().groupList();
                $('.nav-main').addClass('cur');
                $('.groupList').removeClass('hidden');
            }
            this.initEvent();
            $(window).load(function(){
                self.initShare();
            });

        },
        pageInit: function() {
            var _this = this;
            return {
                groupList: function() {
                    _this.pageNo[0].isLoading = true;
                    $.getJSON(location.origin + '/ptuan/service/getactvlist.json?pageno=' + _this.pageNo[0].num + "&test=" + M.url.getParam('test') + '&time=' + new Date().getTime())
                        .done(function(data) {
                            if (data.ret == 0) {
                                _this.groupListHasLoaded = true;
                                if (data.data.list.length || !$('.tab-pane-1 li').length) {
                                    _this.utils().rendered('#groupList', data.data, '.groupList');
                                    if (!_this.isWechatShareInited && data.data.list[0] && data.data.list[0].img2) {
                                        _this.isWechatShareInited = true;
                                        window.Wechat.setShare({
                                            'url': location.href,
                                            'img': data.data.list[0].img2,
                                            'title': '美啦拼团，便宜、便宜、便宜，购了吗？',
                                            'des': '低价的歪果零食、爆款美妆！错过了要等很久！'
                                        });
                                    }
                                }
                                M.opt.lazyload();
                                // _this.pageNo[0].hasMore = data.data.totalPage > data.data.pageNumber;
                                _this.pageNo[0].hasMore = data.data.list.length < data.data.pageSize ? false : true;
                                if (!_this.pageNo[0].hasMore) {
                                    $('.tab-pane-1 li').last().css('margin-bottom', 0);
                                }
                            } else {
                                M.layer.msg({
                                    content: data.msg,
                                    btn: ['确定']
                                });
                            }
                        })
                        .fail(function(data) {
                            $('.small-loading').remove();
                            M.layer.msg({
                                content: '获取"拼团精选"数据失败，请稍后重试~',
                                btn: ['确定']
                            });
                        })
                        .always(function() {
                            $('.small-loading, .loading').remove();
                            _this.pageNo[0].isLoading = false;
                        });
                },
                myGroup: function() {
                    _this.pageNo[1].isLoading = true;
                    $.getJSON(location.origin + '/ptuan/service/gettuanlist.json?pageno=' + _this.pageNo[1].num + '&time=' + new Date().getTime())
                        .done(function(data) {
                            if (data.ret == 0) {
                                _this.myGroupHasLoaded = true;
                                //分享信息
                                //底部分享按钮，不包括朋友圈
                                data.data.list.forEach(function(obj){
                                    var opt = {};
                                    opt.url = location.origin + '/ptuan/group/group-status.html?tuanNo=' + obj.tuanNo;
                                    opt.img = obj.tuanActivity.img2;
                                    opt.title = '我参加了美啦拼团——' +obj.tuanActivity.productName;
                                    opt.des = '拼团中，还差' + obj.statusDesc.match(/\d+/) + '人即可拼团成功，原价' + obj.tuanActivity.skuPrice + '，拼团价' + obj.tuanActivity.tuanPrice + '，快来和ta一起享受优惠吧~';
                                    _this.opts.push(opt);
                                });
                                if (data.data.list.length || !$('.tab-pane-2 li').length) {
                                    _this.utils().rendered('#myGroup', data, '.myGroup');
                                }
                                M.opt.lazyload();
                                _this.pageNo[1].hasMore = data.data.list.length < data.data.pageSize ? false : true;
                                if (!_this.pageNo[1].hasMore) {
                                    $('.tab-pane-2 li').last().css('margin-bottom', 0);
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
                                content: '获取"我的拼团"数据失败，请稍后重试~',
                                btn: ['确定']
                            });
                        }).always(function() {
                            $('.small-loading, .loading').remove();
                            _this.pageNo[1].isLoading = false;
                        });
                }
            };
        },
        initEvent: function() {
            var _this = this;
            // 点击导航栏
            $(document).on('click', '.nav-tab .pack-justify a', function(e) {
                e.preventDefault();
                e.stopPropagation();
                if ($(this).index() == 0) {
                    if(!_this.groupListHasLoaded){
                        _this.pageInit().groupList();
                    }
                    $(this).addClass('cur').siblings().removeClass('cur');
                    $('.groupList').removeClass('hidden').siblings().addClass('hidden');
                } else {
                    if (!_this.myGroupHasLoaded) {
                        if (M.user.isLogin()) {
                            _this.pageInit().myGroup();
                            $(this).addClass('cur').siblings().removeClass('cur');
                            $('.myGroup').removeClass('hidden').siblings().addClass('hidden');
                        } else {
                            if(M.is.inWechat){
                                location.href = '/login/weixin/?url=' + encodeURIComponent(location.origin + '/ptuan/group/group-zone.html');
                            }else{
                                M.user.login();
                            }
                        }
                    } else {
                        $(this).addClass('cur').siblings().removeClass('cur');
                        $('.myGroup').removeClass('hidden').siblings().addClass('hidden');
                    }
                }
            });
            $('.nav-main').on('click',function(){
                var hash = location.hash,
                    url = location.href.replace(hash||"#", '');
                location.replace(url+"#groupList");
            });
            $('.nav-mygroup').on('click',function(){
                var hash = location.hash,
                    url = location.href.replace(hash||"#", '');
                location.replace(url+"#myGroup");
            });
            // 下拉加载
            $(window).on('scroll', function() {
                var idx = $('.nav-tab .pack-justify a.cur').index();
                if ($(document).height() - $(window).scrollTop() - $(window).height() < 10 && _this.pageNo[idx].hasMore && !_this.pageNo[idx].isLoading) {
                    _this.pageNo[idx].num++;
                    $('<div class="loading"><p>正在加载更多...</p></div>').appendTo('.wrapper');
                    document.body.scrollTop = document.documentElement.scrollHeight;
                    if (idx == 0) {
                        _this.pageInit().groupList();
                    } else {
                        _this.pageInit().myGroup();
                    }
                }
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
                $share = null,
                content = {
                    url: location.href.replace(location.hash || '#', ''),
                    img: M.url.currentScriptOrigin + "/ptuan/resources/images/logo.png",
                    title: '美啦拼团，便宜、便宜、便宜，购了吗？',
                    des: '低价的歪果零食、爆款美妆！错过了要等很久！'
                };
            if (window.Utils.isEmptyObj(opt || {})){
                $share = $('.tab-pane-1 .list-select > li');
                if ($share.length){
                    content.img = $share.attr("data-share-img");
                }
            }else{
                $.extend(content, opt);
            }
            if (M.is.inWechat){
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
                                $.extend({cha: typeChaMap[type] || typeChaMap.wechat}, opt || {})
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
            
            $.extend(content, opt || {});
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