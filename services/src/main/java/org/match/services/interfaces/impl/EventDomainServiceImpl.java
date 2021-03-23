package org.match.services.interfaces.impl;

import org.match.services.interfaces.EventDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.match.dataassert.mapper.EventDomainMapper;
import org.match.dataassert.datadomain.EventDomain;
import org.match.domains.model.EventDomainRequest;

@Service
public class EventDomainServiceImpl extends ServiceImpl<EventDomainMapper, EventDomain> implements EventDomainService {



    @Autowired
    private  EventDomainMapper eventDomainMapper;

    @Override
    public int updateBatch(List<EventDomain> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<EventDomain> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(EventDomain record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(EventDomain record) {
        return baseMapper.insertOrUpdateSelective(record);
    }


    //填充秩序册内容完成比赛的信息
    public void fillingEvent(EventDomainRequest domainRequest){

    }
}
