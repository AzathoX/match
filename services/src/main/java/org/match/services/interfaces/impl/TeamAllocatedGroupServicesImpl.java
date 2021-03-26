package org.match.services.interfaces.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.match.domains.bo.MatchTemplateBO;
import org.match.services.interfaces.TeamAllocatedGroupServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.match.dataassert.datadomain.GroupDomains;
import org.match.dataassert.datadomain.TeamDomain;
import org.match.dataassert.mapper.GroupMapper;
import org.match.dataassert.mapper.GroupTeamRelMapper;
import org.match.dataassert.mapper.TeamMapper;
import org.match.services.ddd.AbstractGroup;
import org.match.services.ddd.support.OriginGroup;

import java.util.List;

@Service
public class TeamAllocatedGroupServicesImpl implements TeamAllocatedGroupServices {

    @Autowired
    private TeamMapper teamMapper;


    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private GroupTeamRelMapper groupTeamRelMapper;


    @Transactional
    @Override
    public AbstractGroup group(MatchTemplateBO bo) {
        List<TeamDomain> teamDomainList = teamMapper
                .selectList(new QueryWrapper<TeamDomain>()
                        .select().in(TeamDomain.EVENT_ID, bo.getEventId()));
        AbstractGroup group = new OriginGroup(teamDomainList,bo);
        group.group(false);
        //申請隊伍
        groupMapper.batchInsert(group.getGroupDomains());
        //創建隊伍引用鏈接
        List<GroupDomains> groupDomains = groupMapper.selectList(new QueryWrapper<GroupDomains>()
                .select(GroupDomains.ID,GroupDomains.UNINAME).in(GroupDomains.UNINAME,group.getGroupNames()));
        //對齊鏈接
        group.rel(groupDomains);
        groupTeamRelMapper.batchInsert(group.getGroupTeamRelDomains());
        return  group;
    }
}
