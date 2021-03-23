package org.match.services.ddd;

import lombok.*;
import org.match.dataassert.datadomain.PlayerDomain;
import org.match.dataassert.datadomain.TeamDomain;
import org.match.domains.bo.BusinessObject;
import org.match.domains.vo.ViewObject;
import org.match.services.utils.AbstractMD5Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@AllArgsConstructor
@ToString
public class Team implements DriverDomainDesignedable {

    private TeamDomain teamDomain;


    private final List<String> teamCorePlayer = new ArrayList<>();
    private Map<String,PlayerDomain> playerNo = new HashMap<>();

    @Setter
    @Getter
    private List<PlayerDomain> playerDomainList;

    public static Team from(TeamDomain domain){
        Team team = new Team();
        team.teamDomain = domain;
        return team;
    }

    public Team(){
        teamCorePlayer.add("领队");
        teamCorePlayer.add("教练");
        teamCorePlayer.add("队长");
        teamCorePlayer.add("队员");
    }

    public void addPlayer(String name){
        this.addPlayer(4,name);
    }

    public void addPlayer(int type,String name){
        PlayerDomain playerDomain = new PlayerDomain();
        playerDomain.setEventId(teamDomain.getEventId());
        playerDomain.setTeamId(teamDomain.getId());
        playerDomain.setName(name);
        //1男2女
        playerDomain.setSex((byte) 1);
        playerDomain.setType((byte) type);
        playerDomain.setRemark(teamDomain.getRemark()+"-"+ AbstractMD5Utils.md532ByteRandom(name));
        playerNo.put(teamDomain.getRemark(),playerDomain);
        playerDomainList.add(playerDomain);

    }

    public void genericPlayer(int count){
        this.playerDomainList = new ArrayList<>();
        //先生成四个默认
        int sum = 0;
        for(int i = 0 ; i < 3;i++){
            if(i < 3){
                this.addPlayer(i+1,"生成-"+teamCorePlayer.get(i)+":"+ (sum = i + 1));
            }
        }
        count = count > 3 ? count - 3:1;
        sum++;
        for(int i = 0 ; i< count;i++){
            this.addPlayer(0,"生成-"+teamCorePlayer.get(3)+":"+ ( sum + i ) );
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
