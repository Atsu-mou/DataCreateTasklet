package com.dataCreate.SpringBootBatchTasklet.writer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.dataCreate.SpringBootBatchTasklet.Model.Pet;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(classes = {MyItemWriter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MyItemWriterTest {
    @Autowired
    private MyItemWriter myItemWriter;

    @MockBean
    private RestTemplate restTemplate;

    /**
     * Method under test: {@link MyItemWriter#write(List)}
     */
    @Test
    public void testWrite2() throws Exception {

        when(restTemplate.exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(), (Class<Object>) any(),
                (Object[]) any())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

        ArrayList<Pet> petList = new ArrayList<>();
        petList.add(new Pet());
        myItemWriter.write(petList);
    }
    /**
     * Method under test: {@link MyItemWriter#beforeStep(StepExecution)}
     */
    @Test
    public void testBeforeStep() {
        StepExecution stepExecution = new StepExecution("Step Name", new JobExecution(123L));

        myItemWriter.beforeStep(stepExecution);
        assertEquals(0, stepExecution.getCommitCount());
        assertFalse(stepExecution.isTerminateOnly());
        assertEquals(0, stepExecution.getWriteSkipCount());
        assertEquals(0, stepExecution.getWriteCount());
        assertEquals(
                "StepExecution: id=null, version=null, name=Step Name, status=STARTING, exitStatus=EXECUTING, readCount=0,"
                        + " filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=0,"
                        + " rollbackCount=0",
                stepExecution.getSummary());
        assertEquals(BatchStatus.STARTING, stepExecution.getStatus());
        assertEquals(0, stepExecution.getRollbackCount());
        assertEquals(0, stepExecution.getReadSkipCount());
        assertEquals(0, stepExecution.getReadCount());
        assertEquals(0, stepExecution.getProcessSkipCount());
        assertTrue(stepExecution.getFailureExceptions().isEmpty());
        assertEquals(0, stepExecution.getFilterCount());
    }

    /**
     * Method under test: {@link MyItemWriter#beforeStep(StepExecution)}
     */
    @Test
    public void testBeforeStep2() {
        StepExecution stepExecution = new StepExecution("Step Name", mock(JobExecution.class));

        myItemWriter.beforeStep(stepExecution);
        assertEquals(0, stepExecution.getCommitCount());
        assertFalse(stepExecution.isTerminateOnly());
        assertEquals(0, stepExecution.getWriteSkipCount());
        assertEquals(0, stepExecution.getWriteCount());
        assertEquals(
                "StepExecution: id=null, version=null, name=Step Name, status=STARTING, exitStatus=EXECUTING, readCount=0,"
                        + " filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=0,"
                        + " rollbackCount=0",
                stepExecution.getSummary());
        assertEquals(BatchStatus.STARTING, stepExecution.getStatus());
        assertEquals(0, stepExecution.getRollbackCount());
        assertEquals(0, stepExecution.getReadSkipCount());
        assertEquals(0, stepExecution.getReadCount());
        assertEquals(0, stepExecution.getProcessSkipCount());
        assertEquals(0, stepExecution.getFilterCount());
        assertTrue(stepExecution.getFailureExceptions().isEmpty());
    }

    /**
     * Method under test: {@link MyItemWriter#afterStep(StepExecution)}
     */
    @Test
    public void testAfterStep() {
        ExitStatus actualAfterStepResult = myItemWriter.afterStep(new StepExecution("Step Name", new JobExecution(123L)));
        assertSame(actualAfterStepResult.COMPLETED, actualAfterStepResult);
    }

    /**
     * Method under test: {@link MyItemWriter#afterStep(StepExecution)}
     */
    @Test
    public void testAfterStep2() {
        ExitStatus actualAfterStepResult = myItemWriter
                .afterStep(new StepExecution("Step Name", mock(JobExecution.class)));
        assertSame(actualAfterStepResult.COMPLETED, actualAfterStepResult);
    }
}

