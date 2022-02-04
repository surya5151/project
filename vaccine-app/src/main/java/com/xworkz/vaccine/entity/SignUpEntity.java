package com.xworkz.vaccine.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Target;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "user_signUp_table")
@Data
public class SignUpEntity {

	@Id
//	@GeneratedValue(generator="SIGNUP_ID") //present in jpa for generating unique and auto increment value
//	@GenericGenerator(name="SIGNUP_ID",strategy="increment")
	
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "SIGNUP_ID")
	private int ID;

	@Column(name = "SIGNUP_USERNAME")
	private String userName;

	@Column(name = "SIGNUP_PHONENO")
	private Long phoneNo;

	@Column(name = "SIGNUP_GENDER")
	private String gender;

	@Column(name = "SIGNUP_DOB")
	private String dob;

	@Column(name = "SIGNUP_PASSWORD")
	private String password;
	
	@Column(name = "SIGNUP_EMAILID")
	private String emailID;
	
	@Column(name="LOGIN_ATTEMPT")
	private int loginAttempt;
	

}
