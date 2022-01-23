package com.xworkz.vaccine.contorler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.RegistorService;

@Controller
@RequestMapping("/")
public class RegistorControler {

	@Autowired
	private RegistorService registorService;

	public RegistorControler() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@RequestMapping("/getOTP.vaccine")
	public String onGetOTPButtonClicked(@RequestParam String emailID, Model model) {
		System.out.println("Invoked onGetOTPButtonClicked()");

		boolean result = this.registorService.vaildateEmail(emailID);
		if (result) {
			Number otp = this.registorService.getOTP();
			model.addAttribute("message", "OTP Generated");

			boolean isSendOTP = this.registorService.sendOTP(emailID, otp);
			if (isSendOTP) {

				model.addAttribute("message", "OTP SEND TO YOUR REGISTED MAIL ID");

				return "/WEB-INF/pages/VerifyOTP.jsp";
			} else {
				model.addAttribute("message", "OTP Sending failure...!!!");
			}

		} else {
			model.addAttribute("message", "OTP Not Generated...!!!");
		}
		return "/RegistorVaccine.jsp";

	}
}
