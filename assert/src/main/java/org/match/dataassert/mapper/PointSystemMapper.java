package org.match.dataassert.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.match.dataassert.datadomain.PointSystem;

@Mapper
public interface PointSystemMapper extends BaseMapper<PointSystem> {
    int deleteByPrimaryKey(Integer id);

    @Override
    int insert(PointSystem record);

    int insertSelective(PointSystem record);

    PointSystem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PointSystem record);

    int updateByPrimaryKey(PointSystem record);
}