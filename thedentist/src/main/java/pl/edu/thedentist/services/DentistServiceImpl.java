package pl.edu.thedentist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.thedentist.entity.Dentist;
import pl.edu.thedentist.repositories.DentistRepository;

@Service
public class DentistServiceImpl implements DentistService {

	private DentistRepository dentistRepository;
	
	@Autowired
	public DentistServiceImpl(DentistRepository theDentistRepository) {
		dentistRepository = theDentistRepository;
	}
	
	@Override
	public List<Dentist> findAll() {
		return dentistRepository.findAll();
	}

	@Override
	public Dentist findById(int theId) {
		Optional<Dentist> result = dentistRepository.findById(theId);
		Dentist theDentist = null;
		if(result.isPresent()) {
			theDentist = result.get();
		}
		else {
			throw new RuntimeException("ID " + theId + " not found.");
		}
		return theDentist;
		
	}

	@Override
	public void save(Dentist theDentist) {
		dentistRepository.save(theDentist);

	}

	@Override
	public void deleteById(int theId) {
		dentistRepository.deleteById(theId);

	}

}
