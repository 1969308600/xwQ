package com.mycompany.app.controller.system;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.system.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.app.common.CacheRedis;
import com.mycompany.app.entity.CacheEntity;
import com.mycompany.app.service.impl.systemService;

import io.swagger.annotations.Api;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(path="systemSSo")
@Api(tags="ϵͳ������")
public class SystemSSoConroller {
	
	@Autowired
	systemService systems ;
	@Autowired
	CacheRedis cacheRedis ;
	
	
	//��¼
	@RequestMapping(value = "doLogin.do",method=RequestMethod.POST,name="��¼")
	@ResponseBody
	public String doLogin(SystemUser user,HttpServletResponse resp) {
		return "";
	}
	
	//sso��֤
	@RequestMapping(value = "sign.do",method=RequestMethod.POST,name="��֤")
	@ResponseBody
	public boolean sign(SystemUser user,HttpServletResponse resp,HttpSession session) {
		
		SystemUser selectUser = (SystemUser) systems.getUserByNameAndCode(user);
	 	if(null!=session.getAttribute(session.getId())&&(boolean)session.getAttribute(session.getId())){
			return true;
		}
		if(null!=selectUser) {
			//session ����
			if(null!=selectUser.getSafeKey()) {
				
			}
			boolean boo = cacheRedis.add(new CacheEntity(session.getId(), JSONObject.fromObject(user).toString()));
			//sessionid�������ݿ�
			if(boo) {
				return true;
			}else {
				return false;
			}
//			session.setAttribute(session.getId(), true);  
//			session.setAttribute("userObj", selectUser);
		}else {
			return false;
		}
	
//		
	}
	@RequestMapping(value = "test.do",method=RequestMethod.GET,name="����")
	public ModelAndView test(SystemUser user,HttpServletResponse resp,HttpSession session) {
		ModelAndView mv= new ModelAndView("redirect:http://localhost:8080/webapp/ftl/login.html");
		return mv;
	}
}
