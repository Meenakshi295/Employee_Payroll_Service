package com.bridgelabz.employeepayrolapp.services;

import com.bridgelabz.employeepayrolapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrolapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrolapp.exception.BadRequestException;
import com.bridgelabz.employeepayrolapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrolapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrolapp.respository.EmployeePayrollRepository;
import com.bridgelabz.employeepayrolapp.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

    @org.springframework.stereotype.Service
    @Slf4j
    public class EmployeePayrollService implements IEmployeePayrollService {

        @Autowired
        private EmployeePayrollRepository employeeRepository;

        //private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

        @Override
        public List<EmployeePayrollData> getEmployeePayrollData() {
        	return employeeRepository.findAll();
        }
        
        @Override
        public ResponseDTO addEmployee(EmployeePayrollDTO employeeDTO) {
          if (employeeDTO == null) {
            throw new BadRequestException("Name is not Proper");
          }
          EmployeePayrollData empEntity = new EmployeePayrollData();
          empEntity = this.convertEntity(empEntity, employeeDTO);
          empEntity = employeeRepository.save(empEntity);
          if (empEntity != null) {
            return new ResponseDTO("successfully inserted !!!!");
          } else {
            return new ResponseDTO("not success");
          }
        }
      
        @Override
        public ResponseDTO deleteEmployee(int id) {
          employeeRepository.deleteById(id);
          return new ResponseDTO("Deleted successfully");
        }

        @Override
        public EmployeePayrollData findEmployee(int id) {
          return employeeRepository.findById(id).orElseThrow(()->new NotFoundException("User not found with this Id: " + id));                      		  
        }

        @Override
        public EmployeePayrollData updateEmployeeData(int employeeId, EmployeePayrollDTO employeeDTO) {
        	EmployeePayrollData employeeEntity = employeeRepository.findById(employeeId)
              .orElseThrow(() -> new com.bridgelabz.employeepayrolapp.exception.NotFoundException("User not found with this Id: " + employeeId));
          employeeEntity = this.convertEntity(employeeEntity, employeeDTO);
          employeeEntity.setEmpId(employeeId);
          return employeeRepository.save(employeeEntity);
        }

        private EmployeePayrollDTO convertObj(EmployeePayrollData employee) {
          EmployeePayrollDTO employeeDTO = new EmployeePayrollDTO() ;
          employeeDTO.setName(employee.getName());
          employeeDTO.setGender(employee.getGender());
          employeeDTO.setProfilePic(employee.getProfilePic());
          employeeDTO.setDepartment(employee.getDepartment());
          employeeDTO.setSalary(employee.getSalary());
          employeeDTO.setNote(employee.getNote());
          employeeDTO.setStartDate(employee.getStartDate());
          return employeeDTO;
        }

        private EmployeePayrollData  convertEntity(EmployeePayrollData empEntity, EmployeePayrollDTO empDto) {
          empEntity.setName(empDto.getName());
          empEntity.setDepartment(empDto.getDepartment());
          empEntity.setGender(empDto.getGender());
          empEntity.setProfilePic(empDto.getProfilePic());
          empEntity.setSalary(empDto.getSalary());
          empEntity.setNote(empDto.getNote());
          empEntity.setStartDate(empDto.getStartDate());
          return empEntity;
        }


        
    }

