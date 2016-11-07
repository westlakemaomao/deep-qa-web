/**
* @author hzyuyongmao
* @version 创建时间：2016年11月7日 下午4:09:58
* 类说明
*/
package com.deepQAWeb.domain;

import java.util.List;

import org.apdplat.qa.model.CandidateAnswer;

public class QaResponseDomain {
	private String code;
	private String desc;
	private String reqId;
	private QaResponseData data;

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

	public QaResponseData getData() {
		return data;
	}

	public void setData(QaResponseData data) {
		this.data = data;
	}

	public class QaResponseData {
		private List<CandidateAnswer> candidateAnswer;

		public List<CandidateAnswer> getCandidateAnswer() {
			return candidateAnswer;
		}

		public void setCandidateAnswer(List<CandidateAnswer> candidateAnswer) {
			this.candidateAnswer = candidateAnswer;
		}

	}
}
