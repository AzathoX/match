package org.match.dataassert.datadomain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * t_stage
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName(value = "t_stage")
public class StageDomain implements Serializable {
    public final static String  ID = "id";
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    public final static String  UNINAME = "uniname";
    @TableField(value="uniname")
    private String uniname;

    private Integer eventId;

    private Integer prevStageId;

    private Integer no;

    private Integer competitionRuleId;

    private Byte courtCount;

    private Date startDate;

    private Integer amStartTime;

    private Integer pmStartTime;

    private Byte groupCount;

    private Integer teamCount;

    private Integer matchCount;

    private Integer reqCourtCount;

    private String reqCourtHours;

    private Integer specialMatchType;

    private static final long serialVersionUID = 1L;
}