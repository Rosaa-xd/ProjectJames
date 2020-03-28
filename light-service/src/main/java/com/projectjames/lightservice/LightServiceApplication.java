package com.projectjames.lightservice;

import com.projectjames.lightservice.config.Config;
import com.projectjames.lightservice.exception.IncompleteConfigException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class LightServiceApplication {

	static class EnvironmentPreperation implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
		@Override
		public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
			String home = event.toString();
			Config.getConfig();
			if (Config.USERNAME == null || Config.IP_ADDRESS == null) {
				throw new IncompleteConfigException();
//				throw new ApplicationContextException("Username (" + Config.USERNAME +
//						") or IP Address (" + Config.IP_ADDRESS + ") is missing.");
			}
		}
	};

	public static void main(String[] args) {
		SpringApplication lightService = new SpringApplication();
		lightService.addListeners(new LightServiceApplication.EnvironmentPreperation());
		lightService.setSources(new HashSet(Arrays.asList(LightServiceApplication.class)));
		ConfigurableApplicationContext context = lightService.run(args);
	}


}
