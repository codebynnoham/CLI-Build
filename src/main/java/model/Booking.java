package model;

import service.BookingService;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.NumberFormat;
import java.util.Locale;

import static java.util.Objects.requireNonNull;

public class Booking {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final NumberFormat CF = NumberFormat.getCurrencyInstance(Locale.UK);
    private final int bookingId;
    private final DateRange period;
    private final Customer customer;
    private final Car car;

    public Booking(DateRange period, Customer customer, Car car) {
        this.bookingId = RANDOM.nextInt(100_000, 999_999);
        this.period = requireNonNull(period, "the period cannot be null");
        this.customer = requireNonNull(customer, "the customer cannot be null");
        this.car = requireNonNull(car, "the car cannot be null");
    }

    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public DateRange getPeriod() {
        return period;
    }

    private String message1() {
        return String.format("%s BOOKING SUMMARY %s", " ".repeat(25) , " ".repeat(25));
    }

    private String message2() {
        return String.format("%s CUSTOMER DETAILS %s", " ".repeat(25) , " ".repeat(25));
    }

    private String message3() {
        return String.format("%s CAR DETAILS %s", " ".repeat(25) , " ".repeat(25));
    }

    @Override
    public String toString() {
        return String.format("""
            %s
            Booking ID  : %d
            Start Date  : %s
            End Date    : %s
            %s
            %s
            %s
            %s""", message1(), bookingId, period.startDate(), period.endDate(), message2(), customer, message3(), car);
    }

    public String toString(BigDecimal totalCost) {
        return String.format("""
            %s
            Booking ID  : %d
            Start Date  : %s
            End Date    : %s
            Total Cost  : %s
            %s
            %s
            %s
            %s""", message1(), bookingId, period.startDate(), period.endDate(), CF.format(totalCost), message2(), customer, message3(), car);
    }
}


