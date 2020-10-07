package com.adventurealley.adventurexp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("views/activities")
    String getActivitiesView() {
        return "views/activities";
    }

    @GetMapping("views/home")
    String getHome() {
        return "views/home";
    }

    @GetMapping("views/activity")
    String getActivityView() {
        return "views/activity";
    }

    @GetMapping("views/edit-activity")
    String getEditActivityView() {
        return "views/edit-activity";
    }

    @GetMapping("views/create-activity")
    String getCreateActivityView() {return "views/create-activity";}

    @GetMapping("/activities")
    String getActivities() {
        return "index";
    }

    @GetMapping("/login")
    String login() {
        return "index";
    }

    @GetMapping("/activity/**")
    String getActivity(){
        return "index";
    }

    @GetMapping("/activities/edit/*")
    String editActivity() {
        return "index";
    }

    @GetMapping("/activities/create")
    String createActivity() {return "index";}
}
