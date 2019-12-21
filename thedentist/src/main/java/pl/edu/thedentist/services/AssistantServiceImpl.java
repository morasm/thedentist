package pl.edu.thedentist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.thedentist.entity.Assistant;
import pl.edu.thedentist.repositories.AssistantRepository;

@Service
public class AssistantServiceImpl implements AssistantService {

	private AssistantRepository assistantRepository;
	
	@Autowired
	public AssistantServiceImpl(AssistantRepository theAssistantRepository) {
		assistantRepository = theAssistantRepository;
	}
	
	@Override
	public List<Assistant> findAll() {
		return assistantRepository.findAll();
	}

	@Override
	public Assistant findById(int theId) {
		Optional<Assistant> result = assistantRepository.findById(theId);
		Assistant theAssistant = null;
		if(result.isPresent()) {
			theAssistant = result.get();
		}
		else {
			throw new RuntimeException("ID " + theId + " not found.");
		}
		return theAssistant;
		
	}

	@Override
	public void save(Assistant theAssistant) {
		assistantRepository.save(theAssistant);

	}

	@Override
	public void deleteById(int theId) {
		assistantRepository.deleteById(theId);

	}

}
