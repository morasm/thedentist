package pl.edu.thedentist.services;

import java.util.List;

import pl.edu.thedentist.entity.Person;

public interface PersonService {

public List<Person> findAll();
	
	public Person findById(int theId);
	
	public void save(Person theEmployee);
	
	public void deleteById(int theId);
}
