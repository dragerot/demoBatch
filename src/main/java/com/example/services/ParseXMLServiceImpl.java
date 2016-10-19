package com.example.services;

import com.example.domain.Melding;
import org.springframework.stereotype.Service;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.math.BigDecimal;

@Service
public class ParseXMLServiceImpl implements ParseXMLService{

    @Override
    public Melding transform(InputStream xml) {
        Melding melding = new Melding();
        boolean funnet=false;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(xml);
            while (xmlEventReader.hasNext() && !funnet) {
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
                                    funnet=true;
                                    break;
                              }
//                              else
//                                if (_startElement.getName().getLocalPart().equals("NbOfTxs")) {
//                                    xmlEvent = xmlEventReader.nextEvent();
//                                    melding.setNbOfTxs(xmlEvent.asCharacters().getData());
//                                } else
//                                if (_startElement.getName().getLocalPart().equals("CtrlSum")) {
//                                    xmlEvent = xmlEventReader.nextEvent();
//                                    melding.setCtrlSum(new BigDecimal(xmlEvent.asCharacters().getData()));
//                                }
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
