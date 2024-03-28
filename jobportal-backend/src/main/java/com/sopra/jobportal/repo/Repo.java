package com.sopra.jobportal.repo;

import com.sopra.jobportal.model.JobPortal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface Repo extends MongoRepository<JobPortal, Integer> {

    @Query("{jobCategory:  ?0}")
    List<JobPortal> getbyjobCategory(String jobCategory);

    @Query("{jobTitle:  ?0}")
    List<JobPortal> getbyjobTitle(String jobTitle);
}
