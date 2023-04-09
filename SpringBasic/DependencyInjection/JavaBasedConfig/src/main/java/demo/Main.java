package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

      ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class); //inside bracket class is the class that defines the configuration for my annotations, so here in this case it is the BeanConfig class. So here it will refer the BeanConfig class, where it will come to know that it is a @Configuration class and it will also come to know that we should do @ComponentScan i.e we need to scan "demo" as the base package and whatever the components are there we need to load those components

        Staff Kalki = context.getBean(Doctor.class);
        Kalki.assist();

    }
}
