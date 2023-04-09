package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
//In order to use any method of Doctor.java class, in the Main.java class we first create its reference "doctorsaab" and then instantiate the Doctor.java class using the new keyword //basically instantiating Doctor.java by creating its object
        Doctor doctorsaab = new Doctor();
        //doctorsaab.assist(); //accessing method present in Doctor.class


//Dependency Injection - Type 1) XML based Configuration
//Whenever we start the spring application, spring wil load all the beans and it will store all the beans in the container, so now we can get/access all the beans from the container itself. So there are 2 interfaces available or basically 2 places/containers where all the beans will be stored - Bean Factory and Application Context from these we can try to get all the beans which are loaded and we can use those particular beans, so we don't need to use the new keyword anymore to get the object , we can directly use that particular object //Also, difference between Application Context and Bean Factory - Application Context extends Bean Factory so there are lot more features within the Application Context //Currently we are making use of Application Context here

//as we are using ClassPathXmlApplicationContext we need to create XML configuration for it,and that particular XML has to be in the classpath, and so here we created XML in the resources folder(resources folder is in classpath as resources is present inside the main folder //here we created XML file named "spring.xml" in resources folder
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); //here it means that we created the contexts from "spring.xml"
                                                                                                   //and whatever beans are defined in the spring.xml we can access those beans via context like shown below

              Doctor doctor = context.getBean(Doctor.class); //accessing beans present in "spring.xml" via context // .getBean(Doctor.class) = here we are telling/asking spring we want a bean of type Doctor or basically Doctor.java class ka bean chahiye we are asking here, but to get bean of Doctor.class we need to first add Doctor class bean to the container (bhai pehle container main wo chiz bharega tabhi to time aane pe maangega wo chiz, khali container se kaise maangega) , we do this by creating a bean tag of Doctor class in the spring.xml file (if we don't create a bean tag of Doctor class in the spring.xml file we will get NoSuchBeanDefinitionException error because spring still does not know that I have to create this bean so to make spring aware of which classes beans it has to create and store in container for future use we need to put bean tags of those classes for which we want beans to be created and stored in the spring.xml file) .....spring ko humko pehle bolna padega is is class ke beans bana ke store karke rakh container main by using bean tag of classes in spring.xml file and ab in order to get/call particular beans we use ".getBean(.class)", like by using .getBean(Doctor.class) we are calling/asking spring for bean of Doctor.java class so now spring will search that bean in its container and give it to us
                                                             //also for every bean tag that we define in the spring.xml, we need to make that bean unique for each class so for that we use "id", like for Doctor.java class beans , in the spring.xml we have used id = "doctor"
              //doctor.assist(); //accessing method present in Doctor.class without creation of NEW OBJECT that is created by use of new keyword //here we accessed method present in Doctor.java class without creation of any new object of Doctor class but by using the Doctor.java class bean which was already stored in the container, we accessed this container bean via the context


               Nurse doctor2 = context.getBean(Nurse.class);
//               Nurse doctor2 = (Nurse)context.getBean("nurse"); //we can also write .getBean(Nurse.class) as .getBean("nurse") i.e accessing/getting bean via id name  //also observe here we are putting (Nurse) in RHS for object type casting purpose i.e making both LHS and RHS of same type Nurse
               //doctor2.assist();

//Now both Doctor and Nurse belong to the Staff, so we created a Staff Interface where both class Doctor implements Staff and class Nurse implements Staff, so now both Doctor and Nurse are part of the Staff

               Staff staff1 = context.getBean(Doctor.class);
               //staff1.assist();
               Staff staff2 = context.getBean(Nurse.class);
               //staff2.assist();
               Staff staff3 = (Staff) context.getBean("nurse"); //this way also possible using Staff
               //staff3.assist();


//Setter and Getter Injection - Injecting Properties via XML
              Doctor Vishal = context.getBean(Doctor.class);
              System.out.println(Vishal.getQualification()); //here the value "MBBS" was injected via setters from the XML file itself //if we don't add any property name and value in XML, this will print null i.e default value for String qualification

        //Observe carefully although property name = "qualification" for both Doctor.class bean tag and Nurse.class bean tag, but we are able to print different values for .getQualification() for both Doctor.java class and Nurse.java class

              Nurse Pooja = context.getBean(Nurse.class);
              System.out.println(Pooja.getQualification());//similarly here also the value "Chota MBBS" was injected via setters from the XML file itself

//Setter and Getter Injection - Injecting whole Object via XML (Also Possible, Not IMP just tried)

             Doctor Nikhil = context.getBean(Doctor.class);
             //System.out.println(Nikhil.getNurse());


//Constructor based Injection

//        Doctor Kunal = context.getBean(Doctor.class);
//        System.out.println(Kunal.getQualification()); //calling qualification bean/object that was created and stored in the container by using a constructor bean tag in the spring.xml file (ye wala bean tag ----> "<constructor-arg value = "MBBS2"></constructor-arg>")

        //and add <constructor-arg value = "MBBS2"></constructor-arg> in spring.xml file and hide necessary methods in order to run this i.e run via using a constructor

    }
}
