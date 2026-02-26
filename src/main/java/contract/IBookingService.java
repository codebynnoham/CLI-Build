package contract;

import model.Booking;
import model.DateRange;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IBookingService {
    Booking createBooking(int customerId , String regNumber, DateRange period);

    void cancelBooking(int bookingId);

    boolean isCarAvailable(String registrationNumber, DateRange range);

    Optional<Booking> findBookingById(int bookingId);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByCustomer(int customerId);

    List<Booking> getBookingsByCar(String registrationNumber);

    BigDecimal calculateTotalPrice(int bookingId);

    //String printBookingSummary(int bookingId);

    //String toString(BigDecimal totalCost);
}

