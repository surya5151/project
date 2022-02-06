package com.xworkz.vaccine.service;

import java.util.HashMap;
import java.util.Map;

import com.xworkz.vaccine.dto.AddMemberDTO;

public interface AddMemberService {
	
	Map<String, String> errorMap =new HashMap<String, String>();
	
	boolean validateAddMember(AddMemberDTO addMemberDTO);
	
	boolean saveAddMemberDTO(AddMemberDTO addMemberDTO);

}
