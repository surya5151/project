package com.xworkz.vaccine.dto;

import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data

public class SignUpDTO {
	
	private int ID;
	
	private String userName;
	
	private long phoneNo;
	
	private String gender;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	private String password;
	
	private String confirmPassword;

}
