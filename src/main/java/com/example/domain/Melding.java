package com.example.domain;

import java.math.BigDecimal;

public class Melding {
    String msgId;
    String creDtTm;
    String nbOfTxs;
    BigDecimal ctrlSum;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getCreDtTm() {
        return creDtTm;
    }

    public void setCreDtTm(String creDtTm) {
        this.creDtTm = creDtTm;
    }

    public String getNbOfTxs() {
        return nbOfTxs;
    }

    public void setNbOfTxs(String nbOfTxs) {
        this.nbOfTxs = nbOfTxs;
    }

    public BigDecimal getCtrlSum() {
        return ctrlSum;
    }

    public void setCtrlSum(BigDecimal ctrlSum) {
        this.ctrlSum = ctrlSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Melding melding = (Melding) o;

        if (msgId != null ? !msgId.equals(melding.msgId) : melding.msgId != null) return false;
        if (creDtTm != null ? !creDtTm.equals(melding.creDtTm) : melding.creDtTm != null) return false;
        if (nbOfTxs != null ? !nbOfTxs.equals(melding.nbOfTxs) : melding.nbOfTxs != null) return false;
        return ctrlSum != null ? ctrlSum.equals(melding.ctrlSum) : melding.ctrlSum == null;

    }

    @Override
    public int hashCode() {
        int result = msgId != null ? msgId.hashCode() : 0;
        result = 31 * result + (creDtTm != null ? creDtTm.hashCode() : 0);
        result = 31 * result + (nbOfTxs != null ? nbOfTxs.hashCode() : 0);
        result = 31 * result + (ctrlSum != null ? ctrlSum.hashCode() : 0);
        return result;
    }
}
