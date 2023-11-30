package pl.konczak.aiworkshop.domain;

import pl.konczak.aiworkshop.db.Car;
import pl.konczak.aiworkshop.db.CarRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl
        implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car add(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(carRepository.findAll());
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public List<Car> findByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    @Override
    public List<Car> findByModel(String model) {
        return carRepository.findByModel(model);
    }

    @Override
    public List<Car> findByBrandAndModel(String brand, String model) {
        return carRepository.findByBrandAndModel(brand, model);
    }

}
