package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.server.mapper.MenuRoleMapper;
import com.example.server.pojo.MenuRole;
import com.example.server.pojo.RespBean;
import com.example.server.service.IMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxf
 * @since 2021-12-14
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    /**
     * 更新角色菜单
     * @param mids
     * @param rid
     * @return
     */
    @Override
    public RespBean updateMenuRole(Integer[] mids, Integer rid) {
        menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid",rid));
        if(mids==null||mids.length==0){
            return RespBean.success("更新成功！");
        }
        Integer result = menuRoleMapper.insertRecord(mids, rid);
        if(result==mids.length){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }
}
