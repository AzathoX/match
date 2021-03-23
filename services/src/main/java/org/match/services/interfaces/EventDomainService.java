package org.match.services.interfaces;

import java.util.List;
import org.match.dataassert.datadomain.EventDomain;
import com.baomidou.mybatisplus.extension.service.IService;
public interface EventDomainService extends IService<EventDomain>{


    int updateBatch(List<EventDomain> list);

    int batchInsert(List<EventDomain> list);

    int insertOrUpdate(EventDomain record);

    int insertOrUpdateSelective(EventDomain record);

}
