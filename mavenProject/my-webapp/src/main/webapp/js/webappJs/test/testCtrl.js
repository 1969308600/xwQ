
define([ 'app','qiniu' ], function(app,qiniu) {
	
	app.controller('testCtrl', [ '$scope', function($scope, $state) {
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
				debugger;
				$scope.fileKey = "p59exzcaw.bkt.clouddn.com/"+res.key;
				$scope.$digest();
				//alert('success');
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