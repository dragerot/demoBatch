package com.example.batchconfig;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.io.IOException;


@Configuration
@Import(BatchConfiguration.class)
@ComponentScan(basePackages = {"com.example"})
public class JobConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private Step pain002AvvikStep;

	@Bean
	public Job pain002AvvikJob() {
		return jobBuilderFactory.get("pain002AvvikJob")
				.start(pain002AvvikStep)
				.build();
	}

//	@Bean
//	public Step step1() {
//		return stepBuilderFactory.get("step1")
//				.tasklet(new Tasklet() {
//					@Override
//					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//						System.out.println("Hello World!");
//						for(Transaksjon item : avvikService.hentIkkeBehandledeTransaksjoner()){
//							System.out.println(item.toString());
//						}
//						return RepeatStatus.FINISHED;
//					}
//				}).build();
//	}
//
//	@Bean
//	public Job helloWorldJob() {
//		return jobBuilderFactory.get("helloWorldJob")
//				.start(step1())
//				.build();
//	}
}
