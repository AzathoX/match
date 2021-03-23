package org.match.dataassert.json;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TempJson implements Serializable {

    private Integer hash;

    private Object event;




}
