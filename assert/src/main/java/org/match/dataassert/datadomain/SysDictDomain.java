package org.match.dataassert.datadomain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;
import org.nrocn.lib.baseobj.BaseDomain;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_sys_dict")
public class SysDictDomain extends BaseDomain implements Serializable {


    @TableField(value = "id")
    private Integer id;

    @TableField(value = "cat")
    private String cat;

    @TableField(value = "code")
    private Byte code;

    @TableField(value = "name")
    private String name;

    @TableField(value = "seq")
    private Integer seq;

    @TableField(value = "description")
    private String description;

    @TableField(value = "man_count")
    private Integer manCount;

    /**
     * 年龄限制
     */
    @TableField(value = "age_limit")
    private Integer ageLimit;

    /**
     * 年龄和限制
     */
    @TableField(value = "double_age_limit")
    private Integer doubleAgeLimit;

    @TableField(value = "type")
    private Byte type;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_CAT = "cat";

    public static final String COL_CODE = "code";

    public static final String COL_NAME = "name";

    public static final String COL_SEQ = "seq";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_MAN_COUNT = "man_count";

    public static final String COL_AGE_LIMIT = "age_limit";

    public static final String COL_DOUBLE_AGE_LIMIT = "double_age_limit";

    public static final String COL_TYPE = "type";


    public static final String MATCH_TYPE = "t_event.match_type";
    public static final String VALUE_TYPE = "t_event.type";
    public static final String RULE_TYPE = "rule_type";
    public static final String MATCH_LEVEL = "match_level";

}