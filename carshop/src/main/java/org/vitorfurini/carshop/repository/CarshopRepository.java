package org.vitorfurini.carshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vitorfurini.carshop.entity.Car;


public interface CarshopRepository extends JpaRepository<Car, Long> {
}
