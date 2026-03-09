package com.dev.employee_service.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private String name;
    private String position;
    private String department;
    private SalaryDto salaryDetails;
}
