package pl.edu.thedentist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.thedentist.entity.Prescription;
import pl.edu.thedentist.repositories.PrescriptionRepository;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
	
	private PrescriptionRepository prescriptionRepository;
	
	@Autowired
	public PrescriptionServiceImpl (PrescriptionRepository thePrescriptionRepository) {
		prescriptionRepository = thePrescriptionRepository;
	}

	@Override
	public List<Prescription> findAll() {
		return prescriptionRepository.findAllByOrderByPrescriptionIDAsc();
	}

	@Override
	public Prescription findById(int theId) {
		
		Optional <Prescription> result = prescriptionRepository.findById(theId);
		
		Prescription thePrescription = null;
		
		if (result.isPresent()) {
			thePrescription = result.get();
		}
		else {
			throw new RuntimeException("Did not find prescription ID - " + theId);
		}
		
		return thePrescription;
	}

	@Override
	public void save(Prescription thePrescription) {
		prescriptionRepository.save(thePrescription);
	}

	@Override
	public void deleteById(int theId) {
		prescriptionRepository.deleteById(theId);
	}

}
