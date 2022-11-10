package com.dataCreate.SpringBootBatchTasklet.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import com.dataCreate.SpringBootBatchTasklet.Model.Pet;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.util.StdDateFormat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.FlowStep;
import org.springframework.batch.core.repository.dao.JdbcExecutionContextDao;
import org.springframework.batch.core.repository.dao.JdbcJobExecutionDao;
import org.springframework.batch.core.repository.dao.JdbcJobInstanceDao;
import org.springframework.batch.core.repository.dao.JdbcStepExecutionDao;
import org.springframework.batch.core.repository.support.SimpleJobRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriTemplateHandler;
import org.springframework.web.util.UriTemplateHandler;

@ContextConfiguration(classes = {JobConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class JobConfigTest {
    @MockBean
    private ItemReader itemReader;

    @MockBean
    private ItemWriter itemWriter;

    @MockBean
    private Job job;

    @MockBean
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private JobConfig jobConfig;

    @MockBean
    private Step step;

    @MockBean
    private StepBuilderFactory stepBuilderFactory;

    /**
     * Method under test: {@link JobConfig#restTemplate()}
     */
    @Test
    public void testRestTemplate() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        RestTemplate actualRestTemplateResult = (new JobConfig()).restTemplate();
        assertTrue(actualRestTemplateResult.getErrorHandler() instanceof DefaultResponseErrorHandler);
        UriTemplateHandler uriTemplateHandler = actualRestTemplateResult.getUriTemplateHandler();
        assertTrue(uriTemplateHandler instanceof DefaultUriTemplateHandler);
        assertTrue(actualRestTemplateResult.getRequestFactory() instanceof SimpleClientHttpRequestFactory);
        assertTrue(actualRestTemplateResult.getInterceptors().isEmpty());
        List<HttpMessageConverter<?>> messageConverters = actualRestTemplateResult.getMessageConverters();
        assertEquals(7, messageConverters.size());
        assertTrue(((DefaultUriTemplateHandler) uriTemplateHandler).getDefaultUriVariables().isEmpty());
        assertEquals(1, messageConverters.get(2).getSupportedMediaTypes().size());
        assertEquals(2, messageConverters.get(4).getSupportedMediaTypes().size());
        HttpMessageConverter<?> getResult = messageConverters.get(5);
        assertEquals(3, getResult.getSupportedMediaTypes().size());
        assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult).isProcessExternalEntities());
        HttpMessageConverter<?> getResult1 = messageConverters.get(6);
        assertEquals(2, getResult1.getSupportedMediaTypes().size());
        assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult).isSupportDtd());
        assertEquals(2, messageConverters.get(0).getSupportedMediaTypes().size());
        assertEquals(2, messageConverters.get(1).getSupportedMediaTypes().size());
        ObjectMapper objectMapper = ((MappingJackson2HttpMessageConverter) getResult1).getObjectMapper();
        assertTrue(objectMapper.getSerializerProviderInstance() instanceof DefaultSerializerProvider.Impl);
        assertTrue(objectMapper.getSerializerProvider() instanceof DefaultSerializerProvider.Impl);
        assertTrue(objectMapper.getSerializerFactory() instanceof BeanSerializerFactory);
        assertNull(objectMapper.getPropertyNamingStrategy());
        assertSame(objectMapper.getJsonFactory(), objectMapper.getFactory());
        assertTrue(objectMapper.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
        assertTrue(objectMapper.getDateFormat() instanceof StdDateFormat);
        assertTrue(objectMapper.getSubtypeResolver() instanceof StdSubtypeResolver);
        assertTrue(objectMapper.getVisibilityChecker() instanceof VisibilityChecker.Std);
    }

    /**
     * Method under test: {@link JobConfig#restTemplate()}
     */
    @Test
    public void testRestTemplate2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        JobConfig jobConfig = new JobConfig();
        JdbcJobInstanceDao jobInstanceDao = mock(JdbcJobInstanceDao.class);
        JdbcJobExecutionDao jobExecutionDao = new JdbcJobExecutionDao();
        JdbcStepExecutionDao stepExecutionDao = new JdbcStepExecutionDao();
        jobConfig.jobBuilderFactory = new JobBuilderFactory(
                new SimpleJobRepository(jobInstanceDao, jobExecutionDao, stepExecutionDao, new JdbcExecutionContextDao()));
        RestTemplate actualRestTemplateResult = jobConfig.restTemplate();
        assertTrue(actualRestTemplateResult.getErrorHandler() instanceof DefaultResponseErrorHandler);
        UriTemplateHandler uriTemplateHandler = actualRestTemplateResult.getUriTemplateHandler();
        assertTrue(uriTemplateHandler instanceof DefaultUriTemplateHandler);
        assertTrue(actualRestTemplateResult.getRequestFactory() instanceof SimpleClientHttpRequestFactory);
        assertTrue(actualRestTemplateResult.getInterceptors().isEmpty());
        List<HttpMessageConverter<?>> messageConverters = actualRestTemplateResult.getMessageConverters();
        assertEquals(7, messageConverters.size());
        assertTrue(((DefaultUriTemplateHandler) uriTemplateHandler).getDefaultUriVariables().isEmpty());
        assertEquals(1, messageConverters.get(2).getSupportedMediaTypes().size());
        assertEquals(2, messageConverters.get(4).getSupportedMediaTypes().size());
        HttpMessageConverter<?> getResult = messageConverters.get(5);
        assertEquals(3, getResult.getSupportedMediaTypes().size());
        assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult).isProcessExternalEntities());
        HttpMessageConverter<?> getResult1 = messageConverters.get(6);
        assertEquals(2, getResult1.getSupportedMediaTypes().size());
        assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult).isSupportDtd());
        assertEquals(2, messageConverters.get(0).getSupportedMediaTypes().size());
        assertEquals(2, messageConverters.get(1).getSupportedMediaTypes().size());
        ObjectMapper objectMapper = ((MappingJackson2HttpMessageConverter) getResult1).getObjectMapper();
        assertTrue(objectMapper.getSerializerProviderInstance() instanceof DefaultSerializerProvider.Impl);
        assertTrue(objectMapper.getSerializerProvider() instanceof DefaultSerializerProvider.Impl);
        assertTrue(objectMapper.getSerializerFactory() instanceof BeanSerializerFactory);
        assertNull(objectMapper.getPropertyNamingStrategy());
        assertSame(objectMapper.getJsonFactory(), objectMapper.getFactory());
        assertTrue(objectMapper.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
        assertTrue(objectMapper.getDateFormat() instanceof StdDateFormat);
        assertTrue(objectMapper.getSubtypeResolver() instanceof StdSubtypeResolver);
        assertTrue(objectMapper.getVisibilityChecker() instanceof VisibilityChecker.Std);
    }
}

