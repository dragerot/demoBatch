package com.example.services;

import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.Writer;


public interface TemplateXMLGenerationService {
    Writer genererXML(String template, Object melding);
}
