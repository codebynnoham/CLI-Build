import dao.BookingDAO;
import dao.CarDAO;
import dao.CustomerDAO;
import model.Booking;
import model.Car;
import model.Customer;
import model.DataInitializer;

void main() {

    CarDAO carDAO = new CarDAO(50);

    CustomerDAO customerDAO = new CustomerDAO(50);

    BookingDAO bookingDAO = new BookingDAO(50);

    DataInitializer dataInitializer = new DataInitializer(carDAO, customerDAO, bookingDAO);
    dataInitializer.initializeData();

    System.out.println("* ".repeat(20) + "Car Inventory" + " *".repeat(20));
    for (Car car : carDAO.getAllCars()) {
        System.out.println(car);
    }
    System.out.println();

    System.out.println("* ".repeat(20) + "Customer Database" + " *".repeat(20));
    for (Customer customer : customerDAO.getAllCustomers()) {
        System.out.println(customer);
    }
    System.out.println();

    System.out.println("* ".repeat(20) + "Bookings" + " *".repeat(20));
    for (Booking booking : bookingDAO.getAllBookings()) {
        System.out.println(booking);
    }


}








