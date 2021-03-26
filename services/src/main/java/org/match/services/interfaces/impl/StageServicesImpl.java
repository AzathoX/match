package org.match.services.interfaces.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.match.dataassert.datadomain.PointSystem;
import org.match.dataassert.datadomain.StageDomain;
import org.match.dataassert.datadomain.StageTeamRelDomain;
import org.match.dataassert.mapper.PointSystemMapper;
import org.match.dataassert.mapper.StageMapper;
import org.match.dataassert.mapper.StageTeamRelMapper;
import org.match.domains.bo.MatchTemplateBO;
import org.match.services.ddd.AbstractGroup;
import org.match.services.ddd.AbstractStage;
import org.match.services.ddd.Match;
import org.match.services.ddd.support.OriginSchedule;
import org.match.services.ddd.support.OriginStage;
import org.match.services.interfaces.CacheServices;
import org.match.services.interfaces.StageServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StageServicesImpl implements StageServices {


    @Autowired
    private PointSystemMapper pointSystemMapper;


    @Autowired
    private StageTeamRelMapper stageTeamRelMapper;


    @Autowired
    private StageMapper stageMapper;


    @Autowired
    private CacheServices cacheServices;

    private Map<String,PointSystem> initPointData(){
        Map<String,PointSystem> pointData = new HashMap<>();
        List<PointSystem> pointSystems = pointSystemMapper.selectList(new QueryWrapper<PointSystem>());
        for (PointSystem pointSystem : pointSystems) {
            pointData.put(pointSystem.getName(),pointSystem);
        }
        return pointData;
    }

    private void  aboutMatchTimeOf(StageDomain stageDomain,PointSystem pointSystem){
        int matchCount = stageDomain.getMatchCount();
        int reqCourtCount = stageDomain.getReqCourtCount();
        double reqCourtHours = 1.0 * matchCount * pointSystem.getInningMinutes() *
                pointSystem.getInningCount() / (reqCourtCount * 60);
        stageDomain.setReqCourtHours(reqCourtHours+"");

    }

    @Transactional
    @Override
    public AbstractStage create(AbstractGroup group){
        Map<String,PointSystem> data = initPointData();
        //eventDomain
        AbstractStage stage = new OriginStage(group);
        StageDomain stageDomain = stage.create();
        //teamCount
        stage.setPointSystem(data.get(group.getMatchBo().getPointSystemId()+""));
        this.aboutMatchTimeOf(stageDomain,stage.getPointSystem());
        List<StageTeamRelDomain> stageTeamRelDomainList = stage.getStageTeamRelDomainList();
        //set 开始时间
        stageDomain.setStartDate(group.getMatchBo().getStartDate());
        stageDomain.setCourtCount(group.getMatchBo().getCourtCount().byteValue());
        stageMapper.insert(stageDomain);
        stageDomain = stageMapper.selectOne(new QueryWrapper<StageDomain>().select(StageDomain.ID).eq(StageDomain.UNINAME, stageDomain.getUniname()));
        for (StageTeamRelDomain stageTeamRelDomain : stageTeamRelDomainList) {
            stageTeamRelDomain.setStageId(stageDomain.getId());
        }
        stageTeamRelMapper.batchInsert(stageTeamRelDomainList);
        return stage;
    }

    @Transactional
    @Override
    public void schedule(MatchTemplateBO bo, AbstractStage stage, AbstractGroup group){
        Match match = Match.from(bo);
        match.setSchedule(new OriginSchedule(group,stage));
        //制作编排表
        match.schedule();
        //持久化
        //将对象放入缓存中
        //  cacheServices.addCache("match:"+match.getEventId(),match);
    }

}
