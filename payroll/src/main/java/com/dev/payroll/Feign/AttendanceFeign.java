package com.dev.payroll.Feign;

import com.dev.payroll.dto.AttendanceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ATTENDANCE-SERVICE")
public interface AttendanceFeign {

    @GetMapping("/attendance/getAttendanceByEmpID/{employeeId}")
    AttendanceDto getAttendanceById(@PathVariable int employeeId);
}
