package com.example.services;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;

public class Iso200022ParserServiceImpl implements Iso200022ParserService {

    @Override
    public String hentMeldingId(InputStream xml) {
        String meldingId="";
        try{
            meldingId= hent(xml);
           } catch (XMLStreamException e) {
            e.printStackTrace(); //TODO logging strategi
            throw new RuntimeException(this.getClass().getName()+"hentMeldingId() feiler:");
        }
        return meldingId;
    }

    private String hent(InputStream xml) throws XMLStreamException{
        String meldingId="";
        boolean funnet=false;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
//        try {
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
                                    meldingId=xmlEvent.asCharacters().getData();
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

//        } catch (XMLStreamException e) {
//            e.printStackTrace();
//        }
        return meldingId;
    }

}
