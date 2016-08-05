var Zepto = function() {
    function t(t) {
        return null == t ? t + "" : U[J.call(t)] || "object"
    }

    function e(e) {
        return "function" == t(e)
    }

    function n(t) {
        return null != t && t == t.window
    }

    function i(t) {
        return null != t && t.nodeType == t.DOCUMENT_NODE
    }

    function r(e) {
        return "object" == t(e)
    }

    function o(t) {
        return r(t) && !n(t) && Object.getPrototypeOf(t) == Object.prototype
    }

    function a(t) {
        return "number" == typeof t.length
    }

    function s(t) {
        return P.call(t, function(t) {
            return null != t
        })
    }

    function u(t) {
        return t.length > 0 ? j.fn.concat.apply([], t) : t
    }

    function c(t) {
        return t.replace(/::/g, "/").replace(/([A-Z]+)([A-Z][a-z])/g, "$1_$2").replace(/([a-z\d])([A-Z])/g, "$1_$2").replace(/_/g, "-").toLowerCase()
    }

    function l(t) {
        return t in M ? M[t] : M[t] = RegExp("(^|\\s)" + t + "(\\s|$)")
    }

    function f(t, e) {
        return "number" != typeof e || $[c(t)] ? e : e + "px"
    }

    function h(t) {
        var e, n;
        return D[t] || (e = Z.createElement(t), Z.body.appendChild(e), n = getComputedStyle(e, "").getPropertyValue("display"), e.parentNode.removeChild(e), "none" == n && (n = "block"), D[t] = n), D[t]
    }

    function p(t) {
        return "children" in t ? k.call(t.children) : j.map(t.childNodes, function(t) {
            return 1 == t.nodeType ? t : E
        })
    }

    function d(t, e) {
        var n, i = t ? t.length : 0;
        for (n = 0; i > n; n++) this[n] = t[n];
        this.length = i, this.selector = e || ""
    }

    function m(t, e, n) {
        for (T in e) n && (o(e[T]) || Q(e[T])) ? (o(e[T]) && !o(t[T]) && (t[T] = {}), Q(e[T]) && !Q(t[T]) && (t[T] = []), m(t[T], e[T], n)) : e[T] !== E && (t[T] = e[T])
    }

    function v(t, e) {
        return null == e ? j(t) : j(t).filter(e)
    }

    function g(t, n, i, r) {
        return e(n) ? n.call(t, i, r) : n
    }

    function y(t, e, n) {
        null == n ? t.removeAttribute(e) : t.setAttribute(e, n)
    }

    function b(t, e) {
        var n = t.className || "",
            i = n && n.baseVal !== E;
        return e === E ? i ? n.baseVal : n : (i ? n.baseVal = e : t.className = e, E)
    }

    function w(t) {
        try {
            return t ? "true" == t || ("false" == t ? !1 : "null" == t ? null : +t + "" == t ? +t : /^[\[\{]/.test(t) ? j.parseJSON(t) : t) : t
        } catch (e) {
            return t
        }
    }

    function x(t, e) {
        e(t);
        for (var n = 0, i = t.childNodes.length; i > n; n++) x(t.childNodes[n], e)
    }
    var E, T, j, C, S, O, A = [],
        N = A.concat,
        P = A.filter,
        k = A.slice,
        Z = window.document,
        D = {},
        M = {},
        $ = {
            "column-count": 1,
            columns: 1,
            "font-weight": 1,
            "line-height": 1,
            opacity: 1,
            "z-index": 1,
            zoom: 1
        },
        F = /^\s*<(\w+|!)[^>]*>/,
        L = /^<(\w+)\s*\/?>(?:<\/\1>|)$/,
        _ = /<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:]+)[^>]*)\/>/gi,
        q = /^(?:body|html)$/i,
        z = /([A-Z])/g,
        R = ["val", "css", "html", "text", "data", "width", "height", "offset"],
        W = ["after", "prepend", "before", "append"],
        I = Z.createElement("table"),
        B = Z.createElement("tr"),
        V = {
            tr: Z.createElement("tbody"),
            tbody: I,
            thead: I,
            tfoot: I,
            td: B,
            th: B,
            "*": Z.createElement("div")
        },
        H = /complete|loaded|interactive/,
        X = /^[\w-]*$/,
        U = {},
        J = U.toString,
        Y = {},
        G = Z.createElement("div"),
        K = {
            tabindex: "tabIndex",
            readonly: "readOnly",
            "for": "htmlFor",
            "class": "className",
            maxlength: "maxLength",
            cellspacing: "cellSpacing",
            cellpadding: "cellPadding",
            rowspan: "rowSpan",
            colspan: "colSpan",
            usemap: "useMap",
            frameborder: "frameBorder",
            contenteditable: "contentEditable"
        },
        Q = Array.isArray || function(t) {
            return t instanceof Array
        };
    return Y.matches = function(t, e) {
        if (!e || !t || 1 !== t.nodeType) return !1;
        var n = t.webkitMatchesSelector || t.mozMatchesSelector || t.oMatchesSelector || t.matchesSelector;
        if (n) return n.call(t, e);
        var i, r = t.parentNode,
            o = !r;
        return o && (r = G).appendChild(t), i = ~Y.qsa(r, e).indexOf(t), o && G.removeChild(t), i
    }, S = function(t) {
        return t.replace(/-+(.)?/g, function(t, e) {
            return e ? e.toUpperCase() : ""
        })
    }, O = function(t) {
        return P.call(t, function(e, n) {
            return t.indexOf(e) == n
        })
    }, Y.fragment = function(t, e, n) {
        var i, r, a;
        return L.test(t) && (i = j(Z.createElement(RegExp.$1))), i || (t.replace && (t = t.replace(_, "<$1></$2>")), e === E && (e = F.test(t) && RegExp.$1), e in V || (e = "*"), a = V[e], a.innerHTML = "" + t, i = j.each(k.call(a.childNodes), function() {
            a.removeChild(this)
        })), o(n) && (r = j(i), j.each(n, function(t, e) {
            R.indexOf(t) > -1 ? r[t](e) : r.attr(t, e)
        })), i
    }, Y.Z = function(t, e) {
        return new d(t, e)
    }, Y.isZ = function(t) {
        return t instanceof Y.Z
    }, Y.init = function(t, n) {
        var i;
        if (!t) return Y.Z();
        if ("string" == typeof t)
            if (t = t.trim(), "<" == t[0] && F.test(t)) i = Y.fragment(t, RegExp.$1, n), t = null;
            else {
                if (n !== E) return j(n).find(t);
                i = Y.qsa(Z, t)
            }
        else {
            if (e(t)) return j(Z).ready(t);
            if (Y.isZ(t)) return t;
            if (Q(t)) i = s(t);
            else if (r(t)) i = [t], t = null;
            else if (F.test(t)) i = Y.fragment(t.trim(), RegExp.$1, n), t = null;
            else {
                if (n !== E) return j(n).find(t);
                i = Y.qsa(Z, t)
            }
        }
        return Y.Z(i, t)
    }, j = function(t, e) {
        return Y.init(t, e)
    }, j.extend = function(t) {
        var e, n = k.call(arguments, 1);
        return "boolean" == typeof t && (e = t, t = n.shift()), n.forEach(function(n) {
            m(t, n, e)
        }), t
    }, Y.qsa = function(t, e) {
        var n, i = "#" == e[0],
            r = !i && "." == e[0],
            o = i || r ? e.slice(1) : e,
            a = X.test(o);
        return t.getElementById && a && i ? (n = t.getElementById(o)) ? [n] : [] : 1 !== t.nodeType && 9 !== t.nodeType && 11 !== t.nodeType ? [] : k.call(a && !i && t.getElementsByClassName ? r ? t.getElementsByClassName(o) : t.getElementsByTagName(e) : t.querySelectorAll(e))
    }, j.contains = Z.documentElement.contains ? function(t, e) {
        return t !== e && t.contains(e)
    } : function(t, e) {
        for (; e && (e = e.parentNode);)
            if (e === t) return !0;
        return !1
    }, j.type = t, j.isFunction = e, j.isWindow = n, j.isArray = Q, j.isPlainObject = o, j.isEmptyObject = function(t) {
        var e;
        for (e in t) return !1;
        return !0
    }, j.inArray = function(t, e, n) {
        return A.indexOf.call(e, t, n)
    }, j.camelCase = S, j.trim = function(t) {
        return null == t ? "" : String.prototype.trim.call(t)
    }, j.uuid = 0, j.support = {}, j.expr = {}, j.noop = function() {}, j.map = function(t, e) {
        var n, i, r, o = [];
        if (a(t))
            for (i = 0; t.length > i; i++) n = e(t[i], i), null != n && o.push(n);
        else
            for (r in t) n = e(t[r], r), null != n && o.push(n);
        return u(o)
    }, j.each = function(t, e) {
        var n, i;
        if (a(t)) {
            for (n = 0; t.length > n; n++)
                if (e.call(t[n], n, t[n]) === !1) return t
        } else
            for (i in t)
                if (e.call(t[i], i, t[i]) === !1) return t; return t
    }, j.grep = function(t, e) {
        return P.call(t, e)
    }, window.JSON && (j.parseJSON = JSON.parse), j.each("Boolean Number String Function Array Date RegExp Object Error".split(" "), function(t, e) {
        U["[object " + e + "]"] = e.toLowerCase()
    }), j.fn = {
        constructor: Y.Z,
        length: 0,
        forEach: A.forEach,
        reduce: A.reduce,
        push: A.push,
        sort: A.sort,
        splice: A.splice,
        indexOf: A.indexOf,
        concat: function() {
            var t, e, n = [];
            for (t = 0; arguments.length > t; t++) e = arguments[t], n[t] = Y.isZ(e) ? e.toArray() : e;
            return N.apply(Y.isZ(this) ? this.toArray() : this, n)
        },
        map: function(t) {
            return j(j.map(this, function(e, n) {
                return t.call(e, n, e)
            }))
        },
        slice: function() {
            return j(k.apply(this, arguments))
        },
        ready: function(t) {
            return H.test(Z.readyState) && Z.body ? t(j) : Z.addEventListener("DOMContentLoaded", function() {
                t(j)
            }, !1), this
        },
        get: function(t) {
            return t === E ? k.call(this) : this[t >= 0 ? t : t + this.length]
        },
        toArray: function() {
            return this.get()
        },
        size: function() {
            return this.length
        },
        remove: function() {
            return this.each(function() {
                null != this.parentNode && this.parentNode.removeChild(this)
            })
        },
        each: function(t) {
            return A.every.call(this, function(e, n) {
                return t.call(e, n, e) !== !1
            }), this
        },
        filter: function(t) {
            return e(t) ? this.not(this.not(t)) : j(P.call(this, function(e) {
                return Y.matches(e, t)
            }))
        },
        add: function(t, e) {
            return j(O(this.concat(j(t, e))))
        },
        is: function(t) {
            return this.length > 0 && Y.matches(this[0], t)
        },
        not: function(t) {
            var n = [];
            if (e(t) && t.call !== E) this.each(function(e) {
                t.call(this, e) || n.push(this)
            });
            else {
                var i = "string" == typeof t ? this.filter(t) : a(t) && e(t.item) ? k.call(t) : j(t);
                this.forEach(function(t) {
                    0 > i.indexOf(t) && n.push(t)
                })
            }
            return j(n)
        },
        has: function(t) {
            return this.filter(function() {
                return r(t) ? j.contains(this, t) : j(this).find(t).size()
            })
        },
        eq: function(t) {
            return -1 === t ? this.slice(t) : this.slice(t, +t + 1)
        },
        first: function() {
            var t = this[0];
            return t && !r(t) ? t : j(t)
        },
        last: function() {
            var t = this[this.length - 1];
            return t && !r(t) ? t : j(t)
        },
        find: function(t) {
            var e, n = this;
            return e = t ? "object" == typeof t ? j(t).filter(function() {
                var t = this;
                return A.some.call(n, function(e) {
                    return j.contains(e, t)
                })
            }) : 1 == this.length ? j(Y.qsa(this[0], t)) : this.map(function() {
                return Y.qsa(this, t)
            }) : j()
        },
        closest: function(t, e) {
            var n = this[0],
                r = !1;
            for ("object" == typeof t && (r = j(t)); n && !(r ? r.indexOf(n) >= 0 : Y.matches(n, t));) n = n !== e && !i(n) && n.parentNode;
            return j(n)
        },
        parents: function(t) {
            for (var e = [], n = this; n.length > 0;) n = j.map(n, function(t) {
                return (t = t.parentNode) && !i(t) && 0 > e.indexOf(t) ? (e.push(t), t) : E
            });
            return v(e, t)
        },
        parent: function(t) {
            return v(O(this.pluck("parentNode")), t)
        },
        children: function(t) {
            return v(this.map(function() {
                return p(this)
            }), t)
        },
        contents: function() {
            return this.map(function() {
                return this.contentDocument || k.call(this.childNodes)
            })
        },
        siblings: function(t) {
            return v(this.map(function(t, e) {
                return P.call(p(e.parentNode), function(t) {
                    return t !== e
                })
            }), t)
        },
        empty: function() {
            return this.each(function() {
                this.innerHTML = ""
            })
        },
        pluck: function(t) {
            return j.map(this, function(e) {
                return e[t]
            })
        },
        show: function() {
            return this.each(function() {
                "none" == this.style.display && (this.style.display = ""), "none" == getComputedStyle(this, "").getPropertyValue("display") && (this.style.display = h(this.nodeName))
            })
        },
        replaceWith: function(t) {
            return this.before(t).remove()
        },
        wrap: function(t) {
            var n = e(t);
            if (this[0] && !n) var i = j(t).get(0),
                r = i.parentNode || this.length > 1;
            return this.each(function(e) {
                j(this).wrapAll(n ? t.call(this, e) : r ? i.cloneNode(!0) : i)
            })
        },
        wrapAll: function(t) {
            if (this[0]) {
                j(this[0]).before(t = j(t));
                for (var e;
                    (e = t.children()).length;) t = e.first();
                j(t).append(this)
            }
            return this
        },
        wrapInner: function(t) {
            var n = e(t);
            return this.each(function(e) {
                var i = j(this),
                    r = i.contents(),
                    o = n ? t.call(this, e) : t;
                r.length ? r.wrapAll(o) : i.append(o)
            })
        },
        unwrap: function() {
            return this.parent().each(function() {
                j(this).replaceWith(j(this).children())
            }), this
        },
        clone: function() {
            return this.map(function() {
                return this.cloneNode(!0)
            })
        },
        hide: function() {
            return this.css("display", "none")
        },
        toggle: function(t) {
            return this.each(function() {
                var e = j(this);
                (t === E ? "none" == e.css("display") : t) ? e.show(): e.hide()
            })
        },
        prev: function(t) {
            return j(this.pluck("previousElementSibling")).filter(t || "*")
        },
        next: function(t) {
            return j(this.pluck("nextElementSibling")).filter(t || "*")
        },
        html: function(t) {
            return 0 in arguments ? this.each(function(e) {
                var n = this.innerHTML;
                j(this).empty().append(g(this, t, e, n))
            }) : 0 in this ? this[0].innerHTML : null
        },
        text: function(t) {
            return 0 in arguments ? this.each(function(e) {
                var n = g(this, t, e, this.textContent);
                this.textContent = null == n ? "" : "" + n
            }) : 0 in this ? this[0].textContent : null
        },
        attr: function(t, e) {
            var n;
            return "string" != typeof t || 1 in arguments ? this.each(function(n) {
                if (1 === this.nodeType)
                    if (r(t))
                        for (T in t) y(this, T, t[T]);
                    else y(this, t, g(this, e, n, this.getAttribute(t)))
            }) : this.length && 1 === this[0].nodeType ? !(n = this[0].getAttribute(t)) && t in this[0] ? this[0][t] : n : E
        },
        removeAttr: function(t) {
            return this.each(function() {
                1 === this.nodeType && t.split(" ").forEach(function(t) {
                    y(this, t)
                }, this)
            })
        },
        prop: function(t, e) {
            return t = K[t] || t, 1 in arguments ? this.each(function(n) {
                this[t] = g(this, e, n, this[t])
            }) : this[0] && this[0][t]
        },
        data: function(t, e) {
            var n = "data-" + t.replace(z, "-$1").toLowerCase(),
                i = 1 in arguments ? this.attr(n, e) : this.attr(n);
            return null !== i ? w(i) : E
        },
        val: function(t) {
            return 0 in arguments ? this.each(function(e) {
                this.value = g(this, t, e, this.value)
            }) : this[0] && (this[0].multiple ? j(this[0]).find("option").filter(function() {
                return this.selected
            }).pluck("value") : this[0].value)
        },
        offset: function(t) {
            if (t) return this.each(function(e) {
                var n = j(this),
                    i = g(this, t, e, n.offset()),
                    r = n.offsetParent().offset(),
                    o = {
                        top: i.top - r.top,
                        left: i.left - r.left
                    };
                "static" == n.css("position") && (o.position = "relative"), n.css(o)
            });
            if (!this.length) return null;
            var e = this[0].getBoundingClientRect();
            return {
                left: e.left + window.pageXOffset,
                top: e.top + window.pageYOffset,
                width: Math.round(e.width),
                height: Math.round(e.height)
            }
        },
        css: function(e, n) {
            if (2 > arguments.length) {
                var i, r = this[0];
                if (!r) return;
                if (i = getComputedStyle(r, ""), "string" == typeof e) return r.style[S(e)] || i.getPropertyValue(e);
                if (Q(e)) {
                    var o = {};
                    return j.each(e, function(t, e) {
                        o[e] = r.style[S(e)] || i.getPropertyValue(e)
                    }), o
                }
            }
            var a = "";
            if ("string" == t(e)) n || 0 === n ? a = c(e) + ":" + f(e, n) : this.each(function() {
                this.style.removeProperty(c(e))
            });
            else
                for (T in e) e[T] || 0 === e[T] ? a += c(T) + ":" + f(T, e[T]) + ";" : this.each(function() {
                    this.style.removeProperty(c(T))
                });
            return this.each(function() {
                this.style.cssText += ";" + a
            })
        },
        index: function(t) {
            return t ? this.indexOf(j(t)[0]) : this.parent().children().indexOf(this[0])
        },
        hasClass: function(t) {
            return t ? A.some.call(this, function(t) {
                return this.test(b(t))
            }, l(t)) : !1
        },
        addClass: function(t) {
            return t ? this.each(function(e) {
                if ("className" in this) {
                    C = [];
                    var n = b(this),
                        i = g(this, t, e, n);
                    i.split(/\s+/g).forEach(function(t) {
                        j(this).hasClass(t) || C.push(t)
                    }, this), C.length && b(this, n + (n ? " " : "") + C.join(" "))
                }
            }) : this
        },
        removeClass: function(t) {
            return this.each(function(e) {
                if ("className" in this) {
                    if (t === E) return b(this, "");
                    C = b(this), g(this, t, e, C).split(/\s+/g).forEach(function(t) {
                        C = C.replace(l(t), " ")
                    }), b(this, C.trim())
                }
            })
        },
        toggleClass: function(t, e) {
            return t ? this.each(function(n) {
                var i = j(this),
                    r = g(this, t, n, b(this));
                r.split(/\s+/g).forEach(function(t) {
                    (e === E ? !i.hasClass(t) : e) ? i.addClass(t): i.removeClass(t)
                })
            }) : this
        },
        scrollTop: function(t) {
            if (this.length) {
                var e = "scrollTop" in this[0];
                return t === E ? e ? this[0].scrollTop : this[0].pageYOffset : this.each(e ? function() {
                    this.scrollTop = t
                } : function() {
                    this.scrollTo(this.scrollX, t)
                })
            }
        },
        scrollLeft: function(t) {
            if (this.length) {
                var e = "scrollLeft" in this[0];
                return t === E ? e ? this[0].scrollLeft : this[0].pageXOffset : this.each(e ? function() {
                    this.scrollLeft = t
                } : function() {
                    this.scrollTo(t, this.scrollY)
                })
            }
        },
        position: function() {
            if (this.length) {
                var t = this[0],
                    e = this.offsetParent(),
                    n = this.offset(),
                    i = q.test(e[0].nodeName) ? {
                        top: 0,
                        left: 0
                    } : e.offset();
                return n.top -= parseFloat(j(t).css("margin-top")) || 0, n.left -= parseFloat(j(t).css("margin-left")) || 0, i.top += parseFloat(j(e[0]).css("border-top-width")) || 0, i.left += parseFloat(j(e[0]).css("border-left-width")) || 0, {
                    top: n.top - i.top,
                    left: n.left - i.left
                }
            }
        },
        offsetParent: function() {
            return this.map(function() {
                for (var t = this.offsetParent || Z.body; t && !q.test(t.nodeName) && "static" == j(t).css("position");) t = t.offsetParent;
                return t
            })
        }
    }, j.fn.detach = j.fn.remove, ["width", "height"].forEach(function(t) {
        var e = t.replace(/./, function(t) {
            return t[0].toUpperCase()
        });
        j.fn[t] = function(r) {
            var o, a = this[0];
            return r === E ? n(a) ? a["inner" + e] : i(a) ? a.documentElement["scroll" + e] : (o = this.offset()) && o[t] : this.each(function(e) {
                a = j(this), a.css(t, g(this, r, e, a[t]()))
            })
        }
    }), W.forEach(function(e, n) {
        var i = n % 2;
        j.fn[e] = function() {
            var e, r, o = j.map(arguments, function(n) {
                    return e = t(n), "object" == e || "array" == e || null == n ? n : Y.fragment(n)
                }),
                a = this.length > 1;
            return 1 > o.length ? this : this.each(function(t, e) {
                r = i ? e : e.parentNode, e = 0 == n ? e.nextSibling : 1 == n ? e.firstChild : 2 == n ? e : null;
                var s = j.contains(Z.documentElement, r);
                o.forEach(function(t) {
                    if (a) t = t.cloneNode(!0);
                    else if (!r) return j(t).remove();
                    r.insertBefore(t, e), s && x(t, function(t) {
                        null == t.nodeName || "SCRIPT" !== t.nodeName.toUpperCase() || t.type && "text/javascript" !== t.type || t.src || window.eval.call(window, t.innerHTML)
                    })
                })
            })
        }, j.fn[i ? e + "To" : "insert" + (n ? "Before" : "After")] = function(t) {
            return j(t)[e](this), this
        }
    }), Y.Z.prototype = d.prototype = j.fn, Y.uniq = O, Y.deserializeValue = w, j.zepto = Y, j
}();
window.Zepto = Zepto, void 0 === window.$ && (window.$ = Zepto),
    function(t) {
        function e(e, n, i) {
            var r = t.Event(n);
            return t(e).trigger(r, i), !r.isDefaultPrevented()
        }

        function n(t, n, i, r) {
            return t.global ? e(n || y, i, r) : void 0
        }

        function i(e) {
            e.global && 0 === t.active++ && n(e, null, "ajaxStart")
        }

        function r(e) {
            e.global && !--t.active && n(e, null, "ajaxStop")
        }

        function o(t, e) {
            var i = e.context;
            return e.beforeSend.call(i, t, e) === !1 || n(e, i, "ajaxBeforeSend", [t, e]) === !1 ? !1 : (n(e, i, "ajaxSend", [t, e]), void 0)
        }

        function a(t, e, i, r) {
            var o = i.context,
                a = "success";
            i.success.call(o, t, a, e), r && r.resolveWith(o, [t, a, e]), n(i, o, "ajaxSuccess", [e, i, t]), u(a, e, i)
        }

        function s(t, e, i, r, o) {
            var a = r.context;
            r.error.call(a, i, e, t), o && o.rejectWith(a, [i, e, t]), n(r, a, "ajaxError", [i, r, t || e]), u(e, i, r)
        }

        function u(t, e, i) {
            var o = i.context;
            i.complete.call(o, e, t), n(i, o, "ajaxComplete", [e, i]), r(i)
        }

        function c() {}

        function l(t) {
            return t && (t = t.split(";", 2)[0]), t && (t == T ? "html" : t == E ? "json" : w.test(t) ? "script" : x.test(t) && "xml") || "text"
        }

        function f(t, e) {
            return "" == e ? t : (t + "&" + e).replace(/[&?]{1,2}/, "?")
        }

        function h(e) {
            e.processData && e.data && "string" != t.type(e.data) && (e.data = t.param(e.data, e.traditional)), !e.data || e.type && "GET" != e.type.toUpperCase() || (e.url = f(e.url, e.data), e.data = void 0)
        }

        function p(e, n, i, r) {
            return t.isFunction(n) && (r = i, i = n, n = void 0), t.isFunction(i) || (r = i, i = void 0), {
                url: e,
                data: n,
                success: i,
                dataType: r
            }
        }

        function d(e, n, i, r) {
            var o, a = t.isArray(n),
                s = t.isPlainObject(n);
            t.each(n, function(n, u) {
                o = t.type(u), r && (n = i ? r : r + "[" + (s || "object" == o || "array" == o ? n : "") + "]"), !r && a ? e.add(u.name, u.value) : "array" == o || !i && "object" == o ? d(e, u, i, n) : e.add(n, u)
            })
        }
        var m, v, g = 0,
            y = window.document,
            b = /<script\b[^<]*(?:(?!<\/script>)<[^<]*)*<\/script>/gi,
            w = /^(?:text|application)\/javascript/i,
            x = /^(?:text|application)\/xml/i,
            E = "application/json",
            T = "text/html",
            j = /^\s*$/,
            C = y.createElement("a");
        C.href = window.location.href, t.active = 0, t.ajaxJSONP = function(e, n) {
            if (!("type" in e)) return t.ajax(e);
            var i, r, u = e.jsonpCallback,
                c = (t.isFunction(u) ? u() : u) || "jsonp" + ++g,
                l = y.createElement("script"),
                f = window[c],
                h = function(e) {
                    t(l).triggerHandler("error", e || "abort")
                },
                p = {
                    abort: h
                };
            return n && n.promise(p), t(l).on("load error", function(o, u) {
                clearTimeout(r), t(l).off().remove(), "error" != o.type && i ? a(i[0], p, e, n) : s(null, u || "error", p, e, n), window[c] = f, i && t.isFunction(f) && f(i[0]), f = i = void 0
            }), o(p, e) === !1 ? (h("abort"), p) : (window[c] = function() {
                i = arguments
            }, l.src = e.url.replace(/\?(.+)=\?/, "?$1=" + c), y.head.appendChild(l), e.timeout > 0 && (r = setTimeout(function() {
                h("timeout")
            }, e.timeout)), p)
        }, t.ajaxSettings = {
            type: "GET",
            beforeSend: c,
            success: c,
            error: c,
            complete: c,
            context: null,
            global: !0,
            xhr: function() {
                return new window.XMLHttpRequest
            },
            accepts: {
                script: "text/javascript, application/javascript, application/x-javascript",
                json: E,
                xml: "application/xml, text/xml",
                html: T,
                text: "text/plain"
            },
            crossDomain: !1,
            timeout: 0,
            processData: !0,
            cache: !0
        }, t.ajax = function(e) {
            var n, r = t.extend({}, e || {}),
                u = t.Deferred && t.Deferred();
            for (m in t.ajaxSettings) void 0 === r[m] && (r[m] = t.ajaxSettings[m]);
            i(r), r.crossDomain || (n = y.createElement("a"), n.href = r.url, n.href = n.href, r.crossDomain = C.protocol + "//" + C.host != n.protocol + "//" + n.host), r.url || (r.url = "" + window.location), h(r);
            var p = r.dataType,
                d = /\?.+=\?/.test(r.url);
            if (d && (p = "jsonp"), r.cache !== !1 && (e && e.cache === !0 || "script" != p && "jsonp" != p) || (r.url = f(r.url, "_=" + Date.now())), "jsonp" == p) return d || (r.url = f(r.url, r.jsonp ? r.jsonp + "=?" : r.jsonp === !1 ? "" : "callback=?")), t.ajaxJSONP(r, u);
            var g, b = r.accepts[p],
                w = {},
                x = function(t, e) {
                    w[t.toLowerCase()] = [t, e]
                },
                E = /^([\w-]+:)\/\//.test(r.url) ? RegExp.$1 : window.location.protocol,
                T = r.xhr(),
                S = T.setRequestHeader;
            if (u && u.promise(T), r.crossDomain || x("X-Requested-With", "XMLHttpRequest"), x("Accept", b || "*/*"), (b = r.mimeType || b) && (b.indexOf(",") > -1 && (b = b.split(",", 2)[0]), T.overrideMimeType && T.overrideMimeType(b)), (r.contentType || r.contentType !== !1 && r.data && "GET" != r.type.toUpperCase()) && x("Content-Type", r.contentType || "application/x-www-form-urlencoded"), r.headers)
                for (v in r.headers) x(v, r.headers[v]);
            if (T.setRequestHeader = x, T.onreadystatechange = function() {
                    if (4 == T.readyState) {
                        T.onreadystatechange = c, clearTimeout(g);
                        var e, n = !1;
                        if (T.status >= 200 && 300 > T.status || 304 == T.status || 0 == T.status && "file:" == E) {
                            p = p || l(r.mimeType || T.getResponseHeader("content-type")), e = T.responseText;
                            try {
                                "script" == p ? (1, eval)(e) : "xml" == p ? e = T.responseXML : "json" == p && (e = j.test(e) ? null : t.parseJSON(e))
                            } catch (i) {
                                n = i
                            }
                            n ? s(n, "parsererror", T, r, u) : a(e, T, r, u)
                        } else s(T.statusText || null, T.status ? "error" : "abort", T, r, u)
                    }
                }, o(T, r) === !1) return T.abort(), s(null, "abort", T, r, u), T;
            if (r.xhrFields)
                for (v in r.xhrFields) T[v] = r.xhrFields[v];
            var O = "async" in r ? r.async : !0;
            T.open(r.type, r.url, O, r.username, r.password);
            for (v in w) S.apply(T, w[v]);
            return r.timeout > 0 && (g = setTimeout(function() {
                T.onreadystatechange = c, T.abort(), s(null, "timeout", T, r, u)
            }, r.timeout)), T.send(r.data ? r.data : null), T
        }, t.get = function() {
            return t.ajax(p.apply(null, arguments))
        }, t.post = function() {
            var e = p.apply(null, arguments);
            return e.type = "POST", t.ajax(e)
        }, t.getJSON = function() {
            var e = p.apply(null, arguments);
            return e.dataType = "json", t.ajax(e)
        }, t.fn.load = function(e, n, i) {
            if (!this.length) return this;
            var r, o = this,
                a = e.split(/\s/),
                s = p(e, n, i),
                u = s.success;
            return a.length > 1 && (s.url = a[0], r = a[1]), s.success = function(e) {
                o.html(r ? t("<div>").html(e.replace(b, "")).find(r) : e), u && u.apply(o, arguments)
            }, t.ajax(s), this
        };
        var S = encodeURIComponent;
        t.param = function(e, n) {
            var i = [];
            return i.add = function(e, n) {
                t.isFunction(n) && (n = n()), null == n && (n = ""), this.push(S(e) + "=" + S(n))
            }, d(i, e, n), i.join("&").replace(/%20/g, "+")
        }
    }(Zepto),
    function(t) {
        var e, n = [];
        t.fn.remove = function() {
            return this.each(function() {
                this.parentNode && ("IMG" === this.tagName && (n.push(this), this.src = "data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=", e && clearTimeout(e), e = setTimeout(function() {
                    n = []
                }, 6e4)), this.parentNode.removeChild(this))
            })
        }
    }(Zepto),
    function(t) {
        t.Callbacks = function(e) {
            e = t.extend({}, e);
            var n, i, r, o, a, s, u = [],
                c = !e.once && [],
                l = function(t) {
                    for (n = e.memory && t, i = !0, s = o || 0, o = 0, a = u.length, r = !0; u && a > s; ++s)
                        if (u[s].apply(t[0], t[1]) === !1 && e.stopOnFalse) {
                            n = !1;
                            break
                        }
                    r = !1, u && (c ? c.length && l(c.shift()) : n ? u.length = 0 : f.disable())
                },
                f = {
                    add: function() {
                        if (u) {
                            var i = u.length,
                                s = function(n) {
                                    t.each(n, function(t, n) {
                                        "function" == typeof n ? e.unique && f.has(n) || u.push(n) : n && n.length && "string" != typeof n && s(n)
                                    })
                                };
                            s(arguments), r ? a = u.length : n && (o = i, l(n))
                        }
                        return this
                    },
                    remove: function() {
                        return u && t.each(arguments, function(e, n) {
                            for (var i;
                                (i = t.inArray(n, u, i)) > -1;) u.splice(i, 1), r && (a >= i && --a, s >= i && --s)
                        }), this
                    },
                    has: function(e) {
                        return !(!u || !(e ? t.inArray(e, u) > -1 : u.length))
                    },
                    empty: function() {
                        return a = u.length = 0, this
                    },
                    disable: function() {
                        return u = c = n = void 0, this
                    },
                    disabled: function() {
                        return !u
                    },
                    lock: function() {
                        return c = void 0, n || f.disable(), this
                    },
                    locked: function() {
                        return !c
                    },
                    fireWith: function(t, e) {
                        return !u || i && !c || (e = e || [], e = [t, e.slice ? e.slice() : e], r ? c.push(e) : l(e)), this
                    },
                    fire: function() {
                        return f.fireWith(this, arguments)
                    },
                    fired: function() {
                        return !!i
                    }
                };
            return f
        }
    }(Zepto),
    function(t) {
        function e(e, i) {
            var u = e[s],
                c = u && r[u];
            if (void 0 === i) return c || n(e);
            if (c) {
                if (i in c) return c[i];
                var l = a(i);
                if (l in c) return c[l]
            }
            return o.call(t(e), i)
        }

        function n(e, n, o) {
            var u = e[s] || (e[s] = ++t.uuid),
                c = r[u] || (r[u] = i(e));
            return void 0 !== n && (c[a(n)] = o), c
        }

        function i(e) {
            var n = {};
            return t.each(e.attributes || u, function(e, i) {
                0 == i.name.indexOf("data-") && (n[a(i.name.replace("data-", ""))] = t.zepto.deserializeValue(i.value))
            }), n
        }
        var r = {},
            o = t.fn.data,
            a = t.camelCase,
            s = t.expando = "Zepto" + +new Date,
            u = [];
        t.fn.data = function(i, r) {
            return void 0 === r ? t.isPlainObject(i) ? this.each(function(e, r) {
                t.each(i, function(t, e) {
                    n(r, t, e)
                })
            }) : 0 in this ? e(this[0], i) : void 0 : this.each(function() {
                n(this, i, r)
            })
        }, t.fn.removeData = function(e) {
            return "string" == typeof e && (e = e.split(/\s+/)), this.each(function() {
                var n = this[s],
                    i = n && r[n];
                i && t.each(e || i, function(t) {
                    delete i[e ? a(this) : t]
                })
            })
        }, ["remove", "empty"].forEach(function(e) {
            var n = t.fn[e];
            t.fn[e] = function() {
                var t = this.find("*");
                return "remove" === e && (t = t.add(this)), t.removeData(), n.call(this)
            }
        })
    }(Zepto),
    function(t) {
        function e(n) {
            var i = [
                    ["resolve", "done", t.Callbacks({
                        once: 1,
                        memory: 1
                    }), "resolved"],
                    ["reject", "fail", t.Callbacks({
                        once: 1,
                        memory: 1
                    }), "rejected"],
                    ["notify", "progress", t.Callbacks({
                        memory: 1
                    })]
                ],
                r = "pending",
                o = {
                    state: function() {
                        return r
                    },
                    always: function() {
                        return a.done(arguments).fail(arguments), this
                    },
                    then: function() {
                        var n = arguments;
                        return e(function(e) {
                            t.each(i, function(i, r) {
                                var s = t.isFunction(n[i]) && n[i];
                                a[r[1]](function() {
                                    var n = s && s.apply(this, arguments);
                                    if (n && t.isFunction(n.promise)) n.promise().done(e.resolve).fail(e.reject).progress(e.notify);
                                    else {
                                        var i = this === o ? e.promise() : this,
                                            a = s ? [n] : arguments;
                                        e[r[0] + "With"](i, a)
                                    }
                                })
                            }), n = null
                        }).promise()
                    },
                    promise: function(e) {
                        return null != e ? t.extend(e, o) : o
                    }
                },
                a = {};
            return t.each(i, function(t, e) {
                var n = e[2],
                    s = e[3];
                o[e[1]] = n.add, s && n.add(function() {
                    r = s
                }, i[1 ^ t][2].disable, i[2][2].lock), a[e[0]] = function() {
                    return a[e[0] + "With"](this === a ? o : this, arguments), this
                }, a[e[0] + "With"] = n.fireWith
            }), o.promise(a), n && n.call(a, a), a
        }
        var n = Array.prototype.slice;
        t.when = function(i) {
            var r, o, a, s = n.call(arguments),
                u = s.length,
                c = 0,
                l = 1 !== u || i && t.isFunction(i.promise) ? u : 0,
                f = 1 === l ? i : e(),
                h = function(t, e, i) {
                    return function(o) {
                        e[t] = this, i[t] = arguments.length > 1 ? n.call(arguments) : o, i === r ? f.notifyWith(e, i) : --l || f.resolveWith(e, i)
                    }
                };
            if (u > 1)
                for (r = Array(u), o = Array(u), a = Array(u); u > c; ++c) s[c] && t.isFunction(s[c].promise) ? s[c].promise().done(h(c, a, s)).fail(f.reject).progress(h(c, o, r)) : --l;
            return l || f.resolveWith(a, s), f.promise()
        }, t.Deferred = e
    }(Zepto),
    function(t) {
        function e(t, e) {
            var n = this.os = {},
                i = this.browser = {},
                r = t.match(/Web[kK]it[\/]{0,1}([\d.]+)/),
                o = t.match(/(Android);?[\s\/]+([\d.]+)?/),
                a = !!t.match(/\(Macintosh\; Intel /),
                s = t.match(/(iPad).*OS\s([\d_]+)/),
                u = t.match(/(iPod)(.*OS\s([\d_]+))?/),
                c = !s && t.match(/(iPhone\sOS)\s([\d_]+)/),
                l = t.match(/(webOS|hpwOS)[\s\/]([\d.]+)/),
                f = /Win\d{2}|Windows/.test(e),
                h = t.match(/Windows Phone ([\d.]+)/),
                p = l && t.match(/TouchPad/),
                d = t.match(/Kindle\/([\d.]+)/),
                m = t.match(/Silk\/([\d._]+)/),
                v = t.match(/(BlackBerry).*Version\/([\d.]+)/),
                g = t.match(/(BB10).*Version\/([\d.]+)/),
                y = t.match(/(RIM\sTablet\sOS)\s([\d.]+)/),
                b = t.match(/PlayBook/),
                w = t.match(/Chrome\/([\d.]+)/) || t.match(/CriOS\/([\d.]+)/),
                x = t.match(/Firefox\/([\d.]+)/),
                E = t.match(/\((?:Mobile|Tablet); rv:([\d.]+)\).*Firefox\/[\d.]+/),
                T = t.match(/MSIE\s([\d.]+)/) || t.match(/Trident\/[\d](?=[^\?]+).*rv:([0-9.].)/),
                j = !w && t.match(/(iPhone|iPod|iPad).*AppleWebKit(?!.*Safari)/),
                C = j || t.match(/Version\/([\d.]+)([^S](Safari)|[^M]*(Mobile)[^S]*(Safari))/);
            (i.webkit = !!r) && (i.version = r[1]), o && (n.android = !0, n.version = o[2]), c && !u && (n.ios = n.iphone = !0, n.version = c[2].replace(/_/g, ".")), s && (n.ios = n.ipad = !0, n.version = s[2].replace(/_/g, ".")), u && (n.ios = n.ipod = !0, n.version = u[3] ? u[3].replace(/_/g, ".") : null), h && (n.wp = !0, n.version = h[1]), l && (n.webos = !0, n.version = l[2]), p && (n.touchpad = !0), v && (n.blackberry = !0, n.version = v[2]), g && (n.bb10 = !0, n.version = g[2]), y && (n.rimtabletos = !0, n.version = y[2]), b && (i.playbook = !0), d && (n.kindle = !0, n.version = d[1]), m && (i.silk = !0, i.version = m[1]), !m && n.android && t.match(/Kindle Fire/) && (i.silk = !0), w && (i.chrome = !0, i.version = w[1]), x && (i.firefox = !0, i.version = x[1]), E && (n.firefoxos = !0, n.version = E[1]), T && (i.ie = !0, i.version = T[1]), C && (a || n.ios || f) && (i.safari = !0, n.ios || (i.version = C[1])), j && (i.webview = !0), n.tablet = !!(s || b || o && !t.match(/Mobile/) || x && t.match(/Tablet/) || T && !t.match(/Phone/) && t.match(/Touch/)), n.phone = !(n.tablet || n.ipod || !(o || c || l || v || g || w && t.match(/Android/) || w && t.match(/CriOS\/([\d.]+)/) || x && t.match(/Mobile/) || T && t.match(/Touch/)))
        }
        e.call(t, navigator.userAgent, navigator.platform), t.__detect = e
    }(Zepto),
    function(t) {
        function e(t) {
            return t._zid || (t._zid = h++)
        }

        function n(t, n, o, a) {
            if (n = i(n), n.ns) var s = r(n.ns);
            return (v[e(t)] || []).filter(function(t) {
                return !(!t || n.e && t.e != n.e || n.ns && !s.test(t.ns) || o && e(t.fn) !== e(o) || a && t.sel != a)
            })
        }

        function i(t) {
            var e = ("" + t).split(".");
            return {
                e: e[0],
                ns: e.slice(1).sort().join(" ")
            }
        }

        function r(t) {
            return RegExp("(?:^| )" + t.replace(" ", " .* ?") + "(?: |$)")
        }

        function o(t, e) {
            return t.del && !y && t.e in b || !!e
        }

        function a(t) {
            return w[t] || y && b[t] || t
        }

        function s(n, r, s, u, l, h, p) {
            var d = e(n),
                m = v[d] || (v[d] = []);
            r.split(/\s/).forEach(function(e) {
                if ("ready" == e) return t(document).ready(s);
                var r = i(e);
                r.fn = s, r.sel = l, r.e in w && (s = function(e) {
                    var n = e.relatedTarget;
                    return !n || n !== this && !t.contains(this, n) ? r.fn.apply(this, arguments) : f
                }), r.del = h;
                var d = h || s;
                r.proxy = function(t) {
                    if (t = c(t), !t.isImmediatePropagationStopped()) {
                        t.data = u;
                        var e = d.apply(n, t._args == f ? [t] : [t].concat(t._args));
                        return e === !1 && (t.preventDefault(), t.stopPropagation()), e
                    }
                }, r.i = m.length, m.push(r), "addEventListener" in n && n.addEventListener(a(r.e), r.proxy, o(r, p))
            })
        }

        function u(t, i, r, s, u) {
            var c = e(t);
            (i || "").split(/\s/).forEach(function(e) {
                n(t, e, r, s).forEach(function(e) {
                    delete v[c][e.i], "removeEventListener" in t && t.removeEventListener(a(e.e), e.proxy, o(e, u))
                })
            })
        }

        function c(e, n) {
            return (n || !e.isDefaultPrevented) && (n || (n = e), t.each(j, function(t, i) {
                var r = n[t];
                e[t] = function() {
                    return this[i] = x, r && r.apply(n, arguments)
                }, e[i] = E
            }), (n.defaultPrevented !== f ? n.defaultPrevented : "returnValue" in n ? n.returnValue === !1 : n.getPreventDefault && n.getPreventDefault()) && (e.isDefaultPrevented = x)), e
        }

        function l(t) {
            var e, n = {
                originalEvent: t
            };
            for (e in t) T.test(e) || t[e] === f || (n[e] = t[e]);
            return c(n, t)
        }
        var f, h = 1,
            p = Array.prototype.slice,
            d = t.isFunction,
            m = function(t) {
                return "string" == typeof t
            },
            v = {},
            g = {},
            y = "onfocusin" in window,
            b = {
                focus: "focusin",
                blur: "focusout"
            },
            w = {
                mouseenter: "mouseover",
                mouseleave: "mouseout"
            };
        g.click = g.mousedown = g.mouseup = g.mousemove = "MouseEvents", t.event = {
            add: s,
            remove: u
        }, t.proxy = function(n, i) {
            var r = 2 in arguments && p.call(arguments, 2);
            if (d(n)) {
                var o = function() {
                    return n.apply(i, r ? r.concat(p.call(arguments)) : arguments)
                };
                return o._zid = e(n), o
            }
            if (m(i)) return r ? (r.unshift(n[i], n), t.proxy.apply(null, r)) : t.proxy(n[i], n);
            throw new TypeError("expected function")
        }, t.fn.bind = function(t, e, n) {
            return this.on(t, e, n)
        }, t.fn.unbind = function(t, e) {
            return this.off(t, e)
        }, t.fn.one = function(t, e, n, i) {
            return this.on(t, e, n, i, 1)
        };
        var x = function() {
                return !0
            },
            E = function() {
                return !1
            },
            T = /^([A-Z]|returnValue$|layer[XY]$)/,
            j = {
                preventDefault: "isDefaultPrevented",
                stopImmediatePropagation: "isImmediatePropagationStopped",
                stopPropagation: "isPropagationStopped"
            };
        t.fn.delegate = function(t, e, n) {
            return this.on(e, t, n)
        }, t.fn.undelegate = function(t, e, n) {
            return this.off(e, t, n)
        }, t.fn.live = function(e, n) {
            return t(document.body).delegate(this.selector, e, n), this
        }, t.fn.die = function(e, n) {
            return t(document.body).undelegate(this.selector, e, n), this
        }, t.fn.on = function(e, n, i, r, o) {
            var a, c, h = this;
            return e && !m(e) ? (t.each(e, function(t, e) {
                h.on(t, n, i, e, o)
            }), h) : (m(n) || d(r) || r === !1 || (r = i, i = n, n = f), (d(i) || i === !1) && (r = i, i = f), r === !1 && (r = E), h.each(function(h, d) {
                o && (a = function(t) {
                    return u(d, t.type, r), r.apply(this, arguments)
                }), n && (c = function(e) {
                    var i, o = t(e.target).closest(n, d).get(0);
                    return o && o !== d ? (i = t.extend(l(e), {
                        currentTarget: o,
                        liveFired: d
                    }), (a || r).apply(o, [i].concat(p.call(arguments, 1)))) : f
                }), s(d, e, r, i, n, c || a)
            }))
        }, t.fn.off = function(e, n, i) {
            var r = this;
            return e && !m(e) ? (t.each(e, function(t, e) {
                r.off(t, n, e)
            }), r) : (m(n) || d(i) || i === !1 || (i = n, n = f), i === !1 && (i = E), r.each(function() {
                u(this, e, i, n)
            }))
        }, t.fn.trigger = function(e, n) {
            return e = m(e) || t.isPlainObject(e) ? t.Event(e) : c(e), e._args = n, this.each(function() {
                e.type in b && "function" == typeof this[e.type] ? this[e.type]() : "dispatchEvent" in this ? this.dispatchEvent(e) : t(this).triggerHandler(e, n)
            })
        }, t.fn.triggerHandler = function(e, i) {
            var r, o;
            return this.each(function(a, s) {
                r = l(m(e) ? t.Event(e) : e), r._args = i, r.target = s, t.each(n(s, e.type || e), function(t, e) {
                    return o = e.proxy(r), r.isImmediatePropagationStopped() ? !1 : f
                })
            }), o
        }, "focusin focusout focus blur load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select keydown keypress keyup error".split(" ").forEach(function(e) {
            t.fn[e] = function(t) {
                return 0 in arguments ? this.bind(e, t) : this.trigger(e)
            }
        }), t.Event = function(t, e) {
            m(t) || (e = t, t = e.type);
            var n = document.createEvent(g[t] || "Events"),
                i = !0;
            if (e)
                for (var r in e) "bubbles" == r ? i = !!e[r] : n[r] = e[r];
            return n.initEvent(t, i, !0), c(n)
        }
    }(Zepto),
    function(t) {
        t.fn.serializeArray = function() {
            var e, n, i = [],
                r = function(t) {
                    return t.forEach ? t.forEach(r) : (i.push({
                        name: e,
                        value: t
                    }), void 0)
                };
            return this[0] && t.each(this[0].elements, function(i, o) {
                n = o.type, e = o.name, e && "fieldset" != o.nodeName.toLowerCase() && !o.disabled && "submit" != n && "reset" != n && "button" != n && "file" != n && ("radio" != n && "checkbox" != n || o.checked) && r(t(o).val())
            }), i
        }, t.fn.serialize = function() {
            var t = [];
            return this.serializeArray().forEach(function(e) {
                t.push(encodeURIComponent(e.name) + "=" + encodeURIComponent(e.value))
            }), t.join("&")
        }, t.fn.submit = function(e) {
            if (0 in arguments) this.bind("submit", e);
            else if (this.length) {
                var n = t.Event("submit");
                this.eq(0).trigger(n), n.isDefaultPrevented() || this.get(0).submit()
            }
            return this
        }
    }(Zepto),
    function(t, e) {
        function n(t) {
            return t.replace(/([a-z])([A-Z])/, "$1-$2").toLowerCase()
        }

        function i(t) {
            return r ? r + t : t.toLowerCase()
        }
        var r, o, a, s, u, c, l, f, h, p, d = "",
            m = {
                Webkit: "webkit",
                Moz: "",
                O: "o"
            },
            v = window.document,
            g = v.createElement("div"),
            y = /^((translate|rotate|scale)(X|Y|Z|3d)?|matrix(3d)?|perspective|skew(X|Y)?)$/i,
            b = {};
        t.each(m, function(t, n) {
            return g.style[t + "TransitionProperty"] !== e ? (d = "-" + t.toLowerCase() + "-", r = n, !1) : e
        }), o = d + "transform", b[a = d + "transition-property"] = b[s = d + "transition-duration"] = b[c = d + "transition-delay"] = b[u = d + "transition-timing-function"] = b[l = d + "animation-name"] = b[f = d + "animation-duration"] = b[p = d + "animation-delay"] = b[h = d + "animation-timing-function"] = "", t.fx = {
            off: r === e && g.style.transitionProperty === e,
            speeds: {
                _default: 400,
                fast: 200,
                slow: 600
            },
            cssPrefix: d,
            transitionEnd: i("TransitionEnd"),
            animationEnd: i("AnimationEnd")
        }, t.fn.animate = function(n, i, r, o, a) {
            return t.isFunction(i) && (o = i, r = e, i = e), t.isFunction(r) && (o = r, r = e), t.isPlainObject(i) && (r = i.easing, o = i.complete, a = i.delay, i = i.duration), i && (i = ("number" == typeof i ? i : t.fx.speeds[i] || t.fx.speeds._default) / 1e3), a && (a = parseFloat(a) / 1e3), this.anim(n, i, r, o, a)
        }, t.fn.anim = function(i, r, d, m, v) {
            var g, w, x, E = {},
                T = "",
                j = this,
                C = t.fx.transitionEnd,
                S = !1;
            if (r === e && (r = t.fx.speeds._default / 1e3), v === e && (v = 0), t.fx.off && (r = 0), "string" == typeof i) E[l] = i, E[f] = r + "s", E[p] = v + "s", E[h] = d || "linear", C = t.fx.animationEnd;
            else {
                w = [];
                for (g in i) y.test(g) ? T += g + "(" + i[g] + ") " : (E[g] = i[g], w.push(n(g)));
                T && (E[o] = T, w.push(o)), r > 0 && "object" == typeof i && (E[a] = w.join(", "), E[s] = r + "s", E[c] = v + "s", E[u] = d || "linear")
            }
            return x = function(n) {
                if (n !== e) {
                    if (n.target !== n.currentTarget) return;
                    t(n.target).unbind(C, x)
                } else t(this).unbind(C, x);
                S = !0, t(this).css(b), m && m.call(this)
            }, r > 0 && (this.bind(C, x), setTimeout(function() {
                S || x.call(j)
            }, 1e3 * (r + v) + 25)), this.size() && this.get(0).clientLeft, this.css(E), 0 >= r && setTimeout(function() {
                j.each(function() {
                    x.call(this)
                })
            }, 0), this
        }, g = null
    }(Zepto),
    function(t, e) {
        function n(n, i, r, o, a) {
            "function" != typeof i || a || (a = i, i = e);
            var s = {
                opacity: r
            };
            return o && (s.scale = o, n.css(t.fx.cssPrefix + "transform-origin", "0 0")), n.animate(s, i, null, a)
        }

        function i(e, i, r, o) {
            return n(e, i, 0, r, function() {
                a.call(t(this)), o && o.call(this)
            })
        }
        var r = window.document,
            o = (r.documentElement, t.fn.show),
            a = t.fn.hide,
            s = t.fn.toggle;
        t.fn.show = function(t, i) {
            return o.call(this), t === e ? t = 0 : this.css("opacity", 0), n(this, t, 1, "1,1", i)
        }, t.fn.hide = function(t, n) {
            return t === e ? a.call(this) : i(this, t, "0,0", n)
        }, t.fn.toggle = function(n, i) {
            return n === e || "boolean" == typeof n ? s.call(this, n) : this.each(function() {
                var e = t(this);
                e["none" == e.css("display") ? "show" : "hide"](n, i)
            })
        }, t.fn.fadeTo = function(t, e, i) {
            return n(this, t, e, null, i)
        }, t.fn.fadeIn = function(t, e) {
            var n = this.css("opacity");
            return n > 0 ? this.css("opacity", 0) : n = 1, o.call(this).fadeTo(t, n, e)
        }, t.fn.fadeOut = function(t, e) {
            return i(this, t, null, e)
        }, t.fn.fadeToggle = function(e, n) {
            return this.each(function() {
                var i = t(this);
                i[0 == i.css("opacity") || "none" == i.css("display") ? "fadeIn" : "fadeOut"](e, n)
            })
        }
    }(Zepto),
    function(t) {
        function e(t) {
            return "tagName" in t ? t : t.parentNode
        }
        if (t.os.ios) {
            var n, i = {};
            t(document).bind("gesturestart", function(t) {
                var r = Date.now();
                r - (i.last || r), i.target = e(t.target), n && clearTimeout(n), i.e1 = t.scale, i.last = r
            }).bind("gesturechange", function(t) {
                i.e2 = t.scale
            }).bind("gestureend", function() {
                i.e2 > 0 ? (0 != Math.abs(i.e1 - i.e2) && t(i.target).trigger("pinch") && t(i.target).trigger("pinch" + (i.e1 - i.e2 > 0 ? "In" : "Out")), i.e1 = i.e2 = i.last = 0) : "last" in i && (i = {})
            }), ["pinch", "pinchIn", "pinchOut"].forEach(function(e) {
                t.fn[e] = function(t) {
                    return this.bind(e, t)
                }
            })
        }
    }(Zepto),
    function() {
        try {
            getComputedStyle(void 0)
        } catch (t) {
            var e = getComputedStyle;
            window.getComputedStyle = function(t) {
                try {
                    return e(t)
                } catch (n) {
                    return null
                }
            }
        }
    }(),
    function(t) {
        String.prototype.trim === t && (String.prototype.trim = function() {
            return this.replace(/^\s+|\s+$/g, "")
        }), Array.prototype.reduce === t && (Array.prototype.reduce = function(e) {
            if (this === void 0 || null === this) throw new TypeError;
            var n, i = Object(this),
                r = i.length >>> 0,
                o = 0;
            if ("function" != typeof e) throw new TypeError;
            if (0 == r && 1 == arguments.length) throw new TypeError;
            if (arguments.length >= 2) n = arguments[1];
            else
                for (;;) {
                    if (o in i) {
                        n = i[o++];
                        break
                    }
                    if (++o >= r) throw new TypeError
                }
            for (; r > o;) o in i && (n = e.call(t, n, i[o], o, i)), o++;
            return n
        })
    }(),
    function(t) {
        function e(e) {
            return e = t(e), !(!e.width() && !e.height()) && "none" !== e.css("display")
        }

        function n(t, e) {
            t = t.replace(/=#\]/g, '="#"]');
            var n, i, r = s.exec(t);
            if (r && r[2] in a && (n = a[r[2]], i = r[3], t = r[1], i)) {
                var o = Number(i);
                i = isNaN(o) ? i.replace(/^["']|["']$/g, "") : o
            }
            return e(t, n, i)
        }
        var i = t.zepto,
            r = i.qsa,
            o = i.matches,
            a = t.expr[":"] = {
                visible: function() {
                    return e(this) ? this : void 0
                },
                hidden: function() {
                    return e(this) ? void 0 : this
                },
                selected: function() {
                    return this.selected ? this : void 0
                },
                checked: function() {
                    return this.checked ? this : void 0
                },
                parent: function() {
                    return this.parentNode
                },
                first: function(t) {
                    return 0 === t ? this : void 0
                },
                last: function(t, e) {
                    return t === e.length - 1 ? this : void 0
                },
                eq: function(t, e, n) {
                    return t === n ? this : void 0
                },
                contains: function(e, n, i) {
                    return t(this).text().indexOf(i) > -1 ? this : void 0
                },
                has: function(t, e, n) {
                    return i.qsa(this, n).length ? this : void 0
                }
            },
            s = RegExp("(.*):(\\w+)(?:\\(([^)]+)\\))?$\\s*"),
            u = /^\s*>/,
            c = "Zepto" + +new Date;
        i.qsa = function(e, o) {
            return n(o, function(n, a, s) {
                try {
                    var l;
                    !n && a ? n = "*" : u.test(n) && (l = t(e).addClass(c), n = "." + c + " " + n);
                    var f = r(e, n)
                } catch (h) {
                    throw console.error("error performing selector: %o", o), h
                } finally {
                    l && l.removeClass(c)
                }
                return a ? i.uniq(t.map(f, function(t, e) {
                    return a.call(t, e, f, s)
                })) : f
            })
        }, i.matches = function(t, e) {
            return n(e, function(e, n, i) {
                return !(e && !o(t, e) || n && n.call(t, null, i) !== t)
            })
        }
    }(Zepto),
    function(t) {
        t.fn.end = function() {
            return this.prevObject || t()
        }, t.fn.andSelf = function() {
            return this.add(this.prevObject || t())
        }, "filter,add,not,eq,first,last,find,closest,parents,parent,children,siblings".split(",").forEach(function(e) {
            var n = t.fn[e];
            t.fn[e] = function() {
                var t = n.apply(this, arguments);
                return t.prevObject = this, t
            }
        })
    }(Zepto);
(function(a) {
    a.extend(a.fn, {
        cookie: function(b, c, d) {
            var e, f, g, h;
            if (arguments.length > 1 && String(c) !== "[object Object]") {
                d = a.extend({}, d);
                if (c === null || c === undefined) d.expires = -1;
                return typeof d.expires == "number" && (e = d.expires * 24 * 60 * 60 * 1e3, f = d.expires = new Date, f.setTime(f.getTime() + e)), c = String(c), document.cookie = [encodeURIComponent(b), "=", d.raw ? c : encodeURIComponent(c), d.expires ? "; expires=" + d.expires.toUTCString() : "", d.path ? "; path=" + d.path : "", d.domain ? "; domain=" + d.domain : "", d.secure ? "; secure" : ""].join("")
            }
            return d = c || {}, h = d.raw ? function(a) {
                return a
            } : decodeURIComponent, (g = new RegExp("(?:^|; )" + encodeURIComponent(b) + "=([^;]*)").exec(document.cookie)) ? h(g[1]) : null
        }
    })
})(Zepto);
(function() {
    "use strict";

    function FastClick(layer, options) {
        var oldOnClick;
        options = options || {};
        this.trackingClick = false;
        this.trackingClickStart = 0;
        this.targetElement = null;
        this.touchStartX = 0;
        this.touchStartY = 0;
        this.lastTouchIdentifier = 0;
        this.touchBoundary = options.touchBoundary || 10;
        this.layer = layer;
        this.tapDelay = options.tapDelay || 200;
        this.tapTimeout = options.tapTimeout || 700;
        if (FastClick.notNeeded(layer)) {
            return
        }

        function bind(method, context) {
            return function() {
                return method.apply(context, arguments)
            }
        }
        var methods = ["onMouse", "onClick", "onTouchStart", "onTouchMove", "onTouchEnd", "onTouchCancel"];
        var context = this;
        for (var i = 0, l = methods.length; i < l; i++) {
            context[methods[i]] = bind(context[methods[i]], context)
        }
        if (deviceIsAndroid) {
            layer.addEventListener("mouseover", this.onMouse, true);
            layer.addEventListener("mousedown", this.onMouse, true);
            layer.addEventListener("mouseup", this.onMouse, true)
        }
        layer.addEventListener("click", this.onClick, true);
        layer.addEventListener("touchstart", this.onTouchStart, false);
        layer.addEventListener("touchmove", this.onTouchMove, false);
        layer.addEventListener("touchend", this.onTouchEnd, false);
        layer.addEventListener("touchcancel", this.onTouchCancel, false);
        if (!Event.prototype.stopImmediatePropagation) {
            layer.removeEventListener = function(type, callback, capture) {
                var rmv = Node.prototype.removeEventListener;
                if (type === "click") {
                    rmv.call(layer, type, callback.hijacked || callback, capture)
                } else {
                    rmv.call(layer, type, callback, capture)
                }
            };
            layer.addEventListener = function(type, callback, capture) {
                var adv = Node.prototype.addEventListener;
                if (type === "click") {
                    adv.call(layer, type, callback.hijacked || (callback.hijacked = function(event) {
                        if (!event.propagationStopped) {
                            callback(event)
                        }
                    }), capture)
                } else {
                    adv.call(layer, type, callback, capture)
                }
            }
        }
        if (typeof layer.onclick === "function") {
            oldOnClick = layer.onclick;
            layer.addEventListener("click", function(event) {
                oldOnClick(event)
            }, false);
            layer.onclick = null
        }
    }
    var deviceIsWindowsPhone = navigator.userAgent.indexOf("Windows Phone") >= 0;
    var deviceIsAndroid = navigator.userAgent.indexOf("Android") > 0 && !deviceIsWindowsPhone;
    var deviceIsIOS = /iP(ad|hone|od)/.test(navigator.userAgent) && !deviceIsWindowsPhone;
    var deviceIsIOS4 = deviceIsIOS && /OS 4_\d(_\d)?/.test(navigator.userAgent);
    var deviceIsIOSWithBadTarget = deviceIsIOS && /OS [6-7]_\d/.test(navigator.userAgent);
    var deviceIsBlackBerry10 = navigator.userAgent.indexOf("BB10") > 0;
    FastClick.prototype.needsClick = function(target) {
        switch (target.nodeName.toLowerCase()) {
            case "button":
            case "select":
            case "textarea":
                if (target.disabled) {
                    return true
                }
                break;
            case "input":
                if (deviceIsIOS && target.type === "file" || target.disabled) {
                    return true
                }
                break;
            case "label":
            case "iframe":
            case "video":
                return true
        }
        return /\bneedsclick\b/.test(target.className)
    };
    FastClick.prototype.needsFocus = function(target) {
        switch (target.nodeName.toLowerCase()) {
            case "textarea":
                return true;
            case "select":
                return !deviceIsAndroid;
            case "input":
                switch (target.type) {
                    case "button":
                    case "checkbox":
                    case "file":
                    case "image":
                    case "radio":
                    case "submit":
                        return false
                }
                return !target.disabled && !target.readOnly;
            default:
                return /\bneedsfocus\b/.test(target.className)
        }
    };
    FastClick.prototype.sendClick = function(targetElement, event) {
        var clickEvent, touch;
        if (document.activeElement && document.activeElement !== targetElement) {
            document.activeElement.blur()
        }
        touch = event.changedTouches[0];
        clickEvent = document.createEvent("MouseEvents");
        clickEvent.initMouseEvent(this.determineEventType(targetElement), true, true, window, 1, touch.screenX, touch.screenY, touch.clientX, touch.clientY, false, false, false, false, 0, null);
        clickEvent.forwardedTouchEvent = true;
        targetElement.dispatchEvent(clickEvent)
    };
    FastClick.prototype.determineEventType = function(targetElement) {
        if (deviceIsAndroid && targetElement.tagName.toLowerCase() === "select") {
            return "mousedown"
        }
        return "click"
    };
    FastClick.prototype.focus = function(targetElement) {
        var length;
        if (deviceIsIOS && targetElement.setSelectionRange && targetElement.type.indexOf("date") !== 0 && targetElement.type !== "time" && targetElement.type !== "month") {
            length = targetElement.value.length;
            targetElement.setSelectionRange(length, length)
        } else {
            targetElement.focus()
        }
    };
    FastClick.prototype.updateScrollParent = function(targetElement) {
        var scrollParent, parentElement;
        scrollParent = targetElement.fastClickScrollParent;
        if (!scrollParent || !scrollParent.contains(targetElement)) {
            parentElement = targetElement;
            do {
                if (parentElement.scrollHeight > parentElement.offsetHeight) {
                    scrollParent = parentElement;
                    targetElement.fastClickScrollParent = parentElement;
                    break
                }
                parentElement = parentElement.parentElement
            } while (parentElement)
        }
        if (scrollParent) {
            scrollParent.fastClickLastScrollTop = scrollParent.scrollTop
        }
    };
    FastClick.prototype.getTargetElementFromEventTarget = function(eventTarget) {
        if (eventTarget.nodeType === Node.TEXT_NODE) {
            return eventTarget.parentNode
        }
        return eventTarget
    };
    FastClick.prototype.onTouchStart = function(event) {
        var targetElement, touch, selection;
        if (event.targetTouches.length > 1) {
            return true
        }
        targetElement = this.getTargetElementFromEventTarget(event.target);
        touch = event.targetTouches[0];
        if (deviceIsIOS) {
            selection = window.getSelection();
            if (selection.rangeCount && !selection.isCollapsed) {
                return true
            }
            if (!deviceIsIOS4) {
                if (touch.identifier && touch.identifier === this.lastTouchIdentifier) {
                    event.preventDefault();
                    return false
                }
                this.lastTouchIdentifier = touch.identifier;
                this.updateScrollParent(targetElement)
            }
        }
        this.trackingClick = true;
        this.trackingClickStart = event.timeStamp;
        this.targetElement = targetElement;
        this.touchStartX = touch.pageX;
        this.touchStartY = touch.pageY;
        if (event.timeStamp - this.lastClickTime < this.tapDelay) {
            event.preventDefault()
        }
        return true
    };
    FastClick.prototype.touchHasMoved = function(event) {
        var touch = event.changedTouches[0],
            boundary = this.touchBoundary;
        if (Math.abs(touch.pageX - this.touchStartX) > boundary || Math.abs(touch.pageY - this.touchStartY) > boundary) {
            return true
        }
        return false
    };
    FastClick.prototype.onTouchMove = function(event) {
        if (!this.trackingClick) {
            return true
        }
        if (this.targetElement !== this.getTargetElementFromEventTarget(event.target) || this.touchHasMoved(event)) {
            this.trackingClick = false;
            this.targetElement = null
        }
        return true
    };
    FastClick.prototype.findControl = function(labelElement) {
        if (labelElement.control !== undefined) {
            return labelElement.control
        }
        if (labelElement.htmlFor) {
            return document.getElementById(labelElement.htmlFor)
        }
        return labelElement.querySelector("button, input:not([type=hidden]), keygen, meter, output, progress, select, textarea")
    };
    FastClick.prototype.onTouchEnd = function(event) {
        var forElement, trackingClickStart, targetTagName, scrollParent, touch, targetElement = this.targetElement;
        if (!this.trackingClick) {
            return true
        }
        if (event.timeStamp - this.lastClickTime < this.tapDelay) {
            this.cancelNextClick = true;
            return true
        }
        if (event.timeStamp - this.trackingClickStart > this.tapTimeout) {
            return true
        }
        this.cancelNextClick = false;
        this.lastClickTime = event.timeStamp;
        trackingClickStart = this.trackingClickStart;
        this.trackingClick = false;
        this.trackingClickStart = 0;
        if (deviceIsIOSWithBadTarget) {
            touch = event.changedTouches[0];
            targetElement = document.elementFromPoint(touch.pageX - window.pageXOffset, touch.pageY - window.pageYOffset) || targetElement;
            targetElement.fastClickScrollParent = this.targetElement.fastClickScrollParent
        }
        targetTagName = targetElement.tagName.toLowerCase();
        if (targetTagName === "label") {
            forElement = this.findControl(targetElement);
            if (forElement) {
                this.focus(targetElement);
                if (deviceIsAndroid) {
                    return false
                }
                targetElement = forElement
            }
        } else if (this.needsFocus(targetElement)) {
            if (event.timeStamp - trackingClickStart > 100 || deviceIsIOS && window.top !== window && targetTagName === "input") {
                this.targetElement = null;
                return false
            }
            this.focus(targetElement);
            this.sendClick(targetElement, event);
            if (!deviceIsIOS || targetTagName !== "select") {
                this.targetElement = null;
                event.preventDefault()
            }
            return false
        }
        if (deviceIsIOS && !deviceIsIOS4) {
            scrollParent = targetElement.fastClickScrollParent;
            if (scrollParent && scrollParent.fastClickLastScrollTop !== scrollParent.scrollTop) {
                return true
            }
        }
        if (!this.needsClick(targetElement)) {
            event.preventDefault();
            this.sendClick(targetElement, event)
        }
        return false
    };
    FastClick.prototype.onTouchCancel = function() {
        this.trackingClick = false;
        this.targetElement = null
    };
    FastClick.prototype.onMouse = function(event) {
        if (!this.targetElement) {
            return true
        }
        if (event.forwardedTouchEvent) {
            return true
        }
        if (!event.cancelable) {
            return true
        }
        if (!this.needsClick(this.targetElement) || this.cancelNextClick) {
            if (event.stopImmediatePropagation) {
                event.stopImmediatePropagation()
            } else {
                event.propagationStopped = true
            }
            event.stopPropagation();
            event.preventDefault();
            return false
        }
        return true
    };
    FastClick.prototype.onClick = function(event) {
        var permitted;
        if (this.trackingClick) {
            this.targetElement = null;
            this.trackingClick = false;
            return true
        }
        if (event.target.type === "submit" && event.detail === 0) {
            return true
        }
        permitted = this.onMouse(event);
        if (!permitted) {
            this.targetElement = null
        }
        return permitted
    };
    FastClick.prototype.destroy = function() {
        var layer = this.layer;
        if (deviceIsAndroid) {
            layer.removeEventListener("mouseover", this.onMouse, true);
            layer.removeEventListener("mousedown", this.onMouse, true);
            layer.removeEventListener("mouseup", this.onMouse, true)
        }
        layer.removeEventListener("click", this.onClick, true);
        layer.removeEventListener("touchstart", this.onTouchStart, false);
        layer.removeEventListener("touchmove", this.onTouchMove, false);
        layer.removeEventListener("touchend", this.onTouchEnd, false);
        layer.removeEventListener("touchcancel", this.onTouchCancel, false)
    };
    FastClick.notNeeded = function(layer) {
        var metaViewport;
        var chromeVersion;
        var blackberryVersion;
        var firefoxVersion;
        if (typeof window.ontouchstart === "undefined") {
            return true
        }
        chromeVersion = +(/Chrome\/([0-9]+)/.exec(navigator.userAgent) || [, 0])[1];
        if (chromeVersion) {
            if (deviceIsAndroid) {
                metaViewport = document.querySelector("meta[name=viewport]");
                if (metaViewport) {
                    if (metaViewport.content.indexOf("user-scalable=no") !== -1) {
                        return true
                    }
                    if (chromeVersion > 31 && document.documentElement.scrollWidth <= window.outerWidth) {
                        return true
                    }
                }
            } else {
                return true
            }
        }
        if (deviceIsBlackBerry10) {
            blackberryVersion = navigator.userAgent.match(/Version\/([0-9]*)\.([0-9]*)/);
            if (blackberryVersion[1] >= 10 && blackberryVersion[2] >= 3) {
                metaViewport = document.querySelector("meta[name=viewport]");
                if (metaViewport) {
                    if (metaViewport.content.indexOf("user-scalable=no") !== -1) {
                        return true
                    }
                    if (document.documentElement.scrollWidth <= window.outerWidth) {
                        return true
                    }
                }
            }
        }
        if (layer.style.msTouchAction === "none" || layer.style.touchAction === "manipulation") {
            return true
        }
        firefoxVersion = +(/Firefox\/([0-9]+)/.exec(navigator.userAgent) || [, 0])[1];
        if (firefoxVersion >= 27) {
            metaViewport = document.querySelector("meta[name=viewport]");
            if (metaViewport && (metaViewport.content.indexOf("user-scalable=no") !== -1 || document.documentElement.scrollWidth <= window.outerWidth)) {
                return true
            }
        }
        if (layer.style.touchAction === "none" || layer.style.touchAction === "manipulation") {
            return true
        }
        return false
    };
    FastClick.attach = function(layer, options) {
        return new FastClick(layer, options)
    };
    if (typeof define === "function" && typeof define.amd === "object" && define.amd) {
        define(function() {
            return FastClick
        })
    } else if (typeof module !== "undefined" && module.exports) {
        module.exports = FastClick.attach;
        module.exports.FastClick = FastClick
    } else {
        window.FastClick = FastClick
    }
    $(function() {
        FastClick.attach(document.body)
    })
})();