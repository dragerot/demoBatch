package com.example.domain;

import java.util.List;

public class Bunt {
    String buntId;
    List<Transaksjon> transaksjoner;

    public Bunt(String buntId, List<Transaksjon> transaksjoner){
        this.buntId=buntId;
        this.transaksjoner=transaksjoner;
    }

    public String getBuntId() {
        return buntId;
    }

    public void setBuntId(String buntId) {
        this.buntId = buntId;
    }

    public List<Transaksjon> getTransaksjoner() {
        return transaksjoner;
    }

    public void setTransaksjoner(List<Transaksjon> transaksjoner) {
        this.transaksjoner = transaksjoner;
    }
}
