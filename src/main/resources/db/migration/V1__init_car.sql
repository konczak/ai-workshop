CREATE TABLE car
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    brand    VARCHAR(255),
    model    VARCHAR(255),
    color    VARCHAR(255),
    car_year INT
);
