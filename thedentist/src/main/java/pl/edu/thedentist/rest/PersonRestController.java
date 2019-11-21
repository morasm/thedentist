package pl.edu.thedentist.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.thedentist.entity.Person;
import pl.edu.thedentist.services.PersonService;

@RestController
@RequestMapping("/api")
public class PersonRestController {

	private PersonService personService;
	
	@Autowired
	public PersonRestController(PersonService thePersonService) {
		personService = thePersonService;
	}
	
	@GetMapping("/person")
	public List<Person> findAll(){
		return personService.findAll();
	}
	
	@GetMapping("/person/{personId}")
	public Person getPerson(@PathVariable int personId) {
		Person thePerson = personService.findById(personId);
		
		if(thePerson == null) {
			throw new RuntimeException("Person " + personId + " not found.");
		}
		
		return thePerson;
		
	}
	
	@PostMapping("/person")
	public Person addPerson(@RequestBody Person thePerson) {
		thePerson.setPersonId(0);
		
		personService.save(thePerson);
		
		return thePerson;
	}
	
	@PutMapping("/person")
	public Person updatePerson(@RequestBody Person thePerson) {
				
		personService.save(thePerson);
		
		return thePerson;
	}
	
	@DeleteMapping("/person/{personId}")
	public String deletePerson(@PathVariable int personId) {
		Person thePerson = personService.findById(personId);
		
		if(thePerson == null) {
			throw new RuntimeException("Person " + personId + " not found.");
		}
		
		personService.deleteById(personId);
		return "Person " + personId + " deleted.";
		
	}
}
