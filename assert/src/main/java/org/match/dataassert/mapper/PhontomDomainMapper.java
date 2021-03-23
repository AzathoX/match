package org.match.dataassert.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.match.dataassert.datadomain.PhontomDomain;

import java.util.List;
import java.util.Map;

public interface PhontomDomainMapper extends BaseMapper<PhontomDomain> {
    int deleteByPrimaryKey(Integer id);

    @Override
    int insert(PhontomDomain record);

    int insertSelective(PhontomDomain record);

    PhontomDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PhontomDomain record);

    int updateByPrimaryKey(PhontomDomain record);

    List<PhontomDomain> list(Integer state);
}