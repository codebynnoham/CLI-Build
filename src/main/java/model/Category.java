package model;

import exception.UnsupportedCategoryException;

import java.math.BigDecimal;
import java.util.Objects;

public enum Category {
    ECONOMY {
        @Override
        public BigDecimal getBaseCharge() {
            return new BigDecimal("50.00");
        }

        @Override
        public BigDecimal getDailyRate() {
            return new BigDecimal("300.00");
        }

        @Override
        public String getDescription() {
            return "Basic, fuel-efficient, affordable cars (e.g. Toyota Yaris, VW Polo).";
        }
    },

    COMPACT {
        @Override
        public BigDecimal getBaseCharge() {
            return new BigDecimal( "100.00");
        }

        @Override
        public BigDecimal getDailyRate() {
            return new BigDecimal("400.00");
        }

        @Override
        public String getDescription() {
            return "Small city cars, easy to manoeuvre (e.g. Ford Fiesta, Volvo V40).";
        }
    },

    STANDARD {
        @Override
        public BigDecimal getBaseCharge() {
            return new BigDecimal( "150.00");
        }

        @Override
        public BigDecimal getDailyRate() {
            return new BigDecimal("500.00");
        }

        @Override
        public String getDescription() {
            return "Midsize sedans or hatchbacks (e.g. Opel Vauxhaul, Volvo S60).";
        }
    },

    CROSSOVER {
        @Override
        public BigDecimal getBaseCharge() {
            return new BigDecimal( "200.00");
        }

        @Override
        public BigDecimal getDailyRate() {
            return new BigDecimal("650.00");
        }

        @Override
        public String getDescription() {
            return "Light SUV-like vehicles (e.g. Subaru Cross, Volvo V60).";
        }
    },

    SUV {
        @Override
        public BigDecimal getBaseCharge() {
            return new BigDecimal("350.00");
        }

        @Override
        public BigDecimal getDailyRate() {
            return new BigDecimal("850.00");
        }

        @Override
        public String getDescription() {
            return "Sport Utility Vehicles, higher driving position (e.g. BMW X5, Mercedes Benz GLE).";
        }
    },
    LUXURY {
        @Override
        public BigDecimal getBaseCharge() {
            return new BigDecimal("700.00");
        }

        @Override
        public BigDecimal getDailyRate() {
            return new BigDecimal("1000.00");
        }

        @Override
        public String getDescription() {
            return "Premium interior car with full option (e.g. Mercedes Benz S-class, BMW 7 series, Audi A8).";
        }
    },

    CONVERTIBLE {
        @Override
        public BigDecimal getBaseCharge() {
            return new BigDecimal("500.00");
        }

        @Override
        public BigDecimal getDailyRate() {
            return new BigDecimal("700.00");
        }

        @Override
        public String getDescription() {
            return "Open-top sports cars (e.g. Mazda MX-5, BMW Z4).";
        }
    },

    VAN {
        @Override
        public BigDecimal getBaseCharge() {
            return new BigDecimal("500.00");
        }

        @Override
        public BigDecimal getDailyRate() {
            return new BigDecimal("750.00");
        }

        @Override
        public String getDescription() {
            return "Cargo/passenger vans (e.g. Ford Transit, Peugeot Boxer).";
        }
    },

    PICKUP {
        @Override
        public BigDecimal getBaseCharge() {
            return new BigDecimal( "600.00");
        }

        @Override
        public BigDecimal getDailyRate() {
            return new BigDecimal("800.00");
        }

        @Override
        public String getDescription() {
            return "Trucks with rear bed (e.g. Ford Ranger, Toyota Hilux).";
        }
    },

    OFF_ROAD {
        @Override
        public BigDecimal getBaseCharge() {
            return new BigDecimal( "700.00");
        }

        @Override
        public BigDecimal getDailyRate() {
            return new BigDecimal( "950.00");
        }

        @Override
        public String getDescription() {
            return "Rugged, adventure vehicles (e.g. Ford 150, Jeep Wrangler).";
        }
    };

    public abstract BigDecimal getBaseCharge();
    public abstract BigDecimal getDailyRate();
    public abstract String getDescription();

    public static Category fromString(String category) {
        Objects.requireNonNull(category, "category cannot be null");
        return switch (category.trim().toUpperCase()) {
            case "ECONOMY", "E" -> ECONOMY;
            case "COMPACT", "C" -> COMPACT;
            case "STANDARD", "ST" -> STANDARD;
            case "CROSSOVER", "CO" -> CROSSOVER;
            case "SUV", "S" -> SUV;
            case "LUXURY", "L" -> LUXURY;
            case "CONVERTIBLE", "CT" -> CONVERTIBLE;
            case "VAN", "V" -> VAN;
            case "PICKUP", "P" -> PICKUP;
            case "OFF ROAD", "O" -> OFF_ROAD;
            default -> throw new UnsupportedCategoryException("The Category " + category + " is no supported. " +
                    "The supported categories are: ECONOMY, COMPACT, STANDARD, CROSSOVER, SUV, LUXURY, CONVERTIBLE, " +
                    "VAN, PICKUP, OFF ROAD (or E/C/ST/CO/S/L/CT/V/P/O).");
        };
    }
}
