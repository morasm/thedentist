package pl.edu.thedentist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="patient")
public class Patient extends Person{
	
	@Column(name="patientID")
	private int patientId;
	
	@Column(name="discount")
	private int discount;
	
	public Patient() {
		}

	public Patient(int patientId, int discount) {
		this.patientId = patientId;
		this.discount = discount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", discount=" + discount + "]";
	}

	
}

