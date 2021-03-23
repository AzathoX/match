package org.match.dataassert.datadomain;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * t_team
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_team")
public class TeamDomain implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;


    private Integer eventId;

    private String name;

    private String description;

    private String seedNo;

    private String unit;

    private Integer unitId;

    private String remark;


    private static final long serialVersionUID = 1L;

    public static final String REMARK = "remark";

    public static final String EVENT_ID = "event_id";
}