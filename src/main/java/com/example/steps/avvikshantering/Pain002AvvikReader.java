package com.example.steps.avvikshantering;

import com.example.config.ServiceConfiguration;
import com.example.services.AvvikService;
import com.example.domain.Transaksjon;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

/**
 * Inspirasjon:
 * https://www.petrikainulainen.net/programming/spring-framework/spring-batch-tutorial-reading-information-from-a-rest-api/
 *
 */
@Import( {ServiceConfiguration.class})
public class Pain002AvvikReader implements ItemReader<Transaksjon> {
    private int nesteTransaksjonIndex;
    private List<Transaksjon> transaksjonData;

    @Autowired
    AvvikService avvikService;

    /**
     * Constructor
     *
     */
    public Pain002AvvikReader() {
       nesteTransaksjonIndex = 0;
    }

    @Override
    public Transaksjon read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (transaksjonListIsNotInitialized()) {
            transaksjonData = hentTransaksjonerFraService();
        }
        Transaksjon nesteTransaksjon = null;
        if (nesteTransaksjonIndex < transaksjonData.size()) {
            nesteTransaksjon = transaksjonData.get(nesteTransaksjonIndex);
            nesteTransaksjonIndex++;
        }
        return nesteTransaksjon;
    }

    private boolean transaksjonListIsNotInitialized() {
        return this.transaksjonData == null;
    }

    private List<Transaksjon> hentTransaksjonerFraService() {
        List<Transaksjon> transaksjonList = new ArrayList<>();
        transaksjonList.add(new Transaksjon("Trans1","Melding1"));
        return transaksjonList;
    }
}
