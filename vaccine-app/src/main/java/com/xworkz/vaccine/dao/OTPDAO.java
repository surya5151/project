package com.xworkz.vaccine.dao;

import com.xworkz.vaccine.entity.UserOTPEntity;

public interface OTPDAO {
	
	boolean saveOTPEntity(UserOTPEntity userOTPEntity);
	
	Integer isOTPPresent(Integer otp);
	
	

}
