package org.match.services.interfaces.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.match.domains.bo.MatchTemplateBO;
import org.match.domains.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.match.dataassert.datadomain.*;
import org.match.dataassert.mapper.*;
import org.match.domains.bo.BusinessObject;
import org.match.domains.vo.TemplatePageVO;
import org.match.domains.vo.ViewObject;
import org.match.services.ddd.Match;
import org.match.services.interfaces.TemplateServices;
import org.match.services.utils.AbstractMD5Utils;

import java.util.*;

@Service
public class TemplateServicesImpl implements TemplateServices {


    @Autowired
    private MatchTempMapper matchTempMapper;


    @Autowired
    private EventDomainMapper eventDomainMapper;


    @Autowired
    private ProgramMapper programMapper;


    @Autowired
    private SysDictDomainMapper sysDictDomainMapper;


    @Autowired
    private TeamMapper teamMapper;


    @Autowired
    private PlayerDomainMapper playerDomainMapper;

    @Override
    public ViewObject dataOfCreatePage(){
        TemplatePageVO templatePageVO = new TemplatePageVO();
        //从event 于config中拿到数据
        List<MatchTempDomain> vmatchTempDomains = matchTempMapper.selectCompeleteTemplete();
        //搜索秩序册
        List<ProgramDomain> programDomains = programMapper.selectList(new QueryWrapper<ProgramDomain>().select(ProgramDomain.ID,ProgramDomain.NAME));

        //搜索基本字典
        List<SysDictDomain> sysDictDomains = sysDictDomainMapper.selectList(new QueryWrapper<SysDictDomain>()
                .select(SysDictDomain.COL_ID, SysDictDomain.COL_CODE,
                        SysDictDomain.COL_NAME, SysDictDomain.COL_CAT)
                .eq(SysDictDomain.COL_TYPE, 1)
                .in(SysDictDomain.COL_CAT, SysDictDomain.MATCH_TYPE,
                        SysDictDomain.RULE_TYPE,
                        SysDictDomain.VALUE_TYPE,
                        SysDictDomain.COL_SEQ));

        Map<String, List<SysDictDomain>> dict = new HashMap<>();
        String key = null;
        List<SysDictDomain>  mapSysDictList = null;
        Map<Integer,ProgramDomain> programDict = new HashMap<>();
        for (ProgramDomain programDomain : programDomains) {
            programDict.put(programDomain.getId(),programDomain);
        }
        templatePageVO.setProgramDict(programDict);
        for (SysDictDomain sysDictDomain : sysDictDomains) {
           if(Objects.isNull(mapSysDictList = dict.get(key = sysDictDomain.getCat()))){
               mapSysDictList = new ArrayList<>();
           }
           mapSysDictList.add(sysDictDomain);
           dict.put(key,mapSysDictList);
        }
        templatePageVO.setDict(dict);
        //将其拆成两个模块的数据 1.event的参考数据 2.event配置文件数据 3.秩序册的数据
        for (MatchTempDomain vmatchTempDomain : vmatchTempDomains) {
            MatchTemplateBO matchTemplateBO = (MatchTemplateBO)Match.from(vmatchTempDomain).bo();
            templatePageVO.add(matchTemplateBO);
        }
        return templatePageVO;
    }


    public static int lockMark = 0;





    private   List<TeamDomain>   createTeam(Match match){
        List<TeamDomain> teamDomainList = match.genericTeam();
        //创建队伍
        teamMapper.batchInsert(teamDomainList);
        List<String> uniqueMark = match.getUniqueMark();
        List<TeamDomain> teams = teamMapper.selectList(new QueryWrapper<TeamDomain>()
                .in(TeamDomain.REMARK,uniqueMark).eq(TeamDomain.EVENT_ID,match.getEventId()));
        match.refresTeam(teams);
        List<PlayerDomain> playerDomains = match.genericPlayer();
        playerDomainMapper.batchInsert(playerDomains);
        return teamDomainList;
    }


    @Transactional
    @Override
    public BusinessObject create(EventDTO dto){
        lockMark ++;
        String mark = AbstractMD5Utils.md516Byte(lockMark + "");
        MatchTemplateBO bo = dto.bo();
        Match match = Match.from(bo);
        EventDomain eventDomain = match.getEventDomain();
        //锁
        eventDomain.setRemark(mark);
        List<EventDomain> eventDomains = new ArrayList<>();
        eventDomains.add(eventDomain);
        eventDomainMapper.batchInsert(eventDomains);
        //重新取出数据
        List<EventDomain> list = eventDomainMapper.selectList(new QueryWrapper<EventDomain>().eq(EventDomain.COL_REMARK, mark));
        if(list.size() > 0){
            //去除锁
            eventDomain = list.get(0);
            eventDomain.setRemark("ok");
            eventDomainMapper.updateById(eventDomain);
            createTeam(match);

        }
        bo.setEventId(eventDomain.getId());
        return bo;
    }


    @Override
    public void saveConfig(EventDTO dto){
        //转成业务对象
        MatchTemplateBO bo = dto.bo();
        //从业务对象转成domain对象
        Match match = Match.from(bo);
        //转成配置文件
        match.jsonConfig();
        MatchTempDomain vmatchTempDomain = match.getMatchTempDomain();
        //持久化
        List<MatchTempDomain> matchTempDomainList = new ArrayList<>();
        matchTempDomainList.add(vmatchTempDomain);
        matchTempMapper.batchInsert(matchTempDomainList);
    }
}
