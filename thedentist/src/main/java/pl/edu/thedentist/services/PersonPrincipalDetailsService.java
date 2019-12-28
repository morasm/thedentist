package pl.edu.thedentist.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.edu.thedentist.configuration.PersonPrincipal;
import pl.edu.thedentist.entity.Person;
import pl.edu.thedentist.repositories.PersonRepository;

@Service
public class PersonPrincipalDetailsService implements UserDetailsService {

	private PersonRepository personRepository;
	
	public PersonPrincipalDetailsService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person person = this.personRepository.findByPesel(username);
		PersonPrincipal personPrincipal = new PersonPrincipal(person);
		
		return personPrincipal;
	}
	
	

}
