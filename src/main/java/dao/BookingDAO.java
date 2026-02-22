package dao;

import model.Booking;
import model.Car;
import model.Customer;

import java.time.LocalDate;
import java.util.Arrays;

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
}
