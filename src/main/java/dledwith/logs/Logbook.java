package dledwith.logs;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

	@OneToMany(mappedBy = "logbook", cascade = CascadeType.PERSIST)
	@Column(name = "log")
	private ArrayList<Log> logs;

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

	public Logbook(User user, String name) {
		this.user = user;
		this.name = name;
	}

	// Hibernate needs no-arg
	protected Logbook() {
	}

}
