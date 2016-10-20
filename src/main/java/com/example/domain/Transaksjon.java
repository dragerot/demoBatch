package com.example.domain;

import java.io.Serializable;
import java.util.List;

public class Transaksjon implements Serializable{
    String transaksjonsId;
    String melding;

    public Transaksjon(String id, String melding){
        this.transaksjonsId=id;
        this.melding=melding;
    }


    public String getTransaksjonsId() {
        return transaksjonsId;
    }

    public void setTransaksjonsId(String transaksjonsId) {
        this.transaksjonsId = transaksjonsId;
    }

    public String getMelding() {
        return melding;
    }

    public void setMelding(String melding) {
        this.melding = melding;
    }
}
