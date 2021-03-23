package org.match.dataassert.datadomain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * t_phontom
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_phontom")
@ToString
public class PhontomDomain implements Serializable {


    /**
     * id
     */
    public static final String ID = "id";
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    /**
     * 唯一名字
     */
    public static final String P_UNINAME = "p_uniname";
    @TableField("p_uniname")
    private String pUniname;

    /**
     * 作品名称
     */
    private String pTitle;

    /**
     * 手机号
     */
    private String pTel;

    /**
     * 脱敏数据手机号
     */
    private String pStartTel;

    /**
     * 秩序册id
     */
    private Integer pEventId;

    /**
     * 账号id
     */
    private String pAccountId;

    /**
     * 昵称为空时匿名 项目初期
     */
    private String petName;

    /**
     * 是否过审 1 过审, 0 未审核 ,-1 不过审
     */
    public  static final String P_CHCEK = "p_check";
    @TableField("p_check")
    private Byte pCheck;

    public  static final String IS_DEL = "is_del";
    @TableField("is_del")
    private Boolean isDel;

    /**
     * 上传时间
     */
    private Date createTime;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String text;

    private static final long serialVersionUID = 1L;
}