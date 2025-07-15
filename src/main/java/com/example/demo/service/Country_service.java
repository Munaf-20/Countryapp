package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Country;
import com.example.demo.Repositiry.Repositiry;
import com.example.demo.contoller.Responsd;

@Service
public class Country_service {
	@Autowired
	Repositiry repo;
	
	public List<Country> getAllcountries() {
		return repo.findAll();
	}
	
	public Country getCountryByName(String countryName) {
		List<Country>countries = repo.findAll();
		Country country = null;
		for(Country con:countries) {
			if(con.getCountryName().equalsIgnoreCase(countryName))
				country=con;
		}
		return country;
			
	}
	
	public Country getCountryById(int id) {
		  return repo.findById(id).get();
	}
	
	public Country addCountry(Country country) {
		country.setId(getMaxid());
		repo.save(country);
		return country;
		
	}
	public int getMaxid() {
		return repo.findAll().size()+1;
		
	}
	public Country updateCountry(Country country) {
		repo.save(country);
		return country;	
	}
	
	public Responsd deleteCountry(int id) {
		repo.deleteById(id);
		Responsd res = new Responsd();
		res.setId(id);
		res.setMsg("country deleted");
		return res;
		
		
	}

}
