package pl.edu.thedentist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.edu.thedentist.entity.TestReport;

public interface TestReportRepository extends JpaRepository<TestReport, Integer> {
	
	public List<TestReport> findAllByOrderByTestReportIDAsc();

}
