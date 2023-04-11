package com.example.furama.restController;

import com.example.furama.model.customer.Customer;
import com.example.furama.services.customer.ICustomerServices;
import com.example.furama.services.customer.impl.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customerAPI")
public class CustomerRestController {
    @Autowired
    ICustomerServices customerServices;

    @PostMapping("admin/save")
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody Customer customer) {
            customerServices.save(customer);
           customer.getId();
            return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping("admin/find/{id}")
    public ResponseEntity<?> fetchData(@PathVariable Integer id) {
        return new ResponseEntity<>(customerServices.getCustomerById(id),HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
