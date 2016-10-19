package com.test.freemarker;

import com.example.DemoBatchApplication;
import com.example.config.CommonConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoBatchApplication.class})
@Import({ CommonConfiguration.class })
public class TemplateXMLGenerationServiceImplTest {
}
