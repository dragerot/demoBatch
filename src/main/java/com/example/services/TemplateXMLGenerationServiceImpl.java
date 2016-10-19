package com.example.services;

import com.example.common.DateTimeUtility;
import com.example.domain.NokkelInfo;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@Service
public class TemplateXMLGenerationServiceImpl implements TemplateXMLGenerationService{
    @Autowired
    freemarker.template.Configuration  freemarkerConfiguration;

    @Autowired
    DateTimeUtility dateTimeUtility;

    @Override
    public Writer generate(String templateName, Object melding) throws IOException, TemplateException {
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("header", melding);
        freemarkerConfiguration.setClassForTemplateLoading(this.getClass(), "/templates/");
        Template template = freemarkerConfiguration.getTemplate(templateName);
        StringWriter stringWriter = new StringWriter();
        template.process(input, stringWriter);
        System.out.println("**TRANSFORMERT MELDING:" + stringWriter.toString());
//         // For the sake of example, also write output into a file:
//         Writer fileWriter = new FileWriter(new File("output.html"));
        return stringWriter;
    }
}
