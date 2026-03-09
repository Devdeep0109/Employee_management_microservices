package com.dev.attendance_service;

import lombok.Data;

@Data
public class AttendanceDto {

    private int employeeId;
    private int usedLeave;
    private int totalLeave;
}
