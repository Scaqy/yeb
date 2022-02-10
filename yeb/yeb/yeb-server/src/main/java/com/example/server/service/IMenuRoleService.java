package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.MenuRole;
import com.example.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cxf
 * @since 2021-12-14
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param mid
     * @param rid
     * @return
     */
    RespBean updateMenuRole(Integer[] mids, Integer rid);
}
