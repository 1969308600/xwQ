/**
 * 对于菜单不要在数据库里，这样会影响速度， 现在我要的是让用户觉得菜单是秒出的，这样会给人一种秒出的感觉，其他内容稍后些
 * 
 * 这儿存在一个问题： 菜单静态化了，但是在列表里还是查询的是数据库，如何更新这个sysMenus的问题！
 * 这儿将静态化的值作为默认值，查询后重置这个静态化的值是否解决？
 * 
 * 方案：
 *  页面数据来源于数据库，
 *  路由数据静态化，这样如果不和数据库数据保持一致，也会有bug。
 * 
 */

var sysMenus = [{"code":"code2000","ctrlKey":"","id":1,"key":"","level":1,"name":"系统管理","parent":0,"urlCtrl":"","urlHtml":"","urlKey":"","icon":"&#xe614;"}
,{"code":"code2001","ctrlKey":"","id":2,"key":"","level":1,"name":"你妹","parent":0,"urlCtrl":"","urlHtml":"","urlKey":""},{"code":"code2002","ctrlKey":"","id":3,"key":"","level":1,"name":"商品管理","parent":0,"urlCtrl":"","urlHtml":"","urlKey":""},{"code":"code2003","ctrlKey":"","id":4,"key":"","level":1,"name":"其他管理","parent":0,"urlCtrl":"","urlHtml":"","urlKey":""},{"code":"","ctrlKey":"","id":5,"key":"","level":1,"name":"图形统计","parent":0,"urlCtrl":"","urlHtml":"","urlKey":""},{"code":"","ctrlKey":"","id":11,"key":"","level":1,"name":"首页（锐理）","parent":0,"urlCtrl":"","urlHtml":"","urlKey":""},{"code":"","ctrlKey":"","id":12,"key":"","level":1,"name":"新房管理（锐理）","parent":0,"urlCtrl":"","urlHtml":"","urlKey":""},{"code":"code3000","ctrlKey":"deptCtrl","id":24,"key":"/system/dept","level":2,"name":"部门管理","parent":1,"urlCtrl":"webappJs/sys/deptCtrl","urlHtml":"../ftl/sys/dept.html","urlKey":"dept"},{"code":"code3001","ctrlKey":"roleCtrl","id":25,"key":"/system/role","level":2,"name":"角色管理","parent":1,"urlCtrl":"webappJs/sys/roleCtrl","urlHtml":"../ftl/sys/role.html","urlKey":"role"},{"code":"code3002","ctrlKey":"userCtrl","id":26,"key":"/system/user","level":2,"name":"用户管理","parent":1,"urlCtrl":"webappJs/sys/userCtrl","urlHtml":"../ftl/sys/user.html","urlKey":"user"},{"code":"code3003","ctrlKey":"powerCtrl","id":27,"key":"/system/power","level":2,"name":"权限管理","parent":1,"urlCtrl":"webappJs/sys/powerCtrl","urlHtml":"../ftl/sys/power.html","urlKey":"power"},{"code":"code3004","ctrlKey":"menuCtrl","id":28,"key":"/system/menu","level":2,"name":"菜单管理","parent":1,"urlCtrl":"webappJs/sys/menuCtrl","urlHtml":"../ftl/sys/menu.html","urlKey":"menu"},{"code":"code3005","ctrlKey":"flewCtrl","id":29,"key":"/system/flew","level":2,"name":"流程实列","parent":1,"urlCtrl":"webappJs/sys/flewCtrl","urlHtml":"../ftl/sys/flew.html","urlKey":"flew"},{"code":"code3006","ctrlKey":"ysAnalysisCtrl","id":51,"key":"/analysis/ysAnalysisCtrl","level":2,"name":"楼盘优势分析（锐理）","parent":5,"urlCtrl":"webappJs/analysis/ysAnalysisCtrl","urlHtml":"../ftl/analysis/ysA.html","urlKey":"ysAnalysis"},{"code":"code3007","ctrlKey":"priceAnalysisCtrl","id":52,"key":"/analysis/priceAnalysisCtrl","level":2,"name":"区域价格分析（锐理）","parent":5,"urlCtrl":"webappJs/analysis/priceAnalysisCtrl","urlHtml":"../ftl/analysis/priceA.html","urlKey":"priceAnalysis"},{"code":"","ctrlKey":"","id":221,"key":"","level":2,"name":"来呀来呀来呀","parent":2,"urlCtrl":"","urlHtml":"","urlKey":""},{"code":"","ctrlKey":"","id":222,"key":"","level":2,"name":"来呀来呀来呀2","parent":2,"urlCtrl":"","urlHtml":"","urlKey":""}]
 
 