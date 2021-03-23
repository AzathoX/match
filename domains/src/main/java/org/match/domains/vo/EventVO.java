package org.match.domains.vo;

import lombok.*;

import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventVO {

    private Integer id;

    private String name;

    private String description;


    private Byte type;


    private String matchTypes;


    private String simpleName;


    private Byte subMatchCount;


    private Byte ruleType;


    private Integer teamCount;


    private Integer pointSystemId;


    private Integer pointSystemId2;


    private Integer pointSystemId3;

    private String subMatchName;


    private Date eventCreateTime;

    private Integer species;


    private Integer programId;

    /**
     * 团队循环赛多少组
     */
    private Integer groupCount;

    /**
     * 每隔几分换人
     */
    private Integer pointBase;


}
