package com.dev.employee_service.repo;

import com.dev.employee_service.Model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee extends JpaRepository<EmployeeDetails,Integer> {
}
