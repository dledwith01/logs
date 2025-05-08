package dledwith.logs;

import java.util.ArrayList;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
	
	public Logbook(User user, String name) {
		this.user = user;
		this.name = name;
	}
	
	// Hibernate needs no-arg
	protected Logbook() {}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Log> getLog() {
		return logs;
	}

	public void setLog(ArrayList<Log> log) {
		this.logs = log;
	}
	
	public void addLog(Log log) {
		this.logs.add(log);
	}
	
	public void removelog(Log log) {
		this.logs.remove(log);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
