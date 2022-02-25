package com.xworkz.vaccine.contorler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	public String getUserName() {
		return LoginControler.userName;

	}
	
	public static String addMemberCount;
	
	public String getAddMemberCount() {
		return LoginControler.addMemberCount;
	}

	@RequestMapping("/login.vaccine")
	public String OnLoginButtonClick(@RequestParam String userName, @RequestParam String password,
			HttpServletRequest request, Model model) {
		System.out.println("Invoked OnLoginButtonClick()");
		boolean validated = this.loginService.validateLoginUser(userName, password);
		if (validated) {
			if (this.loginService.checkLoginAttemptExceeded(userName)) {
				model.addAttribute("AttemptExceeded",
						"Wrong attempet password in 3-times, so your Account is blocked ...!!!");
				return "/WEB-INF/pages/Login.jsp";
			} else {
				if (this.loginService.varifyUser(userName, password)) {
					
					LoginControler.userName = userName; // * i am setting this userName to addMember Controller 
					LoginControler.addMemberCount=addMemberCount;
					
					HttpSession session = request.getSession(true); //logout 
					session.setAttribute("UserName", userName);

					model.addAttribute("UserName", userName);
					return "/WEB-INF/pages/HomePage.jsp";

				} else {
					if (this.loginService.NoOfloginAttemptExceeded(userName)) {
						model.addAttribute("No_of_AttemptExceeded", "Your Account is blocked, please reset password");
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
	public String getLoginPage() {
		return "/WEB-INF/pages/Login.jsp";
	}

}
