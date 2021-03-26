package org.match.dataassert.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.match.dataassert.datadomain.StageDomain;

@Mapper
public interface StageMapper  extends BaseMapper<StageDomain> {
    int deleteByPrimaryKey(Integer id);

    @Override
    int insert(StageDomain record);

    int insertSelective(StageDomain record);

    StageDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StageDomain record);

    int updateByPrimaryKey(StageDomain record);
}