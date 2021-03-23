package org.match.views;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.match.dataassert.datadomain.MatchTempDomain;
import org.match.dataassert.mapper.MatchTempMapper;
import org.match.views.controller.TemplateSvcController;
import org.match.views.value.MatchConfig;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ViewsApplicationTests {

	private static int add = 0;


	private void sum(){
		for (int i = 0; i < 100; i++) {
			add++;
		}

		final Map emptyMap = Collections.EMPTY_MAP;
	}

	@Autowired
	private MatchTempMapper matchTempMapper;

	@Test
	void tempMapperTest(){
		List<MatchTempDomain> vmatchTempDomains = matchTempMapper.selectCompeleteTemplete();
		for (MatchTempDomain vmatchTempDomain : vmatchTempDomains) {
			System.out.println(vmatchTempDomain.toString());
		}
	}

	@Test
	void contextLoads() {
//		ReentrantLock lock = new ReentrantLock();
//		lock.lock();
		final Thread t1 = new Thread(() -> {
			sum();
		});
		final Thread t2 = new Thread(() -> {
			sum();
		});
		final Thread t3 = new Thread(() -> {
			sum();
		});
		final Thread t4 = new Thread(() -> {
			sum();
		});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(add);

	}

	@Autowired
	MatchConfig matchConfig;

	@Test
	void matchConfigTest(){
		System.out.println(matchConfig.getPath());

	}


	@Autowired
	private TemplateSvcController templateSvcController;


	@Test
	void pageTest(){
		System.out.println(templateSvcController.doRespGetCreatePageData());
	}

}
