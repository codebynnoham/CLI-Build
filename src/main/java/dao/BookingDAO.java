package dao;

import model.Booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BookingDAO {
    private Booking[] bookingDB;
    private int index;

    public BookingDAO(int initialCapacity) {
        bookingDB = new Booking[Math.max(initialCapacity, 1)];
        index = 0;
    }

    public void addBooking(Booking booking) {
        if (index == bookingDB.length)
            resize();
        bookingDB[index++] = booking;
    }

    private void resize() {
        bookingDB = Arrays.copyOf(bookingDB, bookingDB.length * 2);
    }

    public Booking[] getAllBookings() {
        return Arrays.copyOf(bookingDB, index);
    }

    public Optional<Booking> findByBookingId(int bookingId) {
        for (int i = 0; i < index; i++) {
            Booking booking = bookingDB[i];
            if (booking.getBookingId() == bookingId)
                return Optional.of(booking);
        }
        return Optional.empty();
    }

    public List<Booking> findBookingsByCar(String regNumber) {
        List<Booking> bookingsByCar = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            Booking booking = bookingDB[i];
            if (booking.getCar().registrationNumber().equalsIgnoreCase(regNumber))
                bookingsByCar.add(booking);
        }
        return List.copyOf(bookingsByCar);
    }

    public boolean removeBookingById(int bookingId) {
        for (int i = 0; i < index; i++) {
            Booking booking = bookingDB[i];
            if (booking.getBookingId() == bookingId) {
                for (int j = i; j < index - 1; j++) {
                    bookingDB[j] = bookingDB[j + 1];
                }
                bookingDB[index - 1] = null;
                index--;
                return true;
            }
        }
        return false;
    }

    public List<Booking> findBookingsByCustomer(int customerId) {
        List<Booking> aCustomerBookings = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            Booking booking = bookingDB[i];
            if (booking.getCustomer().getCustomerId() == customerId)
                aCustomerBookings.add(booking);
        }
        return aCustomerBookings.isEmpty()
                ? List.of()
                : List.copyOf(aCustomerBookings);
    }
}

