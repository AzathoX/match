package org.match.domains.dto;

import lombok.Data;
import lombok.ToString;
import org.match.domains.bo.PhontomBO;

@Data
@ToString
public class PhontomDTO extends AbstractDTO<PhontomBO> {
    /**
     * 昵称
     */
    private String name;

    /**
     * 描述
     */
    private String descript;

    /**
     * 作品名称
     */
    private String workName;

    /**
     * 电话
     */
    private String tel;

    /**
     * 短名关联
     */
    private String[] shortNames;


    @Override
    public PhontomBO bo() {
        final PhontomBO phontomBO = new PhontomBO();
        phontomBO.setPTitle(this.workName);
        phontomBO.setPetName(this.name);
        phontomBO.setShortNames(this.shortNames);
        phontomBO.setText(new StringBuffer(this.descript));
        phontomBO.setPTel(this.tel);
        return phontomBO;
    }

}
