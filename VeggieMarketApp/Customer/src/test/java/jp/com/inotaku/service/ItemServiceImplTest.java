package jp.com.inotaku.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import jp.com.inotaku.annotation.DataSets;
import jp.com.inotaku.domain.Item;
import jp.com.inotaku.listener.DatabaseTestExcutionListener;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/test/resources/spring/testConfig.xml",
		"file:src/main/resources/spring/application-config.xml" })
@TestExecutionListeners({ DatabaseTestExcutionListener.class })
@ActiveProfiles("dev")
public class ItemServiceImplTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ItemService itemService;
	
	@After
	public void tearDown(){
	}

	@DataSets(setUpDataSet = "src/test/resources/ItemServiceImplTest.xls")
	@Test
	public void findByItemNameLikeTest() throws Exception {
		List<Item> result = itemService.getItemListByName("いも");
		assertThat(result.size(), is(3));
	}
	
}
