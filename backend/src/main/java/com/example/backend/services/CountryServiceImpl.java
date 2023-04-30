package com.example.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.models.Country;
import com.example.backend.repositories.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getSingleCountry(int id) {
        Optional<Country> country = countryRepository.findById(id);
        if (country.isPresent()) return country.get();
        throw new RuntimeException();
    }

    @Override
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(int id, Country country) {
        country.setId(id);
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(int id) {
        countryRepository.deleteById(id);
        
    }
}
