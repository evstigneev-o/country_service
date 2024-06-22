package ru.evstigneev.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.evstigneev.country.data.CountryEntity;
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

    public List<Country> allCountries() {
        return countryRepository.findAll()
                .stream()
                .map(Country::fromEntity)
                .toList();
    }

    public Country addCountry(Country country) {
        return Country.fromEntity(countryRepository.save(CountryEntity.fromJson(country)));
    }

    public Country getCountry(String countryCode) {
        return Country.fromEntity(countryRepository.findCountryEntityByCode(countryCode));
    }

    public Country editCountry(String code, Country country) {
        CountryEntity countryEntity = countryRepository.findCountryEntityByCode(code);
        countryEntity.setName(country.name());
        return Country.fromEntity(countryRepository.save(countryEntity));
    }
}
