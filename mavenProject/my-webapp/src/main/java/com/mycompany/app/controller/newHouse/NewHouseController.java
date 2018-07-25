package com.mycompany.app.controller.newHouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.web.test.Page;
import com.mycompany.app.controller.AppBaseController;
import com.mycompany.app.service.impl.newHouse.NewHouseService;

import net.sf.json.JSONArray;

@RequestMapping(path="newHouse")
@Controller
public class NewHouseController extends AppBaseController {
	
	@Autowired
	NewHouseService houservice;
	
	@RequestMapping(path="getNewhouseList.do",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public Object getNewhouseList(@RequestBody Page page) {
		return JSONArray.fromObject(houservice.getEntityList(page)).toString();
	}

}
