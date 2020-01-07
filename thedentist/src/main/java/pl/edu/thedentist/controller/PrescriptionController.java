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

import pl.edu.thedentist.entity.Prescription;
import pl.edu.thedentist.services.PrescriptionService;

@Controller
@RequestMapping("/prescriptions")
public class PrescriptionController {
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	public PrescriptionController(PrescriptionService thePrescriptionService) {
		prescriptionService = thePrescriptionService;
	}
	
	@GetMapping("/list")
	public String listPrescriptions(Model theModel) {
		
		List<Prescription> thePrescriptions = prescriptionService.findAll();
		
		theModel.addAttribute("prescriptions", thePrescriptions);
		
		return "prescriptions/list-prescriptions";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Prescription thePrescription = new Prescription();
		
		theModel.addAttribute("prescription", thePrescription);
		
		return "prescriptions/prescription-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("prescriptionId") int theId, Model theModel) {
		
		Prescription thePrescription = prescriptionService.findById(theId);
		
		theModel.addAttribute("prescription", thePrescription);
		
		return "prescriptions/prescription-form";
	}
	
	@PostMapping("/save")
	public String savePrescription (@ModelAttribute("prescription") Prescription thePrescription) {
		
		prescriptionService.save(thePrescription);
		
		return "redirect:/prescriptions/list";
	}
	
	@GetMapping("/delete")
	public String deletePrescription (@RequestParam("prescriptionId") int theId) {
	
		prescriptionService.deleteById(theId);
		
		return "redirect:/prescriptions/list";
		
	}
	
}
