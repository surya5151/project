package com.xworkz.vaccine.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.contorler.LoginControler;
import com.xworkz.vaccine.dao.AddMemberDAO;
import com.xworkz.vaccine.dto.AddMemberDTO;
import com.xworkz.vaccine.entity.AddMemberEntity;

@Service
public class AddMemberServiceImpl implements AddMemberService {

	@Autowired
	private AddMemberDAO addMemberDAO;
	
	@Autowired
	private LoginControler loginControler;

	@Override
	public boolean validateAddMember(AddMemberDTO addMemberDTO) {
		System.out.println("Invoked validateAddMember");

		boolean flag = true;

		if (addMemberDTO.getName() != null && !addMemberDTO.getName().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			errorMap.put("NAME", "Invalid Name");
			return flag;
		}

		if (addMemberDTO.getGender() != null && !addMemberDTO.getGender().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			errorMap.put("GENDER", "Invalid Gender");
			return flag;
		}

		if (addMemberDTO.getYob() != null) {
			flag = true;
		} else {
			flag = false;
			errorMap.put("YOB", "Invalid yob");
			return flag;
		}

		if (addMemberDTO.getPhotoId() != null && !addMemberDTO.getPhotoId().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			errorMap.put("PHOTO_ID", "Invalid PhotoId");
			return flag;
		}

		if (addMemberDTO.getPhotoIdNumber() != null && !addMemberDTO.getPhotoIdNumber().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			errorMap.put("PHOTO_ID_NUMBER", "Invalid PhotoIdNumber");
			return flag;
		}

		if (addMemberDTO.getVaccineType() != null && !addMemberDTO.getVaccineType().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			errorMap.put("VACCINE_TYPE", "Invalid VaccineType");
			return flag;
		}
		if (addMemberDTO.getNoOfDose() != null && !addMemberDTO.getNoOfDose().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			errorMap.put("NO_OF_DOSE", "Invalid NoOfDose");
			return flag;
		}

		return flag;

	}
	
	@Override
	public boolean checkAddMemberCountExceeded(String userName) {
		System.out.println("Invoked checkCountExceeded()..........in service");
		
		int countRow = this.addMemberDAO.addmemberCount(userName);
				
		if (countRow < 4) {	
			
			return true;
		}
		System.err.println("Count exceds the limit.....!!!!!!!!!!!");

		return false;

	}

	@Override
	public boolean saveAddMemberDTO(AddMemberDTO addMemberDTO) {
		System.out.println("Invoked saveAddMemberEntity in serviceImpl");

		AddMemberEntity entity = new AddMemberEntity();
		BeanUtils.copyProperties(addMemberDTO, entity);

		boolean saveEntity = this.addMemberDAO.saveEntity(entity);
		
		System.out.println("Saved Entity is: " + saveEntity);
		
		if (saveEntity) {
			
			int updateCount = this.addMemberDAO.updateCount(loginControler.userName);
			if(updateCount!=0) {
				return true;
			}else {
				System.err.println(".........count exiceds");
			}
			
			
		}

		return false;
	}

	

	
	
	@Override
	public List<AddMemberEntity> getAllMemberList() {
		System.out.println("Invoked getAllMemberList() .....in ServiceIMPL");
		List<AddMemberEntity> addMemberContainer = null;
		List<AddMemberEntity> allMemberList = this.addMemberDAO.getAllMemberList();

		if (allMemberList != null) {
			return addMemberContainer = new ArrayList<AddMemberEntity>(allMemberList);
		}

		return addMemberContainer;
	}

}
