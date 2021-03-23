package org.match.domains.vo;

import lombok.*;
import org.match.domains.bo.PhontomBO;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VChatCloudVO implements ViewObject {

    private String uniname;

    private String title;

    private String startTel;

    private String tel;

    private String petName;

    private List<CloudFileVO> previmgs;

    private StringBuffer text;

    public VChatCloudVO(PhontomBO phontomBO){
        this.uniname = phontomBO.getPUniname();
        this.title = phontomBO.getPTitle();
        this.startTel = phontomBO.getPStartTel();
        this.tel = phontomBO.getPTel();
        this.petName = phontomBO.getPetName();
        this.text = phontomBO.getText();
    }
}
