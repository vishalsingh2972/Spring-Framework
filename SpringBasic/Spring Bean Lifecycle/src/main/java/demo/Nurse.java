package demo;

import org.springframework.stereotype.Component;

public class Nurse implements Staff {
    public void assist() { //nurse can assist others
        System.out.println("Nurse is assisting");
    }

}
