package com.example.commerce;

public class Customer {
    private String name;
    private String email;
    private String grade;

    public Customer(String name,String email, String grade){
            this.name = name;
            this.email = email;
            this.grade = grade;
    }

    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getGrade(){
        return this.grade;
    }
}
