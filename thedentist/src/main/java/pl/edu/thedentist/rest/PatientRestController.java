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

import pl.edu.thedentist.entity.Patient;
import pl.edu.thedentist.services.PatientService;

@RestController
@RequestMapping("/api")
public class PatientRestController {

	private PatientService patientService;
	
	@Autowired
	public PatientRestController(PatientService thePatientService) {
		patientService = thePatientService;
	}
	
	@GetMapping("/patient")
	public List<Patient> findAll(){
		return patientService.findAll();
	}
	
	@GetMapping("/patient/{personId}")
	public Patient getPatient(@PathVariable int personId) {
		Patient thePatient = patientService.findById(personId);
		
		if(thePatient == null) {
			throw new RuntimeException("Person " + personId + " not found.");
		}
		
		return thePatient;
		
	}
	
	@PostMapping("/patient")
	public Patient addPatient(@RequestBody Patient thePatient) {
		thePatient.setPersonId(0);
		
		patientService.save(thePatient);
		
		return thePatient;
	}
	
	@PutMapping("/patient")
	public Patient updatePatient(@RequestBody Patient thePatient) {
				
		patientService.save(thePatient);
		
		return thePatient;
	}
	
	@DeleteMapping("/patient/{personId}")
	public String deletePatient(@PathVariable int personId) {
		Patient thePatient = patientService.findById(personId);
		
		if(thePatient == null) {
			throw new RuntimeException("Person " + personId + " not found.");
		}
		
		patientService.deleteById(personId);
		return "Person " + personId + " deleted.";
		
	}
}
