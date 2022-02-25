package com.xworkz.vaccine.contorler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LogOutControler {
	
	@RequestMapping("/logout.vaccine")
	
	public String GetLogOut(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Invoked GetLogOut()");
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "/WEB-INF/pages/Login.jsp";
		
	}
	

}
