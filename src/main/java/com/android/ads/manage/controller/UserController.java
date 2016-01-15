package com.android.ads.manage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.android.ads.manage.service.IUserService;

@Controller
@RequestMapping(value="user",produces="text/plain;charset=UTF-8")
public class UserController {
	
	@Resource
	private IUserService userService;
}
