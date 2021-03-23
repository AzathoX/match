package org.match.services.ddd;

import cn.hutool.core.util.RandomUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.match.dataassert.datadomain.PhontomDomain;
import org.match.dataassert.datadomain.PhontomFileDomain;
import org.match.dataassert.datadomain.PhontomText;
import org.match.domains.bo.BusinessObject;
import org.match.domains.bo.CloudFileBO;
import org.match.domains.bo.PhontomBO;
import org.match.domains.vo.VChatCloudVO;
import org.match.domains.vo.ViewObject;
import org.match.services.utils.AbstractMD5Utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
public class VChatCloud implements DriverDomainDesignedable,Reviewable {

    /**
     * 审核通过
     */
    public final static byte PASS = 1;

    /**
     * 审核未通过
     */
    public final  static byte UNPASS = -1;

    /**
     * 待审核
     */
    public final  static byte UNCHECK = 0;


    @Getter
    private PhontomDomain phontomDomain;

    private StringBuffer text;


    @Getter
    private PhontomText phontomText;


    @Getter
    private List<PhontomFileDomain> phontomFileDomain;

    private CloudFileBO[] cloudFiles = new CloudFileBO[0];

    public String getUniname(){
        return this.phontomDomain.getPUniname();
    }


    public static VChatCloud vChatCloud(PhontomDomain phontomDomain){
        final VChatCloud vChatCloud = new VChatCloud();
        vChatCloud.phontomDomain = phontomDomain;
        vChatCloud.text = new StringBuffer(phontomDomain.getText());
        vChatCloud.init();
        return vChatCloud;
    }



    public static VChatCloud vChatCloud(BusinessObject bo){
        PhontomBO pbo = (PhontomBO) bo;
        PhontomDomain pd = PhontomDomain.builder()
                .id(pbo.getId())
                .petName(pbo.getPetName())
                .pCheck(pbo.getPCheck())
                .pEventId(pbo.getPEventId())
                .pTel(pbo.getPTel())
                .pStartTel(pbo.getPStartTel())
                .pUniname(pbo.getPUniname())
                .pTitle(pbo.getPTitle())
                .pAccountId(pbo.getPAccountId())
                .isDel(pbo.getIsDel())
                .createTime(pbo.getCreateTime())
                .build();
        final VChatCloud vChatCloud = new VChatCloud();
        vChatCloud.phontomDomain = pd;
        vChatCloud.text = pbo.getText();
        final String[] shortNames = pbo.getShortNames();
        vChatCloud.cloudFiles = new CloudFileBO[shortNames.length];
        for (int i = 0,len= shortNames.length; i < len ; i++) {
            final CloudFileBO cfbo = CloudFileBO.builder()
                    .fShortName(shortNames[i]).build();
            vChatCloud.cloudFiles[i] = cfbo;
        }
        return vChatCloud;
    }


    public void genericUniqueName(){
        this.phontomDomain.setPUniname(AbstractMD5Utils.md532ByteRandom(this.phontomDomain.getPTitle() + this.text));
    }

    public void init(){
        this.phontomText = PhontomText.builder().pUniname(this.phontomDomain.getPUniname())
                .pText(this.text.toString()).build();

        this.phontomFileDomain = new ArrayList<>();
        for (int i = 0,len = this.cloudFiles.length; i <len ; i++) {
             PhontomFileDomain build = PhontomFileDomain.builder()
                    .fShortName(cloudFiles[i].getFShortName())
                    .pUniname(this.phontomDomain.getPUniname())
                    .build();
             this.phontomFileDomain.add(build);
        }
    }






    @Override
    public ViewObject vo() {
        return new VChatCloudVO(this.bo());
    }

    @Override
    public PhontomBO bo() {
        String[] shortNames = new String[cloudFiles.length];
        for (int i = 0,len = shortNames.length; i <len  ; i++) {
            shortNames[i] = cloudFiles[i].getFShortName();
        }
        PhontomBO bo = PhontomBO.builder().pUniname(this.phontomDomain.getPUniname())
                .id(this.phontomDomain.getId())
                .pTel(this.phontomDomain.getPTel())
                .pTitle(this.phontomDomain.getPTitle())
                .pEventId(this.phontomDomain.getPEventId())
                .pAccountId(this.phontomDomain.getPAccountId())
                .isDel(this.phontomDomain.getIsDel())
                .pCheck(this.phontomDomain.getPCheck())
                .petName(this.phontomDomain.getPetName())
                .createTime(this.phontomDomain.getCreateTime())
                .pStartTel(this.phontomDomain.getPStartTel())
                .text(this.text)
                .shortNames(shortNames)
                .build();
        return bo;
    }

    @Override
    public void doReview(int state) {
        byte s = (byte) state;
        this.phontomDomain.setPCheck(s);
    }
}
