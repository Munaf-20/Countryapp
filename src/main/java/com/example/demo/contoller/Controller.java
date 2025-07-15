package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Country;
import com.example.demo.service.Country_service;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Controller {
	
	@Autowired
	Country_service conserve;
	
	@GetMapping("/Allcountries")
	public List<Country> getAllcountries() {
		return conserve.getAllcountries();
	}
	
    @GetMapping("/countryById/{id}")
    public Country getCountryBy(@PathVariable("id") int id) {
    	 return conserve.getCountryById(id);
    }
    
    @GetMapping("/CountryByName/countryName")
    public Country getCountryByName(@RequestParam("name")String countryName) {
    	Country country=conserve.getCountryByName(countryName);
    	return country;
    }
    
    @PostMapping("/addCountry")
    public Country addcountry(@RequestBody Country country) {
    	return conserve.addCountry(country);
    }
    
    @PutMapping("/updateCountry/{id}")
    public Country updateCountry(@PathVariable("id")int id , @RequestBody Country country) {
        Country existcountry=conserve.getCountryById(id);
        existcountry.setCountryName(country.getCountryName());
        existcountry.setCountryCapital(country.getCountryCapital());
        Country updatecountry=conserve.updateCountry(existcountry);
        return updatecountry;
    }
    
    @DeleteMapping("/DeleteCountry/{id}")
    public Responsd DeleteCountry(@PathVariable("id")int id) {
    	return conserve.deleteCountry(id);
    	
    }

}
