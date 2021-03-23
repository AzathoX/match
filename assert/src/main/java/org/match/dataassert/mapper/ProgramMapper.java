package org.match.dataassert.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.match.dataassert.datadomain.ProgramDomain;

public interface ProgramMapper extends BaseMapper<ProgramDomain> {
    int deleteByPrimaryKey(Integer id);

    int insert(ProgramDomain record);

    int insertSelective(ProgramDomain record);

    ProgramDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProgramDomain record);

    int updateByPrimaryKey(ProgramDomain record);
}