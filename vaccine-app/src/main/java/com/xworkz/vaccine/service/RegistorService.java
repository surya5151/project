package com.xworkz.vaccine.service;

public interface RegistorService {
	
	
	boolean vaildateEmail(String email);
	
	Number getOTP();
	
	boolean sendOTP(String email, Number otp);

}
