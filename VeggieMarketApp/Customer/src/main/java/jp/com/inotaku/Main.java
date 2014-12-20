package jp.com.inotaku;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/integration-context.xml");
		PollableChannel toRabbit = (PollableChannel)context.getBean("toRabbit");
		Message<?> message = (Message<?>)toRabbit.receive(20000);
		System.out.println(message);
		((ConfigurableApplicationContext)context).close();
	}
}
