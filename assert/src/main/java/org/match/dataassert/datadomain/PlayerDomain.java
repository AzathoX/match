package org.match.dataassert.datadomain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * t_player
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_team")
public class PlayerDomain implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer eventId;

    private Integer teamId;

    private Byte type;

    private String phone;

    private Byte sex;

    private String unit;

    private String remark;

    private Integer age;

    /**
     * 号码
     */
    private Integer number;

    private String idCard;

    private String photo;

    private static final long serialVersionUID = 1L;
}