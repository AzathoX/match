package org.match.dataassert.datadomain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * tb_count_addr
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_count_addr")
public class CountAddrDomain implements Serializable {
    private Integer id;

    /**
     * 地址名称
     */
    private String addrName;

    /**
     * 可用场地
     */
    private Byte addrCount;

    /**
     * 详细地址
     */
    private String addr;

    private Integer isDel;

    private String remark1;

    private String remark2;

    private String remark3;

    private static final long serialVersionUID = 1L;
}