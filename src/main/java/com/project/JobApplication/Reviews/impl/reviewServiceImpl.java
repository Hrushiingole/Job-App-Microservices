package com.project.JobApplication.Reviews.impl;

import com.project.JobApplication.Reviews.Review;
import com.project.JobApplication.Reviews.ReviewRepository;
import com.project.JobApplication.Reviews.ReviewService;
import com.project.JobApplication.company.Company;
import com.project.JobApplication.company.Companyservice;
import com.project.JobApplication.company.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private Companyservice companyservice;

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews=reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Review createReview(Long companyId, Review review) {
        Company company=companyservice.getCompanyById(companyId);
        if(company==null)   return null;
        review.setCompany(company);
        return reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Long reviewId) {
        Review review=reviewRepository.findById(reviewId).orElse(null);
        return review;
    }

    @Override
    public boolean updateReview(Long reviewId, Review review) {
        Review review1=reviewRepository.findById(reviewId).orElse(null);
        if(review1==null) return false;
        review1.setTitle(review.getTitle());
        review1.setDescription(review.getDescription());
        if(review.getCompany()==null){
            review1.setCompany(review1.getCompany());

        }
        else{
            review1.setCompany(review.getCompany());
        }
        review1.setRating(review.getRating());
        reviewRepository.save(review1);
        return true;
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        Review review=reviewRepository.findById(reviewId).orElse(null);
        if(review==null) return false;
        reviewRepository.delete(review);
        return true;
    }
}
