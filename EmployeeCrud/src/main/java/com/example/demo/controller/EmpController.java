package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmpService;

@RequestMapping("/api/v1")
@RestController
public class EmpController {

        private EmpService employeeService;

        public EmpController(EmpService employeeService) {
                System.out.println("Hey i got an Employee Service object");
                this.employeeService = employeeService;
        }

        @PostMapping("/person")
        public String createEmployee(@RequestBody Employee employee) {
        	    System.out.println("CreateEmployee");
                return employeeService.addEmployee(employee);
        }

        @GetMapping("/person")
        public List<Employee> getAllEmployees(){
        	System.out.println("getAllEmployees");
                return employeeService.getAllEmployees();
        }

        @GetMapping("/person/{id}")
        public Employee getEmployeeByID(@PathVariable("id") int id){
        	System.out.println("getEmployeeByID");
                return employeeService.getEmployee(id);
        }

        @PutMapping("/person")
        public String updateEmployee(@RequestBody Employee employee){
        	System.out.println("updateEmployee");
                return employeeService.updateEmployee(employee);
        }

        @DeleteMapping("/person/{id}")
        public String deleteEmployee(@PathVariable("id") int id){
        	System.out.println("deleteEmployee");
                return employeeService.deleteEmployee(id);
        }

}