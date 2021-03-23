package org.match.dataassert.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.match.dataassert.datadomain.FileDomain;

@Mapper
public interface FileDomainMapper extends BaseMapper<FileDomain> {
    int deleteByPrimaryKey(Integer id);

    int insert(FileDomain record);

    int insertSelective(FileDomain record);

    FileDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FileDomain record);

    int updateByPrimaryKey(FileDomain record);
}