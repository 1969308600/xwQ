define(['jquery'], function() {
	//全局的ajax访问，处理ajax清求时sesion超时 
	$.ajaxSetup({
	    type: "POST",
	    dataType: "json" ,
	    contentType : "application/json;charset=utf-8",
	    complete : function(XMLHttpRequest, textStatus) {
	    	if(XMLHttpRequest.status==900){
	    		alert(XMLHttpRequest.responseText);
	    		window.location.replace("http://localhost:8080/webapp/ftl/login.html");
	    	}
	    },
	    error:function(r){
			  alert(r.statusText+",code:"+r.status);
		  }
	});	
	
});