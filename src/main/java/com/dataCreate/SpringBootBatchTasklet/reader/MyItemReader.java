package com.dataCreate.SpringBootBatchTasklet.reader;

import com.dataCreate.SpringBootBatchTasklet.Model.Pet;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;


@Slf4j
@Component
public class MyItemReader implements ItemReader<Pet>, StepExecutionListener {

    @Override
    public Pet read(){
        int randomNum = ThreadLocalRandom.current().nextInt(20, 100);
        String randomGender = null;
        String randomAnimal = null;
        if((randomNum % 2) == 0){
            randomGender = "Men";
        }else {
            randomGender = "Women";
        }

        if((randomNum % 2) == 0){
            if((randomNum % 3) == 0){
                randomAnimal = "Rabbit";
            }
            randomAnimal = "Dog";
        }else {
            randomAnimal = "Cat";
        }

            Pet pet = new Pet();
        pet.setAge(randomNum);
        pet.setName(RandomStringUtils.randomAlphabetic(5));
        pet.setGender(randomGender);
        pet.setAnimal(randomAnimal);
        return pet;
}

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("Start");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution){
        return ExitStatus.COMPLETED;
}

}