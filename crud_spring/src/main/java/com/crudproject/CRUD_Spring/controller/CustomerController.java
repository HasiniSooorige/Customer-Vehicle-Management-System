package com.crudproject.CRUD_Spring.controller;

import com.crudproject.CRUD_Spring.entity.Customer;
import com.crudproject.CRUD_Spring.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customer")
    public Customer postcustomer(@RequestBody Customer customer) {
        return customerService.postcustomer(customer);
    }

    @GetMapping("/getallcustomers")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/getcustomerbyid/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(customer);
        }
    }

    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer == null)
            return ResponseEntity.notFound().build();
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        Customer updatedCustomer = customerService.updateCustomer(existingCustomer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        Customer existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer == null)
            return ResponseEntity.notFound().build();
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

}