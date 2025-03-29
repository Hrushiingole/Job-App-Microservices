package com.example.jobms.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJobs(Job job);

    Job getJobById(Long id);
    boolean deleteJobById(Long id);
    void updateJob(Job prevJob,Job newJob);
}
