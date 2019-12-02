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

import pl.edu.thedentist.entity.Visit;
import pl.edu.thedentist.services.VisitService;

@RestController
@RequestMapping("/api")
public class VisitRestController {
	
	@Autowired
	private VisitService visitService;
	
	// add mapping for GET /visits
	@GetMapping("/visits")
	public List<Visit> getVisits() {
		
		return visitService.findAll();
	}
	
	// add mapping for GET /visits/{visitID}
	@GetMapping("/visits/{visitID}")
	public Visit getVisit(@PathVariable int visitID) {
		
		Visit theVisit = visitService.findById(visitID);
		
		return theVisit;
	}
	
	// add mapping for POST /visits
	@PostMapping("/visits")
	public Visit addVisit(@RequestBody Visit theVisit) {
		
		visitService.save(theVisit);
		
		return theVisit;
	}
	
	// add mapping for PUT /visits - update an existing visit
	@PutMapping("/visits")
	public Visit updateVisit(@RequestBody Visit theVisit) {
		
		visitService.save(theVisit);
		
		return theVisit;
	}
	
	// add mapping for DELETE /visits/{visitID}
	@DeleteMapping("/visits/{visitID}")
	public String deleteVisit(@PathVariable int visitID) {
		
		visitService.deleteById(visitID);
		return "Deleted visit ID - " + visitID;
	}
	
}
