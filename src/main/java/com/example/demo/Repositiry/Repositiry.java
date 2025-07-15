package com.example.demo.Repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Country;


public interface Repositiry extends JpaRepository<Country, Integer>{

}
