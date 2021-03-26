package org.match.services.ddd;

import lombok.Getter;
import lombok.Setter;
import org.match.dataassert.datadomain.*;
import org.match.dataassert.json.TempJson;
import org.match.domains.bo.BusinessObject;
import org.match.domains.bo.MatchTemplateBO;
import org.match.domains.vo.ViewObject;
import org.match.services.utils.AbstractMD5Utils;

import java.util.*;

public class Match implements DriverDomainDesignedable {


    @Getter
    private MatchTempDomain matchTempDomain;


    @Getter
    private EventDomain eventDomain;

    private ProgramDomain programDomain;

    @Getter
    @Setter
    private Object config;

    private boolean hasProgramDomain = false;

    private boolean hasConfig = false;

    private List<TeamDomain> teamDomains;


    @Getter
    private List<String> uniqueMark;


    private Map<String,Team> teams;

    @Setter
    private AbstractSchedule schedule;


    public Match(){
        this.teamDomains = new ArrayList<>();
        this.uniqueMark = new ArrayList<>();
        this.teams = new HashMap<>();
    }

    public void clear(){
        this.teamDomains = new ArrayList<>();
        this.uniqueMark = new ArrayList<>();
        this.teams = new HashMap<>();
    }



    public static Match from(MatchTempDomain matchTempDomains){
        Match match = new Match();
        match.matchTempDomain = matchTempDomains;
        match.eventDomain =  matchTempDomains.getEventDomain();
        match.programDomain = matchTempDomains.getProgramDomain();
        match.hasProgramDomain = Objects.nonNull(match.programDomain);
        match.hasConfig = Objects.nonNull(match.matchTempDomain.getTempConfig());
        return match;
    }


    public static Match from(BusinessObject bo){
        MatchTemplateBO mtbo = (MatchTemplateBO) bo;
        Match match = new Match();
        EventDomain eventDomain = EventDomain.builder()
                .id(mtbo.getEventId())
                .name(mtbo.getName())
                .teamCount(mtbo.getTeamCount())
                .subMatchCount(mtbo.getSubMatchCount())
                .type(mtbo.getType())
                .programId(mtbo.getProgramId())
                .matchTypes(mtbo.getMatchTypes())
                .pointSystemId(mtbo.getPointSystemId())
                .pointSystemId2(mtbo.getPointSystemId2())
                .pointSystemId3(mtbo.getPointSystemId3())
                .programId(mtbo.getProgramId())
                .subMatchNames(mtbo.getSubMatchNames())
                .simpleName(mtbo.getSimpleName())
                .species(mtbo.getSpecies())
                .groupCount(mtbo.getGroupCount())
                .pointBase(mtbo.getPointBase())
                .ruleType(mtbo.getRuleType())
                .build();
        match.eventDomain = eventDomain;
        return match;
    }

    public void jsonConfig(){
        int hash = this.eventDomain.hashCode();
        TempJson tempJson = TempJson.builder()
                .event(this.eventDomain)
                .hash(hash)
                .build();

        MatchTempDomain vmatchTempDomain = MatchTempDomain.builder()
                .tempUniname(this.eventDomain.getName() + "-模板")
                .tempConfig(tempJson)
                .eventId(this.eventDomain.getId()).build();
        this.matchTempDomain = vmatchTempDomain;
    }




    @Override
    public ViewObject vo() {
        return null;
    }

    @Override
    public BusinessObject bo() {

        MatchTemplateBO.MatchTemplateBOBuilder boBuilder = MatchTemplateBO.builder()
                .name(this.eventDomain.getName())
                .description(this.eventDomain.getDescription())
                .type(this.eventDomain.getType())
                .matchTypes(this.eventDomain.getMatchTypes())
                .subMatchCount(this.eventDomain.getSubMatchCount())
                .ruleType(this.eventDomain.getRuleType())
                .teamCount(this.eventDomain.getTeamCount())
                .pointSystemId(this.eventDomain.getPointSystemId())
                .pointSystemId2(this.eventDomain.getPointSystemId2())
                .pointSystemId3(this.eventDomain.getPointSystemId3())
                .simpleName(this.eventDomain.getSimpleName())
                .subMatchNames(this.eventDomain.getSubMatchNames())
                .species(this.eventDomain.getSpecies())
                .pointBase(this.eventDomain.getPointBase())
                .groupCount(this.eventDomain.getGroupCount())
                .programId(this.eventDomain.getProgramId());
        if(Objects.nonNull(this.matchTempDomain)){
            boBuilder.id(this.matchTempDomain.getId())
                    .eventId(this.matchTempDomain.getEventId());
        }
        if(hasConfig){
             boBuilder.tempConfig(this.matchTempDomain.getTempConfig());
             boBuilder.tempUniname(this.matchTempDomain.getTempUniname());
        }
        if(hasProgramDomain){
             boBuilder.programId(this.programDomain.getId())
                     .programName(this.programDomain.getName())
                     .context(this.programDomain.getContext())
                     .isAvailable(this.programDomain.getIsAvailable());
        }
        return  boBuilder.build();
    }


    public Integer getEventId(){
        return this.eventDomain.getId();
    }

    public List<TeamDomain> genericTeam(){
        this.teamDomains = new ArrayList<>();
        Integer teamCount = this.eventDomain.getTeamCount();
        for (int i = 0; i < teamCount; i++) {
            TeamDomain teamDomain = new TeamDomain();
            teamDomain.setEventId(this.eventDomain.getId());
            teamDomain.setName("生成-赛事队伍："+i);
            //临时方案 ，接近但不保证唯一
            String mark = AbstractMD5Utils.md532ByteRandom(teamDomain.hashCode() + "");
            teamDomain.setRemark(mark);
            Team from = Team.from(teamDomain);
            this.teams.put(mark,from);
            this.uniqueMark.add(mark);
            this.teamDomains.add(teamDomain);
        }
        return this.teamDomains;
    }


    public void refresTeam( List<TeamDomain> teams){
        this.clear();
        for (TeamDomain team : teams) {
            uniqueMark.add(team.getRemark());
            Team from = Team.from(team);
            this.teams.put(team.getRemark(),from);
            this.teamDomains.add(team);
        }
    }

    public void schedule(){
        //准备

        //编排
        this.schedule.schedule();

        //保存

    }

    public List<PlayerDomain> genericPlayer(){
           List<PlayerDomain> playerDomains = new ArrayList<>();
           final int autoSwitch = this.eventDomain.getSubMatchCount();
           //自动生成 3项 对应8个人 5项对应9个人
           this.teams.keySet().stream()
                   .map(k -> k).forEach(action ->{
               Team team = this.teams.get(action);
               int count = 0;
               //临时方案
               if(autoSwitch == 3){
                   count = 8;
               }
               else if(autoSwitch == 5){
                   count = 9;
               }
               else{
                   count = 12;
               }
               team.genericPlayer(count);
               playerDomains.addAll(team.getPlayerDomainList());
           });
           return playerDomains;
    }
}
