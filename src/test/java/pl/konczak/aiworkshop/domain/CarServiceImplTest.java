package pl.konczak.aiworkshop.domain;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.konczak.aiworkshop.db.Car;
import pl.konczak.aiworkshop.db.CarRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceImplTest {

    @Mock
    private CarRepository carRepository;
    @InjectMocks
    private CarServiceImpl carService;

    @Test
    public void shouldReturnCarWhenFindById() {
        // given
        Car car = mock(Car.class);

        long id = 1L;
        when(carRepository.findById(id))
                .thenReturn(Optional.of(car));
        // when
        Car result = carService.findById(id);
        // then
        assertNotNull(result);
    }

    @Test
    public void shouldReturnNullWhenFindByIdAndCarDoesNotExist() {
        // given
        long id = 1L;
        when(carRepository.findById(id))
                .thenReturn(Optional.empty());
        // when
        Car result = carService.findById(id);
        // then
        assertNull(result);
    }
}
