/**
* @author hzyuyongmao
* @version 创建时间：2016年9月8日 下午4:48:56
* 类说明
*/
package com.deepQAWeb.util;

import java.util.UUID;

public class UuidGeneratorUtil {

	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		// 去掉“-”符号
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
	}

	public static void main(String args[]) {
		String result = getUUID();
		System.out.println(result);
	}
}
