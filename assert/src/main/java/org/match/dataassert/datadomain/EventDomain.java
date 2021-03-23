package org.match.dataassert.datadomain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.*;
import org.nrocn.lib.baseobj.BaseDomain;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_event")
public class EventDomain implements Serializable {


    @TableField(value = "id")
    private Integer id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "description")
    private String description;

    /**
     * 1:单项赛,2:团体赛
     */
    @TableField(value = "type")
    private Byte type;

    @TableField(value = "match_types")
    private String matchTypes;

    @TableField(value = "sub_match_count")
    private Byte subMatchCount;

    @TableField(value = "rule_type")
    private Byte ruleType;

    @TableField(value = "team_count")
    private Integer teamCount;

    @TableField(value = "point_system_id")
    private Integer pointSystemId;

    @TableField(value = "point_system_id2")
    private Integer pointSystemId2;

    @TableField(value = "point_system_id3")
    private Integer pointSystemId3;

    @TableField(value = "venue_id")
    private Integer venueId;

    @TableField(value = "court_count")
    private Integer courtCount;

    @TableField(value = "start_date")
    private Date startDate;

    @TableField(value = "remark")
    private String remark;

    @TableField(value = "simple_name")
    private String simpleName;

    @TableField(value = "sub_match_names")
    private String subMatchNames;

    @TableField(value = "challenge_id")
    private Integer challengeId;

    @TableField(value = "be_challenged_id")
    private Integer beChallengedId;

    /**
     * 1羽毛球2乒乓球3篮球4足球
     */
    @TableField(value = "species")
    private Integer species;

    /**
     * 一场比赛时间（篮球、足球）
     */
    @TableField(value = "match_time")
    private Integer matchTime;

    @TableField(value = "half_time")
    private Integer halfTime;

    @TableField(value = "section_time")
    private Integer sectionTime;

    @TableField(value = "program_id")
    private Integer programId;

    /**
     * 团队循环赛多少组
     */
    @TableField(value = "group_count")
    private Integer groupCount;

    /**
     * 每隔几分换人
     */
    @TableField(value = "point_base")
    private Integer pointBase;


    @TableField(value="create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_TYPE = "type";

    public static final String COL_MATCH_TYPES = "match_types";

    public static final String COL_SUB_MATCH_COUNT = "sub_match_count";

    public static final String COL_RULE_TYPE = "rule_type";

    public static final String COL_TEAM_COUNT = "team_count";

    public static final String COL_POINT_SYSTEM_ID = "point_system_id";

    public static final String COL_POINT_SYSTEM_ID2 = "point_system_id2";

    public static final String COL_POINT_SYSTEM_ID3 = "point_system_id3";

    public static final String COL_VENUE_ID = "venue_id";

    public static final String COL_COURT_COUNT = "court_count";

    public static final String COL_START_DATE = "start_date";

    public static final String COL_REMARK = "remark";

    public static final String COL_SIMPLE_NAME = "simple_name";

    public static final String COL_SUB_MATCH_NAMES = "sub_match_names";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_CHALLENGE_ID = "challenge_id";

    public static final String COL_BE_CHALLENGED_ID = "be_challenged_id";

    public static final String COL_SPECIES = "species";

    public static final String COL_MATCH_TIME = "match_time";

    public static final String COL_HALF_TIME = "half_time";

    public static final String COL_SECTION_TIME = "section_time";

    public static final String COL_PROGRAM_ID = "program_id";

    public static final String COL_GROUP_COUNT = "group_count";

    public static final String COL_POINT_BASE = "point_base";
}