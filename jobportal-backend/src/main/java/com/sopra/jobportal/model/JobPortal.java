package com.sopra.jobportal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "Job_Portal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPortal {
    @MongoId
    Integer jobId;

    String jobTitle;
    String jobCategory;
    String jobDesc;
    String[] skills;
    String companyName;

}
