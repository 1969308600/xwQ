package com.mycompany.app.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.web.test.Layui;
import com.mybatis.web.test.Page;
import com.mycompany.app.service.impl.systemService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(path="system")
public class SystemConroller {
	
	@Autowired
	systemService systems ;
	
	@RequestMapping(value = "getMenu.do")
	@ResponseBody
	public String getMenu(Page pages,HttpServletResponse resp) {
		
		List<Object> list = systems.getMenu(  JSONObject.fromObject(pages).toString());
		
		Layui lu = new Layui();
    	lu.setData(list);  
		return JSONObject.fromObject(lu).toString();
	}
	//列表
	@RequestMapping(value = "getMenuListPage.do")
	@ResponseBody
	public String getMenuListPage(Page pages,HttpServletResponse resp) {
		
		List<Object> list = systems.getMenuListByPage( pages,JSONObject.fromObject(pages).toString());
		
		Layui lu = new Layui();
    	lu.setData(list);  
		return JSONObject.fromObject(lu).toString();
	}
	 
	//列表
	@RequestMapping(value = "getMenuCountForList.do")
	@ResponseBody
	public int getMenuCountForList(HttpServletResponse resp) {
		int count = systems.getMenuCountForList(  );
		return count;
	}
	

}
