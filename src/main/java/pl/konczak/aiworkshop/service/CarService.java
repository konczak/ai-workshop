package pl.konczak.aiworkshop.service;

import pl.konczak.aiworkshop.db.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();

    Car findById(int id);

    Car add(Car car);


    List<Car> findAllByBrandAndModel(String brand, String model);


}
