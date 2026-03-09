package com.dev.payroll.dto;

import lombok.Data;

@Data
public class AttendanceDto {

    private int employeeId;
    private int usedLeave;
    private int totalLeave;
}
