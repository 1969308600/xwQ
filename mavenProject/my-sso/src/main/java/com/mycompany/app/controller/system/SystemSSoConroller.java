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

import com.mybatis.web.test.ResultInfo;
import com.mycompany.app.common.CacheRedis;
import com.mycompany.app.entity.CacheEntity;
import com.mycompany.app.service.impl.SystemService;

import io.swagger.annotations.Api;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(path="systemSSo")
@Api(tags="ϵͳ������")
public class SystemSSoConroller {
	
	@Autowired
	SystemService systems ;
	@Autowired
	CacheRedis cacheRedis ;
	
	
	//��¼
	@RequestMapping(value = "doLogin.do",method=RequestMethod.POST,name="��¼")
	@ResponseBody
	public String doLogin(SystemUser user,HttpServletResponse resp) {
		return "";
	}
	
	//sso��֤
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "sign.do",method=RequestMethod.POST,name="��֤")
	@ResponseBody
	public ResultInfo sign(SystemUser user,HttpServletResponse resp,HttpSession session) {
		
		SystemUser selectUser = (SystemUser) systems.getUserByNameAndCode(user);
	 	if(null!=session.getId() &&session.getId()==selectUser.getSafeKey()){
			return new ResultInfo<>(true, new String(session.getId()));
		}
		if(null!=selectUser) {
			boolean boo = cacheRedis.add(new CacheEntity(session.getId()
					, JSONObject.fromObject(user).toString()));	//����redis  ȱ�����ܻ���  ��sha-1����md5��ʹ��+appid�ķ�ʽ��ȫ�Ի����Щ
			
			cacheRedis.keyTimeOut(session.getId(), 3600);
			
			if(boo) {//session ����   ���浽���ݿ�
				selectUser.setSafeKey(session.getId());
				systems.setUserSessionIdByUser(selectUser);
				
				return new ResultInfo<>(true,  session.getId() );
			} 
		}
		return new ResultInfo<>(false);
	
//		
	}
	@RequestMapping(value = "test.do",method=RequestMethod.GET,name="����")
	public ModelAndView test(SystemUser user,HttpServletResponse resp,HttpSession session) {
		ModelAndView mv= new ModelAndView("redirect:http://localhost:8080/webapp/ftl/login.html");
		return mv;
	}
}
