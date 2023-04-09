package demo;

public class Doctor implements Staff {
    public void assist() { //doctor can assist others
        System.out.println("Doctor is assisting");
    }

//Suppose we have a Qualification.java class, and we want to use the Qualification.java class here in the Doctor.java class, so we will create a "qualification" reference to it, and whenever we want to create a new object of Qualification , we will do that either in the getter/setter or in the constructor of the Qualification.java class , we will instantiate that object using new keyword in the getter/setter or in the constructor of the Qualification.java class, so currently Qualification.java class is bound to Doctor.java class i.e they are tightly coupled i.e whenever we want a Doctor.java class we have to have the Qualification.java class, i.e without having Qualification.java class we cannot create object of Doctor.java class

    //Qualification qualification;
//To solve this concern we need to be in a position where we can access/call/create objects of both Doctor.java class and Qualification.java class independently i.e the case when Doctor.java class and Qualification.java class are loosely coupled //Spring allows us to solve this concern by allowing to perform loose coupling within the objects that we are creating i.e if you want to work with only Doctor.java class without any connection to Qualification.java class you should be able to work (if qualification is available it is fine we can use qualification with doctor but in case when qualification is not available even in that case we should still be able to use doctor class or create doctor objects comfortably), similarly if you directly want to work with only Qualification.java class without any connection to Doctor.java class you should be able to work
//Other reason why we have to do loose coupling is for the unit testing -  we will be creating huge projects and to test everything everytime is very cumbersome and not possible, so instead we separate down or we create different small components and we try to test those small components,i.e we instead do unit testing on those small components instead of doing testing on everything everytime // i.e suppose we have created a Doctor class and a Qualification class, then we should be able to test both of them separately and we should be able to test both of them together also.....so in order to achieve this,i.e to perform loose coupling we make use of Dependency Injection feature of Spring, we just create different classes and just tell spring these are the classes I have rest of the work like referencing all the classes to each other,connection between various objects and classes, no need for us to use new keyword to create new object (just add annotations rest i.e give basic blueprint/idea to spring rest all it will handle on its own) and many more functions etc all this work Spring will handle itself on its own, basically we are doing inversion of control i.e we are giving control to the spring, now spring will take care of everything on its own //in order to perform the process "Dependency Injection" we are doing Inversion of Control (giving control to spring)


//Setter and Getter Injection - Injecting Properties via XML
    private String qualification; //by default spring will assign default value as "null" to qualification, but if we want we can add value for qualification, we can inject those values of the properties by adding them in the spring.xml file

    public String getQualification() {
        System.out.println("Ram");
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

//Setter and Getter Injection - Injecting whole Object via XML (Also Possible, Not IMP just tried)
//here instead of putting value we are putting ref in the XML file like this - <property name="nurse" ref="nurse">, where the ref="nurse" will redirect to the below nurse bean tag that has already been created in the XML file, so here the entire below object nurse will be injected into the doctor class present in the XML file
    private Nurse nurse;

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }


//Constructor based Injection

//    private String qualification;

//    public Doctor(String qualification) {
//        this.qualification = qualification;
//    }

//    public String getQualification() {
//        System.out.println("Ram");
//        return qualification;
//    }

}