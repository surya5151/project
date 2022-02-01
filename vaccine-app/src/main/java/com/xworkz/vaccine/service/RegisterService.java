package com.xworkz.vaccine.service;

import com.xworkz.vaccine.dto.SignUpDTO;

public interface RegisterService {
	
	
	boolean vaildateEmail(String email);
	
	int getOTP();
	
	boolean sendOTP(String email, int otp);
	
	boolean saveOTP(String email, int otp);
	
	boolean validateVerifyOTP(int otp);
	
	boolean compareOTP(int otp, String emailID);
	
	boolean UpdateOTPInDB(int newotp, String emailID);	
	
}
