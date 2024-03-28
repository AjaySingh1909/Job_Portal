package com.sopra.jobportal.service;

import com.sopra.jobportal.model.JobPortal;
import com.sopra.jobportal.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements Services {

    @Autowired
    Repo repo;
    @Override
    public List<JobPortal> getbyTitle(String jobTitle) {
        return repo.getbyjobTitle(jobTitle);
    }

    @Override
    public List<JobPortal> getAll() {

        return repo.findAll();
    }

    @Override
    public List<JobPortal> getbyCategory(String jobCategory) {


        return repo.getbyjobCategory(jobCategory);
    }

    @Override
    public void add(JobPortal jp) {
        repo.save(jp);
    }

    @Override
    public JobPortal getbyId(Integer jobId) {
        Optional<JobPortal> op=repo.findById(jobId);
        return op.get();
    }

    @Override
    public void update(JobPortal jp) {
         repo.save(jp);
    }

    @Override
    public void delete(JobPortal job) {
        repo.delete(job);
    }
}
