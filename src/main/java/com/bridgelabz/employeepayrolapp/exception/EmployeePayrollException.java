package com.bridgelabz.employeepayrolapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeePayrollException  extends RuntimeException{

    public static  final long serialVersionUID=1L;

    public  EmployeePayrollException(String message){
        super(message);
    }
}
