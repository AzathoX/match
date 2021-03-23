package org.match.views.value;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "match")
public class MatchConfig {
    /**
     * 默认父文件夹
     */
    private String path;
}
