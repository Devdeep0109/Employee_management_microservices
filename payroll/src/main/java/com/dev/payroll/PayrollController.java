package com.dev.payroll;

import com.dev.payroll.Feign.AttendanceFeign;
import jakarta.ws.rs.PATCH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("payroll")
public class PayrollController {

    @Autowired
    PayrollService payrollService;

    @GetMapping("getDetail/{employeeId}")
    public ResponseEntity<?> getPayrollDetailsOfEmployeeById(@PathVariable int employeeId){
        return payrollService.getPayrollDetailsOfEmployeeById(employeeId);
    }
}
