package com.xworkz.vaccine.dao;

import com.xworkz.vaccine.entity.SignUpEntity;

public interface LoginDAO {

	String isUserExist(String userName);


	int getUpdateAttempt(String userName);

	int updateLoginAttempt(String userName, int curentAttempt);


}
