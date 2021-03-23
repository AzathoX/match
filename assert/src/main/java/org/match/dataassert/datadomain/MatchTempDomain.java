package org.match.dataassert.datadomain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.*;
import org.apache.ibatis.type.JdbcType;
import org.match.dataassert.support.JsonHandler;

/**
 * tb_vmatch_temp
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_match_temp",autoResultMap = true)
public class MatchTempDomain implements Serializable {
    @TableField(value = "id")
    private Integer id;
    /**
     * 模板名称
     */
    @TableField(value = "temp_uniname")
    private String tempUniname;

    @Getter
    private EventDomain eventDomain;


    @Getter
    private  ProgramDomain programDomain;


    @TableField(value = "event_id")
    private Integer eventId;

    /**
     * 模板基本配置
     */
    @TableField(typeHandler = JsonHandler.class)
    private Object tempConfig;


    @TableField(value = "temp_count")
    private Integer tempCount;


    @TableField(value = "outline_rule")
    private Integer outlineRule;

    @TableField(value = "start_time")
    private Date startTime;

    @TableField(value = "is_del")
    private Integer isDel;

    private String remark1;

    private String remark2;

    private String remark3;

    private static final long serialVersionUID = 1L;


}