package contract;

import model.Car;
import model.Category;
import model.DateRange;
import model.EngineType;

import java.util.List;
import java.util.Optional;

public interface ICarService {
    void registerCar(Car car);
    Optional<Car> findCarByRegNumber(String regNumber);
    void deleteCarByRegNumber(String regNumber);
    List<Car> getAllCars();
    List<Car> getAvailableCars(DateRange period);
    List<Car> getCarsByEngineType(EngineType engineType);
    List<Car> getCarsByCategory(Category category);
    List<Car> getAvailableCarsByEngineType(EngineType type, DateRange period);
    List<Car> getAvailableCarsByCategory(Category category, DateRange period);
}
