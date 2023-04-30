package com.example.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.models.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{
    
}
