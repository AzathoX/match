package org.match.services.interfaces;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import org.match.dataassert.datadomain.SysDictDomain;

public interface SysDictDomainService extends IService<SysDictDomain> {


    int deleteByPrimaryKey(Integer id);

    int insert(SysDictDomain record);

    int insertOrUpdate(SysDictDomain record);

    int insertOrUpdateSelective(SysDictDomain record);

    int insertSelective(SysDictDomain record);

    SysDictDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDictDomain record);

    int updateByPrimaryKey(SysDictDomain record);

    int updateBatch(List<SysDictDomain> list);

    int batchInsert(List<SysDictDomain> list);

    int updateBatchSelective(List<SysDictDomain> list);
}



