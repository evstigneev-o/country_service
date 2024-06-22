package ru.evstigneev.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    List<Country> allCountries() {
        return countryService.allCountries();
    }

    @PostMapping("/add")
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) {
        return countryService.getCountry(code);
    }

    @PatchMapping("/{code}/edit")
    public Country editCountry(@PathVariable String code, @RequestBody Country country) {
        return countryService.editCountry(code, country);
    }
}
