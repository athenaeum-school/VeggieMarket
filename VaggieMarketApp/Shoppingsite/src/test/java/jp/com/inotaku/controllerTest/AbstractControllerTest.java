package jp.com.inotaku.controllerTest;

import jp.com.inotaku.test.config.ControllerTestConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ControllerTestConfig.class)
@ActiveProfiles("test")
public class AbstractControllerTest {

	@Test
	public void aa(){
		
	}
}
