package org.match.services.ddd.support;

import org.match.dataassert.datadomain.StageDomain;
import org.match.dataassert.datadomain.StageTeamRelDomain;
import org.match.dataassert.datadomain.TeamDomain;
import org.match.services.ddd.AbstractGroup;
import org.match.services.ddd.AbstractStage;
import org.match.services.utils.AbstractMD5Utils;

import java.util.List;

public class OriginStage extends AbstractStage {

    private static final int  AM_START_TIME = 800;

    private static final int PM_START_TIME = 1400;

    private static final int STAGE_NO = 1;

    private static final int ROUND_ROBIN = 2;

    private static final int TYPE_SINGLE = 1;

    private static final int TYPE_GROUP = 2;
    private static final int TYPE_COMBAT = 3;
    private static final int TYPE_CHALLENGE = 4;
    private static final int TYPE_WUYU = 5;
    private static final int TYPE_ROUND = 6;

    private static final int RULE_TYPE_CLUB = 2;



    private static final StageDomain stageDomain = new StageDomain();
    static {
        stageDomain.setAmStartTime(AM_START_TIME);
        stageDomain.setPmStartTime(PM_START_TIME);
        stageDomain.setNo(STAGE_NO);
        stageDomain.setCompetitionRuleId(ROUND_ROBIN);
    }


    public OriginStage(AbstractGroup group) {
        super(group);
    }


    private void setReqCourtCount(int teamCount){
        int reqCourtCount = 0;
        if (this.matchTemplateBO.getType() == TYPE_SINGLE) {
            if (teamCount <= 5) {
                reqCourtCount = 1;
            }
            else if (teamCount <= 8) {
                reqCourtCount = 2;
            }
            else if (teamCount <= 11) {
                reqCourtCount = 3;
            }
            else if (teamCount <= 22) {
                reqCourtCount = 4;
            }
            else if (teamCount <= 24) {
                reqCourtCount = 6;
            }
            else if (teamCount <= 40) {
                reqCourtCount = 8;
            }
            else {
                reqCourtCount = 16;
            }
        }
        else {
            if (teamCount <= 9) {
                reqCourtCount = 4;
            }
            else if (teamCount <= 24) {
                reqCourtCount = 8;
            }
            else {
                reqCourtCount = 16;
            }
        }
        stageDomain.setReqCourtCount(reqCourtCount);
    }


    @Override
    protected StageDomain doCreate() {
        //
        int matchCount = 0;
        for (TeamDomain[] teamDomains : this.getGroup().getTeamsGroup()) {
            int groupSize = teamDomains.length;
            matchCount += (groupSize * (groupSize - 1) / 2);
        }
        matchCount *= this.getGroup().getMatchBo().getSubMatchCount();
        stageDomain.setMatchCount(matchCount);
        this.setReqCourtCount(this.getGroup().getTeamDomains().size());
        stageDomain.setUniname(AbstractMD5Utils.md532ByteRandom(this.eventId + matchCount+""));
        return stageDomain;
    }



    @Override
    protected void init() {
        stageDomain.setEventId(eventId);
        stageDomain.setTeamCount(this.getGroup().getTeamDomains().size());
        stageDomain.setGroupCount((byte) this.getGroup().getTeamsGroup().length);
    }

    private static StageTeamRelDomain from(TeamDomain teamDomain ){
        StageTeamRelDomain stageTeamRelDomain = new StageTeamRelDomain();
        stageTeamRelDomain.setTeamId(teamDomain.getId());
        stageTeamRelDomain.setUniname(stageDomain.getUniname());
        return  stageTeamRelDomain;
    }

    @Override
    protected void doRel(List<StageTeamRelDomain> stageTeamRelDomainList) {
        for (TeamDomain teamDomain : this.getGroup().getTeamDomains()) {
            stageTeamRelDomainList.add(from(teamDomain));
        }
    }
}
