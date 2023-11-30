package pl.konczak.aiworkshop.assertion;

import pl.konczak.aiworkshop.db.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarAssertion {

    private final Car actual;

    private CarAssertion(Car actual) {
        this.actual = actual;
    }

    public static CarAssertion assertThat(Car actual) {
        return new CarAssertion(actual);
    }

    public CarAssertion hasId() {
        assertNotNull(actual.getId(), "Car id should not be null");
        return this;
    }

    public CarAssertion hasBrand(String expected) {
        assertEquals(expected, actual.getBrand(), "Car brand mismatch");
        return this;
    }

    public CarAssertion hasModel(String expected) {
        assertEquals(expected, actual.getModel(), "Car model mismatch");
        return this;
    }

    public CarAssertion hasYear(int expected) {
        assertEquals(expected, actual.getYear(), "Car year mismatch");
        return this;
    }

    public CarAssertion hasColor(String expected) {
        assertEquals(expected, actual.getColor(), "Car color mismatch");
        return this;
    }
}

