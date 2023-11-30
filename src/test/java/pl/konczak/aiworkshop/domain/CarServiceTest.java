package pl.konczak.aiworkshop.domain;

import pl.konczak.aiworkshop.db.Car;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CarServiceTest {
    @Autowired
    private CarService carService;

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("provideCars")
    void addCar(Car car) {
        // Arrange

        // Act
        Car savedCar = carService.add(car);

        // Assert
        assertEquals(car, savedCar);
    }

    private static Stream<Car> provideCars() {
        return Stream.of(
                createCar("Audi", "A4", "Black", 2023),
                createCar("BMW", "X5", "White", 2022),
                createCar("Volkswagen", "Golf", "Red", 2021)
        );
    }

    private static Car createCar(String brand, String model, String color, int year) {
        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setYear(year);
        car.setColor(color);
        return car;
    }

}
