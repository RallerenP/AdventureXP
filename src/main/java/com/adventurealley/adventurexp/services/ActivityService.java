package com.adventurealley.adventurexp.services;

import com.adventurealley.adventurexp.dtos.ActivityDTO;
import com.adventurealley.adventurexp.entities.Activity;
import com.adventurealley.adventurexp.repositories.IRepository;

import java.util.List;

public class ActivityService implements IActivityService{
    IRepository<Activity, ActivityDTO> activityRepository;

    public void ActivityService(IActivityService activityService){

    }

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.readAll();
    }

    @Override
    public Activity getActivityByName(String name) {
        List<Activity> activities = activityRepository.readAll();
        for(Activity activity: activities){
            if(activity.getName().equals(name)){
                return activity;
            }
        }
        return null;
    }

    @Override
    public Activity createActivity(ActivityDTO activityDto) {
        return activityRepository.create(activityDto);
    }

    @Override
    public boolean deleteActivity(String name) {
        return activityRepository.delete(getActivityByName(name).getId());
    }

    @Override
    public Activity updateActivity(ActivityDTO activityDto) {
        return activityRepository.update(activityDto);
    }
}
