/***
 * app。js 主要做了加载静态资源和菜单选项卡的设置，即页面初始化
 * 
 * 此项目用到了  angular 却很少使用它的组件，比如树形列表，就采用了layui的，其实两者都能达到，看个人习惯。这些都可穿插使用，
 * 
 * 
 * @returns
 */

define([ 'angularAMD', 'angular-route', 'angular', 'jquery', 'systemConfigs', 
		'layui' ], function(angularAMD) {
	var app = angular.module('app', [ 'ui.router' ]);

	app.run(function($rootScope, $state, $stateParams) {// 重要
		$rootScope.$state = $state;
		$rootScope.$stateParams = $stateParams;
	});
	app.controller('myAppController', function($scope, $state) {// 系统controller，加载资源（菜单，字典。。）
		$scope.test = "xwQ";
		$scope.currMenuName = "首页";
		$scope.menus = sysMenus;// 设置静态默认值

		//树 部分 数据转换
		$scope.getTreeArr = function(parntArr, hasChildArr) {
			parntArr.forEach(function(v) {
				var childArr = []
				hasChildArr.forEach(function(m) {
					if (!m.href)
						m.href = '#!/' + m.urlKey;
					if (m.level > 1 && m.parent == v.id && m.parent != 0) {
						childArr.push(m);
					}
				});
				v.children = childArr;
			});
			return parntArr;
		}
		
		// 获取系统 菜单  设置选项卡
		$scope.getSysTemMenu = function(callback) {
			 
			$.post("/webapp/system/getMenu.do", {}, function(res) {// 预留角色参数，后期将以角色获取菜单。
				// console.log("menus:"+res);
				$scope.menus =  res.data;//如果静态资源保持高度一致  这句话就是多余的
				
				$scope.$digest();//对于$digest来说，在父作用域和子作用域上调用是有差别的，但是，对于$apply来说，这两者一样。$apply可以带参数，它可以接受一个函数，然后在应用数据之后，调用这个函数。
				
				callback();
				
				// 处理树的部分数据
				var treeArr = [];
				$scope.menus.forEach(function(v) {
					if (v.level == 1) {
						if (v.id == 1) {
							v.spread = true //展开
						}
						treeArr.push(v);
					}
				});
				//设置 树
				layui.use([ 'tree', 'element','form' ], function() {
					layui.tree({
						elem : '#divForTree',// 传入元素选择器 
						nodes : $scope.getTreeArr(treeArr, $scope.menus),
						skin: 'shihuang',
						click : function(node) {//点击菜单 
							//点击菜单   设置 选项卡  切换
							var $ = layui.jquery, element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
							if ($.inArray(node.id, $scope.layIds) == -1&&node.urlKey) {
								$scope.layIds.push(node.id);
								element.tabAdd('demo', {
									title : node.name,
									id : node.id
								});
							}
							element.tabChange('demo', node.id);
						}
					});
				});
			});
			 
		}
		
		function loadMenuBut(){// 加载按钮
		/*	$.post("/webapp/system/getMenuBut.do", {}, function(res) {
				
			});*/
		}
		
		$scope.getSysTemMenu(loadMenuBut);
		
		function nextE(arr,count){
			if(arr[count].urlHtml){
				$scope.currMenuNode= arr[count];
				$scope.layIds.push( arr[count].id);
				return arr[count];
			}else{
				count++;
				nextE(arr,count);
			}
		}
		//默认 选项卡
		$scope.layIds = [];
		layui.use('element', function() {
			var $ = layui.jquery, element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
			var count = 0;
			nextE($scope.menus,count);
			
			element.tabAdd('demo', {
				title : $scope.currMenuNode.name,
				id : $scope.currMenuNode.id
			});//设置默认选项卡
			//设置事件回调
			element.on('tab(demo)', function(elem) {
				$scope.thisMenuId = $(this).attr('lay-id');
				$scope.menus.forEach(function(v) {
					if ($scope.thisMenuId == v.id&&v.urlKey) {
						$scope.$state.go(v.urlKey);
					}
				});
			}); 
			element.tabChange('demo',$scope.currMenuNode.id);
			$scope.$state.go($scope.currMenuNode.urlKey||'dept');//路由跳转
		});

	});

	//路由加载
	var loadtime = function(scope, $stateProvider) {
		//路由加载 的是静态数据    sysMenus是静态值，如不能保持数据库一致要出问题。
		sysMenus.forEach(function(value) {
			if (value.urlKey) {
				$stateProvider.state(value.urlKey, angularAMD.route({
					url : '/' + value.urlKey,
					templateUrl : value.urlHtml,
					controller : value.ctrlKey,
					controllerUrl : value.urlCtrl,
				}))
			}
		});
	}
	// 路由配置
	app.config(function($stateProvider) {
		setTimeout(function() {// 延时加载，因为scope.menus是在appcontroller里获取的，必须要等他先出来再去设置路由，而且不能写在ajax里，
			var scope = angular.element(
					$('html[ng-controller="myAppController"]')).scope();
			loadtime(scope, $stateProvider)
		}, 5); // 方案一：菜单静态化 但是scope无法获取，需要延迟！！！！！！！0.005 劲量最优了
	});

	//angular 的amd加载
	return angularAMD.bootstrap(app);
});