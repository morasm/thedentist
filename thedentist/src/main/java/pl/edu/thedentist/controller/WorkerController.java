package pl.edu.thedentist.controller;

import javax.persistence.PersistenceException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ch.qos.logback.classic.Logger;
import groovy.util.logging.Log;
import groovyjarjarpicocli.CommandLine.ParameterException;
import pl.edu.thedentist.entity.Worker;
import pl.edu.thedentist.services.WorkerService;

@Controller
public class WorkerController {
	
//	int tmp = 0;
	@Autowired
	WorkerService workerService;
	
	@GetMapping("/addWorkerForm")
	public String showAddWorkerForm(Model theModel) {
		theModel.addAttribute("addWorker", new Worker());
		Worker lastWorker = workerService.findFirstOrderByWorkerId();
		int tmp = lastWorker.getWorkerId() + 1;
		lastWorker.setWorkerId(tmp);
		theModel.addAttribute("addWorkerId", lastWorker);
		return "add-worker-form";
	}
	
	@PostMapping("/addWorkerForm")
	public String submitAddWorkerForm(@ModelAttribute Worker addWorker) {
		
		
		try {
//		addWorker.setWorkerId(tmp);
		workerService.save(addWorker);
		}catch(PersistenceException e){
			System.out.println("Exception");
		}
		return TemplatesNames.HOME_PAGE;
	}

}
