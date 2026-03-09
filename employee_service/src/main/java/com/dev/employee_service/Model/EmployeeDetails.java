package com.dev.employee_service.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String position;
    private String department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_id" ,referencedColumnName = "id")
    private SalaryDetails salaryDetails;
}
