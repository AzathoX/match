package org.match.dataassert.datadomain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * t_phontom_text
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_phontom_text")
@ToString
public class PhontomText implements Serializable {
    /**
     * id
     */
    public static final String ID = "id";
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    /**
     * 唯一名字,一对一
     */
    public static final String P_UNINAME = "p_uniname";
    @TableField("p_uniname")
    private String pUniname;

    private String pText;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private static final long serialVersionUID = 1L;
}