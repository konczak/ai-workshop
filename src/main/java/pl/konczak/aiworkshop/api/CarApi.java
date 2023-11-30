package pl.konczak.aiworkshop.api;

import pl.konczak.aiworkshop.db.Car;
import pl.konczak.aiworkshop.domain.CarService;

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
public class CarApi {

    private final CarService carService;

    public CarApi(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCars() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) {
        return carService.findById(id);
    }

    @GetMapping("/brand/{brand}")
    public List<Car> getCarsByBrand(@PathVariable String brand) {
        return carService.findByBrand(brand);
    }

    @GetMapping("/model/{model}")
    public List<Car> getCarsByModel(@PathVariable String model) {
        return carService.findByModel(model);
    }

    @GetMapping(params = {"brand", "model"})
    public List<Car> getCarsByBrandAndModel(@RequestParam String brand, @RequestParam String model) {
        return carService.findByBrandAndModel(brand, model);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Car createCar(@RequestBody Car car) {
        return carService.add(car);
    }

}
