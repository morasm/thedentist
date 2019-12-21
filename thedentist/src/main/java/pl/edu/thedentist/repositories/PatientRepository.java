package pl.edu.thedentist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.edu.thedentist.entity.Patient;


public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
