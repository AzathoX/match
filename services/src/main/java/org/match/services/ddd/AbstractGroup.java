package org.match.services.ddd;

import lombok.Getter;
import org.match.dataassert.datadomain.GroupDomains;
import org.match.dataassert.datadomain.GroupTeamRelDomain;
import org.match.dataassert.datadomain.TeamDomain;
import org.match.domains.bo.BusinessObject;
import org.match.domains.bo.MatchTemplateBO;
import org.match.domains.vo.ViewObject;
import org.match.services.utils.AbstractMD5Utils;

import java.util.*;

public abstract class AbstractGroup implements DriverDomainDesignedable   {


    @Getter
    protected List<TeamDomain> teamDomains;

    @Getter
    protected List<String>  groupNames;

    @Getter
    private List<GroupDomains> groupDomains;

    @Getter
    protected  List<GroupTeamRelDomain> groupTeamRelDomains;

    @Getter
    protected  Integer eventId;

    @Getter
    protected MatchTemplateBO matchBo;

    private Map<String,List<GroupTeamRelDomain>> relList;




    protected String addGroupList(String name){
        GroupDomains groupDomains = new GroupDomains();
        groupDomains.setEventId(this.eventId);
        groupDomains.setName(name);
        groupDomains.setUniname(AbstractMD5Utils.md532ByteRandom(name+""));
        this.groupDomains.add(groupDomains);
        this.groupNames.add(groupDomains.getUniname());
        return  groupDomains.getUniname();
    }

    protected GroupTeamRelDomain addTeamGroupRel(String groupUniname,TeamDomain teamDomain){
        GroupTeamRelDomain groupTeamRelDomain = new GroupTeamRelDomain();
        groupTeamRelDomain.setTeamId(teamDomain.getId());
        groupTeamRelDomain.setUniname(groupUniname);
        this.put(groupUniname,groupTeamRelDomain);
        this.groupTeamRelDomains.add(groupTeamRelDomain);
        return groupTeamRelDomain;
    }





    public  AbstractGroup(List<TeamDomain> teamDomains){
        this.teamDomains = teamDomains;
        groupNames = new ArrayList<>();
        groupDomains = new ArrayList<>();
        groupTeamRelDomains = new ArrayList<>();
        relList = new HashMap<>();
    }


    protected void put(String key,GroupTeamRelDomain value){
         List<GroupTeamRelDomain> groupTeamRelDomains;
         if(Objects.isNull(groupTeamRelDomains = this.relList.get(key))){
             groupTeamRelDomains = new ArrayList<>();
             this.relList.put(key,groupTeamRelDomains);
         }
         groupTeamRelDomains.add(value);

    }




    public void group(boolean isRandom){
         //拿到隊伍
         this.init();
        //根據隊伍分組,分配隊伍
        //打亂順序
        if(isRandom){
        //  隨機打亂
            Collections.shuffle(this.teamDomains);
        }
        //分配隊伍
        this.allocate();

    }

    @Getter
    protected TeamDomain[][] teamsGroup;




    //隊伍的分配方式
    public abstract List<TeamDomain> doAllocate();

    protected abstract   void init();


    public void allocate(){
        this.doAllocate();
    }


    public void rel(List<GroupDomains> groupDomains){
        this.groupDomains = groupDomains;
        doRel();
    }


    protected void doRel(){
        for (GroupDomains groupDomain : this.groupDomains) {
            List<GroupTeamRelDomain> relDomainsList;
            if (Objects.nonNull(relDomainsList= this.relList.get(groupDomain.getUniname()))) {
                for (GroupTeamRelDomain groupTeamRelDomain : relDomainsList) {
                    groupTeamRelDomain.setGroupId(groupDomain.getId());
                    groupTeamRelDomain.setUniname(null);
                }
            }
        }
    }





    @Override
    public ViewObject vo() {
        return null;
    }

    @Override
    public BusinessObject bo() {
        return null;
    }
}
