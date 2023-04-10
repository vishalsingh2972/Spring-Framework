package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // this will tell spring that this is the configuration and whatever configuration is defined we need to act accordingly
public class BeanConfig {

    @Bean //telling spring that whenever you are loading this is the bean that you need to load
    public Doctor Pandav(){ //method name Pandav which is returning a new object of the Doctor.java class
        System.out.println("Naya Bean paida ho gaya");
        return new Doctor();

    }

//    In Spring, the @Configuration class is used to declare and configure beans. The methods annotated with @Bean inside the @Configuration class are used to create and configure the beans
//
//    When the Spring container is initialized, it scans the @Configuration classes to find the methods annotated with @Bean, for that class that has @Bean annotation it will create objects/beans...so now a bean is born so next it goes to setBeanName() method and the bean is given a name
}

