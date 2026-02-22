package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record DateRange(LocalDate startDate, LocalDate endDate) {
    public DateRange {
        if (startDate == null || endDate == null)
            throw new IllegalArgumentException("Start date and end date cannot be null");
        if (startDate.isAfter(endDate))
            throw new IllegalArgumentException("Start date cannot be after end date");
        if (endDate.isBefore(startDate))
            throw new IllegalArgumentException("End date cannot be before start date");
    }

    public boolean isOverlap(DateRange other) {
        return !(this.endDate.isBefore(other.startDate)
                || this.startDate.isAfter(other.endDate));
    }

    public int numberOfDays() {
        return (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
    }
}
