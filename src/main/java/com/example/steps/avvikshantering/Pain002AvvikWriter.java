package com.example.steps.avvikshantering;

import com.example.domain.Melding;
import com.example.domain.NokkelInfo;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

@Component
@StepScope
public class Pain002AvvikWriter implements ItemWriter<NokkelInfo> {

    @Override
    public void write(List<? extends NokkelInfo> list) throws Exception {
        for (NokkelInfo item : list) {
            System.out.format("************Pain002AvvikWriter *********** ant.:%d, NokkelInfo:  %s", list.size(), item.toString());
        }
//        hallo();
    }

//    private void hallo() {
//        InputStream is = getClass().getResourceAsStream("/pint001Examples/pain.001.001.03 NAVtest0001.xml");
//        Melding melding = parseXML(is);
//        System.out.println("");
//        System.out.println("*****************getMsgId   :" + melding.getMsgId());
//        System.out.println("*****************getNbOfTxs :" + melding.getNbOfTxs());
//        System.out.println("*****************getCtrlSum :" + melding.getCtrlSum());
//    }


}
