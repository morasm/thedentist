package pl.edu.thedentist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.thedentist.entity.TestReport;
import pl.edu.thedentist.services.TestReportService;

@Controller
@RequestMapping("/test_reports")
public class TestReportController {
	
	@Autowired
	private TestReportService testReportService;
	
	public TestReportController(TestReportService theTestReportService) {
		testReportService = theTestReportService;
	}
	
	@GetMapping("/list")
	public String listTestReports(Model theModel) {
		
		List<TestReport> theTestReports = testReportService.findAll();
		
		theModel.addAttribute("testReports", theTestReports);
		
		return "test_reports/list-test_reports";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		TestReport theTestReport = new TestReport();
		
		theModel.addAttribute("testReport", theTestReport);
		
		return "test_reports/test_report-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("testReportId") int theId, Model theModel) {
		
		TestReport theTestReport = testReportService.findById(theId);
		
		theModel.addAttribute("testReport", theTestReport);
		
		return "test_reports/test_report-form";
	}
	
	@PostMapping("/save")
	public String saveTestReport (@ModelAttribute("testReport") TestReport theTestReport) {
		
		testReportService.save(theTestReport);
		
		return "redirect:/test_reports/list";
	}
	
	@GetMapping("/delete")
	public String deleteTestReport (@RequestParam("testReportId") int theId) {
	
		testReportService.deleteById(theId);
		
		return "redirect:/test_reports/list";
		
	}
	
}
