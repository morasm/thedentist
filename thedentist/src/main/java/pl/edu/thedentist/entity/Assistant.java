package pl.edu.thedentist.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="assistant")
public class Assistant extends Worker{

	@Column(name="id_assistant")
	private int idAssistant;
	
	@Column(name="course_date")
	private Date courseDate;
	
	public Assistant() {
		
	}

	public Assistant(int idAssistant, Date courseDate) {
		this.idAssistant = idAssistant;
		this.courseDate = courseDate;
	}

	public int getIdAssistant() {
		return idAssistant;
	}

	public void setIdAssistant(int idAssistant) {
		this.idAssistant = idAssistant;
	}

	public Date getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(Date courseDate) {
		this.courseDate = courseDate;
	}

	@Override
	public String toString() {
		return "Assistant [idAssistant=" + idAssistant + ", courseDate=" + courseDate + "]";
	}

}
