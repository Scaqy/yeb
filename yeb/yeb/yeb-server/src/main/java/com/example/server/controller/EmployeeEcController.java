package com.example.server.controller;


import com.example.server.pojo.EmployeeEc;
import com.example.server.pojo.Position;
import com.example.server.pojo.RespBean;
import com.example.server.service.IEmployeeEcService;
import com.example.server.service.IPositionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cxf
 * @since 2021-12-14
 */
@RestController
@RequestMapping("/system/basic/ec")
public class EmployeeEcController {

    @Autowired
    private IEmployeeEcService employeeEcService;

    @ApiOperation(value = "获取所有奖惩信息")
    @GetMapping("/")
    public List<EmployeeEc> getAllEmployeeEc(){
        return employeeEcService.list();
    }

    @ApiOperation(value = "添加奖惩信息")
    @PostMapping("/")
    public RespBean addEmployeeEc(@RequestBody EmployeeEc employeeEc){
        if(employeeEcService.save(employeeEc)){
            return RespBean.success("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @ApiOperation(value = "更新奖惩信息")
    @PutMapping("/")
    public RespBean updateEmployeeEc(@RequestBody EmployeeEc employeeEc){
        if(employeeEcService.updateById(employeeEc)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除奖惩信息")
    @DeleteMapping("/{id}")
    public RespBean deleteEmployeeEc(@PathVariable Integer id){
        if(employeeEcService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "批量删除奖惩信息")
    @DeleteMapping("/")
    public RespBean deleteEmployeeEcBuIds(Integer[] ids){
        if(employeeEcService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}
