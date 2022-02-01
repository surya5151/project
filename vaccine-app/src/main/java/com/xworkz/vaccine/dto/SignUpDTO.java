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
	
	private Long phoneNo;
	
	private String gender;
	
	private String dob;
	
	private String password;
	
	private String confirmPassword;

}
