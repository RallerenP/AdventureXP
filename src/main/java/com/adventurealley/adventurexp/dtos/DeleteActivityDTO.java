package com.adventurealley.adventurexp.dtos;

public class DeleteActivityDTO {
    private long id;
    private String name;
    private int minAge;
    private int minHeight;
    private int minPeriodMin;
    private double price;
    private String startTime;
    private String endTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getMinAge()
    {
        return minAge;
    }

    public void setMinAge(int minAge)
    {
        this.minAge = minAge;
    }

    public int getMinHeight()
    {
        return minHeight;
    }

    public void setMinHeight(int minHeight)
    {
        this.minHeight = minHeight;
    }

    public int getMinPeriodMin()
    {
        return minPeriodMin;
    }

    public void setMinPeriodMin(int minPeriodMin)
    {
        this.minPeriodMin = minPeriodMin;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }
}

