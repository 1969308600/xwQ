define([ 'angularAMD', 'angular-route', 'angular', 'jquery' ], function(
		angularAMD) {
	var app = angular.module('app', [ 'ui.router' ]);

	app.run(function($rootScope, $state, $stateParams) {//重要
		$rootScope.$state = $state;
		$rootScope.$stateParams = $stateParams;
	});

	app.controller('myAppController', function($scope, $state) {//系统controller，加载资源（菜单，字典。。）
		$scope.test = "xwQ test!";
		$scope.menus = [];
		$scope.thisMenu = 1;//默认系统管理id
		//获取系统  菜单
		$scope.getSysTemMenu = function() {
			$.post("/system/getMenu.do", {}, function(res) {//预留角色参数，后期将以角色获取菜单。
				$scope.menus = JSON.parse(res).data;
				$scope.$digest();

			});
		}
		$scope.getSysTemMenu();

		$scope.choiceMenu = function(id) {//父级菜单选择
			$scope.thisMenu = id;
			//默认跳转子菜单第一个
		}

		$scope.choiceChildMenu = function(id) {

		}
	});
	//路由配置
	app.config(function($stateProvider) {
		
		setTimeout(function() {//延时加载，因为scope.menus是在appcontroller里获取的，必须要等他先出来再去设置路由，而且不能写在ajax里，还没找到解决方案。
			
			var scope = angular.element(
					$('div[ ng-controller="myAppController"]')).scope();
			scope.menus.forEach(function(value) {
				if (value.urlKey) {
					$stateProvider.state(value.urlKey, angularAMD.route({
						url : '/' + value.urlKey,
						templateUrl : value.urlHtml,
						controller : value.ctrlKey,
						controllerUrl : value.urlCtrl,
					}))
				}
			});
			
			scope.$state.go("menu");
		}, 100);
	});
	return angularAMD.bootstrap(app);
});