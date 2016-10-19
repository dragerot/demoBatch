package com.test.xmlparser;

import com.example.domain.Melding;
import com.example.services.ParseXMLServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * http://www.journaldev.com/1191/java-stax-parser-example-read-xml-file
 * https://docs.oracle.com/cd/E13222_01/wls/docs92/xml/stax.html
 *
 * @param
 */
public class ParseXMLServiceImplTest {

    @Test
    public void aTest(){
        ParseXMLServiceImpl parseXMLServiceImpl = new ParseXMLServiceImpl();
        InputStream is = getClass().getResourceAsStream("/pint001Examples/pain.001.001.03 NAVtest0001.xml");
        Melding melding = parseXMLServiceImpl.transform(is);
        Assert.assertEquals("NAV-UR-001D20160503T002341",melding.getMsgId());
    }
}
