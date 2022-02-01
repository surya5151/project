package com.xworkz.vaccine.dao;

import com.xworkz.vaccine.entity.SignUpEntity;

public interface SignUpDAO {
	
	boolean saveSignUPEntity(SignUpEntity signUpEntity);
	
	public String getPassword(String emailId);

}
