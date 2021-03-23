package org.match.domains.bo;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhontomBO implements BusinessObject {

    /**
     * id
     */
    @Getter
    private Integer id;

    /**
     * 唯一名字
     */
    @Getter
    private String pUniname;

    /**
     * 作品名称
     */
    @Getter
    @Setter
    private String pTitle;

    /**
     * 手机号
     */
    @Getter
    @Setter
    private String pTel;

    /**
     * 脱敏数据手机号
     */
    @Getter
    @Setter
    private String pStartTel;

    /**
     * 秩序册id
     */
    @Getter
    private Integer pEventId;

    /**
     * 账号id
     */
    @Getter
    private String pAccountId;

    /**
     * 昵称为空时匿名 项目初期
     */
    @Getter
    @Setter
    private String petName;

    /**
     * 是否过审 1 过审, 0 未审核 ,-1 不过审
     */
    @Getter
    @Setter
    private Byte pCheck;

    @Getter
    @Setter
    private Boolean isDel;


    /**
     * 描述
     */
    @Getter
    @Setter
    private StringBuffer text;

    /**
     * 上传时间
     */
    @Getter
    private Date createTime;

    /**
     * 关联文件脱敏数据
     */
    @Getter
    @Setter
    private String[] shortNames;

    private static final long serialVersionUID = 1L;


    public void dataDesensitization(){
        if(Objects.isNull(this.pTel)){
            return;
        }
        //获取手机号后四位
        final String subffix = pTel.substring(11 - 4,11);
        this.pStartTel = "***"+subffix;
    }

}
