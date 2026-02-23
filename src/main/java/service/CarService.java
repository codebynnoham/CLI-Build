package service;

import contract.IBookingService;
import contract.ICarService;
import dao.CarDAO;
import model.Car;
import model.Category;
import model.DateRange;
import model.EngineType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CarService implements ICarService {
    private final CarDAO carDAO;
    private final IBookingService bookingService;

    public CarService(CarDAO carDAO, IBookingService bookingService) {
        this.carDAO = carDAO;
        this.bookingService = bookingService;
    }

    @Override
    public void registerCar(Car car) {
        Objects.requireNonNull(car, "car cannot be null");
        if (carDAO.findByRegNumber(car.registrationNumber()).isPresent())
            throw new IllegalArgumentException("car with reg number " + car.registrationNumber() + " already exists");
        carDAO.addCar(car);
    }

    @Override
    public Optional<Car> findCarByRegNumber(String regNumber) {
        return carDAO.findByRegNumber(regNumber);
    }

    @Override
    public void deleteCarByRegNumber(String regNumber) {
        if (!carDAO.removeCarByRegNumber(regNumber))
            throw new IllegalArgumentException("car with reg number " + regNumber + " not found");
    }

    @Override
    public List<Car> getAllCars() {
        return List.copyOf(Arrays.asList(carDAO.getAllCars()));
    }

    @Override
    public List<Car> getAvailableCars(DateRange period) {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : carDAO.getAllCars()) {
            if (bookingService.isCarAvailable(car.registrationNumber(), period))
                availableCars.add(car);
        }
        return List.copyOf(availableCars);
    }

    @Override
    public List<Car> getCarsByEngineType(EngineType engineType) {
        List<Car> byEngineType = new ArrayList<>();
        for (Car car : carDAO.getAllCars()) {
            if (car.engineType() == engineType)
                byEngineType.add(car);
        }
        return List.copyOf(byEngineType);
    }

    @Override
    public List<Car> getCarsByCategory(Category category) {
        List<Car> byCategory = new ArrayList<>();
        for (Car car : carDAO.getAllCars()) {
            if (car.category() == category)
                byCategory.add(car);
        }
        return List.copyOf(byCategory);
    }

    @Override
    public List<Car> getAvailableCarsByEngineType(EngineType type, DateRange period) {
        List<Car> availableCarsByEngineType = new ArrayList<>();
        for (Car car : getAvailableCars(period)) {
            if (car.engineType() == type)
                availableCarsByEngineType.add(car);
        }
        return List.copyOf(availableCarsByEngineType);
    }

    @Override
    public List<Car> getAvailableCarsByCategory(Category category, DateRange period) {
        List<Car> availableCarsByCategory = new ArrayList<>();
        for (Car car : getAvailableCars(period)) {
            if (car.category() == category)
                availableCarsByCategory.add(car);
        }
        return List.copyOf(availableCarsByCategory);
    }
}
