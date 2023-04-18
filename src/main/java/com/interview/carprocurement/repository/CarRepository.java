package com.interview.carprocurement.repository;


import com.interview.carprocurement.data.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<Car, String> {

    Optional<Car> findById(String id);

}