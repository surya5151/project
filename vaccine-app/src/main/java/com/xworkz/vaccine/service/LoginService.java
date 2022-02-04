package com.xworkz.vaccine.service;

public interface LoginService {
	

	boolean validateLoginUser(String userName, String password);
	
	boolean varifyUser(String userName, String password);
	
	
	boolean NoOfloginAttemptExceeded(String userName);
	
	boolean checkLoginAttemptExceeded(String userName);
	

}
