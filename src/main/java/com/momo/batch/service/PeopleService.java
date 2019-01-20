package com.momo.batch.service;

import com.momo.batch.bean.People;

import java.util.List;

public interface PeopleService {
    int addPeople(People people);
    List<People> getAllPeople();
}
