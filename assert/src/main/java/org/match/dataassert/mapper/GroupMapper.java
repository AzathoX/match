package org.match.dataassert.mapper;

import org.match.dataassert.datadomain.GroupDomains;

public interface GroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupDomains record);

    int insertSelective(GroupDomains record);

    GroupDomains selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupDomains record);

    int updateByPrimaryKey(GroupDomains record);
}