package com.xworkz.vaccine.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xworkz.vaccine.dto.AddMemberDTO;
import com.xworkz.vaccine.entity.AddMemberEntity;

public interface AddMemberService {
	
	Map<String, String> errorMap =new HashMap<String, String>();
	
	boolean validateAddMember(AddMemberDTO addMemberDTO);
	
	boolean checkAddMemberCountExceeded(String userName);
	
	boolean saveAddMemberDTO(AddMemberDTO addMemberDTO);
	
	List<AddMemberEntity> getAllMemberList();
	
	
	

}
