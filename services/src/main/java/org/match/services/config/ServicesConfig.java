package org.match.services.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"org.match.dataassert.*"})
@MapperScan(basePackages = {"org.match.dataassert.*"})
public class ServicesConfig {
}
