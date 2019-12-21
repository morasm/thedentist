package pl.edu.thedentist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.edu.thedentist.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
	
	public List<Prescription> findAllByOrderByPrescriptionIDAsc();

}
