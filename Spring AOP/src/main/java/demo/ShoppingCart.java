package demo;

import org.springframework.stereotype.Component;

@Component //want to create bean of this class so annotating it as @Component
public class ShoppingCart {

    public void checkout(String status){ //consider that this checkout method and it is doing the checkout for my items in the cart

        //Cross Cutting Concerns(C3) : Logging, Authentication & Authorization, Sanitize the Data etc. //whenever checkout method is being used all these are happening
        //so hence using AOP we handle C3 like Logging using LoggingAspect,java class and C3 like Authentication & Authorization using AuthenticationAspect.java class

        System.out.println("Checkout Method from ShoppingCart Called"); //Business Logic

        //Work of AOP is to separate out all the C3 from the Business Logic, so all the C3 that we want to separate out from the business logic are known as "Aspects", so here Logging, Authentication & Authorization, Sanitize the Data are all "Aspects", as we are separating these C3 from the business logic using AOP....Foe example ou have maggi with mutter, maggi is Business logic and mutter is C3, so we separate out all mutter from maggi using spoon, so her spoon is AOP and the mutter that we want to separated out are the "Aspects"
    }

    public int quantity(){ //joint point method with return type
        return 2; //we can access return type value of the joint point method by use of @AfterReturning in the LoggingAspect.java class  //this value will be returned and then by the use of "returning =" it will be stored in "returnValue"
    }

}
