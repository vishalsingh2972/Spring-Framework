package demo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect //to make spring identify this class as an aspect
@Component //basically if we put only @aspect spring will be able to identify it as an aspect, but it won't be able to use it in the application. In order for spring to be able to also use it in the application we need to also have the @component as well along with the @aspect
public class LoggingAspect { //aspects are like instructions that AOP gives to C3 for when and where to execute, so in order to do this we create "Aspects" in the form of separate classes For eg: LoggingAspect.java and AuthenticationAspect.java, now in these aspect classes we have methods(like beforeLogger() method and afterLogger() method in LoggingAspect.java class) , and when and where to run these methods must run is defined by pointcuts(like pointcut @Before("execution(* demo.ShoppingCart.checkout(..))") for beforeLogger() method and pointcut @After("execution(* *.*.checkout(..))") for afterLogger() method in the LoggingAspect.java class)
                             //so two things are important - 1)what is something we want to call and 2)where we want to call it.......suppose we want to call beforeLogger() method at the checkout() method, so here beforeLogger() method is the pointcut and checkout() method is the jointpoint //basically wherever we are calling the pointcuts is known as a jointpoint

//Here we put the condition - whenever in ShoppingCart.java class the checkout() method is getting executed, before executing that checkout() method I want to call beforeLogger() method of LoggingAspect.java class i.e I want beforeLogger() method to be executed before executing the checkout() method , so I put annotation @Before for beforeLogger() method           //Basically in a way we are giving instructions to spring that before executing Business Logic [i.e checkout() method ke andar ka logic, logic in this case here we have given SOUT("Checkout Method from ShoppingCart Called") ] perform the checks for cross cutting concerns automatically (here LoggingAspect.java and AuthenticationAspect.java are classes related to cross cutting concerns)
    @Before("execution(* demo.ShoppingCart.checkout(..))") //the "*" symbol is used as a wildcard to represent any return type(currently return type of checkout() method is void) that might be returned by the advised method(i.e here checkout() method). For example, if the "checkout" method in the "ShoppingCart" class returns a boolean, a String, or any other data type, the advice will still be applied before the method is executed, regardless of the actual return type. //Using "*" as a wildcard in this context is a way to ensure that the advice is applied to any method that matches the specified pointcut, regardless of its return type.
    public void beforeLogger(JoinPoint jp){
        System.out.println(jp.getSignature()); //signature of the method of the joint point that has been called //so in this way we can get the details of the joint point method //here the jointpoint method is checkout() method
        System.out.println(jp.getArgs()[0].toString()); //this way we can get details/value of the arguments we have passed in the joint point method //here as you can see in the checkout(String status) method, the value for status we have passed is "CANCELLED" via  cart.checkout("CANCELLED") in the Main.java class //so in this way we can access the value of input parameters of the joint point and then we can do any operations with that value as well
        System.out.println("Before Loggers");
    }

    @After("execution(* *.*.checkout(..))") //* *.*.checkout = first star(for any return type) second star(for any package).third star(for any class).checkout
    public void afterLogger(){
        System.out.println("After Loggers");
    }


//trying to get access to the value of return type of the joint point method

    @Pointcut("execution(* demo.ShoppingCart.quantity(..))")
    public void afterReturningPointcut(){

    }
    
//    @AfterReturning(pointcut = "afterReturningPointcut()", returning = "returnValue") //here we need to specify at which pointcut we want to call this, so for that purpose we have put the @pointcut afterReturningPointcut() above this //Also  returning = "returnValue", here we are telling whatever value is returned (i.e whatever value is returned from the joint point method) store that value in "returnValue"
//    public void afterReturning(String returnValue){
//        System.out.println("After Returning");
//        System.out.println(returnValue);
//    }

}

