package org.match.dataassert.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.match.dataassert.datadomain.EventDomain;

@Mapper
public interface EventDomainMapper extends BaseMapper<EventDomain> {
    int updateBatch(List<EventDomain> list);

    int batchInsert(@Param("list") List<EventDomain> list);

    int insertOrUpdate(EventDomain record);

    int insertOrUpdateSelective(EventDomain record);
}