package org.match.dataassert.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.match.dataassert.datadomain.TeamDomain;

import java.util.List;

@Mapper
public interface TeamMapper  extends BaseMapper<TeamDomain> {
    int deleteByPrimaryKey(Integer id);

    int insert(TeamDomain record);

    int insertSelective(TeamDomain record);

    TeamDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeamDomain record);

    int updateByPrimaryKey(TeamDomain record);

    int batchInsert(List<TeamDomain> records);
}