package com.vishalsingh.Springboot.tutorial.service;

import com.vishalsingh.Springboot.tutorial.entity.Department;
import com.vishalsingh.Springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service //when we use the @Service annotation, it means that the class is designed to perform a specific service or task, and that it should be managed by Spring so that we can easily use it in our application //For example, imagine you have a class called "EmailService" that sends emails. If you mark this class with the @Service annotation, it means that Spring will manage it for you, and you can easily use it in other parts of your code whenever you need to send an email
          //also right click ---> it has @Component, so which means it will be or is in the springs radar, so whenever the application starts, for all these @Component classes objects will be created and added to our spring container, so whenever we want we can use this class directly without need for creating objects in order to access the class. Once a class is in the Spring container, it can be accessed and used throughout the application without the need for manual instantiation
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
         return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentBtId(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get(); //getting value from the database and storing it in depDB variable for further processing //This code is working with only one particular id that we got as input and this process repeats each time we enter a new input id value. Basically, each time depDB is associated with only one id value that has been entered

//checks for values - skip null and blank values, perform operation only on those values that are not null and not blank
        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())){      //Objects.nonNull(department.getDepartmentName()) checks if the department name is not null && !"".equalsIgnoreCase(department.getDepartmentName()) checks if the department name is not an empty string
            depDB.setDepartmentName(department.getDepartmentName());  //updating the department name field in the depDB with the new value provided
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());   //updating the department code field in the depDB with the new value provided
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());  //updating the department address field in the depDB with the new value provided
        }
        //checks over and changed done

//Now after the changes have been made to depDB here in the service layer, it is then saved to the database via the repository layer
//Once the updated depDB is saved in the database, it is once again fetched from the database again using the repository layer and returned from the service layer to the controller layer, which in turn can send it back to the client/frontend
        return departmentRepository.save(depDB);
    }

//We have a default method to findById in the JpaRepository, but we don't have any default method in JpaRepository to findByName hence we create a method ourselves in the DepartmentRepository.java class for applying fetchDepartmentByName (giving input as name and getting details back)
    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.finByDepartmentName(departmentName);
    }
}
