package com.adventurealley.adventurexp.controllers;

import com.adventurealley.adventurexp.dtos.CreateActivityDTO;
import com.adventurealley.adventurexp.entities.Activity;
import com.adventurealley.adventurexp.entities.Role;
import com.adventurealley.adventurexp.entities.User;
import com.adventurealley.adventurexp.services.IActivityService;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController()
public class ActivityController
{
    private IActivityService activityService;

    ActivityController(IActivityService activityService){
        this.activityService = activityService;
    }

    @PostMapping("/api/activities")
    ResponseEntity<String> createActivity(@RequestBody CreateActivityDTO createActivityDTO, HttpSession httpSession) {
        User u = (User)httpSession.getAttribute("user");

        if (u == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        if (u.getRole() != Role.EMPLOYEE) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        Activity a = activityService.createActivity(createActivityDTO);
        return new ResponseEntity<>(a.toJSON().toString(), HttpStatus.CREATED);


    }

    @GetMapping("/api/activities")
    ResponseEntity<String> getAllActivities() {
        List<Activity> activities = activityService.getAllActivities();

        JSONArray jarr = new JSONArray();
        for(Activity a : activities) {
            jarr.put(a.toJSON());
        }

        return new ResponseEntity<>(jarr.toString(), HttpStatus.OK);
    }

    @GetMapping("/api/activities/{id}")
    ResponseEntity<String> getActivityById(@PathVariable("id") long id) {
        Activity a = activityService.getById(id);
        return new ResponseEntity<>(a.toJSON().toString(), HttpStatus.OK);
    }

    @DeleteMapping("/api/activities/{id}")
    ResponseEntity<String> deleteById (@PathVariable("id") long id, HttpSession httpSession) {
        User u = (User)httpSession.getAttribute("user");

        if (u == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        if (u.getRole() != Role.EMPLOYEE) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        activityService.delete( id );
        return null;


    }

}
