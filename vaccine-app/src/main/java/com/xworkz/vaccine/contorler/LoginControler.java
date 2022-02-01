package com.xworkz.vaccine.contorler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginControler {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login.vaccine")
	public String OnLoginButtonClick(@RequestParam String userName,@RequestParam String password, Model model) {		
		System.out.println("Invoked OnLoginButtonClick()");
		boolean vaildateLogin = this.loginService.vaildateLoginUser(userName, password);
		if(vaildateLogin) {
			boolean varifyUser = this.loginService.varifyUser(userName, password);
			if(varifyUser) {
				return "/WEB-INF/pages/HomePage.jsp";
			}else {
				model.addAttribute("Login_verify","Login verify failure");
				return "/WEB-INF/pages/Login.jsp";
			}
			
			
		}else {
			model.addAttribute("Login_verify","Login validate failure..");
			return "/WEB-INF/pages/Login.jsp";
		}
		
		
		
		
		
	}

}
