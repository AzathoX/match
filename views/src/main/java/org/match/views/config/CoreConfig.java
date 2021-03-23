package org.match.views.config;

import org.match.views.value.MatchConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableConfigurationProperties(MatchConfig.class)
@EnableAsync
public class CoreConfig {
}
