package com.adventurealley.adventurexp.services;

import com.adventurealley.adventurexp.dtos.ActivityDTO;
import com.adventurealley.adventurexp.dtos.CreateActivityDTO;
import com.adventurealley.adventurexp.entities.Activity;
import com.adventurealley.adventurexp.repositories.ActivityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ActivityService implements IActivityService {

    private ActivityRepository activityRepository;

    ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public Activity createActivity(CreateActivityDTO createActivityDto) {
        Activity a = new Activity();
        a.setName(createActivityDto.getName());
        a.setMinAge(createActivityDto.getMinAge());
        a.setMinHeightCM(createActivityDto.getMinHeight());
        a.setMinPeriodMin(createActivityDto.getMinPeriodMin());
        a.setPrice(createActivityDto.getPrice());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startTime = LocalDateTime.parse(createActivityDto.getStartTime(), formatter);
        LocalDateTime endTime = LocalDateTime.parse(createActivityDto.getEndTime(), formatter);

        a.setStartTime(startTime);
        a.setEndTime(endTime);

        a = activityRepository.save(a);

        return a;
    }

    @Override
    public List<Activity> getAllActivities()
    {
        return activityRepository.findAll();
    }

    @Override
    public Activity getById(long id) {
        return activityRepository.getById(id);
    }
}
