package com.example.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.server.mapper.DepartmentMapper;
import com.example.server.pojo.Department;
import com.example.server.pojo.RespBean;
import com.example.server.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxf
 * @since 2021-12-14
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 获取所有部门信息
     * @return
     */
    @Override
    public List<Department> getAllDepartment() {
        return departmentMapper.getAllDepartment(-1);
    }

    /**
     * 添加部门信息
     * @param department
     * @return
     */
    @Override
    public RespBean addDepartment(Department department) {
        department.setEnabled(true);
        departmentMapper.addDepartment(department);
        if(department.getResult()==1){
            return RespBean.success("添加成功！",department);
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 删除部门信息
     * @param id
     * @return
     */
    @Override
    public RespBean deleteDepartment(Integer id) {
        Department dep = new Department();
        dep.setId(id);
        departmentMapper.deleteDepartment(dep);
        if(dep.getResult()==-2){
            return RespBean.error("该部门下还有子部门，删除失败！");
        }
        if(dep.getResult()==-1){
            return RespBean.error("该部门下还有员工，删除失败！");
        }
        if(dep.getResult()==1){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
