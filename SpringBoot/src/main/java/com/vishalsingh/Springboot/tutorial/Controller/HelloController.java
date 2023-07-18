package com.vishalsingh.Springboot.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Component //no need to put @ComponentScan here as package Controller is already inside of the base package com.vishalsingh.Springboot.tutorial
             //but technically class HelloController is not a simple component, it is a controller or a resource so instead here we use @Controller instead of @Component
//@Controller //right click ---> it has @Component, so @Controller is basically a specialised type of the @Component annotation only i.e even @Controller will also behave as a @Component as it also has @Component inside it
              //but currently we are creating RESTful APIs over here, and when building a RESTful API, we typically want to return data as a response, so here we use @RestController instead of @Controller
@RestController //right click ---> it has @Controller, so @RestController is basically a specialised type of the @Controller annotation only i.e even @RestController will also behave as a @Controller as it also has @Controller inside it
                //also right click ---> @RestController has @ResponseBody, and we need @RequestBody because we want our REST APIs to return some data //Without @ResponseBody, the data returned by the controller method will still be sent to the client(data displayed on screen in frontend), but it won't be in a format that the client can understand or use. It may appear as raw data or some other format that the client cannot interpret, leading to confusion or errors, hence we need @ResponseBody in order for the client to get a response in the frontend that he can understand
                //so when we put annotation @RestController it will define 2 things - 1) it will define that this a controller (as you can see @RestController has @Controller inside of it) & 2) it will tell that it will always return a response body (as you can see @RestController has @ResponseBody inside of it)
                //whatever the things that I will be doing in this class having @RestController annotation (i.e. here class HelloController), that all will be my rest endpoints
public class HelloController {

    //@RequestMapping(value = "/", method = RequestMethod.GET) //whatever request I make I want that request to be mapped to HelloWorld() method, so I am putting annotation @RequestMapping to it //value = "/" ---> whenever I hit localhost:8080/ (same as just localhost:8080) this particular method will be called, basically When you enter localhost:8080, it needs to know which method to execute and what to return. When you specify the value "/" in @RequestMapping, it maps the URL to the HelloWorld() method. However, when you don't specify any value or path in @RequestMapping like @RequestMapping(value = "", it doesn't know which method to map the URL to, and hence it returns the default error page. Basically / is like giving an address that directly url to run a particular method and return that methods value
                                                               //@RequestMapping is "VERBOSE" because each time in order to perform different actions like POST, PUT, DELETE etc we need to put method = RequestMethod.POST or RequestMethod.PUT or RequestMethod.DELETE etc, so instead of using @RequestMapping(value = "/", method = RequestMethod.GET) for get request we can instead directly just use only @GetMapping("/") for get request // even (value = "/",) has been shortened to just ("/")
                                                               //similarly for POST we can simply put just @PostMapping, for DELETE just @DeleteMapping, for PUT just @PutMapping etc instead of putting @RequestMapping(value = "/", method = RequestMethod.POST) or @RequestMapping(value = "/", method = RequestMethod.DELETE) or @RequestMapping(value = "/", method = RequestMethod.PUT) etc respectively
    @GetMapping("/") //right click ---> it has @RequestMapping(method = RequestMethod.GET) inside of it //will be running at localhost:8082/ or simply localhost:8082
    public String HelloWorld(){   //so here method HelloWorld() can be considered as an endpoint
        return "*Welcome Vishal Singh*";  //whenever I hit the endpoint HelloWorld() it gets executed and returns "Welcome Vishal Singh"
    }


    //currently by autoconfiguration spring boot is running on port tomcat 8080, but spring boot allows us to explicitly make changes to the configuration if we wish to, so we can make changes by making changes in the application.properties file //currently we are running our application on port 8080 but I want to run my application on port 8082 so to shift port from 8080 to 8082 we can add configurations in the application.properties file and make changes/shift from 8080 to 8082
    //also have added spring-boot-devtools dependency in the pom.xml


    @GetMapping("b") //will be running at localhost:8082/b
    public String Trial(){
        return "*Welcome Vishal Singh at different URL*";
    }

}
