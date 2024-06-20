package ru.evstigneev.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evstigneev.country.model.Country;
import ru.evstigneev.country.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    List<Country> allCountries(){
        return  countryService.allCountries();

    }
}
