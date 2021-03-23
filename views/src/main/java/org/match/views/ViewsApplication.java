package org.match.views;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication(
		scanBasePackages = {"org.match.services.*"
				            ,"org.match.views.*"})
public class ViewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViewsApplication.class, args);
	}

}
