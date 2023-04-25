package com.vishalsingh.Springboot.tutorial.Controller;

import com.vishalsingh.Springboot.tutorial.entity.Department;
import com.vishalsingh.Springboot.tutorial.repository.DepartmentRepository;
import com.vishalsingh.Springboot.tutorial.service.DepartmentService;
import com.vishalsingh.Springboot.tutorial.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController { //controller for Department entity i.e Department.java class in entity package

    //calling the service layer (RIGHT CONVENTION)
    @Autowired //in the service layer we used @Service which has @Component so a instance/bean of service layer was created and stored in spring container at the start of the application now to access/ get that bean from the spring container here in the controller class we use @Autowired
               //When you annotate a class with @Service, Spring creates an instance of that service class and stores it in the application context/spring container as a bean. Then, when you use @Autowired in a controller class, Spring looks for the requested bean in the application context and injects it into the controller class, INJECTS - you can think of injecting a bean as a way of getting that bean from the bean container (i.e., the application context) and using it in your code
               //So you can think of @Autowired as a way of getting an instance of a bean that has already been created and stored in the Spring container. This allows you to easily access and use beans from different parts of your application, without having to worry about creating and managing instances of those beans yourself
    private DepartmentService departmentService; //telling spring that I want object of type DepartmentService basically service layer ka object

    //add or save or input data to database
    @PostMapping("/departments") //POST method is commonly used to submit new data or to update existing data, so whatever the changes user makes on the frontend those changes will be sent to the web application's server as a POST request to the "/departments" URL, then the web application's server will use the @PostMapping annotation to route the request to the appropriate method to process, wo jo request aara jis method ke upar @PostMapping Likha hain jaise hamare case main "Department saveDepartment()", so request yaha aata is method main jo bhi specified hai wo execute karta aur ek response return karta from the method jo ki phir user ko dikhayi dega on his/her screen //for eg : For example, a user may be filling out a form to create a new department and then submit the form by clicking a "Save" button. When they do so, the data from the form will be sent to the web application's server as a POST request to the "/departments" URL. The web application's server will then use the @PostMapping annotation to route the request to the appropriate method to process the data and save the new department that was inputted by the user, and then after whole process is done the same method(present under @PostMapping) will return a response that is shown to the user to indicate the result of the save operation on the user screen in the form of "saved successfully" or displaying whole new updated departments list with added department
                                 //here from the frontend in the POST method I am passing the request body as well, so I will be passing in an entire json object and I want that whole json object that is coming over here to be converted into my entity i.e the Department entity or Department Object
    public Department saveDepartment(@RequestBody Department department){ //"Department department" ---> represents what I want as an input i.e the Department entity or Department Object //@RequestBody ---> by putting this we are telling spring that whatever input data you are getting in the form of a json object convert it into the form of "Department department" i.e convert that json object into a Department entity or Department Object

        //now after receiving data from user we next need to call the service layer to pass this data and service layer will then call the repository layer to pass the data and then repository layer will interact with the database and make the appropriate changes in the data  as per instructions inputted by the frontend user

        //calling the service layer (WRONG CONVENTION)
//         DepartmentService service = new DepartmentServiceImpl(); //explicitly creating object of service layer class to call/access service layer class //NOT CORRECT way
                                                                  //WRONG CONVENTION, let spring do all the work as we have already defined @Component and spring already has @Component class objects/beans stored in its container so let spring do the job no need for you to "explicitly" create new objects using new keyword

        return departmentService.saveDepartment(department);

    }

    //get all from database
    @GetMapping("/departments") //GET method is used to retrieve or fetch data from the database
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    //get all from database by using id  //here we are passing id as input
    @GetMapping("/departments/{id}") //id is the value that I will be sending for which I want to get the whole data back, like I will send id (suppose departmentId=1) as input and should get other details like departmentName, departmentAddress,departmentCode...back for that particular id value that I have inputted (i.e here departmentId=1) // {id} is a path variable which means that its value is dynamic and can be different each time you access the database, basically every/each time we can enter/input different id values and in return every/each time we will get access to the details of that particular id
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentBtId(departmentId);
    }

    //delete data from database        //here we are passing id as input
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully!!";
    }

    //update the existing data from database    //here we are passing id as input for telling which id you want to make changes and also passing the body for that id i.e also passing the changes we want to make in that particular id
    @PutMapping("/departments/{id}")     //@PutMapping annotation is typically used for updating existing resources in the database
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){ //The @PathVariable is used to specify which record to update based on the value of the specified path variable, while the @RequestBody is used to specify the new values to be updated in the specified record, like here I am giving input as id=2 i.e the @PathVariable or the row I want to make changes in and the @RequestBody are those parameters/columns in this row id=2 that I want to edit/make changes in
        return departmentService.updateDepartment(departmentId,department);
    }

    //get all from database by using name
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
