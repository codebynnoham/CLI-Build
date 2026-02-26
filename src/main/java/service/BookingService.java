package service;

import contract.IBookingService;
import dao.BookingDAO;
import dao.CarDAO;
import dao.CustomerDAO;
import exception.BookingNotFoundException;
import exception.CarNotAvailableException;
import exception.CarNotFoundException;
import exception.CustomerNotFoundException;
import model.Booking;
import model.Car;
import model.Category;
import model.Customer;
import model.DateRange;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BookingService implements IBookingService {
    private final BookingDAO bookingDAO;
    private final CarDAO carDAO;
    private final CustomerDAO customerDAO;

    public BookingService(BookingDAO bookingDAO, CarDAO carDAO, CustomerDAO customerDAO) {
        this.bookingDAO = bookingDAO;
        this.carDAO = carDAO;
        this.customerDAO = customerDAO;
    }
    @Override
    public Booking createBooking(int customerId, String regNumber, DateRange range) {
        Customer customer = customerDAO.findByCustomerId(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("unable to complete booking, customer with id " + customerId + " not found"));
        Car car = carDAO.findByRegNumber(regNumber)
                .orElseThrow(() -> new CarNotFoundException("unable to complete booking, car with reg number " + regNumber + " not found"));
        if (!isCarAvailable(regNumber, range))
            throw new CarNotAvailableException("unable to complete booking, car with reg number " + regNumber +
                    " is not available for the period " + range.startDate() + " to " + range.endDate());

        Booking booking;
        do{
            booking = new Booking(range, customer, car);
        } while (bookingDAO.findByBookingId(booking.getBookingId()).isPresent());

        bookingDAO.addBooking(booking);
        return booking;
    }

    @Override
    public void cancelBooking(int bookingId) {
        if (!bookingDAO.removeBookingById(bookingId))
            throw new BookingNotFoundException("unable to cancel booking, booking with id " + bookingId + " not found");
    }

    @Override
    public boolean isCarAvailable(String registrationNumber, DateRange range) {
        List<Booking> bookings = getBookingsByCar(registrationNumber);
        for (Booking booking : bookings) {
            if (booking.getPeriod().isOverlap(range))
                return false;
        }
        return true;
    }

    @Override
    public Optional<Booking> findBookingById(int bookingId) {
        return bookingDAO.findByBookingId(bookingId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return List.copyOf(Arrays.asList(bookingDAO.getAllBookings()));
    }

    @Override
    public List<Booking> getBookingsByCustomer(int customerId) {
        return bookingDAO.findBookingsByCustomer(customerId);
    }

    @Override
    public List<Booking> getBookingsByCar(String registrationNumber) {
        return bookingDAO.findBookingsByCar(registrationNumber);
    }

    @Override
    public BigDecimal calculateTotalPrice(int bookingId) {
        Booking booking = findBookingById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("booking with id " + bookingId + " not found"));
        Category category = booking.getCar().category();
        BigDecimal baseCharge = category.getBaseCharge();
        BigDecimal dailyRate = category.getDailyRate();
        BigDecimal days = BigDecimal.valueOf(booking.getPeriod().numberOfDays());
        return baseCharge.add(dailyRate.multiply(days));
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
    public String printBookingSummary(int bookingId) {
        Booking booking = findBookingById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking with Id " + bookingId + " not found"));

        BigDecimal totalCost = calculateTotalPrice(bookingId);

        return String.format("""
            %s
            Booking ID  : %d
            Start Date  : %s
            End Date    : %s
            Total Cost  : %s
            %s
            %s
            %s
            %s
            """,
                message1(),
                booking.getBookingId(),
                booking.getPeriod().startDate(),
                booking.getPeriod().endDate(),
                totalCost,
                message2(),
                booking.getCustomer(),
                message3(),
                booking.getCar()
        );
    }
}


