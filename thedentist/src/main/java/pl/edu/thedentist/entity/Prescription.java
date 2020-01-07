package pl.edu.thedentist.entity;

import java.sql.Date;

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
	@Column(name="dateOfIssue", nullable = false)
	private Date dateOfIssue;
	
	@NotNull
	@Column(name="expirationDate", nullable = false)
	private Date expirationDate;
	
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

	public Prescription(int prescriptionID, Visit visitID, @NotNull Date dateOfIssue, @NotNull Date expirationDate,
			@NotNull int patientID, @NotNull int dentistID, @NotNull int medicineID, String receiptNotes) {
		this.prescriptionID = prescriptionID;
		this.visitID = visitID;
		this.dateOfIssue = dateOfIssue;
		this.expirationDate = expirationDate;
		this.patientID = patientID;
		this.dentistID = dentistID;
		this.medicineID = medicineID;
		this.receiptNotes = receiptNotes;
	}

	public int getPrescriptionID() {
		return prescriptionID;
	}

	public void setPrescriptionID(int prescriptionID) {
		this.prescriptionID = prescriptionID;
	}

	public Visit getVisitID() {
		return visitID;
	}

	public void setVisitID(Visit visitID) {
		this.visitID = visitID;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
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