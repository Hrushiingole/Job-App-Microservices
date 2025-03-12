package com.project.JobApplication.job.Impl;

import com.project.JobApplication.job.Job;
import com.project.JobApplication.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl  implements JobService {


    private List<Job> jobs=new ArrayList<>();
    private Long nextId=1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJobs(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        Job job=getJob(id);
        jobs.remove(job);
        if (job==null){
            return false;
        }
        return true;
    }

    @Override
    public void updateJob(Job prevJob, Job newJob) {
        prevJob.setDescription(newJob.getDescription());
        prevJob.setLocation(newJob.getLocation());
        prevJob.setMaxSalary(newJob.getMaxSalary());
        prevJob.setMinSalary(newJob.getMinSalary());
        prevJob.setTitle(newJob.getTitle());

    }

    private Job getJob(Long id){
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }
}
