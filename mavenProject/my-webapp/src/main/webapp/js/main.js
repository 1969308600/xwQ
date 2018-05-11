require.config({

	paths : {
		'angular' : 'angular/angular',
		'angular-route' : 'angular/ngRoute/angular-ui-route',
		'angularAMD' : 'angular/angularAMD',
		
		//对于用的多的可以提前引进   echart这种按需加载就行了。
		"layui" : "lay/layui",    
		"jquery" : "jquery/jquery-3.3.1",
		
		
		"app":"app"

	},
	shim : {
		'angularAMD' : [ 'angular' ],
		'angular-route' : [ 'angular' ]
	} ,
	deps : ['app']//启动应用  
});
 