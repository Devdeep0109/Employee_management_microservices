package com.dev.attendance_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Attendance_service {

    @Autowired
    AttendanceRepo attendanceRepo;

    public ResponseEntity<?> getAllAttendance() {
        try{
            List<Attendance> attendanceList = attendanceRepo.findAll();
            return new ResponseEntity<>(attendanceList, HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getAttendanceById(int employeeId) {
        try{
            Attendance attendanceInfo = attendanceRepo.findByEmployeeId(employeeId);
            return new ResponseEntity<>(attendanceInfo,HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addAttendanceOfEmployee(AttendanceDto attendanceDto) {
        try{
            Attendance attendance = new Attendance();
            attendance.setEmployeeId(attendanceDto.getEmployeeId());
            attendance.setUsedLeave(attendanceDto.getUsedLeave());
            attendance.setTotalLeave(attendanceDto.getTotalLeave());

            attendanceRepo.save(attendance);
            return new ResponseEntity<>("Attendance added successfully",HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
