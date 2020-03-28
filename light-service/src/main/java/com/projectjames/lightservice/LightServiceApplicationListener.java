package com.projectjames.lightservice;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class LightServiceApplicationListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("event: " + event);
    }
}
