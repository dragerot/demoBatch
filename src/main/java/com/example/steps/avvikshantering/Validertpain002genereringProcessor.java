package com.example.steps.avvikshantering;

import com.example.domain.NokkelInfo;
import com.example.services.Transaksjon;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component(value = "validertpain002genereringProcessor")
@StepScope
public class Validertpain002genereringProcessor implements ItemProcessor<Transaksjon,NokkelInfo> {
    @Override
    public NokkelInfo process(Transaksjon transaksjon) throws Exception {
        NokkelInfo nokkelInfo = new NokkelInfo();
        nokkelInfo.setMeldingId(transaksjon.getMessage_id());
        nokkelInfo.setBuntId("Ikke definert i transaksjon?");
        nokkelInfo.setTransaksjonsId(transaksjon.getTransaction_id());
        System.out.println("*****Transformer*****"+nokkelInfo.toString());
        return nokkelInfo;
    }
}
