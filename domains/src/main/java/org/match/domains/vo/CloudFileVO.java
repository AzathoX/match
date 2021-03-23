package org.match.domains.vo;

import lombok.*;
import org.match.domains.bo.CloudFileBO;

import java.util.ArrayList;
import java.util.List;


@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CloudFileVO  implements ViewObject {



    public static List<String> toShortNameList(List<CloudFileVO> vos){
        List<String> shortNames = new ArrayList<>();
        for (CloudFileVO vo : vos) {
            shortNames.add(vo.getFShortName());
        }
        return shortNames;
    }

    /**
     * 脱敏数据
     */
    protected String fShortName;

    /**
     * 网络连接
     */

    protected String fWebSrc;

    /**
     * 原文件名
     */
    protected String fOriginalName;

    /**
     * 后缀
     */
    private String fSubfix;

    public CloudFileVO(CloudFileBO cloudFileBO){
         this.fShortName = cloudFileBO.getFShortName();
         this.fWebSrc = cloudFileBO.getFWebSrc();
         this.fOriginalName = cloudFileBO.getFOriginalName();
         this.fSubfix = cloudFileBO.getFSubfix();
    }




}
