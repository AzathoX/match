package org.match.dataassert.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.match.dataassert.datadomain.StageTeamRelDomain;

import java.util.List;

@Mapper
public interface StageTeamRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StageTeamRelDomain record);

    int insertSelective(StageTeamRelDomain record);

    StageTeamRelDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StageTeamRelDomain record);

    int updateByPrimaryKey(StageTeamRelDomain record);

    int batchInsert(List<StageTeamRelDomain> records);
}