package com.dev.employee_service;

import com.dev.employee_service.Model.EmployeeDetails;
import com.dev.employee_service.Model.SalaryDetails;
import com.dev.employee_service.dto.EmployeeDto;
import com.dev.employee_service.repo.Employee;
import com.dev.employee_service.repo.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private Employee employee;

    @Autowired
    private Salary salary;

    public ResponseEntity<?> getAllEmployeeDetails() {

        try{
            return new ResponseEntity<>(employee.findAll(),HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getEmployeeById(Integer id) {

        try{
            EmployeeDetails employeeDetail = employee.findById(id)
                    .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

            return new ResponseEntity<>(employeeDetail,HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> addEmployeeDetails(EmployeeDto employeeDto) {

        try{
            SalaryDetails salaryDetails = new SalaryDetails();
            salaryDetails.setSalary(employeeDto.getSalaryDetails().getSalary());
            SalaryDetails savedSalary = salary.save(salaryDetails);

            EmployeeDetails employeeDetails = new EmployeeDetails();
            employeeDetails.setName(employeeDto.getName());
            employeeDetails.setPosition(employeeDto.getPosition());
            employeeDetails.setDepartment(employeeDto.getDepartment());
            employeeDetails.setSalaryDetails(savedSalary);
            employee.save(employeeDetails);

            return new ResponseEntity<>("Added successfully",HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
