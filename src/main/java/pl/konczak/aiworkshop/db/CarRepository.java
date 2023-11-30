package pl.konczak.aiworkshop.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository
        extends JpaRepository<Car, Long> {

    List<Car> findByBrand(String brand);

    List<Car> findByModel(String model);

    List<Car> findByBrandAndModel(String brand, String model);

}
