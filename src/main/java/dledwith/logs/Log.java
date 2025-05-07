package dledwith.logs;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

public class Log {
	
	@ManyToOne
	private Logbook logbook;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
