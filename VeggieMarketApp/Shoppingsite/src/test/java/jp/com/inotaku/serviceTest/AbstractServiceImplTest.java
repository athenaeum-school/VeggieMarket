package jp.com.inotaku.serviceTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jp.com.inotaku.test.config.ServiceTestConfig;
import jp.com.inotaku.test.listener.ServiceTestExecutionListener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServiceTestConfig.class })
@TestExecutionListeners({ ServiceTestExecutionListener.class })
@ActiveProfiles("test")
public class AbstractServiceImplTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@PersistenceContext
	protected EntityManager em;
	
	@Test
	public void a(){
		
	}
}
