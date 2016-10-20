package com.example.services;

import com.example.common.DateTimeUtility;
import com.example.config.ServiceConfiguration;
import com.example.domain.NokkelInfo;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@Import( {ServiceConfiguration.class})
public class TemplateXMLGenerationServiceImpl implements TemplateXMLGenerationService{
    @Autowired
    freemarker.template.Configuration  freemarkerConfiguration;

    @Autowired
    DateTimeUtility dateTimeUtility;

    @Override
    public Writer genererXML(String template, Object melding) {
        Writer writer=null;
        try {
            writer =generate(template,melding);

        }catch(Exception e){
            e.printStackTrace(); //TODO logging strategi
            throw new RuntimeException(this.getClass().getName()+"genererXML() feiler:");
        }
        return writer;
    }

    public Writer generate(String templateName, Object melding) throws IOException, TemplateException {
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("header", melding);
        freemarkerConfiguration.setClassForTemplateLoading(this.getClass(), "/templates/");
        Template template = freemarkerConfiguration.getTemplate(templateName);
        StringWriter stringWriter = new StringWriter();
        template.process(input, stringWriter);
        System.out.println("**TRANSFORMERT MELDING:" + stringWriter.toString());
        return stringWriter;
    }
}
