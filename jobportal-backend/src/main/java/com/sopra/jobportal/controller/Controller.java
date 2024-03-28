package com.sopra.jobportal.controller;

import com.sopra.jobportal.model.JobPortal;
import com.sopra.jobportal.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/job")
public class Controller {

    @Autowired
    Services serve;

    @GetMapping("/getAll")
    public ResponseEntity<List<JobPortal>> getAll(){
        List<JobPortal> lis=serve.getAll();
        return new ResponseEntity<>(lis, HttpStatus.OK);
    }

    @GetMapping("/getbyCategory/{jobCategory}")
    public ResponseEntity<List<JobPortal>> getbyjobCategory(@PathVariable String jobCategory){
        List<JobPortal> lis=serve.getbyCategory(jobCategory);
        return new ResponseEntity<>(lis, HttpStatus.OK);
    }

    @GetMapping("/getbyTitle/{jobTitle}")
    public ResponseEntity<List<JobPortal>> getbyJobTitle(@PathVariable String jobTitle){

        List<JobPortal> lis = serve.getbyTitle(jobTitle);
        return new ResponseEntity<>(lis, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<String> add(@RequestBody JobPortal job){
        serve.add(job);
        return new ResponseEntity<>("Job Added", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{jobId}")
    public ResponseEntity<String> delete(@PathVariable Integer jobId){
        JobPortal jp = serve.getbyId(jobId);
        serve.delete(jp);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    @PutMapping("/update/{jobId}")
    public ResponseEntity<String> updateJob(@PathVariable Integer jobId, @RequestBody JobPortal jp){

        JobPortal jobPortal = serve.getbyId(jobId);

        jobPortal.setJobCategory(jp.getJobCategory());
        jobPortal.setJobTitle(jp.getJobTitle());
        jobPortal.setCompanyName(jp.getCompanyName());
        jobPortal.setJobDesc(jp.getJobDesc());
        jobPortal.setSkills(jp.getSkills());

        serve.update(jobPortal);

        return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);

    }


}
