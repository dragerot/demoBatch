package com.example.domain;

import java.util.Date;

public class NokkelInfo {
    private String meldingId;
    private String buntId;
    private String transaksjonsId;
    private Date dato;

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public String getMeldingId() {
        return meldingId;
    }

    public void setMeldingId(String meldingId) {
        this.meldingId = meldingId;
    }

    public String getBuntId() {
        return buntId;
    }

    public void setBuntId(String buntId) {
        this.buntId = buntId;
    }

    public String getTransaksjonsId() {
        return transaksjonsId;
    }

    public void setTransaksjonsId(String transaksjonsId) {
        this.transaksjonsId = transaksjonsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NokkelInfo that = (NokkelInfo) o;

        if (meldingId != null ? !meldingId.equals(that.meldingId) : that.meldingId != null) return false;
        if (buntId != null ? !buntId.equals(that.buntId) : that.buntId != null) return false;
        return transaksjonsId != null ? transaksjonsId.equals(that.transaksjonsId) : that.transaksjonsId == null;

    }

    @Override
    public int hashCode() {
        int result = meldingId != null ? meldingId.hashCode() : 0;
        result = 31 * result + (buntId != null ? buntId.hashCode() : 0);
        result = 31 * result + (transaksjonsId != null ? transaksjonsId.hashCode() : 0);
        return result;
    }
}
