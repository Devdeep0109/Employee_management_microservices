package com.dev.attendance_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("attendance")
public class Attendance_controller {

    @Autowired
    private Attendance_service attendance_service;

    @GetMapping("getAllEmpAttendance")
    public ResponseEntity<?> getAllAttendance(){
        return attendance_service.getAllAttendance();
    }

    @GetMapping("getAttendanceByEmpID/{employeeId}")
    public ResponseEntity<?> getAttendanceById(@PathVariable int employeeId){
        return attendance_service.getAttendanceById(employeeId);
    }

    @PostMapping("addAttendance")
    public ResponseEntity<String> addAttendanceOfEmployee(@RequestBody AttendanceDto attendanceDto){
        return attendance_service.addAttendanceOfEmployee(attendanceDto);
    }

}
