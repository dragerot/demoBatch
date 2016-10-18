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
        hallo();
    }

    private void hallo() {
        InputStream is = getClass().getResourceAsStream("/pint001Examples/pain.001.001.03 NAVtest0001.xml");
        Melding melding = parseXML(is);
        System.out.println("");
        System.out.println("*****************getMsgId   :" + melding.getMsgId());
        System.out.println("*****************getNbOfTxs :" + melding.getNbOfTxs());
        System.out.println("*****************getCtrlSum :" + melding.getCtrlSum());
    }

    /**
     * http://www.journaldev.com/1191/java-stax-parser-example-read-xml-file
     * https://docs.oracle.com/cd/E13222_01/wls/docs92/xml/stax.html
     *
     * @param
     */
    private static Melding parseXML(InputStream is) {
        Melding melding = new Melding();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(is);
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("GrpHdr")) {
                        while (xmlEventReader.hasNext()) {
                            xmlEvent = xmlEventReader.nextEvent();
                            if (xmlEvent.isStartElement()) {
                                StartElement _startElement = xmlEvent.asStartElement();
                                if (_startElement.getName().getLocalPart().equals("MsgId")) {
                                    xmlEvent = xmlEventReader.nextEvent();
                                    melding.setMsgId(xmlEvent.asCharacters().getData());

                              } else
                                if (_startElement.getName().getLocalPart().equals("NbOfTxs")) {
                                    xmlEvent = xmlEventReader.nextEvent();
                                    melding.setNbOfTxs(xmlEvent.asCharacters().getData());
                                } else
                                if (_startElement.getName().getLocalPart().equals("CtrlSum")) {
                                    xmlEvent = xmlEventReader.nextEvent();
                                    melding.setCtrlSum(new BigDecimal(xmlEvent.asCharacters().getData()));
                                }
                            }


                        }
                    }
                }
            }

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return melding;
    }

}
