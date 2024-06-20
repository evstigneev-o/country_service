package ru.evstigneev.country.model;

import ru.evstigneev.country.data.CountryEntity;

public record Country(String name,
                      String code) {

    public static Country fromEntity(CountryEntity entity) {
        return new Country(
                entity.getName(),
                entity.getCode()
        );
    }
}
