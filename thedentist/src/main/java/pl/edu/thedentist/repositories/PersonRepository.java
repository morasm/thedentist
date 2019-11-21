package pl.edu.thedentist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.edu.thedentist.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
