package org.tstraszewski.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;


public class JoinTest {

	@Test public void join(){
		String[] a = {"aaa","bbb","ccc"};
		System.out.println(StringUtils.join(a,", "));
		
		List<String> aa = new ArrayList<String>();
		aa.add("sdfsdfsdF");
		aa.add("sdfsdsdfsdfsdffsdF");
		System.out.println(StringUtils.join(aa,", "));
	}
}
