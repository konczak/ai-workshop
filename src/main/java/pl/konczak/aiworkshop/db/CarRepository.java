package pl.konczak.aiworkshop.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findAllByBrand(String brand);

    List<Car> findAllByModel(String model);

    List<Car> findAllByBrandAndModel(String brand, String model);

}
