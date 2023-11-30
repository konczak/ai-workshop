package pl.konczak.aiworkshop.domain;

import pl.konczak.aiworkshop.assertion.CarAssertion;
import pl.konczak.aiworkshop.db.Car;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CarServiceTest {

    @Autowired
    private CarService carService;

    @Test
    public void shouldAddCar() {
        // given
        Car car = new Car();
        car.setBrand("BMW");
        car.setModel("M3");
        car.setYear(2019);
        car.setColor("red");
        // when
        Car result = carService.add(car);
        // then
        assertNotNull(result);
    }

    @ParameterizedTest
    @MethodSource("carVariants")
    void shouldAddCar(Car car) {
        // given
        // when
        Car result = carService.add(car);
        // then
        CarAssertion.assertThat(result)
                .hasId()
                .hasBrand(car.getBrand())
                .hasModel(car.getModel())
                .hasYear(car.getYear())
                .hasColor(car.getColor());
    }

    // Define the car variants as a static method
    static Stream<Car> carVariants() {
        return Stream.of(
                createCar("Toyota", "Camry", 2022, "Blue"),
                createCar("Honda", "Accord", 2021, "Red"),
                createCar("Ford", "Mustang", 2023, "Yellow"),
                createCar("Chevrolet", "Impala", 2020, "Silver"),
                createCar("BMW", "X5", 2022, "Black"),
                createCar("Mercedes", "E-Class", 2021, "White"),
                createCar("Audi", "A4", 2023, "Green"),
                createCar("Tesla", "Model S", 2022, "Gray"),
                createCar("Nissan", "Altima", 2020, "Purple"),
                createCar("Kia", "Soul", 2021, "Orange")
        );
    }

    private static Car createCar(String brand, String model, int year, String color) {
        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setYear(year);
        car.setColor(color);
        return car;
    }
}
