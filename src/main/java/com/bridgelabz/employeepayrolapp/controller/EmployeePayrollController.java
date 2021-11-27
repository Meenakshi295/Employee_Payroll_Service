package com.bridgelabz.employeepayrolapp.controller;

import com.bridgelabz.employeepayrolapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrolapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrolapp.model.EmployeePayrollData;                                                                                                                                                                                 
import com.bridgelabz.employeepayrolapp.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



	@RestController
	@RequestMapping(value = "/employee")
	@CrossOrigin(origins = {"http://localhost:8080"})
    public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	
    @GetMapping("/get")
    public ResponseEntity<List<EmployeePayrollData>> getAllEmployeeData(){
    	return new ResponseEntity<>(employeePayrollService.getEmployeePayrollData(), HttpStatus.OK);
    }
    
	
    @PostMapping(value = {"/add"})
	public ResponseEntity<ResponseDTO> addEmployee(@RequestBody EmployeePayrollDTO employeeDTO) {
		return new ResponseEntity<ResponseDTO>(employeePayrollService.addEmployee(employeeDTO), HttpStatus.OK);								
    }
    	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id) {
		return new ResponseEntity<ResponseDTO>(employeePayrollService.deleteEmployee(id) , HttpStatus.OK);
	}
		
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<EmployeePayrollData> findEmployeeById(@PathVariable int id) {
		return new ResponseEntity<>(employeePayrollService.findEmployee(id), HttpStatus.OK);
	}
		
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<EmployeePayrollData> updateEmployee(@RequestBody EmployeePayrollDTO employeeDTO, @PathVariable int id) {
		return new ResponseEntity<>(employeePayrollService.updateEmployeeData(id, employeeDTO) , HttpStatus.OK);
	}

}


