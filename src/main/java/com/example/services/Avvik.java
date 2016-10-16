package com.example.services;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@Entity
//@Table(name="NAV standard")
public class Avvik implements Serializable {
    //@Id
    //GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    //Id fra .csv-fila  (hvis tester har ønske om å identifisere testene sine)
    private Long testId;
    private String melding_id_tekn_avvisning;
    private String meldingId;
    private String buntId;
    private String transaksjonsId;
    private String navn_mottaker;
    private String Kontonr_mottaker;
    private String returstatus;
    private String avvik_kode;
    private String avvik_beskrivelse_avvik;
    private Date reg_dato;
    private String registrertAvId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getMelding_id_tekn_avvisning() {
        return melding_id_tekn_avvisning;
    }

    public void setMelding_id_tekn_avvisning(String melding_id_tekn_avvisning) {
        this.melding_id_tekn_avvisning = melding_id_tekn_avvisning;
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

    public String getNavn_mottaker() {
        return navn_mottaker;
    }

    public void setNavn_mottaker(String navn_mottaker) {
        this.navn_mottaker = navn_mottaker;
    }

    public String getKontonr_mottaker() {
        return Kontonr_mottaker;
    }

    public void setKontonr_mottaker(String kontonr_mottaker) {
        Kontonr_mottaker = kontonr_mottaker;
    }

    public String getReturstatus() {
        return returstatus;
    }

    public void setReturstatus(String returstatus) {
        this.returstatus = returstatus;
    }

    public String getAvvik_kode() {
        return avvik_kode;
    }

    public void setAvvik_kode(String avvik_kode) {
        this.avvik_kode = avvik_kode;
    }

    public String getAvvik_beskrivelse_avvik() {
        return avvik_beskrivelse_avvik;
    }

    public void setAvvik_beskrivelse_avvik(String avvik_beskrivelse_avvik) {
        this.avvik_beskrivelse_avvik = avvik_beskrivelse_avvik;
    }

    public Date getReg_dato() {
        return reg_dato;
    }

    public void setReg_dato(Date reg_dato) {
        this.reg_dato = reg_dato;
    }

    public String getRegistrertAvId() {
        return registrertAvId;
    }

    public void setRegistrertAvId(String registrertAvId) {
        this.registrertAvId = registrertAvId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Avvik avvik = (Avvik) o;

        if (id != null ? !id.equals(avvik.id) : avvik.id != null) return false;
        if (testId != null ? !testId.equals(avvik.testId) : avvik.testId != null) return false;
        if (melding_id_tekn_avvisning != null ? !melding_id_tekn_avvisning.equals(avvik.melding_id_tekn_avvisning) : avvik.melding_id_tekn_avvisning != null)
            return false;
        if (meldingId != null ? !meldingId.equals(avvik.meldingId) : avvik.meldingId != null) return false;
        if (buntId != null ? !buntId.equals(avvik.buntId) : avvik.buntId != null) return false;
        if (transaksjonsId != null ? !transaksjonsId.equals(avvik.transaksjonsId) : avvik.transaksjonsId != null)
            return false;
        if (navn_mottaker != null ? !navn_mottaker.equals(avvik.navn_mottaker) : avvik.navn_mottaker != null)
            return false;
        if (Kontonr_mottaker != null ? !Kontonr_mottaker.equals(avvik.Kontonr_mottaker) : avvik.Kontonr_mottaker != null)
            return false;
        if (returstatus != null ? !returstatus.equals(avvik.returstatus) : avvik.returstatus != null) return false;
        if (avvik_kode != null ? !avvik_kode.equals(avvik.avvik_kode) : avvik.avvik_kode != null) return false;
        if (avvik_beskrivelse_avvik != null ? !avvik_beskrivelse_avvik.equals(avvik.avvik_beskrivelse_avvik) : avvik.avvik_beskrivelse_avvik != null)
            return false;
        if (reg_dato != null ? !reg_dato.equals(avvik.reg_dato) : avvik.reg_dato != null) return false;
        return registrertAvId != null ? registrertAvId.equals(avvik.registrertAvId) : avvik.registrertAvId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (testId != null ? testId.hashCode() : 0);
        result = 31 * result + (melding_id_tekn_avvisning != null ? melding_id_tekn_avvisning.hashCode() : 0);
        result = 31 * result + (meldingId != null ? meldingId.hashCode() : 0);
        result = 31 * result + (buntId != null ? buntId.hashCode() : 0);
        result = 31 * result + (transaksjonsId != null ? transaksjonsId.hashCode() : 0);
        result = 31 * result + (navn_mottaker != null ? navn_mottaker.hashCode() : 0);
        result = 31 * result + (Kontonr_mottaker != null ? Kontonr_mottaker.hashCode() : 0);
        result = 31 * result + (returstatus != null ? returstatus.hashCode() : 0);
        result = 31 * result + (avvik_kode != null ? avvik_kode.hashCode() : 0);
        result = 31 * result + (avvik_beskrivelse_avvik != null ? avvik_beskrivelse_avvik.hashCode() : 0);
        result = 31 * result + (reg_dato != null ? reg_dato.hashCode() : 0);
        result = 31 * result + (registrertAvId != null ? registrertAvId.hashCode() : 0);
        return result;
    }
}
