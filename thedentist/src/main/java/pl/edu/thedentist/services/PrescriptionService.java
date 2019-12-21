package pl.edu.thedentist.services;

import java.util.List;

import pl.edu.thedentist.entity.Prescription;

public interface PrescriptionService {
	
	public List<Prescription> findAll();
	
	public Prescription findById(int theId);
	
	public void save(Prescription thePrescription);
	
	public void deleteById(int theId);

}
