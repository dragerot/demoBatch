package com.example.steps.avvikshantering;

import com.example.config.ServiceConfiguration;
import com.example.domain.NokkelInfo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Import;

import java.util.List;

public class Pain002AvvikWriter implements ItemWriter<NokkelInfo> {

    @Override
    public void write(List<? extends NokkelInfo> list) throws Exception {
        for (NokkelInfo item : list) {
            System.out.format("************Pain002AvvikWriter *********** ant.:%d, NokkelInfo:  %s", list.size(), item.toString());
        }
    }
}
