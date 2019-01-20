package com.momo.batch.service.impl;

import com.momo.batch.bean.People;
import com.momo.batch.mapper.PeopleMapper;
import com.momo.batch.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    public int addPeople(People people) {
        return peopleMapper.insert(people);
    }

    @Override
    public List<People> getAllPeople() {
        return peopleMapper.queryAll();
    }
}