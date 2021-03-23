package org.match.services.interfaces.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import org.match.dataassert.datadomain.SysDictDomain;
import org.match.dataassert.mapper.SysDictDomainMapper;
import org.match.services.interfaces.SysDictDomainService;

@Service
public class SysDictDomainServiceImpl extends ServiceImpl<SysDictDomainMapper,SysDictDomain> implements SysDictDomainService {

    @Resource
    private SysDictDomainMapper sysDictDomainMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysDictDomainMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysDictDomain record) {
        return sysDictDomainMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(SysDictDomain record) {
        return sysDictDomainMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysDictDomain record) {
        return sysDictDomainMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(SysDictDomain record) {
        return sysDictDomainMapper.insertSelective(record);
    }

    @Override
    public SysDictDomain selectByPrimaryKey(Integer id) {
        return sysDictDomainMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysDictDomain record) {
        return sysDictDomainMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysDictDomain record) {
        return sysDictDomainMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<SysDictDomain> list) {
        return sysDictDomainMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<SysDictDomain> list) {
        return sysDictDomainMapper.batchInsert(list);
    }

    @Override
    public int updateBatchSelective(List<SysDictDomain> list) {
        return baseMapper.updateBatch(list);
    }
}



