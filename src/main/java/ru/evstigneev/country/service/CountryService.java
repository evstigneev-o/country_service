package ru.evstigneev.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.evstigneev.country.data.CountryRepository;
import ru.evstigneev.country.model.Country;

import java.util.List;

@Component
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> allCountries(){
        return countryRepository.findAll()
                .stream()
                .map(Country::fromEntity)
                .toList();
    }
}
