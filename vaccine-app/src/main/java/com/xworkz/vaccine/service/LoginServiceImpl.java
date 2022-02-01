package com.xworkz.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.dao.LoginDAO;
import com.xworkz.vaccine.dto.SignUpDTO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	@Autowired
	private BCryptPasswordEncoder encrypt;

	private SignUpDTO signUpDTO;

	@Override
	public boolean vaildateLoginUser(String userName, String password) {
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

}
