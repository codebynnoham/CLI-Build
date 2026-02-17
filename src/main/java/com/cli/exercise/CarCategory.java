package com.cli.exercise;

import java.math.BigDecimal;

public enum CarCategory {
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

//    ELECTRIC {
//        @Override
//        public BigDecimal getBaseCharge() {
//            return new BigDecimal("300.00");
//        }
//
//        @Override
//        public BigDecimal getDailyRate() {
//            return new BigDecimal("800.00");
//        }
//
//        @Override
//        public String getDescription() {
//            return "Electric vehicles (e.g. Tesla Model S, Polestar 3, BYD Atto 3).";
//        }
//    },
//
//    HYBRID {
//        @Override
//        public BigDecimal getBaseCharge() {
//            return new BigDecimal("350.00");
//        }
//
//        @Override
//        public BigDecimal getDailyRate() {
//            return new BigDecimal("700.00");
//        }
//
//        @Override
//        public String getDescription() {
//            return "Fuel + electric cars (e.g. Ford Fusion, Hyundai i20, Volvo V40).";
//        }
//    },

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
}
