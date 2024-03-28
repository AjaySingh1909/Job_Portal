/**import React, { useEffect, useState } from "react";
import axios from "axios";


const Job_Category=()=>{
    const [jobCategory, setJobCategory]= useState([]);
    const url=`http://localhost:8080/job/getbyCategory/IT`;

    useEffect(()=> {
        const getJobCategory= async()=>{
            try{
                const res=await axios.get(url);
                setJobCategory(res.data);
            }catch(error){
                console.error('Error',error);
            }
        };
        getJobCategory();
    },[url]);

    return (
        <div>
            <h1>Job by Category</h1>
            <ul>
                {jobCategory.map(job=>(
                    <li key={job.jobId}>
                        <h3>{job.jobTitle}</h3>
                        <p>{job.jobDesc}</p>
                        <p>Category: {job.jobCategory}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Job_Category; **/

import React, { useState } from "react";
import axios from "axios";

const Job_Category = () => {
    const [jobCategory, setJobCategory] = useState([]);
    const [inputCategory, setInputCategory] = useState('');

    const handleInputChange = (event) => {
        setInputCategory(event.target.value);
    };

    const fetchData = async () => {
        try {
            const url = `http://localhost:8080/job/getbyCategory/${inputCategory}`;
            const res = await axios.get(url);
            setJobCategory(res.data);
        } catch (error) {
            console.error('Error', error);
        }
    };

    return (
        <div class="main">
            <h1>Filter by Job Category</h1>
            <input
                type="text"
                value={inputCategory}
                onChange={handleInputChange}
                placeholder="Enter job category"
            /><br></br>
            <button onClick={fetchData}>Search</button>
            <ul>
                {jobCategory.map(job => (
                    <li key={job.jobId}>
                        <h3>{job.jobTitle}</h3>
                        <p>{job.jobDesc}</p>
                        <p>Category: {job.jobCategory}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Job_Category;