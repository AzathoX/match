package org.match.domains.bo;

import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MatchTemplateBO implements BusinessObject {


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


    private String simpleName;


    private Byte subMatchCount;


    private Byte ruleType;


    private Integer teamCount;


    private Integer pointSystemId;


    private Integer pointSystemId2;


    private Integer pointSystemId3;

    /**
     * 模板名称
     */
    private String tempUniname;



    private Object tempConfig;


    @Setter
    private Integer courtCount;


    private Date startDate;


    @Getter
    private String subMatchNames;

    /**
     * 1羽毛球2乒乓球3篮球4足球
     */

    private Integer species;


    private Integer eventId;



    private Integer programId;



    private Date eventCreateTime;

    /**
     * 名称
     */
    private String programName;


    /**
     * 正文
     */
    private String context;

    /**
     * 是否显示
     */
    private Integer isAvailable;



    private Integer groupCount;


    private Integer pointBase;



}
