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

import pl.edu.thedentist.entity.Prescription;
import pl.edu.thedentist.services.PrescriptionService;

@RestController
@RequestMapping("/api")
public class PrescriptionRestController {
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	// add mapping for GET /prescriptions
	@GetMapping("/prescriptions")
	public List<Prescription> getPrescriptions() {
		
		return prescriptionService.findAll();
	}
	
	// add mapping for GET /prescriptions/{prescriptionID}
	@GetMapping("/prescriptions/{prescriptionID}")
	public Prescription getPrescription(@PathVariable int prescriptionID) {
		
		Prescription thePrescription = prescriptionService.findById(prescriptionID);
		
		return thePrescription;
	}
	
	// add mapping for POST /prescriptions
	@PostMapping("/prescriptions")
	public Prescription addPrescription(@RequestBody Prescription thePrescription) {
		
		prescriptionService.save(thePrescription);
		
		return thePrescription;
	}
	
	// add mapping for PUT /prescriptions - update an existing prescription
	@PutMapping("/prescriptions")
	public Prescription updatePrescription(@RequestBody Prescription thePrescription) {
		
		prescriptionService.save(thePrescription);
		
		return thePrescription;
	}
	
	// add mapping for DELETE /prescriptions/{prescriptionID}
	@DeleteMapping("/prescriptions/{prescriptionID}")
	public String deletePrescription(@PathVariable int prescriptionID) {
		
		prescriptionService.deleteById(prescriptionID);
		return "Deleted prescription ID - " + prescriptionID;
	}
	
}
