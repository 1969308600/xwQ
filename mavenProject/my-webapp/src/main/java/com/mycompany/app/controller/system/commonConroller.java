package com.mycompany.app.controller.system;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.web.test.Layui;
import com.mycompany.app.common.QiniuCommon;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(path="common")
public class commonConroller {
	
	 
	@RequestMapping(value = "getQiniuToken.do",name="七牛token" ,method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getQiniuToken(@RequestBody String bucket,HttpServletResponse resp) {
		Layui<Object> lu = new Layui<Object>();
    	lu.setResult(QiniuCommon.token(JSONObject.fromObject(bucket).get("bucket").toString()));
		return JSONObject.fromObject(lu).toString()	;
	}
	
	 


}
