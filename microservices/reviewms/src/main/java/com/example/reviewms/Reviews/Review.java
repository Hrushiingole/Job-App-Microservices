package com.example.reviewms.Reviews;



import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String title;
private String description;
private double rating;
private Long companyId ;

    public Long getCompanyId() {
        return companyId ;
    }

    public Review() {
    }

    public Review(String title, String description, double rating, Long companyId) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.companyId = companyId;

    }

    public void setCompanyId(Long companyId) {
        this.companyId  = companyId;
    }

    public Review(Long companyId) {
        this.companyId = companyId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


}
