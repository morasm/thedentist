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

import pl.edu.thedentist.entity.Assistant;
import pl.edu.thedentist.services.AssistantService;

@RestController
@RequestMapping("/api")
public class AssistantRestController {

	private AssistantService assistantService;
	
	@Autowired
	public AssistantRestController(AssistantService theAssistantService) {
		assistantService = theAssistantService;
	}
	
	@GetMapping("/worker/assistant")
	public List<Assistant> findAll(){
		return assistantService.findAll();
	}
	
	@GetMapping("/worker/assistant/{personId}")
	public Assistant getAssistant(@PathVariable int personId) {
		Assistant theAssistant = assistantService.findById(personId);
		
		if(theAssistant == null) {
			throw new RuntimeException("Person " + personId + " not found.");
		}
		
		return theAssistant;
		
	}
	
	@PostMapping("/worker/assistant")
	public Assistant addAssistant(@RequestBody Assistant theAssistant) {
		theAssistant.setPersonId(0);
		
		assistantService.save(theAssistant);
		
		return theAssistant;
	}
	
	@PutMapping("/worker/assistant")
	public Assistant updateAssistant(@RequestBody Assistant theAssistant) {
				
		assistantService.save(theAssistant);
		
		return theAssistant;
	}
	
	@DeleteMapping("/worker/assistant/{personId}")
	public String deleteAssistant(@PathVariable int personId) {
		Assistant theAssistant = assistantService.findById(personId);
		
		if(theAssistant == null) {
			throw new RuntimeException("Person " + personId + " not found.");
		}
		
		assistantService.deleteById(personId);
		return "Person " + personId + " deleted.";
		
	}
}
