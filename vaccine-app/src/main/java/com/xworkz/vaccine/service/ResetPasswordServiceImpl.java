package com.xworkz.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.dao.ResetPasswordDAOImpl;

@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {

	@Autowired
	private BCryptPasswordEncoder encrypt;

	@Autowired
	private ResetPasswordService resetPasswordService;

	@Autowired
	private ResetPasswordDAOImpl resetPasswordDAOImpl;

	@Override
	public boolean validateResetPassword(String password, String confirmPassword) {
		System.out.println("Invoked validateResetPassword() in service.........");

		if (password != null && !password.isEmpty()) {
			if (confirmPassword != null && !confirmPassword.isEmpty()) {
				if (confirmPassword.equals(password)) {
					System.out.println("password are matched");
					return true;
				}
			}

		}
		System.err.println("password are not matched...");
		return false;
	}

	@Override
	public boolean resetPassword(String password, String emailId) {
		System.out.println("Invoked resetPassword() in service........");
		String encode = encrypt.encode(password);
		System.out.println("ResetPassword is:" + encode);

		if (this.resetPasswordDAOImpl.resetPassword(encode, emailId)) {
			return true;
		}

		return false;
	}

}
