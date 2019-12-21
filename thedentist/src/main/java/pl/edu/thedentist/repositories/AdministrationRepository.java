package pl.edu.thedentist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.edu.thedentist.entity.Administration;

public interface AdministrationRepository extends JpaRepository<Administration, Integer> {

}
