package pl.edu.thedentist.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pl.edu.thedentist.entity.Person;

/**
 * Class contains methods that allow to authenticate User.
 */
public class PersonPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Person person;
	
	public PersonPrincipal(Person person) {
		this.person = person;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		// Extract list of permissions (name)
		this.person.getPermissionList().forEach(p -> {
			GrantedAuthority authority = new SimpleGrantedAuthority(p);
			authorities.add(authority);
		});
		
		// Extract list of roles (ROLE_name)
		this.person.getRoleList().forEach(r -> {
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
			authorities.add(authority);
		});
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.person.getPassword();
	}

	@Override
	public String getUsername() {
		return this.person.getPesel();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
