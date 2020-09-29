package com.adventurealley.adventurexp.services;

import com.adventurealley.adventurexp.dtos.ActivityDTO;
import com.adventurealley.adventurexp.entities.Activity;

import java.util.List;

public interface IActivityService {
    public List<Activity> getAllActivities();
    public Activity getActivityByName(String name);
    public Activity createActivity(ActivityDTO activityDto);
    public boolean deleteActivity(String name);
    public Activity updateActivity(ActivityDTO activityDto);
}
