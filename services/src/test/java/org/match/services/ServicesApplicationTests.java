package org.match.services;

import org.junit.jupiter.api.Test;
import org.match.services.interfaces.TeamAllocatedGroupServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.match.dataassert.mapper.PhontomFileMapper;
import org.match.domains.vo.ViewObject;
import org.match.services.interfaces.TemplateServices;

@SpringBootTest
class ServicesApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void newCloudFile(){

	}

	@Autowired
	private PhontomFileMapper phontomFileMapper;

	@Test
	void getFile(){

	}

	@Autowired
	private TemplateServices templateServices;



	@Autowired
	private TeamAllocatedGroupServices teamAllocatedGroupServices;

	@Test
	void getPage(){
		ViewObject viewObject = templateServices.dataOfCreatePage();
		System.out.println(viewObject);
	}


	@Test
	void getAllocate(){

	}


}

