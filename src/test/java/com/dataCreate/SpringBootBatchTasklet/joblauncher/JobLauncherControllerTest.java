package com.dataCreate.SpringBootBatchTasklet.joblauncher;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JobLauncherControllerTest {
    /**
     * Method under test: {@link JobLauncherController#handle()}
     */
    @Test
    public void testHandle() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        assertEquals("Done!", (new JobLauncherController()).handle());
    }
}

