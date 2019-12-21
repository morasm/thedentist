package pl.edu.thedentist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.edu.thedentist.entity.Dentist;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {

}
