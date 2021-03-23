package org.match.dataassert.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.match.dataassert.datadomain.SysDictDomain;


@Mapper
public interface SysDictDomainMapper extends BaseMapper<SysDictDomain> {
    int updateBatch(List<SysDictDomain> list);

    int batchInsert(@Param("list") List<SysDictDomain> list);

    int insertOrUpdate(SysDictDomain record);

    int insertOrUpdateSelective(SysDictDomain record);

    int updateBatchSelective(List<SysDictDomain> list);

    int deleteByPrimaryKey(Integer id);

    @Override
    int insert(SysDictDomain record);

    int insertSelective(SysDictDomain record);

    SysDictDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDictDomain record);

    int updateByPrimaryKey(SysDictDomain record);
}