package pl.edu.thedentist.services;

import java.util.List;

import pl.edu.thedentist.entity.Dentist;

public interface DentistService {

public List<Dentist> findAll();
	
	public Dentist findById(int theId);
	
	public void save(Dentist theEmployee);
	
	public void deleteById(int theId);
}
