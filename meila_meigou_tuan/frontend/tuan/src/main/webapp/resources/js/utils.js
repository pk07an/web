(function() {
    /**
     * 依赖wxjs
     */
    'use strict';
    
    window.Utils = {
        isEmptyObj: function(obj){
            var key;
            for (key in obj){
                if (obj.hasOwnProperty(key)){
                    return false;
                }
            }
            return true;
        }  
    };
    
    // 微信分享
    (function(){
        var process = {
                failed: -1,
                notStart: 0,
                doing: 1,
                end: 2
            },
            configProcess = process.notStart,
            DEFAULT_JSAPILIST = [
                'checkJsApi',
                'onMenuShareTimeline',
                'onMenuShareAppMessage',
                'onMenuShareQQ',
                'onMenuShareWeibo',
                'onMenuShareQZone',
                'hideMenuItems',
                'showMenuItems',
                'hideAllNonBaseMenuItem',
                'showAllNonBaseMenuItem',
                'translateVoice',
                'startRecord',
                'stopRecord',
                'onVoiceRecordEnd',
                'playVoice',
                'onVoicePlayEnd',
                'pauseVoice',
                'stopVoice',
                'uploadVoice',
                'downloadVoice',
                'chooseImage',
                'previewImage',
                'uploadImage',
                'downloadImage',
                'getNetworkType',
                'openLocation',
                'getLocation',
                'hideOptionMenu',
                'showOptionMenu',
                'closeWindow',
                'scanQRCode',
                'chooseWXPay',
                'openProductSpecificView',
                'addCard',
                'chooseCard',
                'openCard'
            ],
            Wechat = {};
        /**
         * option 可能有以下属性 
         * jsApiList
         * callback wx.ready 的callback
         * debug 是否开启调试模式
         */ 
        function init(option){
            function setApi(myApi){
                var i = 0,
                    len = myApi.length;
                Wechat.wx = {};
                for (; i < len; i ++){
                    Wechat.wx[myApi[i]] = wx[myApi[i]];
                }
            }
            var url = location.origin + '/ptuan/service/getWeinXinSign.json?url=' + encodeURIComponent(location.href) + '&time=' + new Date().getTime(),
                myApi = option.jsApiList || DEFAULT_JSAPILIST;
            if (configProcess == process.end || configProcess == process.doing){
                return ;
            }
            configProcess = process.doing;
            option = option || {};
            $.getJSON(url).done(function(data) {
                if (data.ret == 0) {
                    wx.config({
                        debug: option.debug || false,
                        appId: data.data.app_id,
                        timestamp: data.data.timestamp,
                        nonceStr: data.data.noncestr,
                        signature: data.data.signature,
                        jsApiList: myApi
                    });
                    configProcess = process.end;
                    wx.ready(option.callback || function() {});
                    setApi(myApi);
                } else {
                    console.error(data.msg);
                    configProcess = configProcess.failed;
                }
            }).fail(function() {
                console.error('获取"微信签名"数据失败，请稍后重试~');
                configProcess = process.failed;
            });
        }
        function setShare(option){
            var content;
            if (configProcess != process.end){
                console.log("wechat jssdk is not cofnig");
                return ;
            }
            option = option || {};
            content = {
                'link': option.url || location.href,
                'imgUrl': option.img || M.url.currentScriptOrigin + "/ptuan/resources/images/logo.png",
                'title': option.title || '美啦拼团，便宜、便宜、便宜，购了吗？',
                'desc': option.des || '低价的歪果零食、爆款美妆！错过了要等很久！',
                'success': option.success || function(){},
                'fail': option.success || function(){},
                'error': option.success || function(){}
            };
            wx.onMenuShareTimeline(content); // 朋友圈
            wx.onMenuShareAppMessage(content); // 微信好友
            wx.onMenuShareQQ(content);  // QQ 好友
            wx.onMenuShareWeibo(content);  // 微博
            wx.onMenuShareQZone(content);  // Qzone
        }
        Wechat.init = init;
        Wechat.setShare = setShare;
        window.Wechat = window.Wechat || Wechat;
    })();
    
    // 用App的自定义分享按钮
    (function(){

        function CustomAppShare(){
            function createDom(tags){
                var tagList = [
                        ["wechat", "微信好友"],
                        ["weibo", "新浪微博"],
                        ["qq", "QQ"], 
                        ["qzone", "QQ空间"]
                    ],
                    tagNameList = [],
                    i, index, len,
                    btns = [], html;
                for (i=0, len=tagList.length; i < len; i ++){
                    tagNameList.push(tagList[i][0]);
                }
                if (!Array.isArray(tags)){
                    tags = tagNameList;
                }
                for (i=0, len = tags.length; i < len; i ++){
                    index = tagNameList.indexOf(tags[i]);
                    if (index >= 0){
                        html = "<li class='share-btn' data-type='" + tags[i] +"'>\
                                    <img class='share-btn-img' src='" + M.url.currentScriptOrigin + "/ptuan/resources/images/share_" + tags[i] + ".png' alt='" + tagList[index][1] + "'>\
                                    <p class='share-btn-text'>" + tagList[index][1] + "</p>\
                                </li>";
                        btns.push(html);
                    }
                }
                html = "<div class='custom-share-container'>\
                            <div class='share-wrapper'>\
                                <ul class='share-btn-list'>" + btns.join("") + "</ul>\
                            </div>\
                        </div>";
                return html;
            }
            function initEvent(obj){
                var $customShare = $('.custom-share-container .share-wrapper');
                $customShare.click(function(e){
                    if (e.target == $customShare[0]){
                        obj.close();    
                    }
                });
                $customShare.find(".share-btn").click(function(){
                    var $this = $(this);
                    click(obj, $this.attr("data-type"));
                });
            }
            function click(obj, type){
                data.click(type);
                obj.close();
            }
            function clear(){
                var $customShare = $('.custom-share-container');
                if ($customShare.length){
                    $customShare.remove();
                }
            }
            
            var data = {
                tags: {}, // 配置需要显示按钮标签
                click: function(){}, // 点击按钮是的回调
                close: function(){} // 关闭之后的回调
            };
            this.show = function (option){
                $.extend(data, option);
                clear();
                $('body').append(createDom(data.tags));
                setTimeout(
                    function(){ 
                        $('.custom-share-container .share-btn-list').addClass("moveup");
                    }, 
                    0
                )
                initEvent(this);
            },
            this.close = function(){
                var $customShare = $('.custom-share-container');
                if ($customShare.length){
                    $customShare.remove();
                    data.close();
                }
            }
        };
        window.CustomAppShare = window.CustomAppShare || new CustomAppShare(); 
    })();
})();