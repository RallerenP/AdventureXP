package com.adventurealley.adventurexp.controllers;

import com.adventurealley.adventurexp.dtos.CreateActivityDTO;
import com.adventurealley.adventurexp.entities.Activity;
import com.adventurealley.adventurexp.services.IActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class ActivityController
{
    private IActivityService activityService;

    ActivityController(IActivityService activityService){
        this.activityService = activityService;
    }

    @PostMapping("/api/activity")
    ResponseEntity<String> createActivity(@RequestBody CreateActivityDTO createActivityDTO) {
        Activity a = activityService.createActivity(createActivityDTO);
        return new ResponseEntity<>(a.toString(), HttpStatus.CREATED);
    }

    @GetMapping("/api/activity")
    ResponseEntity<String> getAllActivities() {
        List<Activity> activities = activityService.getAllActivities();
        return new ResponseEntity<>(activities.toString(), HttpStatus.OK);
    }


}
