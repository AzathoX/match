package org.match.dataassert.datadomain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * tb_file
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_file")
@ToString
public class FileDomain implements Serializable {

    /**
     * id
     */
    public static final String ID = "id";
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 文件名
     */
    public static final String F_FILE_NAME = "f_file_name";
    @TableField(value = "f_file_name")
    private String fFileName;

    /**
     * 脱敏数据
     */
    @TableField(value = "f_short_name")
    public static final String F_SHORT_NAME = "f_short_name";
    private String fShortName;

    /**
     * 网络连接
     */
    @TableField(value = "f_web_src")
    public static final String F_WEB_SRC = "f_web_src";
    private String fWebSrc;

    /**
     * 原文件名
     */
    @TableField(value = "f_original_name")
    public static final String F_ORIGINAL = "f_original_name";
    private String fOriginalName;

    /**
     * 在虚拟文件树所在的位置
     */
    @TableField(value = "f_filetree_id")
    public static final String F_FILETREE_ID = "f_filetree_id";
    private Integer fFiletreeId;

    /**
     * 在虚拟文件树所在的目录
     */
    @TableField(value = "f_filetree_virtual")
    public static final String F_FILETREE_VIRTUAL = "f_filetree_virtual";
    private String fFiletreeVirtual;

    /**
     * 绝对路径 到/
     */
    @TableField(value = "f_absolute_src")
    public static final String F_ABSOLUTE_SRC = "f_absolute_src";
    private String fAbsoluteSrc;

    /**
     * 相对路径 到 /
     */
    @TableField(value = "f_position_path")
    public static final String F_POSITION_PATH = "f_position_path";
    private String fPositionPath;

    /**
     * 后缀
     */
    @TableField(value = "f_subfix")
    public static final String F_SUBFIX = "f_subfix";
    private String fSubfix;

    /**
     * 大小
     */
    @TableField(value = "f_size")
    public static final String F_SIZE = "f_size";
    private Long fSize;

    /**
     * 是否为临时文件默认是true
     */
    @TableField(value = "is_temp")
    public static final String IS_TEMP = "is_temp";
    private Boolean isTemp;

    @TableField(value = "is_del")
    public static final String IS_DEL = "is_del";
    private Boolean isDel;
    
    public static final String[] SQL_SELECT = {
            ID,
            F_FILE_NAME,
            F_SHORT_NAME,
            F_ORIGINAL,
            F_WEB_SRC,
            F_ABSOLUTE_SRC,
            F_POSITION_PATH,
            F_SUBFIX,
            F_SIZE,
            F_FILETREE_ID,
            F_FILETREE_VIRTUAL,
            IS_TEMP,
            IS_DEL
    };



    private static final long serialVersionUID = 1L;

    private String remark1;
    private String remark2;
    private String remark3;
    private String remark4;
    private String remark5;
    private String remark6;
    private String remark7;
    private String remark8;
}