package org.match.dataassert.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.match.dataassert.datadomain.PhontomFileDomain;

import java.util.List;
import java.util.Map;

@Mapper
public interface PhontomFileMapper extends BaseMapper<PhontomFileDomain> {
    int deleteByPrimaryKey(Integer id);

    @Override
    int insert(PhontomFileDomain record);

    int insertSelective(PhontomFileDomain record);


    List<Map<String,Object>> map();

    PhontomFileDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PhontomFileDomain record);

    int updateByPrimaryKey(PhontomFileDomain record);

    int batchInsert(List<PhontomFileDomain> list);
}