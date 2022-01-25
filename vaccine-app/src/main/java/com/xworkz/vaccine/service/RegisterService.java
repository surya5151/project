package com.xworkz.vaccine.service;

public interface RegisterService {
	
	
	boolean vaildateEmail(String email);
	
	Number getOTP();
	
	boolean sendOTP(String email, Number otp);
	
	boolean saveOTP(String email, int otp);
	
	boolean validateVerifyOTP(Integer otp);
	
	boolean verifyOTP(Integer otp);

}
