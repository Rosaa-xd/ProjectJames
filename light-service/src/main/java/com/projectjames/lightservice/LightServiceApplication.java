package com.projectjames.lightservice;

import com.projectjames.lightservice.config.Config;
import com.projectjames.lightservice.exception.IncompleteConfigException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

import java.io.IOException;

@SpringBootApplication
public class LightServiceApplication {

	static class EnvironmentPreperation implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
		@Override
		public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
			String home = event.toString();
			Config.getConfig();
			if (Config.USERNAME.isEmpty() || Config.IP_ADDRESS.isEmpty()) {
				throw new IncompleteConfigException();
			}
		}
	};

	public static void main(String[] args) {
		SpringApplication lightService = new SpringApplication(LightServiceApplication.class);
		lightService.addListeners(new LightServiceApplication.EnvironmentPreperation());
		lightService.run(LightServiceApplication.class, args);
	}


}
