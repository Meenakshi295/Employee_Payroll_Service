package com.bridgelabz.employeepayrolapp.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class EmployeePayrollDTO {
   
	public String name;
    public long salary;
    public String gender;
    public String note;
    public Date startDate;
    public String profilePic;
    public String department;
    
}
