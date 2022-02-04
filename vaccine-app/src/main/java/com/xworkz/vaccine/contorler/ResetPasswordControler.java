package com.xworkz.vaccine.contorler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.entity.SignUpEntity;
import com.xworkz.vaccine.service.LoginService;
import com.xworkz.vaccine.service.ResetPasswordService;

@Controller
@RequestMapping("/")
public class ResetPasswordControler {

	@Autowired
	private ResetPasswordService resetPasswordService;

	@Autowired
	private RegisterControler otpControler;

	@RequestMapping("/resetPassword.vaccine")
	public String onResetPassword(@RequestParam String password, @RequestParam String confirmPassword, Model model) {
		System.out.println("Invoked onResetPassword()");

		if (this.resetPasswordService.validateResetPassword(password, confirmPassword)) {
			if (this.resetPasswordService.resetPassword(password, this.otpControler.getEmailId())) {

				model.addAttribute("Reset_password_sucess", "Pasword is reset, please login");

				return "/WEB-INF/pages/Login.jsp";

			} else {
				model.addAttribute("Reset_password_failure", "Pasword invalid");

				return "WEB-INF/pages/ResetPassword.jsp";

			}

		} else {
			model.addAttribute("Reset_password_Not_matched", "Pasword not matched, try once");

			return "WEB-INF/pages/ResetPassword.jsp";

		}

	}

}
