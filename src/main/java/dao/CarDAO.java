package dao;

import model.Car;

import java.util.Arrays;
import java.util.Optional;

public class CarDAO {
    private Car[] carDB;
    private int index;

    public CarDAO(int initialCapacity) {
        this.carDB = new Car[Math.max(initialCapacity, 1)];
        this.index = 0;
    }

    public void addCar(Car car) {
        if (index == carDB.length)
            resize();
        carDB[index ++] = car;
    }

    private void resize() {
        carDB = Arrays.copyOf(carDB, carDB.length * 2);
    }

    public Car[] getAllCars() {
        return Arrays.copyOf(carDB, index);
    }

    public Optional<Car> findByRegNumber(String regNumber) {
        for (Car car : getAllCars()) {
            if (car.registrationNumber().equalsIgnoreCase(regNumber))
                return Optional.of(car);
        }
        return Optional.empty();
    }

    public int getSize() {
        return index;
    }
}
