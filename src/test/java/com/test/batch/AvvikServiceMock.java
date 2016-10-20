package com.test.batch;

import com.example.domain.*;
import com.example.services.AvvikService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class AvvikServiceMock implements AvvikService {
    @Override
    public List<Melding> hentMeldinger() {
        List<Melding> meldinger = new ArrayList<Melding>();
        List<Bunt> bunter0 = new ArrayList<Bunt>();
        List<Transaksjon> transaksjoner = new ArrayList<Transaksjon>();
        transaksjoner.add(0, createTransaksjon("Trans0", "melding0"));
        transaksjoner.add(1, createTransaksjon("Trans1", "melding1"));
        transaksjoner.add(2, createTransaksjon("Trans2", "melding2"));
        transaksjoner.add(3, createTransaksjon("Trans3", "melding3"));
        bunter0.add(createBunt("bunt0", transaksjoner));
        meldinger.add(0, createMelding("melding0", bunter0));

        List<Bunt> bunter1 = new ArrayList<Bunt>();
        transaksjoner = new ArrayList<Transaksjon>();
        transaksjoner.add(0, createTransaksjon("Trans4", "melding4"));
        transaksjoner.add(1, createTransaksjon("Trans5", "melding5"));
        bunter1.add(createBunt("bunt1", transaksjoner));
        meldinger.add(1, createMelding("melding1", bunter1));

        List<Bunt> bunter2 = new ArrayList<Bunt>();
        transaksjoner = new ArrayList<Transaksjon>();
        transaksjoner.add(0, createTransaksjon("Trans6", "melding7"));
        bunter2.add(createBunt("bunt2", transaksjoner));
        meldinger.add(2, createMelding("melding2", bunter2));
        return meldinger;
}

//    private List<Melding> createMeldinger(){
//        List<Melding> meldinger = new ArrayList<Melding>();
//        for(int i = 0; i<100; i++){
//            List<Bunt> bunter = new ArrayList<Bunt>();
//            List<Transaksjon> transaksjoner = new ArrayList<Transaksjon>();
//            for(int j=0; j<10; j++){
//                transaksjoner.add(i, createTransaksjon("Trans", "melding"));
//                transaksjoner.add(i, createTransaksjon("Trans1", "melding"));
//                transaksjoner.add(i, createTransaksjon("Trans2", "melding2"));
//                transaksjoner.add(i, createTransaksjon("Trans3", "melding3"));
//            }
//            bunter.add(createBunt("bunt"+i, transaksjoner));
//            meldinger.add(i, createMelding("melding"+i, bunter));
//
//        }
//        return meldinger;
//      }

    private Melding createMelding(String buntId, List<Bunt> bunter) {
        return new Melding(buntId, bunter);
    }

    private Bunt createBunt(String buntId, List<Transaksjon> transaksjoner) {
        return new Bunt(buntId, transaksjoner);
    }

    private Transaksjon createTransaksjon(String transaksjonId, String melding) {
        Transaksjon transaksjon = new Transaksjon(transaksjonId, melding);
        return transaksjon;
    }


}
