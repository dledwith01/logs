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

/**
 * Defines a Log object.
 */
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

	/**
	 * A Log is created with a reference to a logbook and the value to be logged.
	 * 
	 * @param logbook referenced logbook
	 * @param value   user provided
	 */
	public Log(Logbook logbook, double value) {
		this.logbook = logbook;
		this.value = value;
	}

	/**
	 * No argument constructor for Hibernate.
	 */
	protected Log() {
	}

	public int getId() {
		return this.id;
	}
}
