package pl.edu.thedentist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.thedentist.entity.TestReport;
import pl.edu.thedentist.repositories.TestReportRepository;

@Service
public class TestReportServiceImpl implements TestReportService {
	
	private TestReportRepository testReportRepository;
	
	@Autowired
	public TestReportServiceImpl (TestReportRepository theTestReportRepository) {
		testReportRepository = theTestReportRepository;
	}

	@Override
	public List<TestReport> findAll() {
		return testReportRepository.findAllByOrderByTestReportIDAsc();
	}

	@Override
	public TestReport findById(int theId) {
		
		Optional <TestReport> result = testReportRepository.findById(theId);
		
		TestReport theTestReport = null;
		
		if (result.isPresent()) {
			theTestReport = result.get();
		}
		else {
			throw new RuntimeException("Did not find test report ID - " + theId);
		}
		
		return theTestReport;
	}

	@Override
	public void save(TestReport theTestReport) {
		testReportRepository.save(theTestReport);
	}

	@Override
	public void deleteById(int theId) {
		testReportRepository.deleteById(theId);
	}

}
