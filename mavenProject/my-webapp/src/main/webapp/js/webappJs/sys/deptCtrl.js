/**
 * 
 */
 
define([ 'app','systemConfigs' ], function(app) {
	//操作按钮
	var Templete = '<div class="layui-btn-group">'
			  +'<button  ng-click="deptUpdate(this,{{d.id}})" class="layui-btn layui-btn-sm layui-btn-normal"><i class="layui-icon">&#xe642;</i>修改</button>'
			  +'<button ng-click="deptDelete(this,{{d.id}})" class="layui-btn layui-btn-sm layui-btn-danger"><i class="layui-icon">&#xe640;</i>删除</button>'
	    	/*  +'<button  ng-click="deptDetail(this,{{d.id}})" class="layui-btn layui-btn-sm layui-btn-warm">  <i class="layui-icon">&#xe602;</i></button></div>'*/;
	
	app.controller('deptCtrl', [ '$scope','$compile', function($scope,$compile) {
		 
		layui.use(['element', 'layer', 'form', 'upload', 'treeGrid'], function () {
		        var treeGrid = layui.treeGrid; //很重要
		        var treeTable =treeGrid.render({
		            elem: '#treegrid_test'
		            ,url:'/webapp/system/getDeptList.do'
		            //,data:sysMenus
		            ,cellMinWidth: 100
		            ,$scope:$scope
		            ,$compile:$compile
		            ,treeId:'id'//树形id字段名称
		            ,treeUpId:'parent'//树形父id字段名称
		            ,treeShowName:'name'//以树形式显示的字段
		            ,cols: [[
		                {type:'checkbox'}
		                ,{field:'name', edit:'text',width:'20%', title: '组织名称'}
		                ,{field:'id', edit:'text',width:'15%', title: 'id'}
		                ,{field:'parent', edit:'text',width:'15%', title: '父级id'}
		                ,{field:'sort', edit:'text',width:'15%', title: '排序'}
		                ,{field:'status', edit:'text',width:'15%', title: '状态'}
		                ,{toolbar:Templete, title: '操作'}
		            ]]
		            ,page:false
		        });
		    });
		 
		 $scope.deptDetail=function(v,id){//laytpl没法将对象弄进来？
			 debugger;
			 alert(id);
		 }
	 
		 $scope.deptDelete=function(v,id){//laytpl没法将对象弄进来？
			 debugger;
			 alert(id);
		 }
		 
		 $scope.deptUpdate=function(v,id){//laytpl没法将对象弄进来？
			 debugger;
			 alert(id);
		 }
		 
		 $scope.beforeAdd=function(){
			 layer.open({
			  type: 2, 
			  content: '/webapp/ftl/sys/deptAddForm.html' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
			  ,btn: ['按钮一', '按钮二' ]
			  ,yes: function(index, layero){  //按钮【按钮一】的回调  不会关闭
				  layer.close(index);//不会自动关闭，所以调用一次
			  }
			  ,btn2: function(index, layero){ //按钮【按钮二】的回调    //return false 开启该代码可禁止点击该按钮关闭
			  } 
			  ,cancel: function(){  //右上角关闭回调
			  }
			 });
		 }
		 
			  
	} ])
})