package org.match.dataassert.datadomain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * t_group
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_group")
@ToString
public class GroupDomains implements Serializable {

    public static final String ID = "id";
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;


    public static final String UNINAME = "uniname";
    @TableField(value = "uniname")
    private String uniname;


    public static final String EVENT_ID = "event_id";
    @TableField(value = "event_id")
    private Integer eventId;

    private String name;

    private Integer stageId;

    private static final long serialVersionUID = 1L;
}