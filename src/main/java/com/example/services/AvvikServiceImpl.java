package com.example.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class AvvikServiceImpl implements AvvikService {

    /**
     * Henter alle transaksjoner som ikke er behandlet og knyttet potenseilt avvik.
     * Ingen avvik tilsvarer et happy scenaria, dvs Paint.002 OK
     *
     * @return List<Transaksjon>
     */
    public List<Transaksjon> hentIkkeBehandledeTransaksjoner() {
        List<Transaksjon> ikkeBehandledeTransaksjoner = new ArrayList<Transaksjon>();
        ikkeBehandledeTransaksjoner.add(createTransaksjon("TRANSAKJSONID_INGENAVVIK"));
        ikkeBehandledeTransaksjoner.add(createTransaksjon("TRANSAKJSONID_AVVIK"));
        ikkeBehandledeTransaksjoner.get(1).setListeAvvik(new ArrayList<Avvik>());
        ikkeBehandledeTransaksjoner.get(1).getListeAvvik().add(createAvvik_Kontonr_mottaker("12345678900"));
        //if(true) throw new RuntimeException("AvvikServiceImpl ikke implementert");
        return ikkeBehandledeTransaksjoner;
    }


    private Transaksjon createTransaksjon(String transaction_id) {
        Transaksjon transaksjon = new Transaksjon();
        transaksjon.setTransaction_id(transaction_id);
        transaksjon.setStatus_Transaksjon(Transaksjon_Status.NONE);
        return transaksjon;
    }

    private Avvik createAvvik_Kontonr_mottaker(String kontonr_mottaker) {
        Avvik avvik = new Avvik();
        avvik.setKontonr_mottaker(kontonr_mottaker);
        return avvik;
    }

    private Avvik createAvvik_Navn_Mottaker(String navn_Mottaker) {
        Avvik avvik = setAvvikBase(new Avvik());
        avvik.setNavn_mottaker(navn_Mottaker);
        return avvik;
    }

    private Avvik setAvvikBase(Avvik avvik) {
        avvik.setReg_dato(Calendar.getInstance().getTime());
        return avvik;
    }
}
