/**
* @author hzyuyongmao
* @version 创建时间：2016年9月8日 下午5:01:04
* 类说明
*/
package com.deepQAWeb.domain;

public  class ResponseDomain {
	private String msg;
	private String code;
	private ResponseDataDomain data;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ResponseDataDomain getData() {
		return data;
	}
	public void setData(ResponseDataDomain data) {
		this.data = data;
	}

}
