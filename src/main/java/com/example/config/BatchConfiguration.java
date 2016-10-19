package com.example.config;

import freemarker.template.TemplateExceptionHandler;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

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