package com.project.JobApplication.Reviews.impl;

import com.project.JobApplication.Reviews.Review;
import com.project.JobApplication.Reviews.ReviewRepository;
import com.project.JobApplication.Reviews.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews=reviewRepository.findByCompanyId(companyId);
        return reviews;
    }
}
