import contract.IBookingService;
import contract.ICarService;
import contract.ICustomerService;
import dao.BookingDAO;
import dao.CarDAO;
import dao.CustomerDAO;
import model.BookingManager;
import model.DataInitializer;
import service.BookingService;
import service.CarService;
import service.CustomerService;

import static java.lang.System.in;



void main() {
    final Scanner scanner = new Scanner(in);

    CarDAO carDAO = new CarDAO(50);
    CustomerDAO customerDAO = new CustomerDAO(50);
    BookingDAO bookingDAO = new BookingDAO(50);
    DataInitializer dataInitializer = new DataInitializer(carDAO, customerDAO, bookingDAO);
    dataInitializer.initializeData();

    IBookingService bookingService = new BookingService(bookingDAO, carDAO, customerDAO);
    ICarService carService = new CarService(carDAO, bookingService);
    ICustomerService customerService = new CustomerService(customerDAO);

    BookingManager bookingManager = new BookingManager(bookingService, carService, customerService);
    try {
        bookingManager.taskManagerMenu(scanner);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

    scanner.close();
}









