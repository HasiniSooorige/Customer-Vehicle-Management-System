package com.crudproject.CRUD_Spring.controller;

import com.crudproject.CRUD_Spring.entity.Customer;
import com.crudproject.CRUD_Spring.entity.Vehicle;
import com.crudproject.CRUD_Spring.repository.VehicleRepository;
import com.crudproject.CRUD_Spring.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping("/saveVehicle")
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
        System.out.println("Received Vehicle: " + vehicle);
        return vehicleService.saveVehicle(vehicle);
    }

    @GetMapping("/getAllVehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }


}
