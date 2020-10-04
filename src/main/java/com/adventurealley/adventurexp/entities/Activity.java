package com.adventurealley.adventurexp.entities;

import com.adventurealley.adventurexp.util.JSONable;
import org.json.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Activity implements JSONable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int minAge;
    private int minHeightCM;
    private int minPeriodMin;
    private double price;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString()
    {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minAge=" + minAge +
                ", minHeightCM=" + minHeightCM +
                ", minPeriodMin=" + minPeriodMin +
                ", price=" + price +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("name", getName());
        json.put("minAge", getMinAge());
        json.put("minHeightCm", getMinHeightCM());
        json.put("minPeriodMin", getMinPeriodMin());
        json.put("price", getPrice());
        json.put("startTime", getStartTime().toString());
        json.put("endTime", getEndTime().toString());
        return json;
    }
}
