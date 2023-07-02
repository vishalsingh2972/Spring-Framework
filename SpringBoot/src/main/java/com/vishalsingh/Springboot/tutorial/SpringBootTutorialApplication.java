package com.vishalsingh.Springboot.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //right click ---> it has @ComponentScan, so class SpringBootTutorialApplication has @ComponentScan so all classes in the base package com.vishalsingh.Springboot.tutorial are in springs radar and all these classes in the com.vishalsingh.Springboot.tutorial package which have @Component for those classes bean/object will get created and stored in the container
public class SpringBootTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutorialApplication.class, args);
	}

}
