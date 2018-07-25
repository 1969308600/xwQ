
define([ 'app','qiniu' ], function(app,qiniu) {
	
	app.controller('nhCtrl', [ '$scope', function($scope, $state) {
		  
		$scope.title = "Chart Test"
		$scope.page ={
				limit:10,
				page:1
		}
		$scope.column = [ // 列
			{ field : "ID", width : 100 }, 
			{ field : "Name", width : 100 },  
			{ field : "城区", width : 100 },
			{ field : "均价", width : 100 },
			{ field : "开发商", width : 100 },
			{ field : "销售状态", width : 100 },
			{ field : "交房时间", width : 100 },
			{ field : "总栋数", width : 100 },
			{ field : "佣金", width : 100 },
			{ field : "返佣模式", width : 100 },
			{ field : "发布状态", width : 100 },
			{ field : "操作", width : 100 }
		];
		$scope.getSystemDept= function() {
			$.post("/webapp/newHouse/getNewhouseList.do", JSON.stringify($scope.page), function(res) {
				$scope.dataList = res;
				$scope.$digest();
			});
		}
		$scope.detail = function(v){
			this.$state.go("nh_detail",v);
		}
		
		$scope.getSystemDept();
		
		// ========== start 七牛上传   ===========
		var observer = {
			next(res){ },
			error(err){
				var description = "";
				for (var i in err) {
					description += i + " = " + err[i] + "\n";
				}
				alert( description);
			},
			complete(res){
				alert('success');
			}
		}
		var config = {
			useCdnDomain: true,
			region: qiniu.region.z2
		};
		
		var file = undefined;
		$scope.token = '';
		
		$scope.getQiniuToken = function (){
			$.post("/webapp/common/getQiniuToken.do",JSON.stringify({bucket:"public"}),function(res){
				$scope.token = res.result;
			});
		}
		$scope.getQiniuToken();
			
		$scope.bindToFile = function(){
			file = $('#thisFile')[0].files[0];
		}
		$scope.chioceFile = function (e){
			$(e).click();
		}
		$scope.upload = function (){
			var putExtra = {
			fname: file.name,
			params: {},
		};
		var observable = qiniu.upload(file, "newHouse/"+new Date().getTime(), $scope.token, putExtra, config);
		var subscription = observable.subscribe(observer);
		
		}
		//========= end 七牛上传   =========
		
	} ]);
	
	
	

});