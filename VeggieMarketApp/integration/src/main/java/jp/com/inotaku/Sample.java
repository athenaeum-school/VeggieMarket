package jp.com.inotaku;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Sample {

		public static void main(final String... args) {

			GenericXmlApplicationContext context = new GenericXmlApplicationContext();
			context.load("classpath:spring/integration-context.xml");
			context.refresh();
			
		}
	}