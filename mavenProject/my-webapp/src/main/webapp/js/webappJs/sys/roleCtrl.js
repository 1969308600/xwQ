/**
 * 
 */
define([ 'app' ], function(app) {
	app.controller('roleCtrl', [ '$scope', function($scope) {
		$scope.column = [ // 列
			{
				field : "ID",
				width : 100
			}, {
				field : "Name",
				width : 100
			}, {
				field : "meo",
				width : 100
			},{
				field : "op",
				width : 100
			}  ];

		$scope.Page = {
			page : 0,//mabatis查询所需临时变量
			limit : 15,//mabatis查询所需临时变量
		};//分页参数

		$scope.dataList = []// 数据
		
		//权限关联
		$scope.currChoiceMenu = 0;
		$scope.currChoiceMenuName = "";
		$scope.menuBtn = {};
		
		$scope.getRoleList=function(){
			$.post("../system/getRoleList.do", JSON.stringify( $scope.Page) , function(res) {
				  $scope.dataList = res.data;
				  $scope.$digest();
			}); 
		 
		}
		
		$scope.initMethoed = function(getRoleList){
			getRoleList();//获取列表数据
		}
		
		$scope.initMethoed($scope.getRoleList);
	 
		 
		$scope.roleAdd = function() {
			$('body').append($("#roleAdd"));// layui 说的不加在body外面要出问题
			var index = layer.open({
				title : "我擦嘞！",
				type : 1,
				area : [ '510px', '350px' ],
				content : $('#roleAdd'),
				cancel : function() { // 右上角关闭回调

				}
			});
			//验证
			layui.use('form', function() {
				var form = layui.form;
				//监听提交
				form.on('submit(formRole)', function(data) {
					$.post("../system/insertRole.do", JSON
							.stringify($scope.roleInfo), function(res) {
						if(res.success==1){
							$scope.getRoleList();
							layer.close(index);// 不会自动关闭，所以调用一次
						}else{
							alert("500");
						}
					});
				});
			});
		}
		
		$scope.roleUpdate = function(v) {
			$scope.roleInfo = v;
			$('body').append($("#roleAdd"));// layui 说的不加在body外面要出问题
			var index = layer.open({
				title : "我擦嘞！",
				type : 1,
				area : [ '510px', '350px' ],
				content : $('#roleAdd'),
				cancel : function() { // 右上角关闭回调
					
				}
			});
			//验证
			//监听提交
			layui.form.on('submit(formRole)', function(data) {
				$.post("../system/updateRole.do", JSON
						.stringify($scope.roleInfo), function(res) {
					if(res.success==1){
						$scope.getRoleList();
						layer.close(index);// 不会自动关闭，所以调用一次
					}else{
						alert("500");
					}
				});
			});
		}
		
		$scope.roleRelation = function(role) {
			
			$('body').append($("#roleRelation"));// layui 说的不加在body外面要出问题
			var index = layer.open({
				title : "我擦嘞！",
				type : 1,
				area : [ '610px', '500px' ],
				content : $('#roleRelation'),
				cancel : function() { // 右上角关闭回调
					
				}
			});
			//菜单 $scope.menuBtn 赋值
			$scope.getMenusBtns=function(){
				$scope.menuBtn={id1:[1,2,4],id12:[1,3]};
				//初始化进来默认选中第一个 的btns
				var t=0;
				for(v in $scope.menuBtn){
					if(t==1)break;
					showBtn(v.substring(2,v.length));
					t++;
				}
			}
			
			//设置 树
			var treeArr = [];
			$scope.menus.forEach(function(v) {
				if (v.level == 1) {
					if (v.id == 1) {
						v.spread = true //展开
					}
					treeArr.push(v);
				}
			});
			var treeList = $scope.getTreeArr(treeArr, $scope.menus);
			 
			//自定义树形option{elem:"",list:{children:{}} }
			var createTree =  function(option){
				var list = option.list;
				var divTree = document.createElement("div");
				divTree.className = "layui-tree";
				
				if(list.length>0){
					list.forEach(function(v){
						var tempHtml = createHtml(v,v.children);
						divTree.append(tempHtml);
					});
				} 
				var elm = document.getElementById(option.elem);
				elm.innerHTML = ""; //清空元素
				elm.append(divTree);
			}
			var createHtml = function(obj,child){
				var html;
				if(child.length>0){ 
					html = create(obj,false,true);
					var ul = document.createElement("ul");
					child.forEach(function(v){
						var temp = create(v,true,false);//现在只有两级
						ul.append(temp);
					});
					html.append(ul);
				}else{
					html = create(obj,false,false);
				}
				return html;
			}
			var spreadIcon = ["&#xe625;","&#xe623;"];
			var i0 ;
			var create = function(v,ischild,hasChild){
				var html = document.createElement("li");
				//1 
				var input = window.document.createElement("input")
				input.type="checkbox";
				input.setAttribute("lay-skin","primary");
				input.setAttribute("lay-filter","menu_filter");
				input.value = v.id;
				//2
				i0 = document.createElement("i");
				i0.className="layui-icon layui-tree-spread";
				i0.style="float: right";
				i0.innerHTML =  spreadIcon[1];
				//3
				var i = document.createElement("i");
				i.className="layui-icon layui-tree-"+ischild?'leaf':'branch';
				//3.1
				var i2 = document.createElement("i");
				i2.className="layui-icon layui-tree-leaf";
				i2.innerHTML = v.icon;
				i.append(i2);
				//4
				var cite = document.createElement("cite");
				cite.innerHTML= v.name;
				
				
				var div = document.createElement("div");
				div.id= "divFormenutree";
				div.style = "display:inline";
				
				hasChild ? div.append(i0) : "";
				div.append(i);
				div.append(cite);
				
				html.append(input);
				html.append(div);
				
				//给自定义tree 下的li添加事件
				div.onclick = function(event){
					var currInput =this.parentElement.getElementsByTagName("input")[0];
					showBtn(currInput.value);
					
					
					$scope.currChoiceMenuName = this.getElementsByTagName("cite")[0].innerHTML;
					$scope.$digest();
					
					 
					if(!( this.nextElementSibling))return;
					var dis = this.nextElementSibling.getAttribute("style");
					function ex(taht){
						taht.nextElementSibling.style = "display:inline"
						taht.getElementsByTagName("i")[0].innerHTML =  spreadIcon[0];
					}
					function uex(taht){
						taht.nextElementSibling.style = "display:none";
						taht.getElementsByTagName("i")[0].innerHTML =  spreadIcon[1];
							
					}
					if(this.nextElementSibling.nodeName == "UL")
					dis=="display: inline;"?uex(this):ex(this);
					
					
				}
				
				return html;
			}
		
			 
			layui.form.on("checkbox(menu_filter)",function(data){
				 
				var ul = data.elem.parentElement.lastElementChild;
				if(ul.nodeName == "UL"){
					var boxes = ul.getElementsByClassName("layui-form-checkbox");
					for(var i=0;i<boxes.length;i++){
						debugger;
						boxes[i].click();
						
					} 
				} 
				$scope.currChoiceMenuName = this.parentElement.getElementsByTagName("cite")[0].innerHTML;
				$scope.$digest();
				showBtn(this.value);
			});
			//点击菜单出现相应btn
			var showBtn = function(menuId){
				debugger
				$scope.currChoiceMenu = menuId;//赋值当前选中的菜单
				//反选btn
				var btns = eval("$scope.menuBtn.id"+menuId) ;
				var menuBtn = $('.menuBtn');
				for(v in menuBtn){//清除
					menuBtn[v].checked=false;
				}
				$('#menuBtn .layui-form-checked').prop("class","layui-unselect layui-form-checkbox");//清除
				for(v in btns){
					var btn = $(".menuBtn[value="+btns[v]+"]");
					btn.next().click();
				}
			}
			
			var checkBtn =function(input){
				//获取选中的btn
				var btns = "";
				for(var i=0;i<input.length;i++){
					if(input[i].checked){
						btns+=input[i].value+","
					}
				}
				 
				btns = btns.substring(0,btns.length-1)
				eval("$scope.menuBtn.id"+$scope.currChoiceMenu+"=["+btns+"]") 
				
			}
			layui.form.on("submit(formRoleRelation)",function(){
				var load = layer.msg('处理中，请耐心等候...', {icon: 16,shade: [0.4, '#1E9FFF'],scrollbar: false,offset: '100px', time:100000,elem : '.layui-side' }) 
				var temp = $scope.menuBtn;
				for(v in temp){
					var menuId = v.substring(2,v.length);
					var menuBtn = temp[v];
					for(k in menuBtn){
						var btn = menuBtn[k];
						var menuArr = [];
						menuArr.push({id:menuId,btns:[{id:btn}]})
						var postJson = JSON.stringify({menus:menuArr,id:role.id});
						debugger;
						$.post("../system/updateRoleMenuAndBtn.do",postJson,function(res){
							layer.close(index);
							layer.close(load);
						});
					}
					
				}
			
				
			});
			
			layui.form.on("checkbox(btn_filter)",function(data){
				 
				var input = data.elem.parentElement.getElementsByTagName("input");
				if(input.length>0){
					 checkBtn(input);
				}
			});
			
			$scope.getMenusBtns();
			createTree({elem:"menuTreeForRoleForm",list:treeList });
			layui.form.render();//动态加载后 重新渲染
		 
		}
		
	} ])
})