package com.example.batchconfig;

import com.example.avvikshantering.Pain002AvvikReader;
import com.example.avvikshantering.Pain002AvvikWriter;
import com.example.services.AvvikService;
import com.example.services.Transaksjon;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(BatchConfiguration.class)
@ComponentScan(basePackages = {"com.example"})
public class JobConfiguration {

	@Autowired
	AvvikService avvikService;

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Pain002AvvikReader pain002AvvikReader() {
		return new Pain002AvvikReader(avvikService);
	}

	@Bean
	public Pain002AvvikWriter pain002AvvikWriter() {
		return new Pain002AvvikWriter();
	}

	@Bean
    public Step pain002AvvikStep(){
        return stepBuilderFactory
                .get("pain002AvvikStep")
				.<Transaksjon,Transaksjon>chunk(1)
                .reader(pain002AvvikReader())
//                .processor((ItemProcessor)painInnlesingProcessor)
                .writer(pain002AvvikWriter())
//				})
////                .listener(painInnlesingStepLytter)
                .build();
    }

	@Bean
	public Job pain002AvvikJob() {
		return jobBuilderFactory.get("pain002AvvikJob")
				.start(pain002AvvikStep())
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
