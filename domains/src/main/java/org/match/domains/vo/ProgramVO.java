package org.match.domains.vo;


import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramVO {

    private Integer id;

    private String name;

    private String context;
}
