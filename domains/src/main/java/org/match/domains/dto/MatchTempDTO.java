package org.match.domains.dto;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class MatchTempDTO extends AbstractDTO {
    private Integer eventId;
    private String matchName;
    private String matchType;
    private Integer pointSystemId;
    private Integer pointSystemId2;
    private Integer pointSystemId3;
    private String subMatchName;
    private Integer teamCount;
    private Byte matchCount;
    private Integer matchModel;
    private Byte type;
    private String simpleName;
    private Date createTime;
    private Byte ruleType;
    private Integer species;
    private Integer pointBase;
    private Integer groupCount;

    public EventDTO eventDTO(){
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(eventId);
        eventDTO.setName(matchName);
        eventDTO.setMatchTypes(matchType);
        eventDTO.setSubMatchName(subMatchName);
        eventDTO.setPointSystemId(pointSystemId);
        eventDTO.setPointSystemId2(pointSystemId2);
        eventDTO.setPointSystemId3(pointSystemId3);
        eventDTO.setTeamCount(teamCount);
        eventDTO.setMatchCount(matchCount);
        eventDTO.setType(type);
        eventDTO.setSpecies(species);
        eventDTO.setRuleType(ruleType);
        eventDTO.setSimpleName(simpleName);
        eventDTO.setCreateTime(createTime);
        return eventDTO;


    }
}
