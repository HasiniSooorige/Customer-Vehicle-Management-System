package com.crudproject.CRUD_Spring.service;

import com.crudproject.CRUD_Spring.entity.Customer;
import com.crudproject.CRUD_Spring.entity.Vehicle;
import com.crudproject.CRUD_Spring.repository.CustomerRepository;
import com.crudproject.CRUD_Spring.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }
}
