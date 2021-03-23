package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.match.dataassert.AssertApplication;
import org.match.dataassert.datadomain.MatchTempDomain;
import org.match.dataassert.mapper.MatchTempMapper;

import java.util.List;

@SpringBootTest(classes= AssertApplication.class)
@EnableAutoConfiguration
@ComponentScan(basePackages = {"org.vmatch.dataassert"})
class AssertApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MatchTempMapper matchTempMapper;


	@Test
	void pageData(){
		List<MatchTempDomain> vmatchTempDomains = matchTempMapper.selectCompeleteTemplete();
		for (MatchTempDomain vmatchTempDomain : vmatchTempDomains) {
			System.out.println(vmatchTempDomain);
		}
	}

}
