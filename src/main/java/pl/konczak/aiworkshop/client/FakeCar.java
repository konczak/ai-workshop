package pl.konczak.aiworkshop.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FakeCar(long id,
                      @JsonProperty("car")
                      String brand,
                      @JsonProperty("car_model")
                      String model,
                      @JsonProperty("car_color")
                      String color,
                      @JsonProperty("car_model_year")
                      int year,
                      boolean availability) {
}
