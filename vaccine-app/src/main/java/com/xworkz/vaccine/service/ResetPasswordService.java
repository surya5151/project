package com.xworkz.vaccine.service;


public interface ResetPasswordService {
	
	boolean validateResetPassword(String password, String confirmPassword);
	
	boolean resetPassword(String password, String emailId);

}
