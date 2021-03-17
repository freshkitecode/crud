package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {

    private int id;
    private String name;
    private int age;
    private String title;  
    private String dob;

     public Employee(int id, String name, int age, String title, String dob) {
                this.id = id;
                this.name = name;
                this.age = age;
                this.title = title;
                this.dob = dob;
                System.out.println("Employee: " + name);
        }

        public int getId() {
        	System.out.println("getid " + id);
                return id;
        }

        public String getName() {
        	System.out.println("getname " + name);
                return name;
        }

        public int getAge() {
        	System.out.println("getage " + age);
                return age;
        }

        public String getTitle() {
        	System.out.println("getTitle " + title);
                return title;
        }

        public String getDob() {
        	System.out.println("getdob " + dob);
                return dob;
        }

		public void setId(int id) {
			System.out.println("setid " + id);
			this.id = id;
		}

		public void setName(String name) {
			System.out.println("setname " + name);
			this.name = name;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}
        
        
}