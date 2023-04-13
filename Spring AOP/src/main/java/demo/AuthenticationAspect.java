package demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    @Pointcut("within(demo..*)") //within() will define for which particular type of class we want to execute for all the methods available //Specifically, the ".." part of the syntax means to match any number of subpackages, while the "*" means to match any class name within those subpackages, so in this case, "demo..*" means to match any class within any subpackage of the "demo" package
    public void authenticationPointcut(){

    }

    @Pointcut("within(demo..*)")
    public void authorizationPointcut(){

    }

//to call the above pointcuts

    @Before("authenticationPointcut() && authorizationPointcut()") //I want to run this before running the above 2 @Pointcut s
    public void authenticate(){ //this we will do before doing @pointcut authenticationPointcut(), because the first thing I want to do when any request comes is to authenticate that request
        System.out.println("Authenticating the Request");
    }

    public void authorize(){

    }

}
