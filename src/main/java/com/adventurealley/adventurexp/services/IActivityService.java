package com.adventurealley.adventurexp.services;


import com.adventurealley.adventurexp.dtos.CreateActivityDTO;
import com.adventurealley.adventurexp.entities.Activity;

import java.util.List;

public interface IActivityService {
    Activity createActivity(CreateActivityDTO createActivityDto);
    List<Activity> getAllActivities();
}
