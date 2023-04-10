package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

//        Doctor Krishna = context.getBean(Doctor.class);
//        Krishna.assist();

        Staff Krishna2 = context.getBean(Doctor.class);
        Krishna2.assist();

        Staff Radha = context.getBean(Nurse.class); //will give error as spring will see that Nurse is not a component yet as we have not provided @Component for Nurse class, till now spring only knows that Doctor is a component as Doctor class has @Component annotation
                                                   //for removing this error, make Nurse class as component, we do this by putting @Component annotation in the Nurse class, after putting @Component in Nurse class this should run without error as now spring is able to see and will consider even Nurse class as component for bean creation
        Radha.assist();

    }
}
