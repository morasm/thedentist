package pl.edu.thedentist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.edu.thedentist.entity.Worker;
import pl.edu.thedentist.services.WorkerService;

@Controller
public class WorkerController {
	
	@Autowired
	WorkerService workerService;
	
	@GetMapping("/addWorkerForm")
	public String showAddWorkerForm(Model theModel) {
		theModel.addAttribute("addWorker", new Worker());
		return "add-worker-form";
	}
	
	@PostMapping("/addWorkerForm")
	public String submitAddWorkerForm(@ModelAttribute Worker addWorker) {
		workerService.save(addWorker);
		
		return TemplatesNames.HOME_PAGE;
	}

}
