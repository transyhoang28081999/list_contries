package com.example.backend.services;

import java.util.List;

import com.example.backend.models.Country;

public interface CountryService {
    List<Country> getAllCountries();
    Country getSingleCountry(int id);
    Country createCountry(Country country);
    Country updateCountry(int id, Country country);
    void deleteCountry(int id);
}
