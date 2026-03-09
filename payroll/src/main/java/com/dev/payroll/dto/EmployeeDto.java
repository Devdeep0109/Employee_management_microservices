package com.dev.payroll.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private String name;
    private String position;
    private String department;
    private SalaryDto salaryDetails;
}
