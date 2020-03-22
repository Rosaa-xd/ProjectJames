package com.projectjames.lightservice.controller;

import com.projectjames.lightservice.service.LightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LightsController {

    @Autowired
    private LightsService lightsService;

    @PutMapping("/turnOff")
    public ResponseEntity<?> turnOff() {
        return lightsService.turnOffDeskLampRose();
    }
}
