package pl.edu.thedentist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String showLoginForm(Model theModel) {
		
		return TemplatesNames.LOGIN_FORM;
	}	
}
