package pl.konczak.aiworkshop.domain;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.konczak.aiworkshop.db.Car;
import pl.konczak.aiworkshop.db.CarRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceImplTest {

    @Mock
    private CarRepository carRepository;
    @InjectMocks
    private CarServiceImpl carService;

    @Test
    public void findById_existingId_returnsCar() {
        // Arrange
        Car car = mock(Car.class);
        carService.add(car);
        long id = 1L;
        when(carRepository.findById(id))
                .thenReturn(Optional.of(car));

        // Act
        Car result = carService.findById(id);

        // Assert
        assertEquals(car, result);
    }

    @Test
    public void findById_nonExistingId_returnsNull() {
        // Arrange
        Long nonExistingId = 123456789L;
        when(carRepository.findById(nonExistingId))
                .thenReturn(Optional.empty());

        // Act
        Car foundCar = carService.findById(nonExistingId);

        // Assert
        assertNull(foundCar);
    }

}
