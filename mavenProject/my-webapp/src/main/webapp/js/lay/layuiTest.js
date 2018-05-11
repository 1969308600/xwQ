/** layui-v2.2.6 MIT License By https://www.layui.com */
; !
function(e) {
	"use strict";
	var t = document,
	n = {
		modules: {},
		status: {},
		timeout: 10,
		event: {}
	},
	o = function() {
		this.v = "2.2.6"
	},
	r = function() {
		var e = t.currentScript ? t.currentScript.src: function() {
			for (var e, n = t.scripts,
			o = n.length - 1,
			r = o; r > 0; r--) if ("interactive" === n[r].readyState) {
				e = n[r].src;
				break
			}
			return e || n[o].src
		} ();
		return e.substring(0, e.lastIndexOf("/") + 1)
	} (),
	a = function(t) {
		e.console && console.error && console.error("Layui hint: " + t)
	},
	i = "undefined" != typeof opera && "[object Opera]" === opera.toString(),
	u = {
		layer: "modules/layer",
		laydate: "modules/laydate",
		laypage: "modules/laypage",
		laytpl: "modules/laytpl",
		layim: "modules/layim",
		layedit: "modules/layedit",
		form: "modules/form",
		upload: "modules/upload",
		tree: "modules/tree",
		table: "modules/table",
		element: "modules/element",
		util: "modules/util",
		flow: "modules/flow",
		carousel: "modules/carousel",
		code: "modules/code",
		jquery: "modules/jquery",
		mobile: "modules/mobile",
		"layui.all": "../layui.all"
	};
	
	
	o.prototype.cache = n,
	o.prototype.define = function(e, t) {
		var o = this,
		r = "function" == typeof e,
		a = function() {
			var e = function(e, t) {
				layui[e] = t,
				n.status[e] = !0
			};
			return "function" == typeof t && t(function(o, r) {
				e(o, r),
				n.callback[o] = function() {
					t(e)
				}
			}),
			this
		};
		return r && (t = e, e = []),
		layui["layui.all"] || !layui["layui.all"] && layui["layui.mobile"] ? a.call(o) : (o.use(e, a), o)
	},
	o.prototype.use = function(e, o, l) {
		function s(e, t) {
			var o = "PLaySTATION 3" === navigator.platform ? /^complete$/: /^(complete|loaded)$/; ("load" === e.type || o.test((e.currentTarget || e.srcElement).readyState)) && (n.modules[f] = t, d.removeChild(v),
			function r() {
				return++m > 1e3 * n.timeout / 4 ? a(f + " is not a valid module") : void(n.status[f] ? c() : setTimeout(r, 4))
			} ())
		}
		function c() {
			l.push(layui[f]),
			e.length > 1 ? y.use(e.slice(1), o, l) : "function" == typeof o && o.apply(layui, l)
		}
		var y = this,
		p = n.dir = n.dir ? n.dir: r,
		d = t.getElementsByTagName("head")[0];
		e = "string" == typeof e ? [e] : e,
		window.jQuery && jQuery.fn.on && (y.each(e,
		function(t, n) {
			"jquery" === n && e.splice(t, 1)
		}), layui.jquery = layui.$ = jQuery);
		var f = e[0],
		m = 0;
		if (l = l || [], n.host = n.host || (p.match(/\/\/([\s\S]+?)\//) || ["//" + location.host + "/"])[0], 0 === e.length || layui["layui.all"] && u[f] || !layui["layui.all"] && layui["layui.mobile"] && u[f]) return c(),
		y;
		if (n.modules[f]) !
		function g() {
			return++m > 1e3 * n.timeout / 4 ? a(f + " is not a valid module") : void("string" == typeof n.modules[f] && n.status[f] ? c() : setTimeout(g, 4))
		} ();
		else {
			var v = t.createElement("script"),
			h = (u[f] ? p + "lay/": /^\{\/\}/.test(y.modules[f]) ? "": n.base || "") + (y.modules[f] || f) + ".js";
			h = h.replace(/^\{\/\}/, ""),
			v.async = !0,
			v.charset = "utf-8",
			v.src = h +
			function() {
				var e = n.version === !0 ? n.v || (new Date).getTime() : n.version || "";
				return e ? "?v=" + e: ""
			} (),
			d.appendChild(v),
			!v.attachEvent || v.attachEvent.toString && v.attachEvent.toString().indexOf("[native code") < 0 || i ? v.addEventListener("load",
			function(e) {
				s(e, h)
			},
			!1) : v.attachEvent("onreadystatechange",
			function(e) {
				s(e, h)
			}),
			n.modules[f] = h
		}
		return y
	},
	o.prototype.getStyle = function(t, n) {
		var o = t.currentStyle ? t.currentStyle: e.getComputedStyle(t, null);
		return o[o.getPropertyValue ? "getPropertyValue": "getAttribute"](n)
	},
	o.prototype.link = function(e, o, r) {
		var i = this,
		u = t.createElement("link"),
		l = t.getElementsByTagName("head")[0];
		"string" == typeof o && (r = o);
		var s = (r || e).replace(/\.|\//g, ""),
		c = u.id = "layuicss-" + s,
		y = 0;
		return u.rel = "stylesheet",
		u.href = e + (n.debug ? "?v=" + (new Date).getTime() : ""),
		u.media = "all",
		t.getElementById(c) || l.appendChild(u),
		"function" != typeof o ? i: (function p() {
			return++y > 1e3 * n.timeout / 100 ? a(e + " timeout") : void(1989 === parseInt(i.getStyle(t.getElementById(c), "width")) ?
			function() {
				o()
			} () : setTimeout(p, 100))
		} (), i)
	},
	n.callback = {},
	o.prototype.factory = function(e) {
		if (layui[e]) return "function" == typeof n.callback[e] ? n.callback[e] : null
	},
	o.prototype.addcss = function(e, t, o) {
		return layui.link(n.dir + "css/" + e, t, o)
	},
	o.prototype.img = function(e, t, n) {
		var o = new Image;
		return o.src = e,
		o.complete ? t(o) : (o.onload = function() {
			o.onload = null,
			t(o)
		},
		void(o.onerror = function(e) {
			o.onerror = null,
			n(e)
		}))
	},
	o.prototype.config = function(e) {
		e = e || {};
		for (var t in e) n[t] = e[t];
		return this
	},
	o.prototype.modules = function() {
		var e = {};
		for (var t in u) e[t] = u[t];
		return e
	} (),
	o.prototype.extend = function(e) {
		var t = this;
		e = e || {};
		for (var n in e) t[n] || t.modules[n] ? a("模块名 " + n + " 已被占用") : t.modules[n] = e[n];
		return t
	},
	o.prototype.router = function(e) {
		var t = this,
		e = e || location.hash,
		n = {
			path: [],
			search: {},
			hash: (e.match(/[^#](#.*$)/) || [])[1] || ""
		};
	//return ///
	}
}(window);