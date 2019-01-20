package com.momo.batch.config;

import com.momo.batch.bean.People;
import com.momo.batch.listener.JobCompletionListener;
import com.momo.batch.processor.PeopleProcessor;
import com.momo.batch.writer.OracleWriter;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class Batch {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public OracleWriter oracleWriter;

    @Autowired
    public PeopleProcessor peopleProcessor;

    @Autowired
    private FlatFileItemReader csvFileReader;

    @Bean
    public Job importUserJob(JobCompletionListener listener, Step step) {
        return jobBuilderFactory.get("myjob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step)
                .end()
                .build();
    }

    @Bean
    public Step step() {
        return stepBuilderFactory.get("step")
                .<People, People> chunk(10)
                .reader(csvFileReader)
                .processor(peopleProcessor)
                .writer(oracleWriter)
                .build();
    }
}