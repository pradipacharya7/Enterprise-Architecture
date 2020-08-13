package edu.mum.main;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
 * @EnableBatchProcessing - base configuration for building batch jobs 
   creates the  core resources, for example:
JobRepository, JobLauncher, JobRegistry, JobBuilderFactory, StepBuilderFactory  
 */
@Configuration
@EnableBatchProcessing(modular = false)
@EnableScheduling
public class BatchConfiguration {
}
