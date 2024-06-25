package com.stupendousware.datagenerator.configuration;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stupendousware.datagenerator.processors.UserItemProcessor;
import com.stupendousware.datagenerator.readers.UserItemReader;

@Configuration
public class BatchConfiguration {
@Bean
    public UserItemReader reader() {
new FlatFileItemReader<>()
    }

    @Bean
    public UserItemProcessor processor() {
        return new UserItemProcessor();
    }
}
