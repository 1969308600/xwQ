/**
 * 
 */
define([ 'app' ], function(app) {
	app.controller('userCtrl', [ '$scope', function($scope) {
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
				field : "phone",
				width : 100
			}, {
				field : "email",
				width : 100
			}, {
				field : "dpt",
				width : 100
			}, {
				field : "safeKey",
				width : 100
			}, {
				field : "op",
				width : 100
			}  ];

			$scope.Page = {
				page : 0,//mabatis查询所需临时变量
				limit : 15,//mabatis查询所需临时变量
			};//分页参数

		$scope.dataList = []// 数据
		
		$scope.getUserlist=function(){
			$.post("../system/getUserList.do", JSON.stringify( $scope.Page) , function(res) {
					  $scope.dataList = res.data;
					  $scope.$digest();
			}); 
		 
		}
		
		$scope.initMethoed = function(getUserlist){
			getUserlist();//获取列表数据
		}
		
		$scope.initMethoed($scope.getUserlist);
		
		
		
		$scope.relation = function(v){
			alert(v.id)
		}
	 
	} ])
})