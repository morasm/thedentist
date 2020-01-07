package pl.edu.thedentist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.thedentist.entity.Visit;
import pl.edu.thedentist.services.VisitService;

@Controller
@RequestMapping("/visits")
public class VisitController {
	
	@Autowired
	private VisitService visitService;
	
	public VisitController(VisitService theVisitService) {
		visitService = theVisitService;
	}
	
	@GetMapping("/list")
	public String listVisits(Model theModel) {
		
		List<Visit> theVisits = visitService.findAll();
		
		theModel.addAttribute("visits", theVisits);
		
		return "visits/list-visits";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Visit theVisit = new Visit();
		
		theModel.addAttribute("visit", theVisit);
		
		return "visits/visit-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("visitId") int theId, Model theModel) {
		
		Visit theVisit = visitService.findById(theId);
		
		theModel.addAttribute("visit", theVisit);
		
		return "visits/visit-form";
	}
	
	@PostMapping("/save")
	public String saveVisit (@ModelAttribute("visit") Visit theVisit) {
		
		visitService.save(theVisit);
		
		return "redirect:/visits/list";
	}
	
	@GetMapping("/delete")
	public String deleteVisit (@RequestParam("visitId") int theId) {
	
		visitService.deleteById(theId);
		
		return "redirect:/visits/list";
		
	}
	
}