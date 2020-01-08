package pl.edu.thedentist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.edu.thedentist.entity.Person;
import pl.edu.thedentist.services.PersonService;

@Controller
public class RegistrationController {
	
	@Autowired
	PersonService personService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/addPersonForm")
	public String showAddPersonForm(Model theModel) {	
		theModel.addAttribute("addPerson", new Person());
		
		return TemplatesNames.REGISTRATION_FORM;
	}
	
	@PostMapping("/addPersonForm")
	public String submitAddPersonForm(@ModelAttribute Person addPerson) {
		addPerson.setPassword(passwordEncoder.encode(addPerson.getPassword()));
		personService.save(addPerson);
		
		return TemplatesNames.HOME_PAGE;		
	}
	
}
