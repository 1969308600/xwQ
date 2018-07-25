/**
 * 
 */
define([ 'app' ], function(app) {
	app.controller('userCtrl', [ '$scope', function($scope,$stateParams) {
		debugger
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
				} ];

				$scope.Page = {
					page : 0,// mabatis查询所需临时变量
					limit : 15,// mabatis查询所需临时变量
				};// 分页参数

				$scope.dataList = []// 数据
				$scope.userInfo = {};// 用户form表单对象

				$scope.getUserlist = function() {
					$.post("../system/getUserList.do", JSON
							.stringify($scope.Page), function(res) {
						$scope.dataList = res.data;
						$scope.$digest();
					});

				}

				$scope.initMethoed = function(getUserlist) {
					getUserlist();// 获取列表数据
				}

				$scope.initMethoed($scope.getUserlist);

				$scope.relation = function(v) {
					layer.open({
						title : "wocalei",
						type : 2,
						content : '../ftl/sys/userRoleRelation.html',
						btn : [ '确定', '取消' ],
						yes : function(index, layero) {
							$scope.getUserlist();
							layer.close(index);
						},
						btn2 : function(index, layero) {
							// layer.close(index);
						},
						cancel : function() {

						}
					});
				}

				$scope.doAdd = function() {
					$('body').append($("#userAdd"));// layui 说的不加在body外面要出问题
					var index = layer.open({
						title : "我擦嘞！",
						type : 1,
						area : [ '510px', '510px' ],
						content : $('#userAdd'),
						cancel : function() { // 右上角关闭回调

						}
					});
					//验证
					layui.use('form', function() {
						var form = layui.form;
						//监听提交
						form.on('submit(formUser)', function(data) {
							$.post("../system/insertUser.do", JSON
									.stringify($scope.userInfo), function(res) {
								if(res.success==1){
									$scope.getUserlist();
									layer.close(index);// 不会自动关闭，所以调用一次
								}else{
									alert("500");
								}
							});
						});
					});
				}
				$scope.userUpdate = function(v) {
					$scope.userInfo = v;
					$('body').append($("#userAdd"));// layui 说的不加在body外面要出问题
					var index = layer.open({
						title : "我擦嘞！",
						type : 1,
						area : [ '510px', '510px' ],
						content : $('#userAdd'),
						cancel : function() { // 右上角关闭回调
							$scope.userInfo={};//取消时清除对象，不然影响新增。
						}
					});
					
					//验证
					layui.use('form', function() {
						var form = layui.form;
						//监听提交
						form.on('submit(formUser)', function(data) {
							$.post("../system/updateUser.do", JSON
									.stringify($scope.userInfo), function(res) {
								if(res.success==1){
									$scope.getUserlist();
									layer.close(index);// 不会自动关闭，所以调用一次
								}else{
									alert("500");
								}
							});
						});
					});
				
				}

			} ])

})