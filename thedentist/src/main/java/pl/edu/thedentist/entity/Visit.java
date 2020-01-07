package pl.edu.thedentist.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity	
@Table(name = "visit")
public class Visit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "visitID")
	private int visitID;
	
	@NotNull
	@Column(name = "patientID", nullable = false)
	private int patientID;
	
	@NotNull
	@Column(name = "dentistID", nullable = false)
	private int dentistID;
	
	@NotNull
	@Column(name = "isVisitDone", nullable = false, columnDefinition = "boolean default false")
	private Boolean isVisitDone = false;
	
	@Column(name = "visitType")
	private int visitType;
	
	@NotNull
	@Column(name = "visitDateTime", nullable = false)
	private Date visitDateTime;
	
	@Column(name = "visitNotes")
	private String visitNotes;
	
	@OneToMany(mappedBy = "visitID")
	private List<Prescription> receipts;
	
	@OneToMany(mappedBy = "testReportID")
	private List<TestReport> testReports;

	public Visit() {
		
	}

	public Visit(int visitID, @NotNull int patientID, @NotNull int dentistID,
			@NotNull Boolean isVisitDone, int visitType, @NotNull Date visitDateTime, String visitNotes,
			List<Prescription> receipts, List<TestReport> testReports) {
		this.visitID = visitID;
		this.patientID = patientID;
		this.dentistID = dentistID;
		this.isVisitDone = isVisitDone;
		this.visitType = visitType;
		this.visitDateTime = visitDateTime;
		this.visitNotes = visitNotes;
		this.receipts = receipts;
		this.testReports = testReports;
	}

	public int getVisitID() {
		return visitID;
	}

	public void setVisitID(int visitID) {
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

	public Boolean getIsVisitDone() {
		return isVisitDone;
	}

	public void setIsVisitDone(Boolean isVisitDone) {
		this.isVisitDone = isVisitDone;
	}

	public int getVisitType() {
		return visitType;
	}

	public void setVisitType(int visitType) {
		this.visitType = visitType;
	}

	public Date getVisitDateTime() {
		return visitDateTime;
	}

	public void setVisitDateTime(Date visitDateTime) {
		this.visitDateTime = visitDateTime;
	}

	public String getVisitNotes() {
		return visitNotes;
	}

	public void setVisitNotes(String visitNotes) {
		this.visitNotes = visitNotes;
	}

	public List<Prescription> getReceipts() {
		return receipts;
	}

	public void setReceipts(List<Prescription> receipts) {
		this.receipts = receipts;
	}

	public List<TestReport> getTestReports() {
		return testReports;
	}

	public void setTestReports(List<TestReport> testReports) {
		this.testReports = testReports;
	}
	
}