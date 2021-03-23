package org.match.dataassert.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.match.dataassert.datadomain.PlayerDomain;

import java.util.List;

@Mapper
public interface PlayerDomainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlayerDomain record);

    int insertSelective(PlayerDomain record);

    PlayerDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlayerDomain record);

    int updateByPrimaryKey(PlayerDomain record);

    int batchInsert(List<PlayerDomain> records);
}