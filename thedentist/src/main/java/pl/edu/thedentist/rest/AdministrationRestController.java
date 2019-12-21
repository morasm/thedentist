package pl.edu.thedentist.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.thedentist.entity.Administration;
import pl.edu.thedentist.services.AdministrationService;

@RestController
@RequestMapping("/api")
public class AdministrationRestController {

	private AdministrationService administrationService;
	
	@Autowired
	public AdministrationRestController(AdministrationService theAdministrationService) {
		administrationService = theAdministrationService;
	}
	
	@GetMapping("/worker/administration")
	public List<Administration> findAll(){
		return administrationService.findAll();
	}
	
	@GetMapping("/worker/administration/{personId}")
	public Administration getAdministration(@PathVariable int personId) {
		Administration theAdministration = administrationService.findById(personId);
		
		if(theAdministration == null) {
			throw new RuntimeException("Person " + personId + " not found.");
		}
		
		return theAdministration;
		
	}
	
	@PostMapping("/worker/administration")
	public Administration addAdministration(@RequestBody Administration theAdministration) {
		theAdministration.setPersonId(0);
		
		administrationService.save(theAdministration);
		
		return theAdministration;
	}
	
	@PutMapping("/worker/administration")
	public Administration updateAdministration(@RequestBody Administration theAdministration) {
				
		administrationService.save(theAdministration);
		
		return theAdministration;
	}
	
	@DeleteMapping("/worker/administration/{personId}")
	public String deleteAdministration(@PathVariable int personId) {
		Administration theAdministration = administrationService.findById(personId);
		
		if(theAdministration == null) {
			throw new RuntimeException("Person " + personId + " not found.");
		}
		
		administrationService.deleteById(personId);
		return "Person " + personId + " deleted.";
		
	}
}
