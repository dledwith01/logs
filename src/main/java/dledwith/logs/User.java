package dledwith.logs;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

/**
 * Defines a User object.
 */
@Entity
@Table(name = "users", schema = "logs")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", nullable = false, unique = true)
	private String userName;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password_hash", nullable = false)
	private String hashedPassword;

	@Column(name = "createDateTime")
	private LocalDateTime createDateTime;

	@PrePersist
	private void logDateTime() {
		this.createDateTime = LocalDateTime.now();
	}

	public User(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.hashedPassword = Utilities.hashString(password);
	}

	/**
	 * No argument constructor for Hibernate.
	 */
	protected User() {
	}

}
