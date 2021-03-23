package org.match.domains.vo;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TemplateConfigVO  implements ViewObject{
    private String name;
    private Object config;
}
