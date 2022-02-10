package com.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.pojo.Department;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2021-12-14
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 获取所有部门信息
     * @return
     */
    List<Department> getAllDepartment(Integer id);

    /**
     * 添加部门信息
     * @param department
     */
    void addDepartment(Department department);

    /**
     * 删除部门信息
     * @param dep
     */
    void deleteDepartment(Department dep);
}
