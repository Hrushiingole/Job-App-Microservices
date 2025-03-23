package com.project.JobApplication.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.JobApplication.Reviews.Review;
import com.project.JobApplication.job.Job;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;


    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    private List<Job> jobs;


    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Company() {
    }

    public Company(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
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
}
