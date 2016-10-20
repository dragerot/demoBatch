package com.example.config;

import com.example.common.DateTimeUtility;
import com.example.services.*;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
public class ServiceConfiguration {
    @Bean(value = "prototype")
    public AvvikService aAvvikService(){
        return new AvvikServiceImpl();
    }

    @Bean
    @Scope(value = "prototype")
    public Iso200022ParserService parseXMLService(){
       return new Iso200022ParserServiceImpl();
    }

    @Bean
    @Scope(value = "prototype")
    public TemplateXMLGenerationService templateXMLGenerationService(){
        return new TemplateXMLGenerationServiceImpl();
    }

    @Bean
    DateTimeUtility dateTimeUtility(){return new DateTimeUtility();}

    @Bean
    public freemarker.template.Configuration freemarkerConfiguration(){
        freemarker.template.Configuration cfg = new freemarker.template.Configuration();
        //cfg.setClassForTemplateLoading(DemoBatchApplication.class, "templates");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.getDefault());
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return cfg;
    }


}
