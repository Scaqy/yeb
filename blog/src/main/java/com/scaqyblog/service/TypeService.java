package com.scaqyblog.service;

import com.scaqyblog.pojo.Type;

import java.util.List;

public interface TypeService {
    List<Type> listType();

    int addType(Type type);

    void deleteType(Integer typeId);
}
