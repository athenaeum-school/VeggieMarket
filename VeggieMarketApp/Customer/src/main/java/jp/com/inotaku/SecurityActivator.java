package jp.com.inotaku;

import java.io.UnsupportedEncodingException;

public class ServiceActivator {

	public String outPrint(byte[] value) throws UnsupportedEncodingException{
		String result = new String(value, "UTF-8");
		System.out.println(result);
		return result;
	}
}
