package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // this will tell spring that this is the configuration and whatever configuration is defined we need to act accordingly
//@ComponentScan(basePackages = "demo") //inside bracket we are telling spring where to scan, here we are telling scan in base package = demo package
public class BeanConfig {

    @Bean //telling spring that whenever you are loading this is the bean that you need to load //Bean 1
    public Doctor Madhav(){ //method name Madhav which is returning a new object of the Doctor.java class
        return new Doctor();
    }

//    @Bean    //Bean 2
//    public Nurse Sonia(){ //if you unhide this and hide above bean, then it will give error as, we are creating bean/object of Nurse.java class and storing in the container but in the Main.java class they are asking for ".getBean(Doctor.class);" which means they are asking for object of Doctor.java class, which has not been created yet so error
//        return new Nurse();
//    }

    //if you unhide both Bean 1 and Bean 2 then no error as ----> in this case we are creating bean/object of both Doctor.java class and Nurse.java class and storing them in the container, in the Main.java class when they are ask for ".getBean(Doctor.class);" which means when they are ask for object of Doctor.java class, as spring has already created it, spring will give it to you. SIMPLE!

}

