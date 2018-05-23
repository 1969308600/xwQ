///**
// * 
// */ 
define([ 'app', 'layui' ], function(app) {
	app.controller('menuCtrl', function($scope) {
		$scope.column = [ // 列
		{
			field : "ID",
			width : 100
		}, {
			field : "Name",
			width : 100
		}, {
			field : "Code",
			width : 100
		}, {
			field : "UrlKey",
			width : 100
		}, {
			field : "UrlHtml",
			width : 100
		}, {
			field : "UrlCtrl",
			width : 100
		}, {
			field : "Key",
			width : 100
		} ];

		$scope.Page = {
			page : 0,//mabatis查询所需临时变量
			limit : 15,//mabatis查询所需临时变量
			pageLimit:15,
			currPage:1//当前页，变量
		};//分页参数

		$scope.dataList = []// 数据
 
		$scope.getList = function() { 
			$.post("../system/getMenuListPage.do",  $scope.Page , function(v) {
				 
				$scope.data = JSON.parse(v);
				$scope.dataList = $scope.data.data;
				$.post("../system/getMenuCountForList.do",  {} , function(v) {
					$scope.count = v;
					$scope.$digest();
				});
				// $scope.$apply();//root脏检查    需要手动刷新 
			});
		
		}
		var layuiTemp ;
		$scope.$watch("dataList", function(newValue, oldValue) {
			//angular  加载顺序的问题，延迟0.01。  如果数据查询过慢，0.01也是有问题哟，而这个方法又不能直接放在geilist（）里
			
			if (newValue.length > 0&& $scope.Page.currPage==1) { //当前页面为1才去查询数据库
				layuiTemp = layui.use('laypage', function() {//layui 内置分页设置
					var laypage = layui.laypage;
					//执行一个laypage实例
					laypage.render({
						elem : 'layuiPageForTest1', //注意，这里的 test1 是 ID，不用加 # 号
						
						count : $scope.count, //数据总数，从服务端得到
						
						limit : $scope.Page.pageLimit,
						layout : [ 'prev', 'page', 'next', 'limit', 'skip',
								'count' ],
						jump : function(obj, first) {
							//obj包含了当前分页的所有参数，比如：obj.curr  obj.limit
							$scope.Page.limit =   obj.curr *obj.limit;
							$scope.Page.page = (obj.curr-1)*obj.limit;
							 $scope.Page.currPage = obj.curr;
							//首次不执行
							if (!first)
								$scope.getList();
						}
					});
				});
				
			}
		});

		$scope.doUpdate = function() {
			$.post("../webapp/system/save.do", $scope.object, function(v) {
				debugger;
			});
		}
		$scope.doAdd = function() {
			
			 layer.open({
				  type: 2, 
				  content: '../ftl/sys/menuAddForm.html' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
				  ,btn: ['按钮一', '按钮二' ]
				  ,yes: function(index, layero){  //按钮【按钮一】的回调  不会关闭
//					  $.post("../system/save.do", $scope.object, function(v) {
//							debugger;
//							location.reload();
//						});
					  layer.close(index);//不会自动关闭，所以调用一次
				  }
				  ,btn2: function(index, layero){ //按钮【按钮二】的回调    //return false 开启该代码可禁止点击该按钮关闭
				  } 
				  ,cancel: function(){  //右上角关闭回调
				  }
				 });
			
			
		}

		$scope.getList();
	});

 
})
