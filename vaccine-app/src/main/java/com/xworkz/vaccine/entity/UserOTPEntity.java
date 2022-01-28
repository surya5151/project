package com.xworkz.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "vaccine_table")
@NamedQueries({
		@NamedQuery(name = "UserOTPEntity.getOTPByEmail", query = "SELECT otp FROM UserOTPEntity WHERE emailID=:EMAILID")

})

@Data
public class UserOTPEntity implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "VACCINE_ID")
	private int id;

	@Column(name = "VACCINE_EMAIL")
	private String emailID;

	@Column(name = "VACCINE_OTP")
	private int otp;

}
