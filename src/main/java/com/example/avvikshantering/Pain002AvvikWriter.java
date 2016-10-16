package com.example.avvikshantering;

import com.example.services.Transaksjon;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class Pain002AvvikWriter implements ItemWriter<Transaksjon> {
    @Override
    public void write(List<? extends Transaksjon> list) throws Exception {
        System.out.println("Pain002AvvikWriter size: " + list.size());
        for (Transaksjon item : list) {
            System.out.println("************Pain002AvvikWriter ***********" + item.toString());
        }
    }
}
