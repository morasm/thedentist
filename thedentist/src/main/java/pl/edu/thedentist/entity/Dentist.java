package pl.edu.thedentist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dentist")
public class Dentist extends Worker{

	@Column(name="medical_license")
	private int medicalLicense;
	
	@Column(name="speciality")
	private String speciality;
	
	public Dentist() {
		
	}

	public Dentist(int medicalLicense, String speciality) {
		this.medicalLicense = medicalLicense;
		this.speciality = speciality;
	}

	public int getMedicalLicense() {
		return medicalLicense;
	}

	public void setMedicalLicense(int medicalLicense) {
		this.medicalLicense = medicalLicense;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "Dentist [medicalLicense=" + medicalLicense + ", speciality=" + speciality + "]";
	}
	
	
}
