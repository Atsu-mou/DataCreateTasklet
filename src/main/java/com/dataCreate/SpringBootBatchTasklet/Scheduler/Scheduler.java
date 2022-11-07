package com.dataCreate.SpringBootBatchTasklet.Scheduler;

import com.dataCreate.SpringBootBatchTasklet.service.JobService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Autowired private JobLauncher jobLauncher;
    @Autowired private Job job;

    @Autowired private JobService jobService;

    @Scheduled(cron = "${cron}")
    public void peopleSchedule() throws Exception{
        jobLauncher.run(job,jobService.getJobParam());
    }
}
