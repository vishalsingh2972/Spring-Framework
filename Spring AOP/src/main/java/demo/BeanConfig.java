package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "demo")
@EnableAspectJAutoProxy //@EnableAspectJAutoProxy is a Spring annotation that enables support for AspectJ annotations and proxies. Without this annotation, Spring will not be able to detect and execute the advice that you defined with the @Before annotation in LoggingAspect.java class
public class BeanConfig {

}
