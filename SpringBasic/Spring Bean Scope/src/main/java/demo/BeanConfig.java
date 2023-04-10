package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration // this will tell spring that this is the configuration and whatever configuration is defined we need to act accordingly
@ComponentScan(basePackages = "demo")
public class BeanConfig {

//    @Bean //telling spring that whenever you are loading this is the bean that you need to load
//    public Doctor Sugreev(){ //method name Sugreev which is returning a new object of the Doctor.java class
//        return new Doctor();
//    }

}

