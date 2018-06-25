define(['jquery'], function() {
	//全局的ajax访问，处理ajax清求时sesion超时 
	$.ajaxSetup({
	    contentType : "application/json;charset=utf-8",
	    complete : function(XMLHttpRequest, textStatus) {
	    	if(XMLHttpRequest.status==900){
	    		alert(XMLHttpRequest.responseText);
	    		window.location.replace("http://localhost:8080/webapp/ftl/login.html");
	    	}
	    	 if (XMLHttpRequest.status == 401) {//多余的
	             alert('您好，身份验证已过期，请重新登陆。');
	             //返回首页
	             window.location.href = 'http://localhost:8080/webapp/ftl/login.html';
	         }
	    }
	});	
	
});