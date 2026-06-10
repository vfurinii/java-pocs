package org.order.api.carshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.order.api.carshop.entity.Car;


public interface CarshopRepository extends JpaRepository<Car, Long> {
}
