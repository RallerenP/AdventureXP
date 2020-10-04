package com.adventurealley.adventurexp.controllers;

import com.adventurealley.adventurexp.dtos.CreateActivityDTO;
import com.adventurealley.adventurexp.entities.Activity;
import com.adventurealley.adventurexp.services.IActivityService;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class ActivityController
{
    private IActivityService activityService;

    ActivityController(IActivityService activityService){
        this.activityService = activityService;
    }

    @PostMapping("/api/activities")
    ResponseEntity<String> createActivity(@RequestBody CreateActivityDTO createActivityDTO) {
        Activity a = activityService.createActivity(createActivityDTO);
        return new ResponseEntity<>(a.toJSON().toString(), HttpStatus.CREATED);
    }

    @GetMapping("/api/activities")
    ResponseEntity<String> getAllActivities() {
        List<Activity> activities = activityService.getAllActivities();

        JSONArray jarr = new JSONArray();
        for(Activity a : activities) {
            jarr.put(a);
        }

        return new ResponseEntity<>(jarr.toString(), HttpStatus.OK);
    }

    @GetMapping("/api/activities/{id}")
    ResponseEntity<String> getActivityById(@PathVariable("id") long id) {
        Activity a = activityService.getById(id);
        return new ResponseEntity<>(a.toJSON().toString(), HttpStatus.OK);
    }

}
