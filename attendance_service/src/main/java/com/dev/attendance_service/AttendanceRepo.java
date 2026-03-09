package com.dev.attendance_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance,Integer> {

     Attendance findByEmployeeId(int employeeId);
}
