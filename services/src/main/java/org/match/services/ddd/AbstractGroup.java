package org.match.services.ddd;

import lombok.Getter;
import org.match.dataassert.datadomain.TeamDomain;
import org.match.domains.bo.BusinessObject;
import org.match.domains.vo.ViewObject;

import java.util.Collections;
import java.util.List;

public abstract class AbstractGroup implements DriverDomainDesignedable   {


    @Getter
    protected List<TeamDomain> teamDomains;


    public  AbstractGroup(List<TeamDomain> teamDomains){
        this.teamDomains = teamDomains;
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




    @Override
    public ViewObject vo() {
        return null;
    }

    @Override
    public BusinessObject bo() {
        return null;
    }
}
