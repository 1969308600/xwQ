define(['jquery'], function() {
	//全局的ajax访问，处理ajax清求时sesion超时 
	$.ajaxSetup({
	    contentType : "application/json;charset=utf-8",
	    complete : function(XMLHttpRequest, textStatus) {
	    	debugger
	    	if(XMLHttpRequest.status==900){
	    		alert(XMLHttpRequest.responseText);
	    		window.location.replace("http://localhost:8080/webapp/ftl/login.html");
	    	}
	    }
	});	
});