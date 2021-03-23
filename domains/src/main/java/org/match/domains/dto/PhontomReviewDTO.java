package org.match.domains.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.match.domains.bo.PhontomBO;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class PhontomReviewDTO  extends AbstractDTO<PhontomBO>  {

    private String[] name;


    private Integer state;


}
