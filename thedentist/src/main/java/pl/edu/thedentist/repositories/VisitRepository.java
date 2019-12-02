package pl.edu.thedentist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.edu.thedentist.entity.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
	
	public List<Visit> findAllByOrderByVisitIDAsc();

}
