package com.project.JobApplication.Reviews;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

}
