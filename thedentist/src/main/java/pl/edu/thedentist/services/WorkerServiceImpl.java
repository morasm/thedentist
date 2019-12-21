package pl.edu.thedentist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.thedentist.entity.Worker;
import pl.edu.thedentist.repositories.WorkerRepository;

@Service
public class WorkerServiceImpl implements WorkerService {

	private WorkerRepository workerRepository;
	
	@Autowired
	public WorkerServiceImpl(WorkerRepository theWorkerRepository) {
		workerRepository = theWorkerRepository;
	}
	
	@Override
	public List<Worker> findAll() {
		return workerRepository.findAll();
	}

	@Override
	public Worker findById(int theId) {
		Optional<Worker> result = workerRepository.findById(theId);
		Worker theWorker = null;
		if(result.isPresent()) {
			theWorker = result.get();
		}
		else {
			throw new RuntimeException("ID " + theId + " not found.");
		}
		return theWorker;
		
	}

	@Override
	public void save(Worker theWorker) {
		workerRepository.save(theWorker);

	}

	@Override
	public void deleteById(int theId) {
		workerRepository.deleteById(theId);

	}

}
