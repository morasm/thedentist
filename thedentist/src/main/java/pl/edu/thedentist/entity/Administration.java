package pl.edu.thedentist.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="administration")
public class Administration extends Worker{

	@Column(name="id_administration")
	private int idAdministration;
	
	@Column(name="occupation")
	private Date occupation;
	
	public Administration() {
		
	}

	public Administration(int idAdministration, Date occupation) {
		this.idAdministration = idAdministration;
		this.occupation = occupation;
	}

	public int getIdAdministration() {
		return idAdministration;
	}

	public void setIdAdministration(int idAdministration) {
		this.idAdministration = idAdministration;
	}

	public Date getOccupation() {
		return occupation;
	}

	public void setOccupation(Date occupation) {
		this.occupation = occupation;
	}

	@Override
	public String toString() {
		return "Administration [idAdministration=" + idAdministration + ", occupation=" + occupation + "]";
	}

}
