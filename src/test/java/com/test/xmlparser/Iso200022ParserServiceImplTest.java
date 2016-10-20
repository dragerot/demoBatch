package com.test.xmlparser;

import com.example.services.Iso200022ParserServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * http://www.journaldev.com/1191/java-stax-parser-example-read-xml-file
 * https://docs.oracle.com/cd/E13222_01/wls/docs92/xml/stax.html
 *
 * @param
 */
public class Iso200022ParserServiceImplTest {

    @Test
    public void aTest(){
        Iso200022ParserServiceImpl parseXMLServiceImpl = new Iso200022ParserServiceImpl();
        InputStream is = getClass().getResourceAsStream("/pint001Examples/pain.001.001.03 NAVtest0001.xml");
        String meldingId = parseXMLServiceImpl.hentMeldingId(is);
        Assert.assertEquals("NAV-UR-001D20160503T002341",meldingId);
    }
}
