package com.test.freemarker;

import com.example.config.ServiceConfiguration;
import com.example.services.TemplateXMLGenerationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TemplateXMLGenerationServiceImplTest.class})
@Import({ ServiceConfiguration.class })
public class TemplateXMLGenerationServiceImplTest {

    @Autowired
    TemplateXMLGenerationService templateXMLGenerationService;
    @Test
    public void runTest(){
        Assert.assertTrue(templateXMLGenerationService!=null);
    }
}
