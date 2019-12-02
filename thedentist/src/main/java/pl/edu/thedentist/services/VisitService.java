package pl.edu.thedentist.services;

import java.util.List;

import pl.edu.thedentist.entity.Visit;

public interface VisitService {
	
	public List<Visit> findAll();
	
	public Visit findById(int theId);
	
	public void save(Visit theVisit);
	
	public void deleteById(int theId);

}
