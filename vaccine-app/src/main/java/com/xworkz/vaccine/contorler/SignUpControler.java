package com.xworkz.vaccine.contorler;

import java.beans.PropertyEditor;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

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
import com.xworkz.vaccine.service.SignUpService;

@Controller
@RequestMapping("/")
public class SignUpControler {

	@Autowired
	private RegisterControler registerControler;

	@Autowired
	private SignUpService signUpService;
	
	public static String password;
	
	

	@RequestMapping("/createAccount.vaccine")
	public String OnCreateAccount(@ModelAttribute SignUpDTO signUpDTO, Model model) {
		System.out.println("Invoked OnCreateAccount");
		
		System.out.println("sign up dto is " + signUpDTO);

		boolean vaildateSignUPDTO = this.signUpService.vaildateSignUPDTO(signUpDTO);
		if (vaildateSignUPDTO) {
			boolean isSaved = this.signUpService.saveSignUPDTO(signUpDTO);

			if (isSaved) {
				this.signUpService.sendSignupMail(this.registerControler.emailID);		
				
				model.addAttribute("Signup_Message_sucess", "SignUp Details are saved");
				return "/WEB-INF/pages/Login.jsp";

			} else {
				model.addAttribute("Signup_Message_error", "SignUp Details are not saved, Tray again....");
				return "/WEB-INF/pages/SignUp.jsp";
			}

		} else

		{
			Map<String, String> map = this.signUpService.errorMap;
			model.addAttribute("UserNameNotValid", map.get("INVALID_USERNAME"));
			model.addAttribute("NumberNotValid", map.get("INVLID_NUMBER"));
			model.addAttribute("GenderNotValid", map.get("INVLID_GENDER"));
			model.addAttribute("DOBNotValid", map.get("INVLID_DOB"));
			model.addAttribute("PasswordNotValid", map.get("PASSWORD_INVALID"));
			model.addAttribute("ConfirmPasswordNotValid", map.get("CONFIRMPASSWORD_INVALID"));
			model.addAttribute("PasswordNotMatched", map.get("PASSWORD_NOT_MATCHED"));

		}
		return "/WEB-INF/pages/SignUp.jsp";

	}

}
