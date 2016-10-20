package com.example.steps.avvikshantering;

import com.example.config.ServiceConfiguration;
import com.example.domain.Melding;
import com.example.domain.NokkelInfo;
import com.example.domain.Transaksjon;
import com.example.services.AvvikService;
import com.example.services.TemplateXMLGenerationService;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.io.StringWriter;
import java.util.Date;
import java.util.List;

@Import( {ServiceConfiguration.class})
public class Validertpain002genereringProcessor implements ItemProcessor<Transaksjon,NokkelInfo> {
    @Autowired
    TemplateXMLGenerationService templateXMLGenerationService;

    @Autowired
    AvvikService avvikService;

    @Override
    public NokkelInfo process(Transaksjon transaksjon) throws Exception {
        List<Melding> meldinger =avvikService.hentMeldinger();
        for(Melding item : meldinger) {
            StringWriter writer = (StringWriter)templateXMLGenerationService.genererXML("hello.ftl",item);
            System.out.println(writer.toString());
        }

        NokkelInfo nokkelInfo = new NokkelInfo();
        nokkelInfo.setDato(new Date());
        nokkelInfo.setBuntId("BuntId");
        nokkelInfo.setMeldingId("MeldingId");
        nokkelInfo.setTransaksjonsId("TransaksjonsId");
        return nokkelInfo;
    }
}
