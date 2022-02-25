package com.xworkz.vaccine.contorler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vaccine.dto.AddMemberDTO;
import com.xworkz.vaccine.entity.AddMemberEntity;
import com.xworkz.vaccine.service.AddMemberService;
import com.xworkz.vaccine.service.LoginService;

@Controller
@RequestMapping("/")
public class AddMemberControler {

	@Autowired
	private AddMemberService addMemberService;

	@Autowired
	private SignUpControler signUpControler;

	@Autowired
	private LoginControler loginControler;

	@RequestMapping("/addMemberPage.vaccine")
	public String getAddMemberPage() {
		System.out.println("Invoked getAddMemberPage()");
		return "/WEB-INF/pages/AddMember.jsp";

	}

	@RequestMapping("/addMember.vaccine")
	public String OnAddMember(@ModelAttribute AddMemberDTO addMemberDTO, Model model) {
		System.out.println("Invoked OnAddMember CONTROLER.......");

		boolean validateAddMember = this.addMemberService.validateAddMember(addMemberDTO);
		if (validateAddMember) {
			System.out.println("Validation is successfully.........");
			if (this.addMemberService.checkAddMemberCountExceeded(loginControler.userName)) {
				if (this.addMemberService.saveAddMemberDTO(addMemberDTO)) {					
					
					System.out.println("saveAddMemberDTO ");
					model.addAttribute("Entity_saved_sucess", "Member Stored in Successfully...");
					return "/WEB-INF/pages/HomePage.jsp";
				} else {
					model.addAttribute("Entity_not_saved_", "Member Stored failure...");
					return "/WEB-INF/pages/HomePage.jsp";
				}				

			} else {
				model.addAttribute("NO_ADDMember_COUNT_EXCEDED", "AddMember count exceded..!!!!!.");
				System.err.println("Entity is not Saved");
				return "/WEB-INF/pages/HomePage.jsp";
			}
		}

		else {
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
			return "/WEB-INF/pages/AddMember.jsp";
		}
		
	}

	@RequestMapping("/memberList.vaccine")
	public String getMemberList(Model model) {
		System.out.println("Invoked getMemberList()...Controler.....");
		List<AddMemberEntity> allMemberList = this.addMemberService.getAllMemberList();
		model.addAttribute("ALL_MEMBER_LIST", allMemberList);
		return "/WEB-INF/pages/HomePage.jsp";

	}
}
