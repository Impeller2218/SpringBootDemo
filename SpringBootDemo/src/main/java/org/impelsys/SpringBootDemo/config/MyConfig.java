package org.impelsys.SpringBootDemo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.impelsys.SpringBootDemo.resources.MessageResource;
import org.impelsys.SpringBootDemo.resources.UserResource;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig extends ResourceConfig{
	public MyConfig() {
//		register(UserResource.class);
		register(MessageResource.class);
	}
}