package org.match.domains.bo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
public class CloudFileBO implements BusinessObject {

    /**
     * id
     */
    @Getter
    private Integer id;

    /**
     * 文件名
     */
    @Getter
    protected String fFileName;

    /**
     * 脱敏数据
     */
    @Getter
    protected String fShortName;

    /**
     * 网络连接
     */
    @Getter
    protected String fWebSrc;

    /**
     * 原文件名
     */
    @Getter
    protected String fOriginalName;

    /**
     * 在虚拟文件树所在的位置
     */
    @Getter
    @Setter
    private Integer fFiletreeId;

    /**
     * 在虚拟文件树所在的目录
     */
    @Getter
    @Setter
    private String fFiletreeVirtual;

    /**
     * 绝对路径 到/
     */
    @Getter
    private String fAbsoluteSrc;

    /**
     * 相对路径 到 /
     */
    @Getter
    @Setter
    private String fPositionPath;

    /**
     * 后缀
     */
    @Getter
    private String fSubfix;

    /**
     * 大小
     */
    @Getter
    private Long fSize;

    /**
     * 是否为临时文件默认是true
     */
    private Boolean isTemp;

    /**
     * 是否已经被删除
     */
    private Boolean isDel;



}
