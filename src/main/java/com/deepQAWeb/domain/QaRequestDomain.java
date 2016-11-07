/**
* @author hzyuyongmao
* @version 创建时间：2016年11月7日 下午4:01:12
* 类说明
*/
package com.deepQAWeb.domain;

public class QaRequestDomain {
	private String reqId;
	private String appkey;
	private String appSecret;
	private String ts;
	private RequestData data;

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public RequestData getData() {
		return data;
	}

	public void setData(RequestData data) {
		this.data = data;
	}

	public class RequestData {
		private String question;
		private int topN;
		private String uid;

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

		public int getTopN() {
			return topN;
		}

		public void setTopN(int topN) {
			this.topN = topN;
		}

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

	}

	public class QueryCardListExt {

	}

}
