/**
* @author hzyuyongmao
* @version 创建时间：2016年11月7日 下午7:28:03
* 类说明
*/
package com.deepQAWeb.domain;

public class ResponseUtilDomain {
	private String code;
	private String desc;
	private String reqId;
	private ResponseDataInterface data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public ResponseDataInterface getData() {
		return data;
	}

	public void setData(ResponseDataInterface data) {
		this.data = data;
	}

}
