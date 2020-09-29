package com.adventurealley.adventurexp.dtos;

public class ActivityDTO {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    private String name;
    private String time;
    private int minAge;
    private int minHeightCm;
    private int minPeriodMin;
    private double price;
}
