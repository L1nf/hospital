package com.soft_engin.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft_engin.hospital.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Linf
 * @description 针对表【menu(菜单表)】的数据库操作Mapper
 * @createDate 2022-10-30 12:54:48
 * @Entity com.soft_engin.hospital.entity.Menu
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserId(
            Long userId
    );
}
