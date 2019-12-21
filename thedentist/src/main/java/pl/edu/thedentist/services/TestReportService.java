package pl.edu.thedentist.services;

import java.util.List;

import pl.edu.thedentist.entity.TestReport;

public interface TestReportService {
	
	public List<TestReport> findAll();
	
	public TestReport findById(int theId);
	
	public void save(TestReport theTestReport);
	
	public void deleteById(int theId);

}
