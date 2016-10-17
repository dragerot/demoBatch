package com.example.services;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class AvvikServiceImpl implements AvvikService {

    @Autowired
    freemarker.template.Configuration  freemarkerConfiguration;

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
         Map<String, Object> input = new HashMap<String, Object>();
         input.put("title", "Vogella example");
         freemarkerConfiguration.setClassForTemplateLoading(this.getClass(), "/templates/");
         Template template = freemarkerConfiguration.getTemplate("hello.ftl");
         // Write output to the console
         Writer consoleWriter = new OutputStreamWriter(System.out);
         StringWriter stringWriter =new StringWriter();
         template.process(input,stringWriter);
         System.out.println("*********************************"+stringWriter.toString());


//         // For the sake of example, also write output into a file:
//         Writer fileWriter = new FileWriter(new File("output.html"));
//         try {
//             template.process(input, fileWriter);
//         } finally {
//             fileWriter.close();
//         }

     }
}
