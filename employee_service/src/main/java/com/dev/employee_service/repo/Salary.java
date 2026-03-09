package com.dev.employee_service.repo;

import com.dev.employee_service.Model.SalaryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Salary extends JpaRepository<SalaryDetails,Integer> {
}
