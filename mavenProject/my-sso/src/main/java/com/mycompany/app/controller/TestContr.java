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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.web.test.Layui;
import com.mybatis.web.test.Page;
import com.mycompany.app.service.impl.TestService;
import com.mycompany.app.swagger.ApiResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
@Controller
@RequestMapping(path="/mapper")
@Api(tags="个人业务")
public class TestContr implements EnvironmentAware {
	
	
	@Resource (name="testService")
	TestService testService;
	
	
	@RequestMapping(value="testJson.do",method=RequestMethod.POST)
	@ResponseBody
	public String testJson( Page pages,HttpServletRequest s) {
		List<Object> o = testService.getMappertListByPage(pages,JSONObject.fromObject(pages).toString());
    	Layui lu = new Layui();
    	lu.setCount(o.size()+"");
    	lu.setData(o);
		return  JSONObject.fromObject(lu).toString() ;
	}
	  
	@RequestMapping(value="save.do",method=RequestMethod.POST)
	@ResponseBody
	public String save( Mapper mapper,HttpServletRequest s) {
		 try {
			 testService.InsertEntity(mapper); 
			 return "suceccss";
		 }catch(Exception e) {
			 return  "123" ; 
		 }
      
	}
	
	@RequestMapping(value="go.do",method=RequestMethod.POST)
	public String test( Model m,ModelAndView mv,HttpServletRequest request ) {
		m.addAttribute("name","test"); 
		return "/go";
	}
	Environment local;
	@Override
	public void setEnvironment(Environment e) {
		local = e;
	}
	
	@RequestMapping(value="testApi.do",method=RequestMethod.POST)
	@ResponseBody
	 @ApiOperation(value = "获取用户列表1", notes = "2")  
	 @ApiImplicitParam(name = "userid", value = "用户ID", required = true, dataType = "String")  
	//@ApiOperation(value="根据ID获取用户信息",httpMethod="POST",notes="get user by id",response=ApiResult.class) 
	public ApiResult testApi(String userid) {
		ApiResult res = new ApiResult();
		res.setCode("100");
		res.setNotes ("sss");
		
		return res;
	}
	@RequestMapping(value="testApi2.do",method=RequestMethod.POST)
	@ResponseBody
	// @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid ID supplied"),
	//	      @ApiResponse(code = 404, message = "Pet not found") })
	 @ApiOperation(value = "233", notes = "1")  
	public ApiResult testApi2(String userid2) {
		ApiResult res = new ApiResult();
		res.setCode("100");
		res.setNotes ("sss");
		
		return res;
	}
	
	
	

}
