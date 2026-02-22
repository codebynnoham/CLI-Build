package model;

import dao.BookingDAO;
import dao.CarDAO;
import dao.CustomerDAO;

import java.time.LocalDate;

public class DataInitializer {
    private final CarDAO carDAO;
    private final CustomerDAO customerDAO;
    private final BookingDAO bookingDAO;

    public DataInitializer(CarDAO carDAO, CustomerDAO customerDAO, BookingDAO bookingDAO) {
        this.carDAO = carDAO;
        this.customerDAO = customerDAO;
        this.bookingDAO = bookingDAO;
    }

    public void initializeData() {
        carInventory();
        customerInventory();
        bookingInventory();
    }

    private void carInventory() {
        carDAO.addCar(new Car("HYB212", "Toyota", "Corolla Hybrid", 2022, Category.COMPACT, EngineType.HYBRID));
        carDAO.addCar(new Car("HYB313", "Honda", "CR-V Hybrid", 2023, Category.SUV, EngineType.HYBRID));
        carDAO.addCar(new Car("HYB414", "Ford", "Kuga Hybrid", 2024, Category.CROSSOVER, EngineType.HYBRID));
        carDAO.addCar(new Car("ABC123", "Toyota", "Yaris", 2020, Category.ECONOMY, EngineType.PETROL));
        carDAO.addCar(new Car("DEF456", "Volkswagen", "Polo", 2019, Category.ECONOMY, EngineType.DIESEL));
        carDAO.addCar(new Car("GHI789", "Ford", "Fiesta", 2021, Category.COMPACT, EngineType.PETROL));
        carDAO.addCar(new Car("JKL321", "Volvo", "V40", 2018, Category.COMPACT, EngineType.DIESEL));
        carDAO.addCar(new Car("MNO654", "Opel", "Astra", 2022, Category.STANDARD, EngineType.HYBRID));
        carDAO.addCar(new Car("PQR987", "Volvo", "S60", 2020, Category.STANDARD, EngineType.PETROL));
        carDAO.addCar(new Car("STU111", "Subaru", "Cross", 2021, Category.CROSSOVER, EngineType.PETROL));
        carDAO.addCar(new Car("VWX222", "Volvo", "V60", 2023, Category.CROSSOVER, EngineType.PLUG_IN_HYBRID));
        carDAO.addCar(new Car("YZA333", "BMW", "X5", 2022, Category.SUV, EngineType.DIESEL));
        carDAO.addCar(new Car("BCD444", "Mercedes", "GLE", 2023, Category.SUV, EngineType.HYBRID));
        carDAO.addCar(new Car("EFG555", "Mercedes", "S-Class", 2024, Category.LUXURY, EngineType.PLUG_IN_HYBRID));
        carDAO.addCar(new Car("HIJ666", "BMW", "7 Series", 2022, Category.LUXURY, EngineType.DIESEL));
        carDAO.addCar(new Car("KLM777", "Audi", "A8", 2021, Category.LUXURY, EngineType.PETROL));
        carDAO.addCar(new Car("NOP888", "Mazda", "MX-5", 2020, Category.CONVERTIBLE, EngineType.PETROL));
        carDAO.addCar(new Car("QRS999", "BMW", "Z4", 2023, Category.CONVERTIBLE, EngineType.PETROL));
        carDAO.addCar(new Car("TUV101", "Ford", "Transit", 2019, Category.VAN, EngineType.DIESEL));
        carDAO.addCar(new Car("ELE606", "Tesla", "Model 3", 2023, Category.STANDARD, EngineType.ELECTRIC));
        carDAO.addCar(new Car("ELE707", "Tesla", "Model Y", 2024, Category.SUV, EngineType.ELECTRIC));
        carDAO.addCar(new Car("ELE808", "Nissan", "Leaf", 2022, Category.ECONOMY, EngineType.ELECTRIC));
        carDAO.addCar(new Car("ELE909", "Hyundai", "Kona Electric", 2023, Category.CROSSOVER, EngineType.ELECTRIC));
        carDAO.addCar(new Car("ELE010", "Volkswagen", "ID.4", 2024, Category.SUV, EngineType.ELECTRIC));
        carDAO.addCar(new Car("ELE111", "BMW", "i4", 2023, Category.LUXURY, EngineType.ELECTRIC));
        carDAO.addCar(new Car("WXY202", "Peugeot", "Boxer", 2021, Category.VAN, EngineType.DIESEL));
        carDAO.addCar(new Car("ZAB303", "Ford", "Ranger", 2022, Category.PICKUP, EngineType.DIESEL));
        carDAO.addCar(new Car("CDE404", "Toyota", "Hilux", 2023, Category.PICKUP, EngineType.PETROL));
        carDAO.addCar(new Car("FGH505", "Jeep", "Wrangler", 2024, Category.OFF_ROAD, EngineType.PETROL));
        carDAO.addCar(new Car("PHE515", "Volvo", "XC60 Recharge", 2024, Category.SUV, EngineType.PLUG_IN_HYBRID));
        carDAO.addCar(new Car("PHE616", "BMW", "530e", 2023, Category.STANDARD, EngineType.PLUG_IN_HYBRID));
        carDAO.addCar(new Car("PHE717", "Mercedes", "C300e", 2024, Category.STANDARD, EngineType.PLUG_IN_HYBRID));

    }

    private void customerInventory() {
        customerDAO.addCustomer(new Customer("Alice", "Johnson", "alice.johnson@email.com", "0701234567",
                new Address("12A", "Birch Street", "41101", "Gothenburg")));

        customerDAO.addCustomer(new Customer("Brian", "Smith", "brian.smith@email.com", "0702345678",
                new Address("45B", "Oak Avenue", "41102", "Gothenburg")));

        customerDAO.addCustomer(new Customer("Clara", "Adams", "clara.adams@email.com", "0703456789",
                new Address("78", "Pine Road", "41234", "Mölndal")));

        customerDAO.addCustomer(new Customer("Daniel", "Moore", "daniel.moore@email.com", "0704567890",
                new Address("9C", "Maple Lane", "41345", "Partille")));

        customerDAO.addCustomer(new Customer("Emma", "Clark", "emma.clark@email.com", "0705678901",
                new Address("101", "Cedar Drive", "41456", "Lerum")));

        customerDAO.addCustomer(new Customer("Frank", "Miller", "frank.miller@email.com", "0706789012",
                new Address("22D", "Elm Street", "41567", "Kungsbacka")));

        customerDAO.addCustomer(new Customer("Grace", "Walker", "grace.walker@email.com", "0707890123",
                new Address("34", "Willow Way", "41678", "Gothenburg")));

        customerDAO.addCustomer(new Customer("Henry", "White", "henry.white@email.com", "0708901234",
                new Address("56E", "Aspen Court", "41789", "Kungälv")));

        customerDAO.addCustomer(new Customer("Isabella", "Green", "isabella.green@email.com", "0709012345",
                new Address("78F", "Poplar Street", "41890", "Gothenburg")));

        customerDAO.addCustomer(new Customer("Jack", "Hall", "jack.hall@email.com", "0710123456",
                new Address("90", "Spruce Boulevard", "41901", "Alingsås")));

        customerDAO.addCustomer(new Customer("Karen", "Young", "karen.young@email.com", "0711234567",
                new Address("11A", "Chestnut Road", "42112", "Gothenburg")));

        customerDAO.addCustomer(new Customer("Liam", "King", "liam.king@email.com", "0712345678",
                new Address("23B", "Magnolia Street", "42223", "Mölndal")));

        customerDAO.addCustomer(new Customer("Mia", "Scott", "mia.scott@email.com", "0713456789",
                new Address("35C", "Hazel Avenue", "42334", "Partille")));

        customerDAO.addCustomer(new Customer("Noah", "Turner", "noah.turner@email.com", "0714567890",
                new Address("47D", "Juniper Way", "42445", "Lerum")));

        customerDAO.addCustomer(new Customer("Olivia", "Phillips", "olivia.phillips@email.com", "0715678901",
                new Address("59E", "Sycamore Drive", "42556", "Kungsbacka")));

        customerDAO.addCustomer(new Customer("Paul", "Campbell", "paul.campbell@email.com", "0716789012",
                new Address("61", "Hawthorn Lane", "42667", "Kungälv")));

        customerDAO.addCustomer(new Customer("Quinn", "Parker", "quinn.parker@email.com", "0717890123",
                new Address("73A", "Redwood Street", "42778", "Gothenburg")));

        customerDAO.addCustomer(new Customer("Rachel", "Evans", "rachel.evans@email.com", "0718901234",
                new Address("85B", "Sequoia Road", "42889", "Alingsås")));

        customerDAO.addCustomer(new Customer("Samuel", "Edwards", "samuel.edwards@email.com", "0719012345",
                new Address("97C", "Birchwood Avenue", "42990", "Mölndal")));

        customerDAO.addCustomer(new Customer("Tina", "Collins", "tina.collins@email.com", "0720123456",
                new Address("109", "Oakwood Drive", "43001", "Gothenburg")));
    }

    private void bookingInventory() {
        Car[] carsArray = carDAO.getAllCars();
        Customer[] customersArray = customerDAO.getAllCustomers();

        bookingDAO.addBooking(new Booking(
                new DateRange(
                    LocalDate.of(2025, 5, 1),
                    LocalDate.of(2025, 5, 5)
                ),
                customersArray[0],
                carsArray[0]
        ));
        bookingDAO.addBooking(new Booking(
                new DateRange(
                    LocalDate.of(2025, 5, 6),
                    LocalDate.of(2025, 5, 10)
                ),
                customersArray[1],
                carsArray[1]
        ));
        bookingDAO.addBooking(new Booking(
                new DateRange(
                    LocalDate.of(2025, 6, 1),
                    LocalDate.of(2025, 6, 3)
                ),
                customersArray[2],
                carsArray[2]
        ));
        bookingDAO.addBooking(new Booking(
                new DateRange(
                    LocalDate.of(2025, 6, 5),
                    LocalDate.of(2025, 6, 12)
                ),
                customersArray[3],
                carsArray[3]
        ));
        bookingDAO.addBooking(new Booking(
                new DateRange(
                    LocalDate.of(2025, 7, 1),
                    LocalDate.of(2025, 7, 7)
                ),
                customersArray[4],
                carsArray[4]
        ));
        bookingDAO.addBooking(new Booking(
                new DateRange(
                    LocalDate.of(2025, 7, 10),
                    LocalDate.of(2025, 7, 15)
                ),
                customersArray[5],
                carsArray[5]
        ));
        bookingDAO.addBooking(new Booking(
                new DateRange(
                    LocalDate.of(2025, 8, 1),
                    LocalDate.of(2025, 8, 4)
                ),
                customersArray[6],
                carsArray[6]
        ));
        bookingDAO.addBooking(new Booking(
                new DateRange(
                    LocalDate.of(2025, 8, 6),
                    LocalDate.of(2025, 8, 9)
                ),
                customersArray[7],
                carsArray[7]
        ));
        bookingDAO.addBooking(new Booking(
                new DateRange(
                    LocalDate.of(2025, 9, 1),
                    LocalDate.of(2025, 9, 5)
                ),
                customersArray[8],
                carsArray[8]
        ));
        bookingDAO.addBooking(new Booking(
                new DateRange(
                    LocalDate.of(2025, 9, 7),
                    LocalDate.of(2025, 9, 12)
                ),
                customersArray[9],
                carsArray[9]
        ));
        bookingDAO.addBooking(new Booking(
                new DateRange(
                    LocalDate.of(2025, 10, 1),
                    LocalDate.of(2025, 10, 3)
                ),
                customersArray[10],
                carsArray[10]
        ));
        bookingDAO.addBooking(new Booking(
                new DateRange(
                    LocalDate.of(2025, 10, 5),
                    LocalDate.of(2025, 10, 8)
                ),
                customersArray[11],
                carsArray[11]
        ));
        bookingDAO.addBooking(new Booking(
                new DateRange(
                    LocalDate.of(2025, 11, 1),
                    LocalDate.of(2025, 11, 4)
                ),
                customersArray[12],
                carsArray[12]
        ));
        bookingDAO.addBooking(new Booking(
                new DateRange(
                    LocalDate.of(2025, 11, 6),
                    LocalDate.of(2025, 11, 10)
                ),
                customersArray[13],
                carsArray[13]
        ));
        bookingDAO.addBooking(new Booking(
                new DateRange(
                    LocalDate.of(2025, 12, 1),
                    LocalDate.of(2025, 12, 6)
                ),
                customersArray[14],
                carsArray[14]
        ));
    }
}
