package org.order.api.carshop.service;

import org.springframework.stereotype.Service;
import org.order.api.carshop.entity.Car;
import org.order.api.carshop.repository.CarshopRepository;

import java.util.List;

@Service
public class CarshopService {
    private final CarshopRepository repo;

    public CarshopService(CarshopRepository repo) {
        this.repo = repo;
    }

    public List<Car> list() {
        return repo.findAll();
    }

    public Car save(Car car) {
        return repo.save(car);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
