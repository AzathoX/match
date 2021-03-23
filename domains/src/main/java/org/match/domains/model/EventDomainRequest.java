package org.match.domains.model;

import lombok.*;

import java.util.Date;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDomainRequest {

    private Integer id;

    private String name;

    private String description;

    private Byte type;

    private String matchTypes;

    private Byte subMatchCount;

    private Byte ruleType;

    private Integer teamCount;

    private Integer pointSystemId;

    private Integer pointSystemId2;

    private Integer pointSystemId3;

    private Integer venueId;

    private Integer courtCount;

    private Date startDate;

    private String remark;

    private String simpleName;

    private String subMatchNames;

    private Integer challengeId;

    private Integer beChallengedId;

    /**
     * 1羽毛球2乒乓球3篮球4足球
     */
    private Integer species;

    /**
     * 一场比赛时间（篮球、足球）
     */
    private Integer matchTime;

    private Integer halfTime;

    private Integer sectionTime;

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
