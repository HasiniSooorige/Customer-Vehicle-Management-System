package com.crudproject.CRUD_Spring.repository;

import com.crudproject.CRUD_Spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

}
