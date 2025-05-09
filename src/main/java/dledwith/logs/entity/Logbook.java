package dledwith.logs.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

/**
 * Defines a Logbook object.
 */
@Entity
@Table(name = "logbooks", schema = "logs")
public class Logbook {

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "logbook", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "log")
	private List<Log> logs = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "createDateTime")
	private LocalDateTime createDateTime;

	@PrePersist
	void logDateTime() {
		this.createDateTime = LocalDateTime.now();
	}

	/**
	 * A Logbook is created with a reference to a user and the logbook's name
	 * 
	 * @param user referenced user
	 * @param name user provided
	 */
	public Logbook(User user, String name) {
		this.user = user;
		this.name = name;
	}

	/**
	 * No argument constructor for Hibernate.
	 */
	protected Logbook() {
	}

	public int getId() {
		return this.id;
	}

	public List<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}
}
