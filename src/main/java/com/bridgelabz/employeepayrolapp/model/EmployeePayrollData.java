package com.bridgelabz.employeepayrolapp.model;
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

    @Data
    @Entity
    @Table(name = "Employee")
    public class EmployeePayrollData {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "empId")
        private int empId;
        
        @Column(name = "name")        
        private String name;
        
        @Column(name = "salary")        
        private long salary;
        
        @Column(name = "gender")        
        private String gender;
        
        @Column(name = "startDate")        
        private Date startDate;
        
        @Column(name = "department")        
        private String department;
        
        @Column(name = "profilePic")        
        private String profilePic;
        
        @Column(name = "note")      
        private String note;


		/*
		 * public EmployeePayrollData() { }
		 * 
		 * public EmployeePayrollData(int empId, EmployeePayrollDTO employeeParollDTO) {
		 * this.empId = empId; this.name = employeeParollDTO.name; this.salary =
		 * employeeParollDTO.salary; this.gender = employeeParollDTO.gender;
		 * 
		 * this.startDate = employeeParollDTO.startDate; this.profilePic =
		 * employeeParollDTO.profilePic; this.department = employeeParollDTO.department;
		 * this.note=employeeParollDTO.note; }
		 * 
		 * @Override public String toString() { return "EmployeePayrollDTO{" + "name='"
		 * + name + '\'' + ", salary=" + salary + '}'; }
		 */
    }