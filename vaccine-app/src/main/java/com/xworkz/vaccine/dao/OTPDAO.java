package com.xworkz.vaccine.dao;

import com.xworkz.vaccine.entity.SignUpEntity;
import com.xworkz.vaccine.entity.UserOTPEntity;

public interface OTPDAO {
	
	boolean saveOTPEntity(UserOTPEntity userOTPEntity);
	
	int isOTPPresent(int otp);
	
	int getOTPByEmail(String emailID);
	
	boolean updateOTPDetails(UserOTPEntity userOTPEntity);
	
	

}
