package edu.mum.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private Long id;

 	private String street;
	private String city;	
 	private String state;
  	private String zipCode;

  // this field [memberId] needs to reflect the name of the FK in Address Table in DB
  	public Long memberId;
  	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	// No setter as this is the FK & JPA sets it  
	public Long getMemberId() {
		return memberId;
	}

}