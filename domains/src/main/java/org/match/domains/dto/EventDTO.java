package org.match.domains.dto;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.match.domains.bo.MatchTemplateBO;

import java.util.Date;
import java.util.Objects;

@Data
@ToString
public class EventDTO extends AbstractDTO<MatchTemplateBO> {


    private Integer id;

    @Setter
    private String name;

    @Setter
    private String description;

    /**
     * 1:单项赛,2:团体赛
     */
    private Byte type;


    private String matchTypes;


    private Byte subMatchCount;


    private Integer teamCount;


    private Byte matchCount;


    private String simpleName;

    private Integer pointSystemId;


    private Integer pointSystemId2;


    private Integer pointSystemId3;

    private String subMatchName;

    private Integer programId;

    private Date createTime;

    private Byte ruleType;


    private Integer species;
    private Integer pointBase;
    private Integer groupCount;

    @Override
    public MatchTemplateBO bo() {
        MatchTemplateBO build = MatchTemplateBO.builder()
                .eventId(id)
                .name(name)
                .matchTypes(matchTypes)
                .teamCount(teamCount)
                .type(type)
                .subMatchCount(matchCount)
                .pointSystemId(pointSystemId)
                .pointSystemId2(pointSystemId2)
                .pointSystemId3(pointSystemId3)
                .programId(programId)
                .simpleName(simpleName)
                .eventCreateTime(createTime)
                .ruleType(ruleType)
                .subMatchNames(subMatchName)
                .groupCount(groupCount)
                .pointBase(pointBase)
                .species(species)
                .build();

        return build;
    }

}
