package dledwith.logs;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "logs", schema = "logs")
public class Log {
	
	@ManyToOne
	private Logbook logbook;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "value")
	private double value;
	
	@Column(name = "log_date_time")
	private Date logDateTime;
	
	@PrePersist
	void logDateTime() {
		this.logDateTime = new Date(System.currentTimeMillis());
	}
	
	public Log(Logbook logbook, double value) {
		this.logbook = logbook;
		this.value = value;
	}
	
	protected Log() {} // Hibernate needs this.

	public Logbook getLogbook() {
		return logbook;
	}

	public void setLogbook(Logbook logbook) {
		this.logbook = logbook;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getLogDateTime() {
		return logDateTime;
	}

	public void setLogDateTime(Date logDateTime) {
		this.logDateTime = logDateTime;
	}
	
	

}
