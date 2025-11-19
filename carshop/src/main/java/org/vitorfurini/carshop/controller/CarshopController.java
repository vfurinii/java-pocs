package org.vitorfurini.carshop.controller;

import org.springframework.web.bind.annotation.*;
import org.vitorfurini.carshop.entity.Car;
import org.vitorfurini.carshop.service.CarshopService;

import java.util.List;


@RestController
@RequestMapping("/api/cars")
public class CarshopController {

    private final CarshopService service;

    public CarshopController(CarshopService service) {
        this.service = service;
    }

    @GetMapping
    public List<Car> list() {
        return service.list();
    }

    @PostMapping
    public Car create(@RequestBody Car car) {
        return service.save(car);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
