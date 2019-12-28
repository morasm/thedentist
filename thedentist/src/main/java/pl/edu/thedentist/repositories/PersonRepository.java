package pl.edu.thedentist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.edu.thedentist.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	Person findByPesel(String pesel);
	
}
