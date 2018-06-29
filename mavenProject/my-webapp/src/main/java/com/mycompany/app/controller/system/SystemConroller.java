package com.mycompany.app.controller.system;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.system.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.web.test.Layui;
import com.mybatis.web.test.Page;
import com.mycompany.app.service.impl.SystemUserService;
import com.mycompany.app.service.impl.systemService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(path="system")
public class SystemConroller {
	
	@Autowired
	systemService systems ;
	@Autowired
	SystemUserService userService ;

	@RequestMapping(value = "getMenu.do",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getMenu(Page pages,HttpServletResponse resp) {
		
		List<Object> list = systems.getMenu(  JSONObject.fromObject(pages).toString());
		
		Layui<Object> lu = new Layui<Object>();
    	lu.setData(list);  
		return JSONObject.fromObject(lu).toString();
	}
	//列表
	@RequestMapping(value = "getMenuListPage.do",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getMenuListPage(@RequestBody Page pages,HttpServletResponse resp) {
		
		List<Object> list = systems.getMenuListByPage( pages,JSONObject.fromObject(pages).toString());
		
		Layui<Object> lu = new Layui<Object>();
    	lu.setData(list);  
		return JSONObject.fromObject(lu).toString();
	}
	//列表
	@RequestMapping(value = "getDeptList.do",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getDeptList(HttpServletResponse resp) {
		
		List<Object> list = systems.getDeptList( "getDeptList");
		Layui<Object> lu = new Layui<Object>();
		lu.setData(list);  
		String res = JSONObject.fromObject(lu).toString();
		return res;
	}
	 
 
	//列表
	@RequestMapping(value = "getUserList.do",name="用户列表" ,method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getUserList(  HttpServletRequest req,HttpServletResponse resp,@RequestBody Page page) { 
		List<SystemUser> list = userService.getEntityList( page );
		Layui<SystemUser> lu = new Layui<SystemUser>();
		lu.setData(list);  
		String res = JSONObject.fromObject(lu).toString();
		return res;
	} 
	//列表
	@RequestMapping(value = "getMenuCountForList.do")
	@ResponseBody
	public int getMenuCountForList(HttpServletResponse resp) {
		int count = systems.getMenuCountForList(  );
		return count;
	}
	 
	 


}
