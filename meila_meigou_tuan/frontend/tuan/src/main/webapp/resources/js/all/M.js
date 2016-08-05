function viewWillDisappear() {}

function viewWillAppear() {}
"undefined" != typeof M && M || (window.M = {}), ! function(e) {
        "use strict";

        function t(e) {
            d.closeAll();
            var t = new p(e || {});
            return t.index
        }
        var n = "";
        n = n ? n : document.scripts[document.scripts.length - 1].src.match(/[\s\S]*\//)[0];
        var r = document,
            i = "querySelectorAll",
            o = "getElementsByClassName",
            a = function(e) {
                return r[i](e)
            },
            c = {
                type: 0,
                shade: !0,
                shadeClose: !0,
                fixed: !0,
                anim: !0
            },
            l = {
                extend: function(e) {
                    var t = JSON.parse(JSON.stringify(c));
                    for (var n in e) t[n] = e[n];
                    return t
                },
                timer: {},
                end: {}
            },
            u = 0,
            s = ["layermbox"],
            p = function(e) {
                var t = this;
                t.config = l.extend(e), t.view()
            };
        p.prototype.view = function() {
            var e = this,
                t = e.config,
                n = r.createElement("div");
            e.id = n.id = s[0] + u, n.setAttribute("class", s[0] + " " + s[0] + (t.type || 0) + " " + t.className || ""), n.setAttribute("index", u);
            var i = function() {
                    var e = "object" == typeof t.title;
                    return t.title ? '<h3 style="' + (e ? t.title[1] : "text-align:center;") + '">' + (e ? t.title[0] : t.title) + "</h3>" : ""
                }(),
                c = function() {
                    var e, n = (t.btn || []).length;
                    return 0 !== n && t.btn ? (e = '<span type="1">' + t.btn[0] + "</span>", 2 === n && (e += '<span type="0">' + t.btn[1] + "</span>"), '<div class="layermbtn">' + e + "</div>") : ""
                }();
            if (t.fixed || (t.top = t.hasOwnProperty("top") ? t.top : 100, t.style = t.style || "", t.style += " top:" + (r.body.scrollTop + t.top) / 50 + "rem"), 2 === t.type && (t.content = '<i></i><i class="laymloadtwo"></i><i></i><div>' + (t.content || "") + "</div>"), n.innerHTML = (t.shade ? '<div class="laymshade"></div>' : "") + '<div class="layermmain" ' + (t.fixed ? "" : 'style="position:static;"') + '><div class="section"><div class="layermchild ' + (t.type || t.shade ? "" : "layermborder ") + (t.anim ? "layermanim" : "") + '" ' + (t.style ? 'style="' + t.style + '"' : "") + ">" + i + '<div class="layermcont">' + t.content + "</div>" + c + "</div></div></div>", !t.type || 2 === t.type) {
                var l = r[o](s[0] + t.type),
                    p = l.length;
                p >= 1 && d.close(l[0].getAttribute("index"))
            }
            document.body.appendChild(n);
            var m = e.elem = a("#" + e.id)[0];
            setTimeout(function() {
                try {
                    m.className = m.className + " layermshow"
                } catch (e) {
                    return
                }
                t.success && t.success(m)
            }, 1), e.index = u++, e.action(t, m)
        }, p.prototype.action = function(e, t) {
            var n = this;
            if (e.time && (l.timer[n.index] = setTimeout(function() {
                    d.close(n.index)
                }, e.time)), e.btn)
                for (var r = t[o]("layermbtn")[0].children, i = r.length, a = 0; i > a; a++) $(r[a]).on("click", function() {
                    var t = this.getAttribute("type");
                    0 == t ? (e.no && e.no(), d.close(n.index)) : e.yes ? e.yes(n.index) : d.close(n.index)
                });
            if (!e.btn) {
                var c = t[o]("laymshade")[0];
                c.onclick = function() {
                    d.close(n.index, e.end)
                }, c.ontouchmove = function() {
                    d.close(n.index, e.end)
                }
            }
            e.end && (l.end[n.index] = e.end)
        };
        var d = {
            v: "1.2",
            index: u,
            wait: function(e) {
                e = e || {}, e.type = 2, t(e)
            },
            popup: function(e) {
                e = e || {}, e.type = 1, t(e)
            },
            msg: function(e) {
                e = e || {}, t(e)
            },
            close: function(e) {
                var t = a("#" + s[0] + e)[0];
                t && (t.innerHTML = "", r.body.removeChild(t), clearTimeout(l.timer[e]), delete l.timer[e], "function" == typeof l.end[e] && l.end[e](), delete l.end[e])
            },
            closeAll: function() {
                for (var e = r[o](s[0]), t = 0, n = e.length; n > t; t++) d.close(e[t].getAttribute("index"))
            }
        };
        "function" == typeof define ? define(function() {
            return d
        }) : e.layer = d
    }(M), M.is = {}, M.is.inApp = function() {
        return navigator.userAgent.indexOf("meila") >= 0 ? !0 : !1
    }(), M.is.inWechat = function() {
        return navigator.userAgent.indexOf("MicroMessenger") >= 0 ? !0 : !1
    }(), M.is.supportWebp = function() {
        var e = "__webp_available__",
            t = localStorage.getItem(e),
            n = new Image;
        return t ? !!parseInt(t) : (n.onload = function() {
            localStorage.setItem(e, 1), M.is.supportWebp = !0
        }, n.onerror = function() {
            localStorage.setItem(e, 0), M.is.supportWebp = !1
        }, n.src = "data:image/webp;base64,UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAsAAAABBxAREYiI/gcAAABWUDggGAAAADABAJ0BKgEAAQABABwlpAADcAD+/gbQAA==", !1)
    }(), M.url = {}, M.url.getParam = function(e, t) {
        var n = new RegExp("(^|&|\\?|#)" + e + "=([^&]*?)(&|#|$)"),
            t = t || location.href,
            r = t.match(/#.*/) ? t.match(/#.*/)[0] : "";
        return t = t.replace(/#.*/, ""), n.test(r) ? decodeURIComponent(r.match(n)[2]) : n.test(t) ? decodeURIComponent(t.match(n)[2]) : ""
    }, M.url.clearParam = function(e, t) {
        var n, r, i, o = /([^\?#]*)?(\?([^#]*)?)?(#.*)?/,
            a = null,
            c = [],
            l = [];
        if (t = t || location.href, Array.isArray(e) && e.length > 0 && (a = o.exec(t), a && a[3])) {
            for (c = a[3].split("&"), r = 0, i = c.length; i > r; r++) n = c[r].split("="), -1 === e.indexOf(decodeURIComponent(n[0])) && l.push(c[r]);
            n = "", l.length > 0 && (n = "?" + l.join("&")), t = (a[1] || "") + n + (a[4] || "")
        }
        return t
    }, M.url.clearTrackParam = function(e, t) {
        var n, r, i = ["utm_channel", "utm_user", "utm_medium", "utm_source", "utm_activity", "in_channel"],
            o = [];
        if (Array.isArray(e))
            for (n = 0, r = i.length; r > n; n++) e.indexOf(i[n]) >= 0 && o.push(i[n]);
        else o = ["utm_channel", "utm_user", "utm_medium", "utm_source"];
        return M.url.clearParam(o, t)
    }, M.url.getTrackParam = function(e) {
        return "utm_activity" === e && location.pathname.match(/activities\/[a-z0-9]{8}\/?/) ? $.fn.cookie(e) : M.url.getParam(e) || $.fn.cookie(e)
    }, M.url.getAllTrackParam = function() {
        var e, t, n = ["utm_user", "utm_activity", "utm_medium", "utm_source", "utm_channel", "in_channel"],
            r = {};
        for (e = 0, t = n.length; t > e; e++) r[n[e]] = M.url.getTrackParam(n[e]);
        return r
    }, M.url.updateCookieTrackParam = function(e) {
        function t(e) {
            var t = $.fn.cookie(r);
            t !== e && $.fn.cookie(r, e, {
                path: "/",
                domain: "meilapp.com"
            })
        }

        function n(e) {
            $.fn.cookie(r, e, {
                path: "/",
                domain: "meilapp.com"
            })
        }
        var r, i = {
            utm_activity: t,
            utm_user: n,
            utm_channel: n,
            utm_medium: n,
            utm_source: n,
            in_channel: n
        };
        for (r in i) i.hasOwnProperty(r) && r in e && i[r](e[r])
    }, M.url.appendTrackParam = function(e, t) {
        var n, r, i = M.url.getAllTrackParam(),
            o = [];
        t = t || {};
        for (n in i) i.hasOwnProperty(n) && (n in t ? (r = t[n], r ? e = M.url.setParam(n, t[n], e) : o.push(n)) : i[n] && (e = M.url.setParam(n, i[n], e)));
        return o.length && (e = M.url.clearParam(o, e)), e
    }, M.url.setParam = function(e, t, n, r) {
        if ("undefined" == typeof e || "undefined" == typeof t || "undefined" == typeof n) return n;
        var i = new RegExp("(^|&|\\?|#)" + e + "=([^&]*?)(&|#|$)"),
            o = n.match(/#.*/) ? n.match(/#.*/)[0] : "";
        if (n = n.replace(/#.*/, ""), r === !0) {
            if (i.test(o)) o = o.replace(i, function(n, r, i, o) {
                return r + e + "=" + encodeURIComponent(t) + o
            });
            else {
                var a = -1 === o.indexOf("#") ? "#" : "&";
                o = o + a + e + "=" + encodeURIComponent(t)
            }
            o = o.replace(i, function(n, r, i, o) {
                return r + e + "=" + encodeURIComponent(t) + o
            })
        } else if (i.test(n)) n = n.replace(i, function(n, r, i, o) {
            return r + e + "=" + encodeURIComponent(t) + o
        });
        else {
            var a = -1 === n.indexOf("?") ? "?" : "&";
            n = n + a + e + "=" + encodeURIComponent(t)
        }
        return n + o
    }, M.url.currentScriptOrigin = function() {
        function e() {
            if (document.currentScript) return document.currentScript.src;
            var e;
            try {
                a.b.c()
            } catch (t) {
                e = t.stack, !e && window.opera && (e = (String(t).match(/of linked script \S+/g) || []).join(" "))
            }
            if (e) return e = e.split(/[@ ]/g).pop(), e = "(" == e[0] ? e.slice(1, -1) : e, e.replace(/(:\d+)?:\d+$/i, "");
            for (var n, r = document.getElementsByTagName("script"), i = 0; n = r[i++];)
                if ("interactive" === n.readyState) return n.className = n.src
        }
        var t = "string" == typeof e() ? e() : "";
        return t.match(/^http:\/\/[^\/]+/) ? t.match(/^http:\/\/[^\/]+/)[0] : ""
    }(), M.dom = {}, M.dom.getPosition = function(e) {
        var t, n, r;
        return e = e.get ? e.get(0) : e, (t = M.dom.getRect(e)) ? ((n = $(r = e.ownerDocument).scrollLeft()) && (t.left += n, t.right += n), (n = $(r).scrollTop()) && (t.top += n, t.bottom += n), t) : void 0
    }, M.dom.getRect = function(e) {
        if (e = e.get ? e.get(0) : e) {
            var t = $.extend({}, e.getBoundingClientRect());
            return "undefined" == typeof t.width && (t.width = t.right - t.left, t.height = t.bottom - t.top), t
        }
    }, M.app = function() {
        function e() {
            var e = navigator.userAgent.match(/meila\/(\d+\.\d+(\.\d+)?)/);
            return M.is.inApp && e ? e[1] : 0
        }

        function t(e, t) {
            var n = ["client_share", "client_getShareData"],
                r = null;
            n.indexOf(e) >= 0 && t.length && (r = t[1], r.url = M.url.clearTrackParam(null, r.url))
        }

        function n(e) {
            var t = {
                    4.2: ["client_jumpToPage", "client_getUserLoginMud", "client_getClientId", "client_getPhoneNetType", "client_uploadImg", "client_pay", "client_login", "client_share"],
                    4.3: ["client_controlShareShow", "client_registerBtn", "client_changeBtnStatus", "client_getShareData", "client_viewWillAppear", "client_viewWillDisappear", "client_controlSharePlatform"],
                    4.7: ["client_getPushStatus", "client_openPush"],
                    "5.0": ["client_setWebInfo"]
                },
                n = [];
            for (var r in t)("undefined" == typeof e || e >= r) && (n = n.concat(t[r]));
            return n
        }

        function r() {
            var e = null,
                n = null,
                r = l.length;
            e = setInterval(function() {
                if (window.meilaWebviewJsBridge && meilaWebviewJsBridge[l[0]]) {
                    for (clearInterval(e); r;) --r, -1 != $.inArray(l[r], ["client_setWebInfo", "client_jumpToPage", "client_controlShareShow", "client_controlSharePlatform", "client_openPush"]) ? c[l[r].split("_")[1]] = function(e) {
                        return function() {
                            var n = $.Deferred();
                            return t(l[e], arguments), meilaWebviewJsBridge[l[e]].apply(null, arguments), n.resolve(), n.promise()
                        }
                    }(r) : c[l[r].split("_")[1]] = function(e) {
                        return function() {
                            var n = Array.prototype.slice.call(arguments),
                                r = n.shift(),
                                i = $.Deferred();
                            return n.unshift(function(e) {
                                r(JSON.parse(e))
                            }), t(l[e], n), meilaWebviewJsBridge[l[e]].apply(null, n), i.resolve(), i.promise()
                        }
                    }(r);
                    for (M.app = c; n = funcPool.shift();) M.app[n.split("_")[1]].apply(null, arguPool.shift())
                }
            }, 20)
        }

        function i() {
            for (var e = n(), t = null, r = e.length, i = {}; r;) --r, t = e[r], i[t.split("_")[1]] = function(e) {
                return function() {
                    var t = Array.prototype.slice.call(arguments);
                    return -1 == $.inArray(e, l) ? (a.reject(), a.promise()) : (o(e, t) || (funcPool.push(e), arguPool.push(t)), a.promise())
                }
            }(t);
            return i
        }

        function o(e, t) {
            var n = $.inArray(e, funcPool);
            if (-1 == n) return !1;
            for (var r = 0; r < t.length; ++r) {
                if ($.type(t[r]) != $.type(arguPool[n][r])) return !1;
                if ("object" == $.type(t[r]) && JSON.stringify(t[r]) != JSON.stringify(arguPool[n][r])) return !1;
                if (t[r].toString() != arguPool[n][r].toString()) return !1
            }
            return !0
        }
        var a = $.Deferred(),
            c = $.extend(i(), {
                version: e()
            }),
            l = n(c.version);
        return funcPool = [], arguPool = [], M.is.inApp && c.version >= "4.2" && r(), c
    }(), M.opt = {}, M.opt.lazyload = function() {
        function e(e) {
            if (M.is.supportWebp && e.match(/^http:\/\/(meilapp\.qiniucdn|meilatest\.qiniudn)\.com/)) {
                var t = e.match(/(&|\?)imageMogr2\/[^&#]+?(?=(&|#|$))/);
                t ? e = e.replace(t[0], t[0] + "/format/webp") : e += e.indexOf("?") < 0 ? "?imageMogr2/format/webp" : "&imageMogr2/format/webp"
            }
            return e
        }

        function t() {
            this.config = {
                attrName: "relSrc",
                nodeName: "img",
                threshold: 100
            }, this.lazyloader = function() {
                var t = $("img[" + this.config.attrName + "]"),
                    n = t.length,
                    r = null;
                if (0 == n) return $(window).off("scroll", $.proxy(this.lazyloader, this)), $(window).off("resize", $.proxy(this.lazyloader, this)), void $(document.body).off("touchmove", $.proxy(this.lazyloader, this));
                for (var i = this.config.threshold + $(document.body).scrollTop() + document.documentElement.clientHeight, o = 0; n > o; ++o) {
                    r = $(t[o]);
                    var a = M.dom.getPosition(r).top;
                    if (i >= a) {
                        var c = e(r.attr(this.config.attrName));
                        r.attr("src", c), r.removeAttr(this.config.attrName)
                    }
                }
            }, this.bindEvent = function() {
                $(window).on("scroll", $.proxy(this.lazyloader, this)), $(window).on("resize", $.proxy(this.lazyloader, this)), $(document.body).on("touchmove", $.proxy(this.lazyloader, this))
            }
        }
        var n = new t;
        n.lazyloader(), n.bindEvent()
    }, M.opt.pullDown = function(e, t) {
        function n() {
            return !(!e || i || Math.max(document.documentElement.scrollTop, document.body.scrollTop) + document.documentElement.clientHeight + o < $(document.documentElement).height())
        }

        function r() {
            return n() ? (i = 1, a.page > 1 && $(".wrapper").append('<img src="' + location.origin + '/resource/web/images/mobile/global/loading.gif" class="g-loading-gif" />'), void $.get(M.url.setParam("page", a.page, a.url)).done(function(t) {
                if (0 == t.ret) {
                    if (a.bcb(t) === !1) return !1;
                    $("img.g-loading-gif").remove(), e.append(t.data[0].html), M.opt.lazyload(), t.data[0].has_next ? a.page++ : $(window).off("scroll", r), a.acb(t)
                }
                i = 0
            }).fail(function() {
                i = 0
            })) : !1
        }
        var i = 0,
            o = 200,
            a = {
                url: location.href,
                page: 1,
                bcb: function() {},
                acb: function() {}
            };
        $.extend(a, t), r(), $(window).on("scroll", r)
    }, M.ware = {}, M.ware["goto"] = function(e) {
        var t;
        M.is.inApp ? (t = M.app.version, e.wareSlug && t >= "4.2.0" ? window.meilaWebviewJsBridge && window.meilaWebviewJsBridge.client_jumpToPage ? meilaWebviewJsBridge.client_jumpToPage("waredetail", {
            data1: e.wareSlug
        }) : location.href = "/ware/" + e.wareSlug + "/" + location.search : e.wareSlug && t >= "4.1.0" ? location.href = "meilapp://waredetail/" + e.wareSlug : e.topicSlug && (location.href = "meilapp://vtalk/" + e.topicSlug)) : e.wareSlug && (location.href = "/ware/" + e.wareSlug + "/" + location.search)
    }, M.lang = {}, M.lang.dateFormat = function(e, t) {
        function n(e, t) {
            for (var n = e.toString(); n.length < t;) n = "0" + n;
            return n
        }
        var r = {
            "%Y": e.getFullYear(),
            "%m": n(e.getMonth() + 1, 2),
            "%d": n(e.getDate(), 2),
            "%H": n(e.getHours(), 2),
            "%M": n(e.getMinutes(), 2),
            "%S": n(e.getSeconds(), 2)
        };
        return t.replace(/%[YmdHMS]/g, function(e) {
            return r[e]
        })
    }, M.user = {}, M.user.isLogin = function() {
        return null === $.fn.cookie("sc0") && -1 != $.inArray($.fn.cookie("Mud"), [null, "null"]) ? !1 : !0
    }, M.user.login = function(e) {
        var t, n = location.pathname + location.search + location.hash;
        e = e || {}, n = e.nextUrl || n, t = e.scene || "other", 0 != n.indexOf("//") && 0 != n.indexOf("http://") && (n = "http://" + location.host + n), M.app.login(function(e) {
            0 == e.code && ($.fn.cookie("Mud", e.mud, {
                domain: ".meilapp.com",
                path: "/",
                raw: !0
            }), location.href = n)
        }, {
            scene: t
        }).fail(function() {
            location.href = "/login/?next=" + encodeURIComponent(n) + "&scene=" + encodeURIComponent(t)
        })
    }, M.user.share = function(e) {
        var t = "meilapp://share?callback=M.callback";
        if (e = e || {}, e.title = e.title || "美啦", e.url = e.url || location.href, e.url = 0 == e.url.indexOf("http://") ? e.url : "http://" + location.host + e.url, e.imageUrl = e.imageUrl || "http://www.meilapp.com/resource/images/logo32.png", e.cha = "undefined" == typeof e.cha ? 0 : e.cha, M.callback = e.callback || M.callback, M.app.version >= "4.2") M.app.share(function(t) {
            0 == t.code ? (e.callback || M.callback)(t) : M.layer.msg({
                content: "系统繁忙，请稍后再试",
                btn: ["确定"]
            })
        }, e);
        else if (M.app.version >= "3.16") {
            for (var n in e) "callback" != n && (t = "undefined" == typeof e[n] ? t : M.url.setParam(n, e[n], t));
            location.href = t
        } else M.is.inApp ? M.layer.msg({
            content: "亲 请点击右上角分享哦",
            btn: ["确认"]
        }) : M.layer.msg({
            content: "亲 请下载客户端再分享活动哦",
            btn: ["确认"]
        })
    }, M.callback = function() {}, M.footer = function(e) {
        "undefined" == typeof e ? M.is.inApp || $(".wrapper").append('<footer class="copyright">Copyright &copy; 2016，品汇科技版权所有 著作权保护声明</footer>') : e ? $(".wrapper").append('<footer class="copyright">Copyright &copy; 2016，品汇科技版权所有 著作权保护声明</footer>') : $(".wrapper").find("footer.copyright").remove()
    },
    function() {
        function e() {
            var e = localStorage && localStorage.getItem(o) || 0;
            return !e || r > e ? (localStorage.removeItem(o), !0) : !1
        }

        function t() {
            var e, t, n = ["meirenzhuang", "mama"],
                r = location.search;
            return n.some(function(n) {
                return e = new RegExp("(^|&|\\?|#)utm_channel=" + n + "(&|#|$)"), t = !!$.fn.cookie(n) || e.test(r), t ? ($.fn.cookie(n, 1, {
                    domain: "meilapp.com",
                    path: "/"
                }), !0) : !1
            })
        }

        function n() {
            var e, t = location.origin,
                n = location.href,
                r = ["/address/addManager", "/address/\\w+/editManager", "/address/listManager", "/m/seller/order/rejectView.xhtml", "/m/seller/order/commentList.xhtml", "/m/seller/order/checkComment.xhtml", "/m/seller/order/detail.xhtml", "/login", "/ware/[a-z0-9]{3,}", "/wareorder/cart", "/wareorder/confirm", "/address/\\w+/edit", "/address/add", "/coupon/list", "/address/list", "/wareorder/pay", "/m/buyer/orders", "/m/buyer/order/detail", "/m/buyer/order/comments", "/m/buyer/order/comment/add", "/m/buyer/order/comment/detail", "/ptuan/\\S+"];
            return r.some(function(r) {
                return e = new RegExp("^" + t + r + "/?(\\?|#|$)"), e.test(n)
            })
        }
        var r = +new Date,
            i = r + 12e5,
            o = "__downloadbar_hide_expire__";
        if (!M.is.inApp && e() && M.url.currentScriptOrigin && !t() && !n()) {
            var a = {
                    utm_source: "",
                    utm_activity: "",
                    utm_user: "",
                    utm_medium: "",
                    utm_channel: ""
                },
                c = "/getapp/",
                l = !1;
            for (var u in a) a[u] = M.url.getParam(u), "" != a[u] && (l = !0);
            if (0 == l && (a.utm_source = M.url.getParam("from"), "" == a.utm_source))
                for (u in a) a[u] = $.fn.cookie(u);
            for (u in a) null !== a[u] && "" !== a[u] && (c = M.url.setParam(u, a[u], c));
            $(document.body).append('<div class="outer-footer">                                    <div class="download-bar">                                        <div>                                            <img src="' + M.url.currentScriptOrigin + '/resource/web/images/mobile/global/downloadbar.png" />                                            <a id="download_app" href="' + c + '" title="下载美啦" >下载美啦</a>                                            <span class="close-download-bar"></span>                                        </div>                                    </div>                                </div>'), $(".outer-footer .close-download-bar").on("click", function() {
                return $(this).parents(".outer-footer").hide(), localStorage.setItem(o, i), !1
            })
        }
    }(), M.wechat = {}, M.wechat.settings = function(e) {
        var t = {
            imgUrl: "http://" + location.host + "/resource/web/images/new-logo-64.png",
            lineLink: location.href,
            descContent: "美啦App，美女聚集最多的美妆社区",
            shareTitle: "美啦",
            signature_info: {},
            debug: !1,
            success_callback: function(e) {},
            cancel_callback: function(e) {},
            error_callback: function(e) {}
        };
        return e = e || {}, e = $.extend(!0, t, e), e.lineLink = M.url.clearTrackParam(null, e.lineLink), e
    }, M.wechat.showWechatSharePrompt = function(e) {
        var t = "点击右上角分享给朋友吧",
            n = 0;
        if ("undefined" == typeof e) var r = t,
            i = n,
            o = null;
        else var r = e.content || t,
            i = e.seconds || n,
            o = e.func || null;
        var a = '<div class="wechat-share-prompt">                    <img class="point-share" src="/resource/web/images/mobile/spring_tour/point-share.png" alt="指向分享"/>                    <p>' + r + '</p>                    <img class="i-know" src="/resource/web/images/mobile/spring_tour/i-know.png" alt="我知道了" />                </div>';
        setTimeout(function() {
            $(".wrapper").append(a)
        }, i), $("body").on("click", ".wechat-share-prompt", function() {
            $(this).hide(), o && o()
        })
    }, M.wechat.settingShare = function(e) {
        M.wechat.is_new_version() && M.wechat.set_new_version_share(e)
    }, M.wechat.is_new_version = function() {
        return !0
    }, M.wechat.set_new_version_share = function(e) {
        if ("undefined" != typeof wx) {
            var t = {
                title: e.shareTitle,
                link: e.lineLink,
                desc: e.descContent,
                imgUrl: e.imgUrl,
                success: e.success_callback,
                cancel: e.cancel_callback,
                fail: e.error_callback
            };
            wx.onMenuShareTimeline(t), wx.onMenuShareAppMessage(t), wx.onMenuShareQQ(t), wx.onMenuShareWeibo(t)
        }
    }, M.wechat.initShare = function(e) {
        "undefined" != typeof e && (e = M.wechat.settings(e), M.wechat.is_new_version() && e.signature_info && (wx.config({
            debug: e.debug || !1,
            appId: e.signature_info.app_id,
            timestamp: e.signature_info.timestamp,
            nonceStr: e.signature_info.noncestr,
            signature: e.signature_info.signature,
            jsApiList: ["onMenuShareTimeline", "onMenuShareAppMessage", "onMenuShareQQ", "onMenuShareWeibo"]
        }), wx.ready(function() {
            wx.checkJsApi({
                jsApiList: ["onMenuShareTimeline", "onMenuShareAppMessage", "onMenuShareQQ", "onMenuShareWeibo"],
                success: function(e) {}
            }), M.wechat.settingShare(e)
        })))
    }, setTimeout(function() {
        function e(e) {
            var t = ["http://meilapp.com/", "meilapp://", "http://meilapp.qiniudn.com/", "http://www.google-analytics.com/", "http://hm.baidu.com/", "javascript:false;"];
            if (e = $.trim(e), !e) return !0;
            if (e = 0 == e.indexOf("//") ? "http:" + e : e, 0 == e.indexOf("/")) return !0;
            for (var n = 0; n < t.length; ++n)
                if (0 === e.indexOf(t[n])) return !0;
            return i = !0, !1
        }

        function t(t) {
            for (var n = $("iframe"), r = $("script"), i = 0; i < n.length; ++i) r.push(n[i]);
            for (var i = 0; i < r.length; ++i) 0 == e($(r[i]).attr("src")) && t($(r[i]))
        }

        function n(e) {
            var t = $('div[style*="bottom:"][style*="0"][style*="position:"][style*="fixed"]');
            t.length && (e(t), i = !0)
        }

        function r(e) {
            e.remove()
        }
        var i = !1;
        t(r), n(r)
    }, 1e3);