package org.match.dataassert.datadomain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * t_stage_team_rel
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName(value = "t_stage_team_rel")
public class StageTeamRelDomain implements Serializable {

    public final static String  ID = "id";
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String uniname;

    private Integer stageId;

    private Integer teamId;

    private static final long serialVersionUID = 1L;
}