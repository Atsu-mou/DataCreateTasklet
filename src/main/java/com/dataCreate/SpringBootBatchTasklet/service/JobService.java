package com.dataCreate.SpringBootBatchTasklet.service;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class JobService {

    public JobParameters getJobParam(){
        return new JobParametersBuilder()
                .addString("JobId",String.valueOf(System.currentTimeMillis()))
                .addString("executeDate", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                .toJobParameters();
    }
}
