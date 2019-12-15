package pl.edu.thedentist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.thedentist.entity.Patient;
import pl.edu.thedentist.repositories.PatientRepository;


@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository patientRepository;
	
	@Autowired
	public PatientServiceImpl(PatientRepository thePatientRepository) {
		patientRepository = thePatientRepository;
	}
	
	@Override
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	@Override
	public Patient findById(int theId) {
		Optional<Patient> result = patientRepository.findById(theId);
		Patient thePatient = null;
		if(result.isPresent()) {
			thePatient = result.get();
		}
		else {
			throw new RuntimeException("ID " + theId + " not found.");
		}
		return thePatient;
		
	}

	@Override
	public void save(Patient thePatient) {
		patientRepository.save(thePatient);

	}

	@Override
	public void deleteById(int theId) {
		patientRepository.deleteById(theId);

	}

}
