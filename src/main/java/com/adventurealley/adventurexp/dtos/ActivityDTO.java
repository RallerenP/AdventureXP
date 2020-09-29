package com.adventurealley.adventurexp.dtos;

public class ActivityDTO {
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

    public int getMinHeightCm() {
        return minHeightCm;
    }

    public void setMinHeightCm(int minHeightCm) {
        this.minHeightCm = minHeightCm;
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

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    private String name;
    private int minAge;
    private int minHeightCm;
    private int minPeriodMin;
    private double price;
    private String endTime;
    private String startTime;
}
