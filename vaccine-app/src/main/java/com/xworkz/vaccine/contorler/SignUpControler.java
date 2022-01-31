package com.xworkz.vaccine.contorler;

import java.beans.PropertyEditor;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vaccine.dto.SignUpDTO;
import com.xworkz.vaccine.service.RegisterService;



@Controller
@RequestMapping("/")
public class SignUpControler {
	
	@Autowired
	private RegisterService registerService;
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(Date.class,     
	    (PropertyEditor) new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));   
	}
	
	
	@RequestMapping("/createAccount.vaccine")
	public String OnCreateAccount(@ModelAttribute SignUpDTO signUpDTO, Model model) {
		System.out.println("Invoked OnCreateAccount");
		
		boolean vaildateSignUPDTO = this.registerService.vaildateSignUPDTO(signUpDTO);		
		if(vaildateSignUPDTO) {			
			boolean isSaved = this.registerService.saveSignUPDTO(signUpDTO);
			if(isSaved) {
				model.addAttribute("Message", "SignUp Details are saved");
				return "/WEB-INF/pages/Login.jsp";
				
			}else {
				model.addAttribute("Message", "SignUp Details are not saved, Tray again....");
				return "/WEB-INF/pages/SignUp.jsp";
			}
			
		}
		return "/WEB-INF/pages/SignUp.jsp";
		
		
		
	}
	

}
