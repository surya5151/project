package com.xworkz.vaccine.contorler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String onGetOTPButtonClicked(@RequestParam String emailID) {
		System.out.println("Invoked onGetOTPButtonClicked()");

		boolean result = this.registorService.vaildateEmail(emailID);
		if (result) {
			Number otp = this.registorService.getOTP();
			
			boolean isSendOTP = this.registorService.sendOTP(emailID, otp);
			if(isSendOTP) {
				
				
				return "/WEB-INF/pages/VerifyOTP.jsp";
			}else {
				
			}
			
			

		}else {
			
		}
		return "/RegistorVaccine.jsp";

	}
}
