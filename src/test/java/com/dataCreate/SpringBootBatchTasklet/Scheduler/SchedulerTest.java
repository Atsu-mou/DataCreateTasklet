package com.dataCreate.SpringBootBatchTasklet.Scheduler;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dataCreate.SpringBootBatchTasklet.service.JobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {Scheduler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SchedulerTest {
    @MockBean
    private Job job;

    @MockBean
    private JobLauncher jobLauncher;

    @MockBean
    private JobService jobService;

    @Autowired
    private Scheduler scheduler;

    /**
     * Method under test: {@link Scheduler#peopleSchedule()}
     */
    @Test
    public void testPeopleSchedule() throws Exception {
        when(jobLauncher.run((Job) any(), (JobParameters) any())).thenReturn(new JobExecution(123L));
        when(jobService.getJobParam()).thenReturn(new JobParameters());
        scheduler.peopleSchedule();
        verify(jobLauncher).run((Job) any(), (JobParameters) any());
        verify(jobService).getJobParam();
    }
}

