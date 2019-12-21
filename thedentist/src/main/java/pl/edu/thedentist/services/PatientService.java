package pl.edu.thedentist.services;

import java.util.List;

import pl.edu.thedentist.entity.Patient;

public interface PatientService {

public List<Patient> findAll();
	
	public Patient findById(int theId);
	
	public void save(Patient theEmployee);
	
	public void deleteById(int theId);
}
