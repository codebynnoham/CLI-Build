package model;

import exception.UnsupportedEngineTypeException;

import java.util.Objects;

public enum EngineType {
    PETROL,
    DIESEL,
    ELECTRIC,
    HYBRID,
    PLUG_IN_HYBRID;

    public static EngineType fromString(String engineType) {
        Objects.requireNonNull(engineType, "engineType cannot be null");
        return switch (engineType.trim().toUpperCase()) {
            case "PETROL", "PT" -> PETROL;
            case "DIESEL" , "D" -> DIESEL;
            case "ELECTRIC", "E" -> ELECTRIC;
            case "HYBRID", "H" -> HYBRID;
            case "PLUG_IN_HYBRID", "PL" -> PLUG_IN_HYBRID;
            default -> throw new UnsupportedEngineTypeException("The Engine Type " + engineType + " is not supported. " +
                    "Supported engine types are: PETROL, DIESEL, ELECTRIC, HYBRID, " +
                    "PLUG_IN_HYBRID (or PT/D/E/H/PL).");
        };
    };
}
