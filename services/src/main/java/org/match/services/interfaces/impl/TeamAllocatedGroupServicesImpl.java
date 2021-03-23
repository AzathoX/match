package org.match.services.interfaces.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.match.services.interfaces.TeamAllocatedGroupServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.match.dataassert.datadomain.TeamDomain;
import org.match.dataassert.mapper.TeamMapper;
import org.match.services.ddd.AbstractGroup;
import org.match.services.ddd.support.BaseGroup;

import java.util.Arrays;
import java.util.List;

@Service
public class TeamAllocatedGroupServicesImpl implements TeamAllocatedGroupServices {

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public void group(int eventId) {
        List<TeamDomain> teamDomainList = teamMapper.selectList(new QueryWrapper<TeamDomain>().select().in(TeamDomain.EVENT_ID, eventId));
        AbstractGroup group = new BaseGroup(teamDomainList);
        group.group(false);
        TeamDomain[][] teamsGroup = group.getTeamsGroup();
        //申請隊伍

        //創建隊伍引用鏈接

    }
}
