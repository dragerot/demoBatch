package com.example.avvikshantering;

import com.example.services.AvvikService;
import com.example.services.Transaksjon;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import java.util.List;

/**
 * Inspirasjon:
 * https://www.petrikainulainen.net/programming/spring-framework/spring-batch-tutorial-reading-information-from-a-rest-api/
 *
 */

public class Pain002AvvikReader implements ItemReader<Transaksjon> {
    AvvikService avvikService;
    private int nesteTransaksjonIndex;
    private List<Transaksjon> transaksjonData;

    /**
     * Constructor
     *
     * @param avvikService
     */
    public Pain002AvvikReader(AvvikService avvikService) {
        this.avvikService = avvikService;
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
        List<Transaksjon> transaksjonList = avvikService.hentIkkeBehandledeTransaksjoner();
        return transaksjonList;
    }
}
