package org.match.services.ddd.support;

import org.match.dataassert.datadomain.TeamDomain;
import org.match.domains.bo.MatchTemplateBO;
import org.match.services.ddd.AbstractGroup;

import java.util.ArrayList;
import java.util.List;

public class OriginGroup extends AbstractGroup {
 

    private static  List<TeamDomain[][]> ALLOCATE_RULE = new ArrayList<>();



    private static final int MAX_TEAM_RULE = 64;

    private static final int LOWER_FOUR = 4;
    private static final TeamDomain[][] LOWER_FOUR_GROUP = new TeamDomain[1][];

    private static final int LOWER_EIGHT = 8;
    private static final TeamDomain[][] LOWER_EIGHT_GROUP = new TeamDomain[2][];

    private static final int LOWER_SIXTEEN = 16;
    private static final TeamDomain[][] LOWER_SIXTEEN_GROUP = new TeamDomain[4][];

    private static  final int LOWER_FOURTY = 40;
    private static  final TeamDomain[][] LOWER_FOURTY_GROUP = new TeamDomain[8][];


    private static final int EQUAL_NIGHT = 9;
    private static final TeamDomain[][] EQUAL_NIGHT_GROUP = new TeamDomain[3][];

    private static final int LOWER_EIGHTEEN = 18;
    private static final TeamDomain[][] LOWER_EIGHTEEN_GROUP = new TeamDomain[6][];


    private static  final TeamDomain[][] OTHER = new TeamDomain[16][];

    static{
        ALLOCATE_RULE.add(LOWER_FOUR_GROUP);
        for(int i=1 ; i<= MAX_TEAM_RULE ; i++){
            if( i <= LOWER_FOUR){
                ALLOCATE_RULE.add(LOWER_FOUR_GROUP);
            }
            else if (i <= LOWER_EIGHT){
                ALLOCATE_RULE.add(LOWER_EIGHT_GROUP);
            }
            else if(i == EQUAL_NIGHT){
                ALLOCATE_RULE.add(EQUAL_NIGHT_GROUP);
            }
            else if(i <= LOWER_SIXTEEN){
                ALLOCATE_RULE.add(LOWER_SIXTEEN_GROUP);
            }
            else  if(i <= LOWER_EIGHTEEN){
                ALLOCATE_RULE.add(LOWER_EIGHTEEN_GROUP);
            }
            else if(i <= LOWER_FOURTY){
                ALLOCATE_RULE.add(LOWER_FOURTY_GROUP);
            }
            else{
                ALLOCATE_RULE.add(OTHER);
            }
        }
    }




    @Override
    public void init(){
        super.teamsGroup =  ALLOCATE_RULE.get(super.teamDomains.size()).clone();
    }




    public OriginGroup(List<TeamDomain> teamDomains , int eventId) {
        super(teamDomains);
        this.eventId = eventId;
    }

    public OriginGroup(List<TeamDomain> teamDomains , MatchTemplateBO bo) {
         this(teamDomains,bo.getEventId());
         this.matchBo = bo;
    }


    @Override
    public List<TeamDomain> doAllocate() {
        int groupSize = super.teamDomains.size() / super.teamsGroup.length;
        //將teamDomains 轉換成迭代器
        for (int i = 0; i < this.teamsGroup.length; i++) {
            //初始化每個數組項
            this.teamsGroup[i] = new TeamDomain[groupSize];
            String uniName = this.addGroupList((char)('A'+ i)+"");
            //設置數組
            for(int j = 0 ; j < groupSize ; j++){
                 int index = (i * groupSize)+j;
                 if(index < teamDomains.size()){
                     TeamDomain teamDomain = teamDomains.get(index);
                     this.teamsGroup[i][j] = teamDomain;
                     this.addTeamGroupRel(uniName,teamDomain);
                 }
            }
        }
        return null;
    }


}
