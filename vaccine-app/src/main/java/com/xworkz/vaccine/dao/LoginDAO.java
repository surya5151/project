package com.xworkz.vaccine.dao;

import com.xworkz.vaccine.entity.SignUpEntity;

public interface LoginDAO {

	String isUserExist(String userName);

	int updateLoginAttempt(String userName, int curentAttempt);

	int getUpdateAttempt(String userName);

	

}
