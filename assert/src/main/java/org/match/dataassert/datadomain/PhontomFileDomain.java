package org.match.dataassert.datadomain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * t_phontom_file
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_phontom_file")
@ToString
public class PhontomFileDomain implements Serializable {
    /**
     * id
     */
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    /**
     * 唯一名字,一对一
     */
    public static final String P_UNINAME = "p_uniname";
    @TableField("p_uniname")
    private String pUniname;

    /**
     * 文件脱敏数据
     */

    public final static String F_SHORT_NAME = "f_short_name";
    private String fShortName;


    public final static String SUBFIX = "subfix";
    private String subFix;

    private static final long serialVersionUID = 1L;
}