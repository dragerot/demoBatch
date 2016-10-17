package com.example.steps.avvikshantering;

import com.example.domain.NokkelInfo;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@StepScope
public class Pain002AvvikWriter implements ItemWriter<NokkelInfo> {

    @Override
    public void write(List<? extends NokkelInfo> list) throws Exception {
      for (NokkelInfo item : list) {

            System.out.format("************Pain002AvvikWriter *********** ant.:%d, NokkelInfo:  %s", list.size(),item.toString());
        }
    }
}
