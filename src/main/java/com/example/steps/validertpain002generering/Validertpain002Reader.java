package com.example.steps.validertpain002generering;

import com.example.domain.NokkelInfo;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class Validertpain002Reader implements ItemReader<NokkelInfo> {

    @Override
    public NokkelInfo read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}
