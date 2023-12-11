package pl.konczak.aiworkshop.api;

import pl.konczak.aiworkshop.db.Car;
import pl.konczak.aiworkshop.service.CarService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> findAll() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable("id") int id) {
        return carService.findById(id);
    }

    @PostMapping
    public Car add(@RequestBody Car car) {
        return carService.add(car);
    }

    @GetMapping(params = {"brand", "model"})
    public List<Car> findAllByBrandAndModel(
            @RequestParam String brand,
            @RequestParam String model) {
        return carService.findAllByBrandAndModel(brand, model);
    }
}
