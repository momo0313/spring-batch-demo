package com.momo.batch.processor;

import com.momo.batch.bean.People;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class PeopleProcessor implements ItemProcessor<People, People> {
    private static final Logger log = LoggerFactory.getLogger(PeopleProcessor.class);

    @Override
    public People process(final People people) throws Exception {
        final String firstName = people.getFirstName().toUpperCase();
        final String lastName = people.getLastName().toUpperCase();

        final People transformedPeople = new People(firstName, lastName);

        log.info("Converting (" + people + ") into (" + transformedPeople + ")");

        return transformedPeople;
    }
}