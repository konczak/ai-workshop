package pl.konczak.aiworkshop.service;

import lombok.AllArgsConstructor;
import pl.konczak.aiworkshop.db.Car;
import pl.konczak.aiworkshop.db.CarRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarServiceImpl
        implements CarService {

    private final CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(final int id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Car add(final Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> findAllByBrandAndModel(final String brand, final String model) {
        return carRepository.findAllByBrandAndModel(brand, model);
    }
}
