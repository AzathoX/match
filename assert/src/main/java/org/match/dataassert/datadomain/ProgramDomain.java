package org.match.dataassert.datadomain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * t_program
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_program")
@ToString
public class ProgramDomain implements Serializable {

    public final static String  ID = "id";
    @TableId(value = "id")
    private Integer id;

    /**
     * 名称
     */
    public final static String  NAME = "name";
    @TableField(value = "name")
    private String name;

    private String time;

    private String place;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 报名开始时间
     */
    private Date startTime;

    /**
     * 报名结束时间
     */
    private Date endTime;

    /**
     * 正文
     */
    private String context;

    /**
     * 是否显示
     */
    private Integer isAvailable;

    private static final long serialVersionUID = 1L;
}