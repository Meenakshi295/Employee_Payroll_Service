package com.bridgelabz.employeepayrolapp.services;

import com.bridgelabz.employeepayrolapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrolapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrolapp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    
	public List<EmployeePayrollData> getEmployeePayrollData();
    public ResponseDTO addEmployee(EmployeePayrollDTO employeeDTO);
	//public List<EmployeePayrollData> getEmployeeList();
	public ResponseDTO deleteEmployee(int id);
	public EmployeePayrollData findEmployee(int id);
	public EmployeePayrollData updateEmployeeData(int employeeId, EmployeePayrollDTO employeeDTO);
    
}

