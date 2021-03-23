package org.match.dataassert.mapper;

import org.match.dataassert.datadomain.CountAddrDomain;

public interface CountAddrCountAddrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CountAddrDomain record);

    int insertSelective(CountAddrDomain record);

    CountAddrDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CountAddrDomain record);

    int updateByPrimaryKey(CountAddrDomain record);
}