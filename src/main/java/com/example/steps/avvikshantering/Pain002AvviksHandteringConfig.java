package com.example.steps.avvikshantering;

import com.example.config.BatchConfiguration;
import com.example.domain.NokkelInfo;
import com.example.domain.Transaksjon;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



@Configuration
@Import(BatchConfiguration.class)
@ComponentScan(basePackages = {"com.example"})
public class Pain002AvviksHandteringConfig {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    Validertpain002genereringProcessor validertpain002genereringProcessor;

    @Autowired
    Pain002AvvikReader pain002AvvikReader;

    @Autowired
    public Pain002AvvikWriter pain002AvvikWriter;

    @Bean
    public Step pain002AvvikStep(){
        return stepBuilderFactory
                .get("pain002AvvikStep")
                .<Transaksjon,NokkelInfo>chunk(1)
                .reader((ItemReader)pain002AvvikReader)
                .processor((ItemProcessor)validertpain002genereringProcessor)
                .writer(pain002AvvikWriter)
//				})
////                .listener(painInnlesingStepLytter)
                .build();
    }







//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    AvvikService avviksservce;
//
//    @Bean
//    public Pain002AvvikReader pain002AvvikReader(){
//        return new Pain002AvvikReader(avviksservce.hentIkkeBehandledeTransaksjoner());
//    }
//    @Bean //.<Transaksjon,Transaksjon>
//    public Step pain002AvvikStep(){
//        return stepBuilderFactory
//                .get("pain002AvvikStep")
//                .chunk(1)
//                .reader(pain002AvvikReader())
//
////                .processor((ItemProcessor)painInnlesingProcessor)
////                .writer((ItemWriter)painInnlesingWriter)
//////                .listener(painInnlesingStepLytter)
//                .build();
//
//    }
}
