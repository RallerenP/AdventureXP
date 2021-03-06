package com.adventurealley.adventurexp.services;


import com.adventurealley.adventurexp.dtos.CreateActivityDTO;
import com.adventurealley.adventurexp.dtos.DeleteActivityDTO;
import com.adventurealley.adventurexp.dtos.EditActivityDTO;
import com.adventurealley.adventurexp.entities.Activity;

import java.util.List;

public interface IActivityService {
    Activity createActivity(CreateActivityDTO createActivityDto);
    List<Activity> getAllActivities();
    Activity getById(long id);
    void delete(long id);
    Activity editActivity(long id, EditActivityDTO editActivityDTO);
}
