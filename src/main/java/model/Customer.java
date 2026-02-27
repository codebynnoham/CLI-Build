package model;

import java.security.SecureRandom;

import static java.util.Objects.requireNonNull;

public class Customer {
    private final static SecureRandom RANDOM = new SecureRandom();

    private final int customerId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final Address address;
    //private final Booking[] booking;

    public Customer(String firstName, String lastName, String email, String phoneNumber, Address address) {
        this.customerId = RANDOM.nextInt(100_000, 1_000_000);
        this.firstName = requireNonNull(firstName, "the first name cannot be null");
        this.lastName = requireNonNull(lastName, "the last name cannot be null");
        this.email = requireNonNull(email, "the email cannot be null");
        this.phoneNumber = requireNonNull(phoneNumber, "the phone number cannot be null");
        this.address = requireNonNull(address, "the address cannot be null");
        //this.booking = new Booking[10];
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

//    public Booking[] getBooking() {
//        return booking;
//    }

    public String toString() {
        return String.format("""
                Customer ID: %d
                Name       : %s %s
                Email      : %s
                Phone      : %s
                Address    : %s %s
                             %s
                             %s
                """, customerId, firstName, lastName, email, phoneNumber, address.houseNumber(),
                address.streetName(), address.postalCode(), address.cityName());
    }
}
