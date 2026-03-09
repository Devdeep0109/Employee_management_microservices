package com.dev.payroll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayrollDto {

    private String name;
    private String position;
    private String department;
    private double grossSalary;
    private double finalSalary;
    private double deductionAmount;
}
