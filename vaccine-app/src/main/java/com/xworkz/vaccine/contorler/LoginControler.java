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

	public static String userName;
	
	public static String password;
	
	
	
	@RequestMapping("/login.vaccine")
	public String OnLoginButtonClick(@RequestParam String userName, @RequestParam String password, Model model) {
		System.out.println("Invoked OnLoginButtonClick()");
		boolean validated = this.loginService.validateLoginUser(userName, password);
		if (validated) {
			if (this.loginService.checkLoginAttemptExceeded(userName)) {
				model.addAttribute("AttemptExceeded", "Your Account is blocked, please reset password");
				//model.addAttribute("Reset_link", "true");
				return "/WEB-INF/pages/Login.jsp";
			} else {
				if (this.loginService.varifyUser(userName, password)) {
					return "/WEB-INF/pages/HomePage.jsp";
				} else {
					if (this.loginService.NoOfloginAttemptExceeded(userName)) {
						model.addAttribute("No_of_AttemptExceeded", "Entered 3-times wrong password so your Account is blocked");
					//	model.addAttribute("Reset_link", "true");
						return "/WEB-INF/pages/Login.jsp";
					}
					model.addAttribute("AttemptExceeded", "Invalid UserName or password");
					return "/WEB-INF/pages/Login.jsp";
				}
			}

		} else {
			model.addAttribute("Login_verify", "UserName OR password is missing please try once..");
			return "/WEB-INF/pages/Login.jsp";
		}

	}
	
	@RequestMapping("/resetPasswordpage.vaccine")
	public String resetPasswordPageRedirect() {
		System.out.println("Invoked resetPasswordPageRedirect() and go through reset page..");
		
		return "/WEB-INF/pages/ResetPassword.jsp";		
	}
	
	
	@RequestMapping("/loginPage.vaccine")
	public String loginPageRedirect() {
		return "/WEB-INF/pages/Login.jsp";
		
	}
}
