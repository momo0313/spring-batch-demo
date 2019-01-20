package com.momo.batch.writer;

import com.momo.batch.bean.People;
import com.momo.batch.service.PeopleService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OracleWriter implements ItemWriter<People> {

    @Autowired
    private PeopleService peopleService;

    @Override
    public void write(List<? extends People> list) throws Exception {
        for(People people: list) {
            peopleService.addPeople(people);
        }
    }
}
