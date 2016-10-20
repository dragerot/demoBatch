package com.example.domain;

import java.math.BigDecimal;
import java.util.List;

public class Melding {
    String msgId;
    List<Bunt> bunter;

    public Melding(String msgId,List<Bunt> bunter){
        this.msgId=msgId;
        this.bunter=bunter;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public List<Bunt> getBunter() {
        return bunter;
    }

    public void setBunter(List<Bunt> bunter) {
        this.bunter = bunter;
    }
}
