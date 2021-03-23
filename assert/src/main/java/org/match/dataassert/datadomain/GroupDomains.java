package org.match.dataassert.datadomain;

import java.io.Serializable;
import lombok.Data;

/**
 * t_group
 * @author 
 */
@Data
public class GroupDomains implements Serializable {
    private Integer id;

    private Integer eventId;

    private String name;

    private Integer stageId;

    private static final long serialVersionUID = 1L;
}