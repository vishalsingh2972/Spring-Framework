package com.vishalsingh.Springboot.tutorial.repository;

import com.vishalsingh.Springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //a @Repository is a special type of class that helps us work with databases. It's like a special helper that knows how to talk to the database and perform database operations like saving data, updating data, deleting data, and retrieving data //When we mark a class with the @Repository annotation, Spring will automatically create an object of that class for us and make it available throughout our application. So, we can use that object to perform any database operation that we need to, If we didn't use JpaRepository, we would have to manually implement all of these methods ourselves, which would be time-consuming and error-prone. By extending JpaRepository, we can focus on implementing any custom methods we need for our specific use case, and let Spring Data JPA handle the common operations for us //Also, by extending JpaRepository in your DepartmentRepository interface, you are using Spring Data JPA to provide the implementation of the repository methods for you. JpaRepository is a part of Spring Data JPA, and it provides a set of common methods for performing CRUD (Create, Read, Update, Delete) operations on entities
             //also right click ---> it has @Component, so which means it will be or is in the springs radar, so whenever the application starts, for all these @Component classes objects will be created and added to our spring container, so whenever we want we can use this class directly without need for creating objects in order to access the class. Once a class is in the Spring container, it can be accessed and used throughout the application without the need for manual instantiation
public interface DepartmentRepository extends JpaRepository<Department, Long> { //extending DepartmentRepository.java interface to JpaRepository.java interface
                                                                                //<Department, Long> == <name of entity, here we passed Department entity, type of primary key, here our primary key(departmentId) type is Long>
//unlike for the service layer (service package) where we created a separate concrete implementation class (DepartmentServiceImpl.java class) for the DepartmentService.java interface implementation, BUT here for the DepartmentRepository.java interface implementation we won't be creating a separate concrete implementation class rather extending the DepartmentRepository.java interface to the JpaRepository.java interface itself, because JpaRepository provides us with a lot of pre-defined methods for performing common database operations for interacting our entities with the database. By extending the JpaRepository, we inherit all of these pre-defined methods, and we can use them directly in our DepartmentRepository interface without having to implement them ourselves

    public Department finByDepartmentName(String departmentName); //convention is findBy+(name of input that we are using to find(in camel case)) ---> findByDepartmentName as we are giving input as departmentName to get all the details back




}