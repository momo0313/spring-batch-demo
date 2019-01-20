package com.momo.batch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MyDataSource {
    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.oracle.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
}