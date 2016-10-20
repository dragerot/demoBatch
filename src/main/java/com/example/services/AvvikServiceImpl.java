package com.example.services;

import com.example.common.DateTimeUtility;
import com.example.config.BatchConfiguration;
import com.example.config.ServiceConfiguration;
import com.example.domain.Melding;
import com.example.domain.NokkelInfo;
import com.example.domain.Transaksjon;
import com.example.steps.avvikshantering.Pain002AvviksHandteringConfig;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Template;

import javax.xml.datatype.XMLGregorianCalendar;

@Import( {ServiceConfiguration.class})
public class AvvikServiceImpl implements AvvikService {

    @Autowired
    TemplateXMLGenerationService templateXMLGenerationService;

    @Autowired
    DateTimeUtility dateTimeUtility;

    @Override
    public List<Melding>  hentMeldinger() {
        if(true) throw new RuntimeException("AvvikServiceImpl ikke implementert");
        return null;
    }
}
