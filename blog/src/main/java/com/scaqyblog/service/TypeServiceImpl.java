package com.scaqyblog.service;

import com.scaqyblog.mapper.TypeMapper;
import com.scaqyblog.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> listType() {
        return typeMapper.listType();
    }

    @Override
    public int addType(Type type) {
        return typeMapper.addType(type);
    }

    @Override
    public void deleteType(Integer typeId) {
        typeMapper.deleteType(typeId);
    }
}
