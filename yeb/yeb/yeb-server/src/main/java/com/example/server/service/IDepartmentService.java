package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.Department;
import com.example.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cxf
 * @since 2021-12-14
 */
public interface IDepartmentService extends IService<Department> {

    /**
     * 获取所有部门信息
     * @return
     */
    List<Department> getAllDepartment();

    /**
     * 添加部门信息
     * @param department
     * @return
     */
    RespBean addDepartment(Department department);

    /**
     * 删除部门信息
     * @param id
     * @return
     */
    RespBean deleteDepartment(Integer id);
}
