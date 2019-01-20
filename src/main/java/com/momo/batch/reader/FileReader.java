package com.momo.batch.reader;

import com.momo.batch.bean.People;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class FileReader {
    @Value("${source.file.path}")
    private String filePath;

    @Bean
    public FlatFileItemReader csvFileReader() {
        return new FlatFileItemReaderBuilder<People>()
                .name("csvFileReader")
                .resource(new ClassPathResource(filePath))
                .delimited()
                .names(new String[]{"firstName", "lastName"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<People>() {{
                    setTargetType(People.class);
                }})
                .build();
    }
}