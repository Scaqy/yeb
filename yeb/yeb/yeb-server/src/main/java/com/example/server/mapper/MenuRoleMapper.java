package com.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.pojo.MenuRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2021-12-14
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * 更新角色菜单
     *
     * @param mids
     * @param rid
     * @return
     */
    Integer insertRecord(@Param("mids") Integer[] mids, @Param("rid") Integer rid);
}
