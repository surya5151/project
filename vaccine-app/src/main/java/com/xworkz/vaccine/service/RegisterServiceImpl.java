package com.xworkz.vaccine.service;

import java.util.HashMap;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.dao.OTPDAO;
import com.xworkz.vaccine.dto.SignUpDTO;
import com.xworkz.vaccine.entity.SignUpEntity;
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
	public int getOTP() {
		System.out.println("Invoked getOTP()");

		return OTPGenerator.generateOTP();
	}

	@Override
	public boolean sendOTP(String email, int otp) {
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

		otpEntity.setEmailID(email);
		otpEntity.setOtp(otp);

		boolean result = this.otpdao.saveOTPEntity(otpEntity);

		return result;
	}

	@Override
	public boolean validateVerifyOTP(int otp) {
		System.out.println("Invoked validateVerifyOTP()");
		if (otp != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean compareOTP(int otp, String emailID) {
		System.out.println("Invoked compareOTP()");

		int userotp = this.otpdao.getOTPByEmail(emailID);

		if (otp == userotp) {

			System.out.println("OTP is Matching" + otp + " " + userotp);
			return true;
		} else {
			System.out.println("OTP is Not matched");
			return false;
		}

	}

	@Override
	public boolean UpdateOTPInDB(int newotp, String emailID) {

		UserOTPEntity entity = new UserOTPEntity();

		entity.setEmailID(emailID);
		entity.setOtp(newotp);

		boolean isUpdated = this.otpdao.updateOTPDetails(entity);
		if (isUpdated) {
			return true;
		}

		return false;
	}

}
