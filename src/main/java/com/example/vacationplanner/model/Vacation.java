package org.blen.wondimagegn.vacationplanner.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Data
@Entity
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String hotel;
    private String startDate;
    private String endDate;
    private String destination;

    public Vacation(Long id, String title, String hotel, String startDate, String endDate, String destination) {
        this.id = id;
        this.title = title;
        this.hotel = hotel;
        this.startDate = startDate;
        this.endDate = endDate;
        this.destination = destination;
    }

    public Vacation() {
        this.id = null;
        this.title = " ";
        this.hotel = " ";
        this.startDate = " ";
        this.endDate = " ";
        this.destination = " ";
    }
    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Excursion> excursions;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    // Getters and Setters for reviews
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}

