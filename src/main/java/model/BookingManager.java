package model;

import contract.IBookingService;
import contract.ICarService;
import contract.ICustomerService;
import exception.CarNotAvailableException;
import exception.CarNotFoundException;
import exception.CustomerNotFoundException;
import exception.DuplicateCustomerException;
import exception.EndDatePrecedesStartDateException;
import exception.StartDateSucceedsEndDateException;
import exception.UnsupportedCategoryException;
import exception.UnsupportedEngineTypeException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;
import static java.util.Objects.requireNonNull;

public class BookingManager {
    private final IBookingService bookingService;
    private final ICarService carService;
    private final ICustomerService customerService;

    public BookingManager(IBookingService bookingService, ICarService carService, ICustomerService customerService) {
        this.bookingService = bookingService;
        this.carService = carService;
        this.customerService = customerService;
    }

    private void showMenu() {
        out.println(" ".repeat(30) + "\033[1m * * * * * *  Booking Services Manager Menu  * * * * * * \033[0m");
        out.println(" ".repeat(20) + "1.  Register a Booking");
        out.println(" ".repeat(20) + "2.  Register a Car");
        out.println(" ".repeat(20) + "3.  Register a Customer");
        out.println(" ".repeat(20) + "4.  View all Bookings");
        out.println(" ".repeat(20) + "5.  View all Cars");
        out.println(" ".repeat(20) + "6.  View all Customers");
        out.println(" ".repeat(20) + "7.  View all Bookings by Customer");
        out.println(" ".repeat(20) + "8.  View all Available Cars for a Date Range");
        out.println(" ".repeat(20) + "9.  View all Cars by Category");
        out.println(" ".repeat(20) + "10. View all Cars by Engine Type");
        out.println(" ".repeat(20) + "11. Exit");
        out.println();
        out.print(" ".repeat(25) + "\033[1mPlease enter the number that matches your choice:\033[0m ");
    }

    public void taskManagerMenu(Scanner scanner) throws InterruptedException {
        requireNonNull(scanner, "Scanner cannot be null");
        boolean exit = false;
        while (!exit) {
            showMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> registerBooking(scanner);
                case "2" -> registerCar(scanner);
                case "3" -> registerCustomer(scanner);
                case "4" -> getAllBookings(scanner);
                case "5" -> getAllCars(scanner);
                case "6" -> getAllCustomers(scanner);
                case "7" -> getBookingsByCustomerId(scanner);
                case "8" -> getAllAvailableCars(scanner);
                case "9" -> getAllCarsByCategory(scanner);
                case "10" -> getAllCarsByEngineType(scanner);
                case "11" -> exit = exitApplication();
                default -> invalidInput(scanner);
            }
        }
    }

    public void registerBooking(Scanner scanner) {
        requireNonNull(scanner, "Scanner cannot be null");
        try {
            out.print("Enter the Customer ID: ");
            int customerId = Integer.parseInt(scanner.nextLine().trim());
            out.println();
            out.print("Enter the Registration Number of the Car to Book: ");
            String regNumber = scanner.nextLine().trim();
            out.println();
            out.print("Enter Booking Start Date (yyyy-mm-dd): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine().trim());
            out.println();
            out.print("Enter Booking End Date (yyyy-mm-dd): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine().trim());
            DateRange period = new DateRange(startDate, endDate);
            Booking booking = bookingService.createBooking(customerId, regNumber, period);
            out.println();
            out.println("Booking successfully created:");
            out.println();
            out.println(booking);
        }  catch (NumberFormatException e) {
            err.println("Invalid number format. Please enter a valid numeric Customer ID.");
        } catch (DateTimeParseException e) {
            err.println("Invalid date format or date value. Please use yyyy-mm-dd.");
        } catch (CustomerNotFoundException | CarNotFoundException | CarNotAvailableException |
                 StartDateSucceedsEndDateException | EndDatePrecedesStartDateException  e ) {
            err.println(" ".repeat(10) + "Error: " + e.getMessage());
        }
        pause(scanner);
    }

    public void registerCar(Scanner scanner) {
        requireNonNull(scanner, "Scanner cannot be null");
        try{
            out.print("Enter Car Registration Number: ");
            String regNumber = scanner.nextLine().trim();
            out.println();
            out.print("Enter Car Brand: ");
            String brand = scanner.nextLine().trim();
            out.println();
            out.print("Enter Car Model: ");
            String model = scanner.nextLine().trim();
            out.println();
            out.print("Enter Year of Manufacture (yyyy): ");
            int yearOfManufacture = Integer.parseInt(scanner.nextLine().trim());
            out.println();
            out.print("Enter Car Category: ");
            Category category = Category.fromString(scanner.nextLine().trim());
            out.println();
            out.print("Enter Engine Type: ");
            EngineType engineType = EngineType.fromString(scanner.nextLine().trim());
            out.println();
            Car car = new Car(regNumber, brand, model, yearOfManufacture, category, engineType);
            carService.registerCar(car);
            out.println("Car successfully registered.");
        } catch (NumberFormatException e) {
            err.println("Invalid number format. Please enter a valid numeric year of manufacture.");
        } catch (UnsupportedCategoryException | UnsupportedEngineTypeException e) {
            err.println("Error: " + e.getMessage());
        }
        pause(scanner);
    }

    public void registerCustomer(Scanner scanner) {
        requireNonNull(scanner, "Scanner cannot be null");
        try {
            out.print("Enter Customer First Name: ");
            String firstName = scanner.nextLine().trim();
            out.println();
            out.print("Enter Customer Last Name: ");
            String lastName = scanner.nextLine().trim();
            out.println();
            out.print("Enter Customer Email: ");
            String email = scanner.nextLine().trim();
            out.println();
            out.print("Enter Customer Phone Number: ");
            String phoneNumber = scanner.nextLine().trim();
            out.println();
            out.print("Enter Customer House Number: ");
            String houseNumber = scanner.nextLine().trim();
            out.println();
            out.print("Enter customer Street Name: ");
            String streetName = scanner.nextLine().trim();
            out.println();
            out.print("Enter Customer Postal Code: ");
            String postalCode = scanner.nextLine().trim();
            out.println();
            out.print("Enter Customer City Name: ");
            String cityName = scanner.nextLine().trim();
            Address address = new Address(houseNumber, streetName, postalCode, cityName);
            Customer customer = new Customer(firstName, lastName, email, phoneNumber, address);
            customerService.registerCustomer(customer);
            out.println();
            out.println("Customer successfully registered.");
            out.println();
        } catch (DuplicateCustomerException e) {
            err.println("Error: " + e.getMessage());
        }
        pause(scanner);
    }

    public void getAllBookings(Scanner scanner) {
        out.println("**".repeat(20) + " Summary List of All Bookings " + "**".repeat(20));
        bookingService.getAllBookings().forEach(booking -> out.println(booking));
        out.println();
        pause(scanner);
    }

    public void getAllCars(Scanner scanner) {
        out.println("**".repeat(20) + " Summary List of All Cars " + "**".repeat(20));
        carService.getAllCars().forEach(car -> out.println(car));
        out.println();
        pause(scanner);
    }

    public void getAllCustomers(Scanner scanner) {
        out.println("**".repeat(20) + " Summary List of All Customers " + "**".repeat(20));
        customerService.getAllCustomers().forEach(customer -> out.println(customer));
        out.println();
        pause(scanner);
    }

    public void getBookingsByCustomerId(Scanner scanner) {
        requireNonNull(scanner, "Scanner cannot be null");
        try {
            out.print("Please Enter the Customer ID: ");
            int customerId = Integer.parseInt(scanner.nextLine().trim());
            customerService.findCustomerById(customerId)
                    .orElseThrow(() -> new CustomerNotFoundException("Customer with id " + customerId + " not found"));
            List<Booking> bookings = bookingService.getBookingsByCustomer(customerId);
            //BigDecimal totalCost = bookingService.calculateTotalPrice(customerId);
            out.println("**".repeat(20) + " Summary List of All Bookings by Customer with Id: " + customerId + "**".repeat(20));
            if (bookings.isEmpty()) {
                out.println(" ".repeat(15) + " No bookings found for customer with id " + customerId);
            } else {
                bookings.forEach(booking ->  {
                    BigDecimal totalCost = bookingService.calculateTotalPrice(booking.getBookingId());
                    out.println(booking.toString(totalCost));
                });
            }
        } catch (NumberFormatException e) {
            err.println("Invalid number format. Please enter a valid numeric Customer ID.");
        } catch (CustomerNotFoundException e) {
            err.println("Error: " + e.getMessage());
        }
        out.println();
        pause(scanner);
    }

    public void getAllAvailableCars(Scanner scanner) {
        requireNonNull(scanner, "Scanner cannot be null");
        try {
            out.print(" Please Enter Start Date (yyyy-mm-dd): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine().trim());
            out.println();
            out.print(" Please Enter End Date (yyyy-mm-dd): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine().trim());
            DateRange period = new DateRange(startDate, endDate);
            out.println("*".repeat(10) + " Summary List of Available Cars for the Period " + period.startDate() + " to " + period.endDate() + "*".repeat(10));
            carService.getAvailableCars(period).forEach(car -> out.println(car));
        } catch (DateTimeParseException e) {
            err.println("Invalid date format or date value. Please use yyyy-mm-dd.");
        } catch (CarNotAvailableException e) {
            err.println("Error: " + e.getMessage());
        }
        out.println();
        pause(scanner);
    }

    public void getAllCarsByCategory(Scanner scanner) {
        requireNonNull(scanner, "Scanner cannot be null");
        try {
            out.print("Please Enter the Category of Cars you want to view: ");
            Category category = Category.fromString(scanner.nextLine().trim());
            out.println("*".repeat(20) + " Summary List of Cars in the " + category + " Category " + "*".repeat(20));
            carService.getCarsByCategory(category).forEach(car -> out.println(car));
        } catch (UnsupportedCategoryException e) {
            err.println("Error: " + e.getMessage());
        }
        out.println();
        pause(scanner);
    }

    public void getAllCarsByEngineType(Scanner scanner) {
        requireNonNull(scanner, "Scanner cannot be null");
        try {
            out.print("Please Enter the Engine Type of Cars you want to view: ");
            EngineType engineType = EngineType.fromString(scanner.nextLine().trim());
            out.println("*".repeat(20) + " Summary List of " + engineType +  " Engine Type Cars " + "*".repeat(20));
            carService.getCarsByEngineType(engineType).forEach(car -> out.println(car));
        } catch (UnsupportedEngineTypeException e) {
            err.println("Error: " + e.getMessage());
        }
        out.println();
        pause(scanner);
    }

    private static boolean exitApplication() throws InterruptedException {
        out.println();
        out.println("Exiting the application...");
        Thread.sleep(3000);
        return true;
    }

    private void invalidInput(Scanner scanner) {
        out.println(" ".repeat(20) + "*".repeat(20) + " The number you entered is invalid. " + "*".repeat(20));
        out.println();
        pause(scanner);
    }

    private void pause(Scanner scanner) {
        out.print("".repeat(10) + ">>".repeat(10) + "Press the enter key to continue...");
        scanner.nextLine();
    }


}
