package pl.edu.thedentist.services;

import java.util.List;

import pl.edu.thedentist.entity.Assistant;

public interface AssistantService {

	public List<Assistant> findAll();
	
	public Assistant findById(int theId);
	
	public void save(Assistant theEmployee);
	
	public void deleteById(int theId);
}
