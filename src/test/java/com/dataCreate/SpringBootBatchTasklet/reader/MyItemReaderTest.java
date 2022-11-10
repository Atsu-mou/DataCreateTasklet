package com.dataCreate.SpringBootBatchTasklet.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MyItemReader.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MyItemReaderTest {
    @Autowired
    private MyItemReader myItemReader;

    /**
     * Method under test: {@link MyItemReader#beforeStep(StepExecution)}
     */
    @Test
    public void testBeforeStep() {
        StepExecution stepExecution = new StepExecution("Step Name", new JobExecution(123L));

        myItemReader.beforeStep(stepExecution);
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
     * Method under test: {@link MyItemReader#beforeStep(StepExecution)}
     */
    @Test
    public void testBeforeStep2() {
        StepExecution stepExecution = new StepExecution("Step Name", mock(JobExecution.class));

        myItemReader.beforeStep(stepExecution);
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
     * Method under test: {@link MyItemReader#afterStep(StepExecution)}
     */
    @Test
    public void testAfterStep() {
        ExitStatus actualAfterStepResult = myItemReader.afterStep(new StepExecution("Step Name", new JobExecution(123L)));
        assertSame(actualAfterStepResult.COMPLETED, actualAfterStepResult);
    }

    /**
     * Method under test: {@link MyItemReader#afterStep(StepExecution)}
     */
    @Test
    public void testAfterStep2() {
        ExitStatus actualAfterStepResult = myItemReader
                .afterStep(new StepExecution("Step Name", mock(JobExecution.class)));
        assertSame(actualAfterStepResult.COMPLETED, actualAfterStepResult);
    }
}

