package pl.edu.thedentist.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/addPersonForm")
	public String showAddPersonForm(Model theModel) {
				
		Person addPerson = new Person();
		
		theModel.addAttribute("addPerson", addPerson);
		
		return "registration-form";
	}
	
	@PostMapping("/addPersonForm")
	public String submitAddPersonForm(@ModelAttribute Person addPerson) {
		personService.save(addPerson);
		return "home";		
	}
	
}
