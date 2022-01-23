package com.xworkz.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.util.OTPGenerator;

@Service
public class RegistorServiceImpl implements RegistorService {

	@Autowired
	private JavaMailSender mailSender;

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
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			mailMessage.setTo(email);
			mailMessage.setSubject("OTP Generated");
			mailMessage.setText(otp + "this is generated otp");

			mailSender.send(mailMessage);

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

}
