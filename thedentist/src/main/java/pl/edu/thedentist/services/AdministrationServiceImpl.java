package pl.edu.thedentist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.thedentist.entity.Administration;
import pl.edu.thedentist.repositories.AdministrationRepository;

@Service
public class AdministrationServiceImpl implements AdministrationService {

	private AdministrationRepository administrationRepository;
	
	@Autowired
	public AdministrationServiceImpl(AdministrationRepository theAdministrationRepository) {
		administrationRepository = theAdministrationRepository;
	}
	
	@Override
	public List<Administration> findAll() {
		return administrationRepository.findAll();
	}

	@Override
	public Administration findById(int theId) {
		Optional<Administration> result = administrationRepository.findById(theId);
		Administration theAdministration = null;
		if(result.isPresent()) {
			theAdministration = result.get();
		}
		else {
			throw new RuntimeException("ID " + theId + " not found.");
		}
		return theAdministration;
		
	}

	@Override
	public void save(Administration theAdministration) {
		administrationRepository.save(theAdministration);

	}

	@Override
	public void deleteById(int theId) {
		administrationRepository.deleteById(theId);

	}

}
