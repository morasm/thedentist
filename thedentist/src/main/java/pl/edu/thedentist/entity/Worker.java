package pl.edu.thedentist.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="worker")
public class Worker extends Person{
	
	@Column(name="workerID")
	private int workerId;
	
	@Column(name="salary")
	private float salary;
	
	@Column(name="date_of_employment")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfEmployment;
	
	public Worker() {
	}

	public Worker(int workerId, float salary, Date dateOfEmployment) {
		this.workerId = workerId;
		this.salary = salary;
		this.dateOfEmployment = dateOfEmployment;
	}

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}

	@Override
	public String toString() {
		return "Worker [workerId=" + workerId + ", salary=" + salary + ", dateOfEmployment=" + dateOfEmployment + "]";
	}

}
