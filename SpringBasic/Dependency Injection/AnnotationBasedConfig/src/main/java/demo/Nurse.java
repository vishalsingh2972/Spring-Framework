package demo;

import org.springframework.stereotype.Component;

//@Component //try with "Staff Radha = context.getBean(Nurse.class);" in Main.java class
public class Nurse implements Staff {
    public void assist() { //nurse can assist others
        System.out.println("Nurse is assisting");
    }

}
