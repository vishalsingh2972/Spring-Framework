package demo;
import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Doctor implements Staff, BeanNameAware { //BeanNameAware - on of the "Aware" interfaces in Spring Framework

    public void assist() { //doctor can assist others
        System.out.println("Doctor is assisting");
    }

//    When a bean is created, it needs a name so that other parts of the application can refer to it. The setBeanName() method is like a helper that sets the name of the bean after it's created
//
//    Think of it like this - when you're born, your parents give you a name. Similarly, when a bean is created, the container (like a parent) gives it a name. The setBeanName() method is like a helper that tells the bean what its name is, so it knows how to introduce itself to others
//
//    So, the setBeanName() method is called after the bean is created, and it helps the bean know what its name is, so it can interact with other parts of the application
    @Override
    public void setBeanName(String name) { //The setBeanName() method is called by the Spring container as soon as the bean is created
        System.out.println("setBeanName method is called, and ab Bean ka naamkaran ho gaya");
    }

    @PostConstruct //in order to add @PostConstruct, we first need to download "javax.annotation-api" dependency via maven, and then we add javax.annotation-api <dependency> tag in the pom.xml file  //Specifying the dependencies in the pom.xml file ensures that the necessary libraries are available when the project is built and run, regardless of the environment or machine on which it is executed, so after downloading any dependencies adding their corresponding dependency tags in the pom.xml is very important and a good practise as per norms/rules in order to avoid any future abnormalities, unnecessary errors and issues with the application in the long run
    public void postConstruct(){
        System.out.println("Post Construct method is called");
    }

}