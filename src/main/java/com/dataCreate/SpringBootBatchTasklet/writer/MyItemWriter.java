package com.dataCreate.SpringBootBatchTasklet.writer;

import java.util.List;

import com.dataCreate.SpringBootBatchTasklet.Model.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class MyItemWriter implements ItemWriter<Pet>, StepExecutionListener {

    final private RestTemplate restTemplate;

    @Value("${api.request.url}")
    String apiRequestUrl;

    @Autowired
    public MyItemWriter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void write(List<? extends Pet> list) throws Exception {
        for(Pet filePath : list){
            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Pet> request = new HttpEntity<>(filePath, headers);
            restTemplate.exchange(apiRequestUrl, HttpMethod.POST,request,Void.class);
            log.info(filePath.toString());
        }

    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("before");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return ExitStatus.COMPLETED;
    }
}