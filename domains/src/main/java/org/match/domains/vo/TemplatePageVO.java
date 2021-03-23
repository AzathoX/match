package org.match.domains.vo;

import lombok.*;
import org.match.domains.bo.MatchTemplateBO;

import java.util.*;

@Data
@ToString
@Builder
@AllArgsConstructor
public class TemplatePageVO  implements ViewObject {


    private List<TemplateConfigVO> config;


    private Map programDict;

    private Map dict;

    private List<EventVO> events;


    private List<ProgramVO> programs;

    public TemplatePageVO(){
        this.events = new ArrayList<>();
        this.programs = new ArrayList<>();
        this.config = new ArrayList<>();
    }



    public void add(MatchTemplateBO matchTemplateBO){
        ProgramVO pvo = ProgramVO.builder()
                .id(matchTemplateBO.getProgramId())
                .context(matchTemplateBO.getContext())
                .name(matchTemplateBO.getProgramName()).build();
        //event 肯定要有
        EventVO evo = EventVO.builder().id(matchTemplateBO.getEventId())
                .name(matchTemplateBO.getName())
                .matchTypes(matchTemplateBO.getMatchTypes())
                .type(matchTemplateBO.getType())
                .simpleName(matchTemplateBO.getSimpleName())
                .eventCreateTime(matchTemplateBO.getEventCreateTime())
                .type(matchTemplateBO.getType())
                .pointSystemId(matchTemplateBO.getPointSystemId())
                .pointSystemId2(matchTemplateBO.getPointSystemId2())
                .pointSystemId3(matchTemplateBO.getPointSystemId3())
                .ruleType(matchTemplateBO.getRuleType())
                .subMatchCount(matchTemplateBO.getSubMatchCount())
                .species(matchTemplateBO.getSpecies())
                .groupCount(matchTemplateBO.getGroupCount())
                .pointBase(matchTemplateBO.getPointBase())
                .programId(matchTemplateBO.getProgramId())
                .subMatchName(matchTemplateBO.getSubMatchNames())
                .teamCount(matchTemplateBO.getTeamCount()).build();
        this.events.add(evo);
        this.programs.add(pvo);
        if(Objects.nonNull(matchTemplateBO.getTempConfig())){
            TemplateConfigVO tcv = new TemplateConfigVO();
            tcv.setConfig(matchTemplateBO.getTempConfig());
            tcv.setName(matchTemplateBO.getTempUniname());
            this.config.add(tcv);
        }
    }


}
