package com.xworkz.vaccine.service;

import java.util.HashMap;
import java.util.Map;

import com.xworkz.vaccine.dto.SignUpDTO;

public interface SignUpService {

	Map<String, String> errorMap = new HashMap<String, String>();

	boolean vaildateSignUPDTO(SignUpDTO signUpDTO);

	boolean saveSignUPDTO(SignUpDTO signUpDTO);
	
//	boolean sendSignupMail(String emailId);
//	
//	String getPassword(String emailId);
//	

}
