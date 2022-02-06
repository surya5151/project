package com.xworkz.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "addMember_table")
public class AddMemberEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="ID")
	private int id;

	@Column(name="NAME")
	private String name;
	
	@Column(name="GENDER")
	private String gender;

	@Column(name="YOB")
	private Integer yob;

	@Column(name="PHOTO_ID")
	private String photoId;

	@Column(name="PHOTO_ID_NUMBER")
	private String photoIdNumber;

	@Column(name="VACCINE_TYPE")
	private String vaccineType;

	@Column(name="NO_OF_DOSE")
	private String NoOfDose;

}
