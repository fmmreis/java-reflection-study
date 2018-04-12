package test;

import java.util.Date;

public class MyObject {
    private String firstName;
    public String lastName;
    private Integer age;
    private Date birhDate;
    private Double salary;

    public MyObject(){};

    public MyObject(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirhDate() {
        return birhDate;
    }

    public void setBirhDate(Date birhDate) {
        this.birhDate = birhDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
