package org.match.dataassert.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.match.dataassert.datadomain.GroupTeamRelDomain;

import java.util.List;

@Mapper
public interface GroupTeamRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupTeamRelDomain record);

    int insertSelective(GroupTeamRelDomain record);

    GroupTeamRelDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupTeamRelDomain record);

    int updateByPrimaryKey(GroupTeamRelDomain record);

    int batchInsert(List<GroupTeamRelDomain> records);
}