package dledwith.logs;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "logs", schema = "logs")
public class Log {
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "logbook_id")
	private Logbook logbook;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "value")
	private double value;
	
	@Column(name = "log_date_time")
	private LocalDateTime logDateTime;
	
	@PrePersist
	void logDateTime() {
		this.logDateTime = LocalDateTime.now();
	}
	
	public Log(Logbook logbook, double value) {
		this.logbook = logbook;
		this.value = value;
	}
	
	// Hibernate needs no-arg
	protected Log() {}

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

	public LocalDateTime getLogDateTime() {
		return logDateTime;
	}

	public void setLogDateTime(LocalDateTime logDateTime) {
		this.logDateTime = logDateTime;
	}
	
}
