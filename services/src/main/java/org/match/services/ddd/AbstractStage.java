package org.match.services.ddd;

import lombok.Getter;
import lombok.Setter;
import org.match.dataassert.datadomain.PointSystem;
import org.match.dataassert.datadomain.StageDomain;
import org.match.dataassert.datadomain.StageTeamRelDomain;
import org.match.domains.bo.MatchTemplateBO;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStage {


    @Getter
    @Setter
    protected PointSystem pointSystem;

    protected MatchTemplateBO matchTemplateBO;

    protected Integer eventId;

    @Getter
    private List<StageTeamRelDomain> stageTeamRelDomainList;


    @Getter
    private AbstractGroup group;

    public AbstractStage(AbstractGroup group){
         this.matchTemplateBO = group.getMatchBo();
         this.eventId = this.matchTemplateBO.getEventId();
         this.group = group;
         this.stageTeamRelDomainList = new ArrayList<>();
    }

    protected  abstract StageDomain doCreate();

    protected abstract  void init();


    protected  abstract  void doRel(List<StageTeamRelDomain> stageTeamRelDomainList);


    public StageDomain create(){
        init();
        StageDomain stageDomain = doCreate();
        doRel(this.stageTeamRelDomainList);
        return  stageDomain;
    }

}
