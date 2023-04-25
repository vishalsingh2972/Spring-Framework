package com.vishalsingh.Springboot.tutorial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //putting @Entity to class Department, so now this class Department can interact with our database using the Spring Data JPA
public class Department {

    @Id //putting @Id will make departmentId as my primary key ( column that uniquely identifies each row in a table ) //baki sab same ho sakte for 2 people but departmentId hamesha unique value hi rehta sabke liye isliye isko banaye primary key
    @GeneratedValue (strategy = GenerationType.AUTO)//defining how we want to generate our primary key //There are four generation types: AUTO, IDENTITY, SEQUENCE and TABLE
                                                    //if we don't explicitly specify a value, the generation type defaults to AUTO, i.e @GeneratedValue (strategy = GenerationType.AUTO) can be directly written as just @GeneratedValue
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }
}
