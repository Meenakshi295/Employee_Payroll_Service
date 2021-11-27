package com.bridgelabz.employeepayrolapp.respository;

import com.bridgelabz.employeepayrolapp.model.EmployeePayrollData;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer> {
      
    	//public Optional<EmployeePayrollData> findById(int id);
     }


