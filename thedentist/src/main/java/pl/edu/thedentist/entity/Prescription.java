package pl.edu.thedentist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity	
@Table(name = "prescription")
public class Prescription {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "prescriptionID")
	private int prescriptionID;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "visit")
	private Visit visitID;
	
	@NotNull
	@Column(name = "patientID", nullable = false)
	private int patientID;
	
	@NotNull
	@Column(name = "dentistID", nullable = false)
	private int dentistID;
	
	@NotNull
	@Column(name = "medicineID", nullable = false)
	private int medicineID;
	
	@Column(name = "receiptNotes")
	private String receiptNotes;

	public Prescription() {
		
	}

	public Prescription(int prescriptionID, Visit visitID, @NotNull int patientID, @NotNull int dentistID,
			@NotNull int medicineID, String receiptNotes) {
		this.prescriptionID = prescriptionID;
		this.visitID = visitID;
		this.patientID = patientID;
		this.dentistID = dentistID;
		this.medicineID = medicineID;
		this.receiptNotes = receiptNotes;
	}

	public int getprescriptionID() {
		return prescriptionID;
	}

	public void setprescriptionID(int prescriptionID) {
		this.prescriptionID = prescriptionID;
	}

	public Visit getVisitID() {
		return visitID;
	}

	public void setVisitID(Visit visitID) {
		this.visitID = visitID;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public int getDentistID() {
		return dentistID;
	}

	public void setDentistID(int dentistID) {
		this.dentistID = dentistID;
	}

	public int getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(int medicineID) {
		this.medicineID = medicineID;
	}

	public String getReceiptNotes() {
		return receiptNotes;
	}

	public void setReceiptNotes(String receiptNotes) {
		this.receiptNotes = receiptNotes;
	}
	
}