package com.sopra.jobportal.service;

import com.sopra.jobportal.model.JobPortal;

import java.util.List;

public interface Services {

     List<JobPortal> getbyTitle(String jobTitle);

     List<JobPortal> getAll();

     List<JobPortal> getbyCategory(String jobCategory);

     void add(JobPortal jp);

     JobPortal getbyId(Integer jobId);

     void  update(JobPortal jp);

     void delete(JobPortal job);


}
