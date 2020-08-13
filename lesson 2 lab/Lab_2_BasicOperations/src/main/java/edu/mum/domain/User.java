package edu.mum.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="users")
  public class User implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", nullable = false,length = 20, unique = true)
	private Long id = null;
	@Column(name = "FIRSTNAME", nullable = false)
     private String firstName;

	@Column(name = "LASTNAME", nullable = false)

     private String lastName;
	@Column(name = "EMAIL", nullable = false)

     private String email;

	@Column(name = "RATING", nullable = false)

     private int rating = 0;

	@Column(name = "IS_ADMIN", nullable = false)

	private boolean admin = false;
     
     @Version
	 @Column(name = "version" , nullable = false)
     private int version = 0;
	@Temporal(TemporalType.TIMESTAMP)
     private Date lastLogin;

	public User() {
	}

	public User(String firstName, String lastName, String email, int rating, boolean admin, int version) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.rating = rating;
		this.admin = admin;
		this.version = version;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

}