package com.mycompany.app.controller;

 
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.test.Mapper;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.web.test.Layui;
import com.mybatis.web.test.Page;
import com.mycompany.app.service.impl.TestService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(path="/mapper")
public class AppMapperController implements EnvironmentAware {
	
	
	@Resource (name="testService")
	TestService testService;
	@RequestMapping("testJson.do")
	@ResponseBody
	public String testJson( Page pages,HttpServletRequest s) {
		List<Object> o = testService.getMappertListByPage(pages,JSONObject.fromObject(pages).toString());
    	Layui lu = new Layui();
    	lu.setCount(o.size()+"");
    	lu.setData(o);
		return  JSONObject.fromObject(lu).toString() ;
	}
	  
	@RequestMapping("save.do")
	@ResponseBody
	public String save( Mapper mapper,HttpServletRequest s) {
		 try {
			 testService.InsertEntity(mapper); 
			 return "suceccss";
		 }catch(Exception e) {
			 return  "123" ; 
		 }
      
	}
	
	@RequestMapping("go.do")
	public String test( Model m,ModelAndView mv,HttpServletRequest request ) {
		m.addAttribute("name","test"); 
		return "/go";
	}
	Environment local;
	@Override
	public void setEnvironment(Environment e) {
		local = e;
	}

}
