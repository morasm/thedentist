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
	@Column(name = "staffID", nullable = false)
	private int staffID;
	
	@NotNull
	@Column(name = "isVisitDone", nullable = false, columnDefinition = "boolean default false")
	private Boolean isVisitDone = false;
	
	@Column(name = "visitType")
	private int visitType;
	
	@NotNull
	@Column(name = "visitDataTime", nullable = false)
	private Date visitDataTime;
	
	@Column(name = "visitNotes")
	private String visitNotes;
	
	@OneToMany(mappedBy = "receipt")
	private List<Prescription> receipts;
	
	@OneToMany(mappedBy = "testReport")
	private List<TestReport> testReports;

	public Visit() {
		
	}

	public Visit(int visitID, @NotNull int patientID, @NotNull int dentistID, @NotNull int staffID,
			@NotNull Boolean isVisitDone, int visitType, @NotNull Date visitDataTime, String visitNotes,
			List<Prescription> receipts, List<TestReport> testReports) {
		this.visitID = visitID;
		this.patientID = patientID;
		this.dentistID = dentistID;
		this.staffID = staffID;
		this.isVisitDone = isVisitDone;
		this.visitType = visitType;
		this.visitDataTime = visitDataTime;
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

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
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

	public Date getVisitDataTime() {
		return visitDataTime;
	}

	public void setVisitDataTime(Date visitDataTime) {
		this.visitDataTime = visitDataTime;
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