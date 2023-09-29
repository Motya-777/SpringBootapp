package com.example.CarCatalog.Repository;

import com.example.CarCatalog.Models.Cars;
import org.springframework.data.repository.CrudRepository;

public interface CarsRepo extends CrudRepository<Cars, Long> {
}
