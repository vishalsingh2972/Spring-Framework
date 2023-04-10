package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

      ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class); //inside bracket class is the class that defines the configuration for my annotations, so here in this case it is the BeanConfig class. So here it will refer the BeanConfig class, where it will come to know that it is a @Configuration class and it will also come to know that we should do @ComponentScan i.e we need to scan "demo" as the base package and whatever the components are there we need to load those components

        //Singleton Scope
//        Doctor Hanuman = context.getBean(Doctor.class);
//        Hanuman.assist();
//        Hanuman.setQualification("MBBS");
//        System.out.println(Hanuman); //will get object1 by .getBean(Doctor.class) and print object1.....in this case object1=MBBS
//
//        Doctor Hanuman2 = context.getBean(Doctor.class);
//        System.out.println(Hanuman2);//will get the same object i.e object1 back, i.e even Hanuman2 will print MBBS. This is happening as by default it is the singleton design pattern/singleton scope being implemented for all the beans. So here for Doctor.java class spring is creating only 1 bean/object for the entire application and whenever I am asking object of Doctor.java class, spring is returning the same object i.e object1 everytime

        //Prototype Scope
        Doctor Hanuman = context.getBean(Doctor.class);
        //Hanuman.assist();
        Hanuman.setQualification("MBBS");
        System.out.println(Hanuman); //will get object1 by .getBean(Doctor.class) and print object1.....in this case object1=MBBS

        Doctor Hanuman2 = context.getBean(Doctor.class);
        System.out.println(Hanuman2);//will not get the same object i.e object1 back as scope is prototype (In prototype we will get a different object everytime when we request the object from the container)


    }
}
