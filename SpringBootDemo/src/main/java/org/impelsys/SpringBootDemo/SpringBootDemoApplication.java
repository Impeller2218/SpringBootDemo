package org.impelsys.SpringBootDemo;

import org.impelsys.SpringBootDemo.controller.CommentController;
import org.impelsys.SpringBootDemo.dao.CommentDaoImpl;
import org.impelsys.SpringBootDemo.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.ObjectPostProcessor;

@SpringBootApplication //Combination of @Configuration(Source of bean)+@ComponentScan(all which pacakages have the beans)+@EnableAutoConfirugation(It will enavle this mechanism(attempts to automatic configure the spring project based on our jar dependency))
//@ComponentScan(basePackages={"org.impelsys.controller","org.impelsys.resources","org.impelsys.config","org.impelsys.dao","org.impelsys.model"})
@EnableJpaRepositories
@EnableAutoConfiguration(exclude= {SecurityAutoConfiguration.class,ManagementWebSecurityAutoConfiguration.class})
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackageClasses = {CommentController.class,CommentService.class,CommentDaoImpl.class})
public class SpringBootDemoApplication {

	public static void main(String[] args) {
//		System.setProperty("server.servlet.context-path","/SpringBootDemo"); (allternative way of setting context path(not recommended))
		
		ApplicationContext context = new SpringApplicationBuilder(SpringBootDemoApplication.class)
											.profiles("dev").run(args);
//		SpringApplication.run(SpringBootDemoApplication.class, args);
		System.out.println("hello from springboot");
	}

}

//Jersey media jaxB is required for xml