package com.dataCreate.SpringBootBatchTasklet.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {JobService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class JobServiceTest {
    @Autowired
    private JobService jobService;

    /**
     * Method under test: {@link JobService#getJobParam()}
     */
    @Test
    public void testGetJobParam() {
        Map<String, JobParameter> parameters = jobService.getJobParam().getParameters();
        assertEquals(2, parameters.size());
        JobParameter getResult = parameters.get("executeDate");
        assertTrue(getResult.isIdentifying());
        JobParameter getResult1 = parameters.get("JobId");
        assertTrue(getResult1.isIdentifying());
        assertEquals(JobParameter.ParameterType.STRING, getResult1.getType());
        assertEquals(JobParameter.ParameterType.STRING, getResult.getType());
    }
}

