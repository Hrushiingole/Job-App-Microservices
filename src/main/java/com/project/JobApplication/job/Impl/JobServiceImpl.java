package com.project.JobApplication.job.Impl;

import com.project.JobApplication.job.Job;
import com.project.JobApplication.job.JobRepository;
import com.project.JobApplication.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl  implements JobService {


//    private List<Job> jobs=new ArrayList<>();
@Autowired
private JobRepository jobsRepository;


    @Override
    public List<Job> findAll() {
        return jobsRepository.findAll();
    }

    @Override
    public void createJobs(Job job) {
        jobsRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        Job job =jobsRepository.findById(id).orElse(null);
        return job;
    }

    @Override
    public boolean deleteJobById(Long id) {
        Job job=jobsRepository.findById(id).orElse(null);

        if (job==null){
            return false;
        }
        jobsRepository.delete(job);
        return true;
    }

    @Override
    public void updateJob(Job prevJob, Job newJob) {
        prevJob.setDescription(newJob.getDescription());
        prevJob.setLocation(newJob.getLocation());
        prevJob.setMaxSalary(newJob.getMaxSalary());
        prevJob.setMinSalary(newJob.getMinSalary());
        prevJob.setTitle(newJob.getTitle());
        jobsRepository.save(prevJob);
    }


}
