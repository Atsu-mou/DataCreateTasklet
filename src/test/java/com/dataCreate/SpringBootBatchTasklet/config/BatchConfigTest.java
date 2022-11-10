package com.dataCreate.SpringBootBatchTasklet.config;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class BatchConfigTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link BatchConfig}
     *   <li>{@link BatchConfig#getJobExplorer()}
     *   <li>{@link BatchConfig#getJobLauncher()}
     *   <li>{@link BatchConfig#getJobRepository()}
     *   <li>{@link BatchConfig#getTransactionManager()}
     * </ul>
     */
    @Test
    public void testConstructor() throws Exception {
        BatchConfig actualBatchConfig = new BatchConfig();
        assertNull(actualBatchConfig.getJobExplorer());
        assertNull(actualBatchConfig.getJobLauncher());
        assertNull(actualBatchConfig.getJobRepository());
        assertNull(actualBatchConfig.getTransactionManager());
    }
}

