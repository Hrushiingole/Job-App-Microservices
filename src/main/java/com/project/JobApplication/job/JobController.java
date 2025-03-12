package com.project.JobApplication.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;




    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        List<Job> jobList=jobService.findAll();
        return new ResponseEntity<>(jobList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String > createJobs(@RequestBody Job job){
        jobService.createJobs(job);
        return new ResponseEntity<>("Job created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job=jobService.getJobById(id);
        if(job!=null){
            return new ResponseEntity<>(jobService.getJobById(id), HttpStatus.OK);
        }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean delete=jobService.deleteJobById(id);
        if (delete){
            return new ResponseEntity<>("job deleted successfully",HttpStatus.OK);
        }

        return new ResponseEntity<>("job not found",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String > updateJob(@PathVariable Long id,@RequestBody Job job) {
        Job prevJob=jobService.getJobById(id);
        if(prevJob==null){
            return new ResponseEntity<>("job not found",HttpStatus.NOT_FOUND);
        }
       jobService.updateJob(prevJob,job);
        return new ResponseEntity<>("Job updated successfully",HttpStatus.OK);
    }




}
//    GET /jobs : get all jobs
//    GET /jobs/{id} : get job by id
//    POST /jobs : create new job
//    DELETE /jobs/{id} : delete job by id
//    PUT /jobs/{id} : update job by id

//    exmaple API URLS:
//   GET  http://localhost:8080/jobs
//    GET http://localhost:8080/jobs/1
//    POST http://localhost:8080/jobs
//    DELETE http://localhost:8080/jobs/1
//    PUT http://localhost:8080/jobs/1