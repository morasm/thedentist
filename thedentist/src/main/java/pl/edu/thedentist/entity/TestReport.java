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
@Table(name = "testReport")
public class TestReport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "testReporttID")
	private int testReportID;
	
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
	@Column(name = "testID", nullable = false)
	private int testID;
	
	@Column(name = "testReportNotes")
	private String testReportNotes;

	public TestReport() {
		
	}

	public TestReport(int testReportID, Visit visitID, @NotNull int patientID, @NotNull int dentistID,
			@NotNull int testID, String testReportNotes) {
		this.testReportID = testReportID;
		this.visitID = visitID;
		this.patientID = patientID;
		this.dentistID = dentistID;
		this.testID = testID;
		this.testReportNotes = testReportNotes;
	}

	public int getTestReportID() {
		return testReportID;
	}

	public void setTestReportID(int testReportID) {
		this.testReportID = testReportID;
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

	public int getTestID() {
		return testID;
	}

	public void setTestID(int testID) {
		this.testID = testID;
	}

	public String getTestReportNotes() {
		return testReportNotes;
	}

	public void setTestReportNotes(String testReportNotes) {
		this.testReportNotes = testReportNotes;
	}
	
}