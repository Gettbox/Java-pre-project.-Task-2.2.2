package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> carList = Arrays.asList(
            new Car("Rolls-Royce", "15 HP", 10),
            new Car("cabriolet Dodge", "Hemi Coronet R/T", 20),
            new Car("Porsche", "916", 30),
            new Car("Talbot", "Lago Grand Sport", 40),
            new Car("Ferrari", "250 GTO", 50)
    );

    @Override
    public List<Car> getCarList(int count) throws IllegalArgumentException {
        if (count < 0) {
            throw new IllegalArgumentException("count < 0");
        }
        if (count >= 5) {
            return carList;
        }
        return carList.stream().limit(count).toList();
    }
}