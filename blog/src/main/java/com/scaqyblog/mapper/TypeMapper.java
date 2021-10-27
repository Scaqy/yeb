package com.scaqyblog.mapper;


import com.scaqyblog.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeMapper {
    List<Type> listType();

    int addType(Type type);

    int deleteType(Integer typeId);

}
