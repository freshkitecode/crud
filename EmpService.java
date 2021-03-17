package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public class EmpService{

        private MongoTemplate mongoTemplate;

        @Autowired
        public EmpService(MongoTemplate mongoTemplate) {
                System.out.println("Hey i am Employee Service class");
                this.mongoTemplate = mongoTemplate;
        }

        public String addEmployee(Employee employee) {
                Employee insertedEntity = mongoTemplate.insert(employee);
                System.out.println("Employee "+ insertedEntity.getName()+" added into the database.");
                return "Employee "+ insertedEntity.getName()+" added into the database.";
        }

        public List<Employee> getAllEmployees() {
        	System.out.println("getAllEmployees");
                return mongoTemplate.findAll(Employee.class);
        }

        public Employee getEmployee(int id) {
                Query q=new Query();
                q.addCriteria(Criteria.where("id").is(id));
                System.out.println("getEmployee");
                return mongoTemplate.findOne(q, Employee.class);
        }

        public String updateEmployee(Employee employee) {
                mongoTemplate.save(employee);
                System.out.println("Employee "+ employee.getName()+" details updated in the database.");
                return "Employee "+ employee.getName()+" details updated in the database.";
        }

        public String deleteEmployee(int id) {
                Query q=new Query();
                q.addCriteria(Criteria.where("id").is(id));
                Employee employee=mongoTemplate.findAndRemove(q, Employee.class);
                System.out.println("Employee "+ employee.getName()+" removed from database.");
                return "Employee "+ employee.getName()+" removed from database.";
        }
}