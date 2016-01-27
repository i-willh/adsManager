package com.android.ads.manage.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.android.ads.manage.model.User;
import com.android.ads.manage.service.IUserService;

public class SecurityInterceptor extends HandlerInterceptorAdapter {
	
	public final static String COOKIEDOMAINNAME = "user";
	
	@Resource
	private IUserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("******SecurityInterceptor***********preHandle()");
		Cookie cookies[] = request.getCookies();
		String cookieValue = null;
		if(cookies != null) {
			for(int i = 0; i < cookies.length; i++) {
				if(COOKIEDOMAINNAME.equals(cookies[i].getName())) {
					cookieValue = cookies[i].getValue();
					break;
				}
			}
		}
		
		if(cookieValue == null) {
			response.setStatus(300);
			response.sendRedirect("../signin.html");
			return false;
		} else {
			String cookieValues[] = cookieValue.split(":");
			if(cookieValues.length != 3) {
				response.sendRedirect("../signin.html");
				return false;
			}
			User user = userService.getUserByEmail(cookieValues[0]);
			if(user == null) {
				response.sendRedirect("../signin.html");
				return false;
			} else {
				if(!cookieValues[1].equals(user.getPassword())) {
					response.sendRedirect("../signin.html");
					return false;
				}
			}
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("******SecurityInterceptor***********postHandle()");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("******SecurityInterceptor***********afterCompletion()");
		super.afterCompletion(request, response, handler, ex);
	}
}
