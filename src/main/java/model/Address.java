package model;

import static java.util.Objects.requireNonNull;

public record Address(String houseNumber, String streetName, String postalCode, String cityName) {
    public Address(String houseNumber, String streetName, String postalCode, String cityName) {
        this.houseNumber = requireNonNull(houseNumber, "House number cannot be null");
        this.streetName = requireNonNull(streetName, "Street name cannot be null");
        this.postalCode = requireNonNull(postalCode, "Postal code cannot be null");
        this.cityName = requireNonNull(cityName, "City name cannot be null");
    }

    @Override
    public String toString() {
        return String.format("""
                %s %s
                %s
                %s
                """, houseNumber, streetName, postalCode, cityName);
    }
}
