package pl.edu.thedentist.services;

import java.util.List;

import pl.edu.thedentist.entity.Administration;

public interface AdministrationService {

	public List<Administration> findAll();
	
	public Administration findById(int theId);
	
	public void save(Administration theEmployee);
	
	public void deleteById(int theId);
}
