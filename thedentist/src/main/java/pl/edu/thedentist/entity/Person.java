package pl.edu.thedentist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="person_id", updatable = false, nullable = false)
	private int personId;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="pesel")
	private String pesel;
	
	@Column(name="address_city")
	private String addressCity;
	
	@Column(name="address_street")
	private String addressStreet;
	
	@Column(name="address_number")
	private String addressNumber;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@Column(name="password")
	private String password;

//	@OneToOne
//	@JoinColumn(name="patient_id")
//	private Patient patient;
//	
//	@OneToOne
//	@JoinColumn(name="worker_id")
//	private Worker worker;
	
	public Person() {
	}

	public Person(int personId, String lastName, String firstName, String pesel, String addressCity,
			String addressStreet, String addressNumber, String phoneNumber, String emailAddress, String password) {
		this.personId = personId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.pesel = pesel;
		this.addressCity = addressCity;
		this.addressStreet = addressStreet;
		this.addressNumber = addressNumber;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", lastName=" + lastName + ", firstName=" + firstName + ", pesel="
				+ pesel + ", addressCity=" + addressCity + ", addressStreet=" + addressStreet + ", addressNumber="
				+ addressNumber + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + "]";
	}

	
}
