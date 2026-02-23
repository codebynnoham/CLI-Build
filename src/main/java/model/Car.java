package model;

import java.time.LocalDate;

import static java.util.Objects.requireNonNull;

public record Car(String registrationNumber, String brand, String model, int yearOfManufacture, Category category,
                  EngineType engineType) {
    public Car(String registrationNumber, String brand, String model, int yearOfManufacture, Category category, EngineType engineType) {
        this.registrationNumber = requireNonNull(registrationNumber, "The registration number cannot be null");
        this.brand = requireNonNull(brand, "The car brand cannot be null");
        this.model = requireNonNull(model, "The car model cannot be null");
        this.yearOfManufacture = Math.min(yearOfManufacture, LocalDate.now().getYear());
        this.category = requireNonNull(category, "The car category cannot be null");
        this.engineType = requireNonNull(engineType, "The engine type cannot be null");
    }

    @Override
    public String toString() {
        return String.format("""
                        Reg number  : %s
                        Brand       : %s
                        Year Model  : %d %s
                        Category    : %s
                        Description : %s
                        Engine type : %s
                        """,
                registrationNumber,
                brand,
                yearOfManufacture,
                model,
                category,
                category.getDescription(),
                engineType);
    }
}
