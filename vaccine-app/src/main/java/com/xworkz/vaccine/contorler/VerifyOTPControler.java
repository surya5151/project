package com.xworkz.vaccine.contorler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.RegisterService;

@Controller
@RequestMapping("/")
public class VerifyOTPControler {

	@Autowired
	private RegisterService registerService;

	@RequestMapping("/verifyOTP.vaccine")
	public String onclickVerifyANDProcess(@RequestParam int otp, Model model) {
		System.out.println("Invoked onclickverifyANDProcess()");

		boolean compareOTP = this.registerService.compareOTP(otp, RegisterControler.emailID);
		if (compareOTP) {
			model.addAttribute("OTP_Verified", "OTP Verify and matched");
			return "/WEB-INF/pages/SignUp.jsp";
		} else {
			model.addAttribute("OTP_Verified", "OTP Verify and not matched");
			return "/WEB-INF/pages/VerifyOTP.jsp";
		}

	}

	@RequestMapping("/resendOTP.vaccine")
	public String resendOTP(Model model) {
		System.out.println("Invoked resendOTP()");

		int otp = this.registerService.getOTP();
		boolean resendOTP = this.registerService.sendOTP(RegisterControler.emailID, otp);
		if (resendOTP) {
			boolean saveOTP = this.registerService.saveOTP(RegisterControler.emailID, otp);
			model.addAttribute("OTP_Resend", "Again OTP Send your email and sotre in DB");
			return "/WEB-INF/pages/VerifyOTP.jsp";
		} else {
			model.addAttribute("OTP_Resend", "Again OTP NOT Send your email and NOT sotre in DB");
			return "/WEB-INF/pages/VerifyOTP.jsp";

		}

	}

	@RequestMapping("/resendOTPAndUpdate.vaccine")
	public String resendOTPMailAndUpdate(Model model) {
		System.out.println("Invoked resendOTPMailAndUpdate()");

		int otp = this.registerService.getOTP();

		boolean resendOTPMailAndUpdate = this.registerService.sendOTP(RegisterControler.emailID, otp);

		if (resendOTPMailAndUpdate) {
			if (this.registerService.UpdateOTPInDB(otp, RegisterControler.emailID)) {
				model.addAttribute("OTP_ReSendAndUpdate", "OTP has Resend and Update In DB");
				return "/WEB-INF/pages/VerifyOTP.jsp";
			} else {
				model.addAttribute("OTP_ReSendAndUpdate", "OTP has not resend...... somthing wrong.........");
				return "/WEB-INF/pages/VerifyOTP.jsp";

			}

		}
		return "/WEB-INF/pages/VerifyOTP.jsp";

	}
}
