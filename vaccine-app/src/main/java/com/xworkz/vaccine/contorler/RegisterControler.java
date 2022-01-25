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
	private RegisterService registorService;

	public RegisterControler() {
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
			boolean issaved = this.registorService.saveOTP(emailID, 0);

			if (isSendOTP && issaved) {

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
	
	

	@RequestMapping("/verifyOTP.vaccine")
	public String verifyOTP(@RequestParam Integer otp, Model model) {
		System.out.println("invoked verifyOTP()");
		if (this.registorService.validateVerifyOTP(otp)) {
			if (this.registorService.verifyOTP(otp)) {
				System.out.println("OTP varified");
				model.addAttribute("OTP_Verified", "OTP Verified....");
				return "/WEB-INF/pages/VerifyOTP.jsp";
			} else {
				model.addAttribute("Wrong_OTP_Entered", "Wrong OTP Entered!!!!!");
				return "/WEB-INF/pages/VerifyOTP.jsp";
			}
		} else {
			model.addAttribute("Invalid_OTP_Entered", "Invalid OTP Entered!!!");
			return "/WEB-INF/pages/VerifyOTP.jsp";

		}
	}
}
