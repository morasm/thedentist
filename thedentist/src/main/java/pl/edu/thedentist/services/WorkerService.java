package pl.edu.thedentist.services;

import java.util.List;

import pl.edu.thedentist.entity.Worker;

public interface WorkerService {

public List<Worker> findAll();
	
	public Worker findById(int theId);
	
	public void save(Worker theEmployee);
	
	public void deleteById(int theId);
}
