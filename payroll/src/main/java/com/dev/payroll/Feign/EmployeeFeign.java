package com.dev.payroll.Feign;

import com.dev.payroll.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="EMPLOYEE-SERVICE")
public interface EmployeeFeign {

    @GetMapping("/employee/getEmployeeById/{id}")
    EmployeeDto getEmployeeById(@PathVariable Integer id);
}
