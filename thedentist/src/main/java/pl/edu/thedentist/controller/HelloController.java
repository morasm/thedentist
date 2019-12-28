package pl.edu.thedentist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String listDoctor(Model theModel) {
		return "hello";
	}
	
}
