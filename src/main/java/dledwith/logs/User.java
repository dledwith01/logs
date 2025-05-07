package dledwith.logs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Defines a User object
 */
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String userName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password_hash", nullable = false)
	private String hashedPassword;
	
	
	public User(String userName, String password) {
		this.userName = userName;
		this.hashedPassword = Utilities.hashString(password);
		System.out.println(this.userName + ": " + this.hashedPassword);
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

}
