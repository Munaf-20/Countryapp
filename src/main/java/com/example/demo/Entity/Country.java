package com.example.demo.Entity;

import org.springframework.context.annotation.ComponentScan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@ComponentScan
@Entity
@Table(name ="country_")
public class Country {
	
	@Id
	@Column(name="id")
	private int id;
	
    @Column(name="Capital")
	private String countryCapital;
    
    public String getCountryCapital() {
		return countryCapital;
	}

	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Column(name="Country_name")
	private String countryName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Country(int id, String countryCapital, String countryName) {
		super();
		this.id = id;
		this.countryCapital = countryCapital;
		this.countryName = countryName;
	}

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
