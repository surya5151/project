package com.xworkz.vaccine.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.util.OTPGenerator;

@Service
public class RegistorServiceImpl implements RegistorService {

	public RegistorServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@Override
	public boolean vaildateEmail(String email) {
		System.out.println("Invoked vaildateEmail()");

		return true;
	}

	@Override
	public Number getOTP() {
		System.out.println("Invoked getOTP()");

		return OTPGenerator.generateOTP();
	}

	@Override
	public boolean sendOTP(String email, Number otp) {
		System.out.println("Invoked sendOTP()");
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo(email);
		mailMessage.setSubject("OTP Generated");
		mailMessage.setText(otp +"this is generated otp");
		
		return true;
	}

}
