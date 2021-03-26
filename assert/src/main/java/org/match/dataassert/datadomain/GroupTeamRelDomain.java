package org.match.dataassert.datadomain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * t_group_team_rel
 * @author 
 */
@Data
public class GroupTeamRelDomain implements Serializable {
    public static final String ID = "id";
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String uniname;

    private Integer groupId;

    private Integer teamId;

    private Integer groupIdForStage2;

    private static final long serialVersionUID = 1L;
}