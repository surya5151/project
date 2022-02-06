package com.xworkz.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.dao.LoginDAO;
import com.xworkz.vaccine.dto.SignUpDTO;
import com.xworkz.vaccine.entity.SignUpEntity;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	@Autowired
	private BCryptPasswordEncoder encrypt;

	public static int loginAttempt = 0;

	@Override
	public boolean validateLoginUser(String userName, String password) {
		System.out.println("Invoked vaildateLogin");

		boolean flag = true;

		if (userName != null && !userName.isEmpty()) {
			flag = true;
		} else {
			flag = false;
			System.out.println("User name not valid");
			return flag;
		}

		if (password != null && !password.isEmpty()) {
			flag = true;
		} else {
			flag = false;
			System.out.println("Password not valid");
			return flag;
		}
		return flag;
	}

	@Override
	public boolean varifyUser(String userName, String password) {
		System.out.println("Invoked varifyUser()");

		String DBPassword = this.loginDAO.isUserExist(userName);
		if (this.encrypt.matches(password, DBPassword)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean NoOfloginAttemptExceeded(String userName) {
		System.out.println("Invoked NoOfloginAttemptExceeded");
		loginAttempt = this.loginDAO.updateLoginAttempt(userName, loginAttempt);
		if (loginAttempt == 3) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkLoginAttemptExceeded(String userName) {
		System.out.println("Invoked checkLoginAttemptExceeded()");
		int attempt = this.loginDAO.getUpdateAttempt(userName);
		if (attempt == 3) {
			return true;
		}
		return false;
	}

}
