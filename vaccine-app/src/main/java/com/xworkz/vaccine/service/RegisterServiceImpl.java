package com.xworkz.vaccine.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.dao.OTPDAO;
import com.xworkz.vaccine.entity.UserOTPEntity;
import com.xworkz.vaccine.util.OTPGenerator;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private OTPDAO otpdao;

	public RegisterServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@Override
	public boolean vaildateEmail(String email) {
		System.out.println("Invoked vaildateEmail()");
		if (!email.isEmpty() && email != null) {
			return true;
		}

		return false;
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
			mailMessage.setText(otp + " this is generated otp");

			mailSender.send(mailMessage);

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	@Override
	public boolean saveOTP(String email, int otp) {
		System.out.println("Invoked saveOTP()");

		UserOTPEntity otpEntity = new UserOTPEntity();

		BeanUtils.copyProperties(email, otpEntity);
		boolean result = this.otpdao.saveOTPEntity(otpEntity);

		return result;
	}

	@Override
	public boolean validateVerifyOTP(Integer otp) {
		System.out.println("Invoked validateVerifyOTP()");
		if (otp != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean verifyOTP(Integer otp) {
		System.out.println("Invoked verifyOTP()");

		Integer otpValue = this.otpdao.isOTPPresent(otp);

		if (otpValue != null) {
			System.out.println("Inside null check");
			if (otpValue.compareTo(otp) == 0) {
				return true;
			}
		}

		return false;
	}

}
