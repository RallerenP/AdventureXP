package com.adventurealley.adventurexp.entities;

import com.adventurealley.adventurexp.util.JSONable;
import org.json.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Activity implements JSONable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int minAge;
    private int minHeightCM;
    private String image;
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

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString()
    {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minAge=" + minAge +
                ", minHeightCM=" + minHeightCM +
                ", image= " + image +
                ", price=" + price +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public JSONObject toJSON() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        JSONObject json = new JSONObject();
        json.put("name", getName());
        json.put("minAge", getMinAge());
        json.put("minHeightCm", getMinHeightCM());
        json.put("image", getImage());
        json.put("price", getPrice());
        json.put("startTime", getStartTime().format(formatter));
        json.put("endTime", getEndTime().format(formatter));
        json.put("id", getId());
        return json;
    }
}
