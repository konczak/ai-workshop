package pl.konczak.aiworkshop.domain;

import pl.konczak.aiworkshop.db.Car;

import java.util.List;

public interface CarService {
    Car add(Car car);

    List<Car> findAll();

    Car findById(Long id);

    List<Car> findByBrand(String brand);

    List<Car> findByModel(String model);

    List<Car> findByBrandAndModel(String brand, String model);
}
