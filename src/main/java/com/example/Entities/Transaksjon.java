package com.example.Entities;

import javax.persistence.*;

@Entity(name = "TRANSAKSJON")
public class Transaksjon {
    @Id
    @Column(name = "TRANSAKSJON_ID", nullable = false)
    private String transaksjonsId;
    @Column(name = "MELDING")
    private String melding;
    @Column(name = "STATUS")
    private String status;

    /**
     * Contructor
     */
    public Transaksjon() { }

//    /**
//     * Contructor
//     */
//    public Transaksjon(String transaksjonsId) {
//        this.transaksjonsId = transaksjonsId;
//    }
//
//    /**
//     * Contructor
//     */
//    public Transaksjon(String transaksjonsId, String melding, String status ) {
//        this.transaksjonsId=transaksjonsId;
//        this.melding = melding;
//        this.status = status;
//    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
