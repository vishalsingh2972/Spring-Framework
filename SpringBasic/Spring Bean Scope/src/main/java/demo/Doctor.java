package demo;
//Different Scopes/design patterns available in the spring bean : So whenever spring is creating the beans we need to define how we want those particular beans, so there are 5 different types of scopes available in spring bean - singleton, prototype, request, session, global session
//Singleton Scope: By default all the beans will be created using the singleton scope,i.e in singleton case for each and every class there will be only one single object available in the entire application, this is the process spring will follow by default, But if we want we can ask for any other different type of scope as well  //Also when we are trying the singleton scope whenever we do any changes, those changes will reflect in all the particular objects that we get
//Prototype Scope: In prototype we will get a different object everytime when we request the object from the container
//Request Scope: Request is used when we need one object or we need a different object for each and every request that we receive in the application
//Also Scopes - request,session and global session are used mainly when there is a web context available so that is when we are implementing the spring mvc

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(scopeName = "singleton") //no need to define this explicitly as by default spring follows singleton scope //Basically, if you want a bean to be created as a singleton, you can simply define it without any explicit scope annotation and Spring will automatically use the default singleton scope
                                //However, we need to use the @Scope annotation when we are specifying a different scope such as prototype or request scope, as in this case we want our provided prototype or request @Scope annotation to override the default singleton @Scope annotation

@Scope(scopeName = "prototype")
public class Doctor implements Staff {
    @Override
    public String toString() {
        return "Doctor{" +
                "qualification='" + qualification + '\'' +
                '}';
    }

    private String qualification;
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void assist() { //doctor can assist others
        System.out.println("Doctor is assisting");
    }

}