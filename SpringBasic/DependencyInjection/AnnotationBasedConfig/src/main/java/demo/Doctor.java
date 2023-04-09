package demo;

import org.springframework.stereotype.Component;

@Component //by putting @Component we are telling spring that you can use this class "Doctor" as a component to create Beans out of it
           //so,we have created a class, we have defined that class as @Component but spring still does not know where to search for that Component, so we need to tell spring in order to reach @Component class you need to search the base package, we do this i.e we tell spring to search base package by giving "<context:component-scan base-package="demo"></context:component-scan>" instruction in the spring.xml     //basically telling spring search here you will get the components
           //"<context:component-scan base-package="demo"></context:component-scan>" ---> here we are telling spring that in the demo package all the @Components are there, so search for @Components in the base package i.e here search for @Components in the demo package. And after finding whatever @Components you are getting/able to find in the demo package try to load all those components
public class Doctor implements Staff {
    public void assist() { //doctor can assist others
        System.out.println("Doctor is assisting");
    }

}