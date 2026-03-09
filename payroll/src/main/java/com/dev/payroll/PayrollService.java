package com.dev.payroll;

import com.dev.payroll.Feign.AttendanceFeign;
import com.dev.payroll.Feign.EmployeeFeign;
import com.dev.payroll.dto.AttendanceDto;
import com.dev.payroll.dto.EmployeeDto;
import com.dev.payroll.dto.PayrollDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PayrollService {

    @Autowired
    AttendanceFeign attendanceFeign;

    @Autowired
    EmployeeFeign employeeFeign;


    public ResponseEntity<?> getPayrollDetailsOfEmployeeById(int employeeId) {
        try{
            AttendanceDto attendanceDetails = attendanceFeign.getAttendanceById(employeeId);
            EmployeeDto employeeDetails = employeeFeign.getEmployeeById(employeeId);

            PayrollDto payrollDetails = new PayrollDto();
            payrollDetails.setName(employeeDetails.getName());
            payrollDetails.setDepartment(employeeDetails.getDepartment());
            payrollDetails.setPosition(employeeDetails.getPosition());
            double gross_salary = employeeDetails.getSalaryDetails().getSalary();
            payrollDetails.setGrossSalary(gross_salary);

            int usedLeave = attendanceDetails.getUsedLeave();
            int totalLeave = attendanceDetails.getTotalLeave();
            int extraLeave = 0;
            double amountDeducted = 0;
            double finalSalary = gross_salary;

            if(usedLeave > totalLeave){
                extraLeave = usedLeave-totalLeave;
                double perDaySalary = gross_salary / totalLeave;
                amountDeducted = extraLeave * perDaySalary;
                finalSalary -= amountDeducted;
            }
            payrollDetails.setFinalSalary(finalSalary);
            payrollDetails.setDeductionAmount(amountDeducted);

            return new ResponseEntity<>(payrollDetails,HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
