package com.vishalsingh.Springboot.tutorial.service;

import com.vishalsingh.Springboot.tutorial.entity.Department;

import java.util.List;

public interface DepartmentService { //interface DepartmentService can have multiple implementations in various classes, one of the implementations being in the DepartmentServiceImpl.java class
    Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId);

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);

}
