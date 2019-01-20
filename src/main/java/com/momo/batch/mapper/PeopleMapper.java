package com.momo.batch.mapper;

import com.momo.batch.bean.People;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PeopleMapper {
    int insert(People people);
    List<People> queryAll();
}