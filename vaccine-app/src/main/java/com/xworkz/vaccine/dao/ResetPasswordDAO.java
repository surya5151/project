package com.xworkz.vaccine.dao;

public interface ResetPasswordDAO {
	
	
	boolean resetPassword(String password, String emailId, int loginAttempt);

}
