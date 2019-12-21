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

import pl.edu.thedentist.entity.Worker;
import pl.edu.thedentist.services.WorkerService;

@RestController
@RequestMapping("/api")
public class WorkerRestController {

	private WorkerService workerService;
	
	@Autowired
	public WorkerRestController(WorkerService theWorkerService) {
		workerService = theWorkerService;
	}
	
	@GetMapping("/worker")
	public List<Worker> findAll(){
		return workerService.findAll();
	}
	
	@GetMapping("/worker/{personId}")
	public Worker getWorker(@PathVariable int personId) {
		Worker theWorker = workerService.findById(personId);
		
		if(theWorker == null) {
			throw new RuntimeException("Person " + personId + " not found.");
		}
		
		return theWorker;
		
	}
	
	@PostMapping("/worker")
	public Worker addWorker(@RequestBody Worker theWorker) {
		theWorker.setPersonId(0);
		
		workerService.save(theWorker);
		
		return theWorker;
	}
	
	@PutMapping("/worker")
	public Worker updateWorker(@RequestBody Worker theWorker) {
				
		workerService.save(theWorker);
		
		return theWorker;
	}
	
	@DeleteMapping("/worker/{personId}")
	public String deleteWorker(@PathVariable int personId) {
		Worker theWorker = workerService.findById(personId);
		
		if(theWorker == null) {
			throw new RuntimeException("Person " + personId + " not found.");
		}
		
		workerService.deleteById(personId);
		return "Person " + personId + " deleted.";
		
	}
}
