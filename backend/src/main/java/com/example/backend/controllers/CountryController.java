package com.example.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.Country;
import com.example.backend.services.CountryService;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    // get all countries
    @GetMapping("")
    public ResponseEntity<List<Country>> getAllCountries(){
        return new ResponseEntity<List<Country>>(countryService.getAllCountries(), HttpStatus.OK);
    }
    // get single country
    @GetMapping("/{id}")
    public ResponseEntity<Country> getSingleCountry(@PathVariable int id){
        return new ResponseEntity<Country>(countryService.getSingleCountry(id), HttpStatus.OK);
    }
    // create a new country
    @PostMapping("")
    public ResponseEntity<Country> createCountry(@RequestBody Country country){
        return new ResponseEntity<Country>(countryService.createCountry(country), HttpStatus.CREATED);
    }
    // update an old country
    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable int id, @RequestBody Country country){
        return new ResponseEntity<Country>(countryService.updateCountry(id, country), HttpStatus.OK);
    }
    // delete a country
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCountry(@PathVariable int id){
        countryService.deleteCountry(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
