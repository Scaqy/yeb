package com.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.pojo.AdminRole;
import com.example.server.pojo.RespBean;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2021-12-14
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {


    /**
     * 更新操作员角色
     *
     * @param adminId
     * @param rids
     * @return
     */
    Integer addAdminRoles(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
