package com.mycompany.app.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.system.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.json.SomeStatic;
import com.mybatis.web.test.ResultInfo;
import com.mycompany.app.common.CacheRedis;
import com.mycompany.app.entity.CacheEntity;
import com.mycompany.app.service.impl.SystemService;

import io.swagger.annotations.Api;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(path="systemSSo")
@Api(tags="系统控制器")
public class SystemSSoConroller {
	
	@Autowired
	SystemService systems ;
	@Autowired
	CacheRedis cacheRedis ;
	
	
	//登录
	@RequestMapping(value = "doLogin.do",method=RequestMethod.POST,name="登录")
	@ResponseBody
	public String doLogin(SystemUser user,HttpServletResponse resp) {
		return "";
	}
	
	//sso验证
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "sign.do",method=RequestMethod.POST,name="验证",consumes="application/json;charset=utf-8")
	@ResponseBody
	public ResultInfo sign(@RequestBody SystemUser user,HttpServletRequest req,HttpServletResponse resp,HttpSession session) {
		
			SystemUser selectUser = (SystemUser) systems.getUserByNameAndCode(user);
			if(null!=selectUser) {
			 	if(null!=session.getId() &&session.getId().equals(selectUser.getSafeKey())){
					return new ResultInfo<>(true, new String(session.getId()));
				}
			 	
			 	//ExecutorService exc = Executors.newSingleThreadExecutor(); 
			 	//ExecutorCompletionService<Object> tem = new  ExecutorCompletionService<Object>(exc);
			 	
			 	
		 
					boolean boo = cacheRedis.add(new CacheEntity(session.getId()
							, JSONObject.fromObject(user).toString()));	//共享到redis  缺乏加密机制  ，sha-1或者md5，使用+appid的方式安全性会跟高些
					
					cacheRedis.keyTimeOut(session.getId(), SomeStatic.TIMEOUT_TEST);
//			 	tem.submit(new Callable<Object>() {
//					@Override
//					public Object call() throws Exception {
//						boolean boo = cacheRedis.add(new CacheEntity(session.getId()
//								, JSONObject.fromObject(user).toString()));	//共享到redis  缺乏加密机制  ，sha-1或者md5，使用+appid的方式安全性会跟高些
//						
//						cacheRedis.keyTimeOut(session.getId(), SomeStatic.TIMEOUT_TEST);
//						return boo;
//					}
//				});
			 	
			 	
				try {
					 if(boo) {//session 共享    
						//如果我不去 拿线程池里的东西，直接返回，会很快，
						selectUser.setSafeKey(session.getId());
						systems.setUserSessionIdByUser(selectUser); 
						 
						return new ResultInfo<>(true, session.getId() );
					 }
				} catch (Exception e) {
					return new ResultInfo<>(false);
				}  
			}
			return new ResultInfo<>(false);
	
//		
	}
	@RequestMapping(value = "test.do",method=RequestMethod.GET,name="测试")
	public ModelAndView test(SystemUser user,HttpServletResponse resp,HttpSession session) {
		ModelAndView mv= new ModelAndView("redirect:http://localhost:8080/webapp/ftl/login.html");
		return mv;
	}
}
