package com.projectjames.lightservice.service;

import com.projectjames.lightservice.util.Request;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LightsService {

    public ResponseEntity<?> turnOffDeskLampRose() {
        String body = "{\"on\":false}";
        return Request.request(
                "/lights/4/state",
                null,
                body,
                HttpMethod.PUT
        );
    }
}
