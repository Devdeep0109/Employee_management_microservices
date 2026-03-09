package com.dev.employee_service;

import com.dev.employee_service.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("getAllEmployee")
    public ResponseEntity<?> getAllEmployeeDetails(){
        return service.getAllEmployeeDetails();
    }

    @GetMapping("getEmployeeById/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer id){
        return service.getEmployeeById(id);
    }

    @PostMapping("add")
    public ResponseEntity<?> addEmployeeDetails(@RequestBody EmployeeDto employeeDto){
        return service.addEmployeeDetails(employeeDto);
    }




}
