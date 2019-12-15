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

import pl.edu.thedentist.entity.Dentist;
import pl.edu.thedentist.services.DentistService;

@RestController
@RequestMapping("/api")
public class DentistRestController {

	private DentistService dentistService;
	
	@Autowired
	public DentistRestController(DentistService theDentistService) {
		dentistService = theDentistService;
	}
	
	@GetMapping("/worker/dentist")
	public List<Dentist> findAll(){
		return dentistService.findAll();
	}
	
	@GetMapping("/worker/dentist/{personId}")
	public Dentist getDentist(@PathVariable int personId) {
		Dentist theDentist = dentistService.findById(personId);
		
		if(theDentist == null) {
			throw new RuntimeException("Person " + personId + " not found.");
		}
		
		return theDentist;
		
	}
	
	@PostMapping("/worker/dentist")
	public Dentist addDentist(@RequestBody Dentist theDentist) {
		theDentist.setPersonId(0);
		
		dentistService.save(theDentist);
		
		return theDentist;
	}
	
	@PutMapping("/worker/dentist")
	public Dentist updateDentist(@RequestBody Dentist theDentist) {
				
		dentistService.save(theDentist);
		
		return theDentist;
	}
	
	@DeleteMapping("/worker/dentist/{personId}")
	public String deleteDentist(@PathVariable int personId) {
		Dentist theDentist = dentistService.findById(personId);
		
		if(theDentist == null) {
			throw new RuntimeException("Person " + personId + " not found.");
		}
		
		dentistService.deleteById(personId);
		return "Person " + personId + " deleted.";
		
	}
}
