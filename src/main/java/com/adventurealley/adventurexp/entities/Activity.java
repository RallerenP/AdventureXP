package com.adventurealley.adventurexp.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Activity {

    private String name;
    private int minAge;
    private int minHeightCM;
    private int minPeriodMin;
    private double price;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Activity(String name, int minAge, int minHeightCM, int minPeriodMin, double price, LocalDateTime startTime, LocalDateTime endTime) {
        this.name = name;
        this.minAge = minAge;
        this.minHeightCM = minHeightCM;
        this.minPeriodMin = minPeriodMin;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMinHeightCM() {
        return minHeightCM;
    }

    public void setMinHeightCM(int minHeightCM) {
        this.minHeightCM = minHeightCM;
    }

    public int getMinPeriodMin() {
        return minPeriodMin;
    }

    public void setMinPeriodMin(int minPeriodMin) {
        this.minPeriodMin = minPeriodMin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
