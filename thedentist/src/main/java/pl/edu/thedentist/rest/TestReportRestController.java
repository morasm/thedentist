package pl.edu.thedentist.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.thedentist.entity.TestReport;
import pl.edu.thedentist.services.TestReportService;

@RestController
@RequestMapping("/api")
public class TestReportRestController {
	
	@Autowired
	private TestReportService testReportService;
	
	// add mapping for GET /test_reports
	@GetMapping("/test_reports")
	public List<TestReport> getTestReport() {
		
		return testReportService.findAll();
	}
	
	// add mapping for GET /test_reports/{testReportID}
	@GetMapping("/test_reports/{testReportID}")
	public TestReport getTestReport(@PathVariable int testReportID) {
		
		TestReport theTestReport = testReportService.findById(testReportID);
		
		return theTestReport;
	}
	
	// add mapping for POST /test_reports
	@PostMapping("/test_reports")
	public TestReport addTestReport(@RequestBody TestReport theTestReport) {
		
		testReportService.save(theTestReport);
		
		return theTestReport;
	}
	
	// add mapping for PUT /test_reports - update an existing test report
	@PutMapping("/test_reports")
	public TestReport updateTestReport(@RequestBody TestReport theTestReport) {
		
		testReportService.save(theTestReport);
		
		return theTestReport;
	}
	
	// add mapping for DELETE /test_reports/{testReportID}
	@DeleteMapping("/test_reports/{testReportID}")
	public String deleteTestReport(@PathVariable int testReportID) {
		
		testReportService.deleteById(testReportID);
		return "Deleted test report ID - " + testReportID;
	}
	
}
