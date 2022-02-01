package com.xworkz.vaccine.service;

import java.util.HashMap;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.contorler.RegisterControler;
import com.xworkz.vaccine.contorler.SignUpControler;
import com.xworkz.vaccine.dao.OTPDAO;
import com.xworkz.vaccine.dao.SignUpDAO;
import com.xworkz.vaccine.dto.SignUpDTO;
import com.xworkz.vaccine.entity.SignUpEntity;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private SignUpDAO signUpDAO;

	@Autowired
	private BCryptPasswordEncoder encrypt;

	@Autowired
	private RegisterControler registerControler;

	@Autowired
	private SignUpControler signUpControler;

	@Autowired
	private JavaMailSender mailsender;

	@Override
	public boolean vaildateSignUPDTO(SignUpDTO signUpDTO) {

		System.out.println("Invoked vaildateSignUPDTO");

		boolean flag = true;

		if (signUpDTO.getUserName() != null) {
			flag = true;
		} else {
			flag = false;
			System.err.println("Invalid UserName");

			errorMap.put("INVALID_USERNAME", "Invalid UserName");

			return flag;
		}

		if (signUpDTO.getPhoneNo() != null) {
			flag = true;
		} else {
			flag = false;
			System.err.println("Invlid Number");
			errorMap.put("INVLID_NUMBER", "Invlid Number");

			return flag;
		}

		if (signUpDTO.getGender() != null && !signUpDTO.getGender().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			System.err.println("Invalid Gender");
			errorMap.put("INVLID_GENDER", "Invlid Gender");

			return flag;
		}

		if (signUpDTO.getDob() != null) {
			flag = true;
		} else {
			flag = false;
			System.err.println("Invalid DOB");
			errorMap.put("INVLID_DOB", "Invlid DOB");
			return flag;
		}

		if (signUpDTO.getPassword() != null && !signUpDTO.getPassword().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			System.err.println("Password Invalid......");
			errorMap.put("PASSWORD_INVALID", "Password Invalid");
			return flag;
		}

		if (signUpDTO.getConfirmPassword() != null && signUpDTO.getPassword().equals(signUpDTO.getConfirmPassword())) {
			flag = true;
		} else {
			flag = false;
			System.err.println("Password not matched......");
			errorMap.put("PASSWORD_NOT_MATCHED", "Password not matched");
			return flag;
		}
		return flag;
	}

	@Override
	public boolean saveSignUPDTO(SignUpDTO signUpDTO) {
		System.out.println("invoked saveSignUPDTO");
		signUpDTO.setPassword(encrypt.encode(signUpDTO.getPassword()));
		SignUpEntity signUpEntity = new SignUpEntity();
		BeanUtils.copyProperties(signUpDTO, signUpEntity);

		signUpEntity.setEmailID(registerControler.emailID);

		boolean saveSignUPEntity = this.signUpDAO.saveSignUPEntity(signUpEntity);
		if (saveSignUPEntity) {
			return true;
		}
		return false;
	}

//	@Override
//	public boolean sendSignupMail(String emailId) {
//		System.out.println("Invoked sendSignupMail()");
//
//		try {
//			String password = "";
//
//			if (encrypt.matches(signUpControler.password, this.getPassword(emailId))) {
//				password = signUpControler.password;
//			}
//			SimpleMailMessage mailMessage = new SimpleMailMessage();
//			mailMessage.setTo(emailId);
//			mailMessage.setSubject("Geting password & vaccian signup sucess...");
//			mailMessage.setText("A/C created for vaccine and password for login is " + password);
//			mailsender.send(mailMessage);
//			return true;
//		} catch (Exception e) {
//
//			System.out.println(e.getMessage());
//		}
//
//		return false;
//	}
//
//	@Override
//	public String getPassword(String emailId) {
//		System.out.println("Invoked getPassword()");
//
//		String DBpassword = this.signUpDAO.getPassword(emailId);
//		
//		if(DBpassword !=null) {
//			return DBpassword;
//		}
//		return null;
//	}

}
