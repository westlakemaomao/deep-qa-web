/**
* @author hzyuyongmao
* @version 创建时间：2016年11月7日 下午7:30:38
* 类说明
*/
package com.deepQAWeb.domain;

public class AppKeyResponseData implements ResponseDataInterface {
	private String appkey;
	private String key;

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
