package jp.com.inotaku;

import java.io.UnsupportedEncodingException;

public class ServiceActivator {

	public void sample(byte[] value) throws UnsupportedEncodingException{
		String result = new String(value, "UTF-8");
		System.out.println(result);
	}
}
