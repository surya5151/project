package com.xworkz.vaccine.contorler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.RegisterService;

@Controller
@RequestMapping("/")
public class RegisterControler {

	@Autowired
	private RegisterService registerService;

	public static String emailID;

	public String getEmailId() {
		return RegisterControler.emailID;

	}

	public RegisterControler() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@RequestMapping("/getOTP.vaccine")
	public String onGetOTPButtonClicked(@RequestParam String emailID, Model model) {
		System.out.println("Invoked onGetOTPButtonClicked()");

		RegisterControler.emailID = emailID;

		boolean result = this.registerService.vaildateEmail(emailID);
		if (result) {
			int otp = this.registerService.getOTP();
			model.addAttribute("message", "OTP Generated");

			boolean isSendOTP = this.registerService.sendOTP(emailID, otp);

			boolean issaved = this.registerService.saveOTP(emailID, otp);

			if (isSendOTP && issaved) {
			//	isSendOTP &&
				model.addAttribute("message", "OTP send to your mailID and Also store in DB");

				return "/WEB-INF/pages/VerifyOTP.jsp";
			} else {
				model.addAttribute("message", "OTP Sending failure...!!!");
				return "RegisterVaccine.jsp";
			}

		} else {
			model.addAttribute("message", "OTP Not Generated...!!!");
		}
		return "RegisterVaccine.jsp";

	}

}