package com.android.ads.manage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.android.ads.manage.model.UsrBehavior;
import com.android.ads.manage.service.IUsrBehaviorService;

@Controller
@RequestMapping(value="/behavior",produces="text/plain;charset=UTF-8")
public class UsrBehaviorController {
	
	@Resource
	private IUsrBehaviorService usrBehaviorService;
	
	@ResponseBody
	@RequestMapping("queryUsrBehavior")
	public String queryUsrBehavior() {
		UsrBehavior usrBehavior = new UsrBehavior();
		usrBehavior.setSeqId(1000L);
		List<UsrBehavior> list = usrBehaviorService.queryUsrBehavior(usrBehavior);
		list.forEach(usrBehavior1 -> System.out.println(usrBehavior1.toString()));
		return "queryUsrBehavior";
	}
}
