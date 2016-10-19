package com.example.services;

import com.example.common.DateTimeUtility;
import com.example.domain.NokkelInfo;
import com.example.domain.Transaksjon;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Template;

import javax.xml.datatype.XMLGregorianCalendar;

@Service
public class AvvikServiceImpl implements AvvikService {

    @Autowired
    freemarker.template.Configuration  freemarkerConfiguration;

    @Autowired
    DateTimeUtility dateTimeUtility;

    /**
     * Henter alle transaksjoner som ikke er behandlet og knyttet potenseilt avvik.
     * Ingen avvik tilsvarer et happy scenaria, dvs Paint.002 OK
     *
     * @return List<Transaksjon>
     */
    public List<Transaksjon> hentIkkeBehandledeTransaksjoner() {
        try {
            prosess();
            System.out.println("******************OK");
        }catch (Exception e){
            System.out.println("******************Feiler");
        }
        if(true) throw new RuntimeException("AvvikServiceImpl ikke implementert");
        return null;
    }

     private void prosess() throws IOException, TemplateException {
//         Map<String, Object> input = new HashMap<String,Object>() {
//         };
//         NokkelInfo nokkeInfo = new NokkelInfo();
//         nokkeInfo.setBuntId("B123456");
//         nokkeInfo.setTransaksjonsId("T123456");
//         nokkeInfo.setMeldingId("M123456");
//         nokkeInfo.setDato(dateTimeUtility.retrieveLocalDate("NO"));
//         input.put("title", nokkeInfo);
//         freemarkerConfiguration.setClassForTemplateLoading(this.getClass(), "/templates/");
//         Template template = freemarkerConfiguration.getTemplate("hello.ftl");
//         // Write output to the console
//         Writer consoleWriter = new OutputStreamWriter(System.out);
//
//         StringWriter stringWriter =new StringWriter();
//         template.process(input,stringWriter);
//         System.out.println("*********************************"+stringWriter.toString());
//
//
////         // For the sake of example, also write output into a file:
////         Writer fileWriter = new FileWriter(new File("output.html"));
////         try {
////             template.process(input, fileWriter);
////         } finally {
////             fileWriter.close();
////         }
//
     }
}
