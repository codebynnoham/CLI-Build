package contract;

import model.Booking;
import model.DateRange;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    Booking createBooking(int customerId,
                          String registrationNumber,
                          DateRange range);

    boolean cancelBooking(int bookingId);

    boolean isCarAvailable(String registrationNumber, DateRange range);

    Optional<Booking> findBookingById(int bookingId);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByCustomer(int customerId);

    List<Booking> getBookingsByCar(String registrationNumber);
}
