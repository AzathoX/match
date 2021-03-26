package org.match.dataassert.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.match.dataassert.datadomain.GroupDomains;

import java.util.List;

@Mapper
public interface GroupMapper extends BaseMapper<GroupDomains> {
    int deleteByPrimaryKey(Integer id);

    @Override
    int insert(GroupDomains record);

    int insertSelective(GroupDomains record);

    GroupDomains selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupDomains record);

    int updateByPrimaryKey(GroupDomains record);

    int batchInsert(List<GroupDomains> records);
}