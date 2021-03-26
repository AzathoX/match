package org.match.dataassert.datadomain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * t_point_system
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_point_system")
@ToString
public class PointSystem implements Serializable  {
    private Integer id;

    private String name;

    private Byte inningMinutes;

    private Byte inningCount;

    private String remark;

    private static final long serialVersionUID = 1L;
}