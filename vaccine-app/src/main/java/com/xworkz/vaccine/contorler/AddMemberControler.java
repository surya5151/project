package com.xworkz.vaccine.contorler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vaccine.dto.AddMemberDTO;
import com.xworkz.vaccine.service.AddMemberService;

@Controller
@RequestMapping("/")
public class AddMemberControler {
	
	@Autowired
	private AddMemberService addMemberService;
	
	
	
	@RequestMapping("/addMember.vaccine")
	public String OnAddMember(@ModelAttribute AddMemberDTO addMemberDTO, Model model) {
		System.out.println("Invoked OnAddMember");
		
		boolean validateAddMember = this.addMemberService.validateAddMember(addMemberDTO);
		if(validateAddMember) {
			
			boolean isSavedEnty = this.addMemberService.saveAddMemberDTO(addMemberDTO);
			if(isSavedEnty) {
				
				model.addAttribute("Entity_saved_sucess", "One member are stored in successfully...");
				System.out.println("Enty is Saved");
				return "/WEB-INF/pages/AddMember.jsp";
			}else {
				model.addAttribute("Entity_saved_failure", "Member are not stored in the DB......!!!!!.");
				System.out.println("Enty is not Saved");
				return "/WEB-INF/pages/AddMember.jsp";
			}
		}else {
			Map<String, String> map = this.addMemberService.errorMap;
			model.addAttribute("validate_Name", map.get("NAME"));
			model.addAttribute("validate_Gender", map.get("GENDER"));
			model.addAttribute("validate_yob", map.get("YOB"));
			model.addAttribute("validate_PhotoID", map.get("PHOTO_ID"));
			model.addAttribute("validate_PhotoIdNu", map.get("PHOTO_ID_NUMBER"));
			model.addAttribute("validate_VaccineType", map.get("VACCINE_TYPE"));
			model.addAttribute("validate_NoOfDose", map.get("NO_OF_DOSE"));

			
			
			model.addAttribute("Entity_validation_failure", "Not validate properly.......");
			System.err.println("Not validate properly......");
			return "/WEB-INF/pages/HomePage.jsp";	
		}	
		
		
		
	}

}
