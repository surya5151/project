package com.xworkz.vaccine.dao;

import java.util.List;

import com.xworkz.vaccine.contorler.LoginControler;
import com.xworkz.vaccine.contorler.SignUpControler;
import com.xworkz.vaccine.entity.AddMemberEntity;

public interface AddMemberDAO {
	
	int addmemberCount(String userName);
	
	boolean saveEntity(AddMemberEntity addMemberEntity);
	
	int updateCount(String userName);
	
	int isUserPresent(String userName);
	
	List<AddMemberEntity>getAllMemberList();
	
	
	
	

	
}
