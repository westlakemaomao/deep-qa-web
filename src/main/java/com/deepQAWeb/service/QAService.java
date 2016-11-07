package com.deepQAWeb.service;

import java.util.ArrayList;
import java.util.List;

import org.apdplat.qa.SharedQuestionAnsweringSystem;
import org.apdplat.qa.model.CandidateAnswer;
import org.apdplat.qa.model.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deepQAWeb.dao.AppkeyTokenDao;
import com.deepQAWeb.domain.QaRequestDomain;
import com.deepQAWeb.domain.QaRequestDomain.RequestData;
import com.deepQAWeb.domain.QaResponseDomain;
import com.deepQAWeb.domain.QaResponseDomain.QaResponseData;
import com.deepQAWeb.util.Hmac;
import com.deepQAWeb.util.JsonGenerator;

import edu.stanford.nlp.util.StringUtils;

@Service("qAService")
@Transactional
public class QAService {
	private static final Logger LOGGER = LoggerFactory.getLogger(QAService.class);
	@Autowired
	AppkeyTokenDao appkeyTokenDao;
	/*
	 * 问题及答案
	 */
	public String getQuestionResult(String questionStr, String n, String uid) {
		int topN = -1;
		if (n != null && StringUtils.isNumeric(n)) {
			topN = Integer.parseInt(n);
		}
		Question question = null;
		List<CandidateAnswer> candidateAnswers = null;
		if (questionStr != null && questionStr.trim().length() > 3) {
			question = SharedQuestionAnsweringSystem.getInstanceByDataSourceType(uid).answerQuestion(questionStr);
			if (question != null) {
				candidateAnswers = question.getAllCandidateAnswer();
			}
		}
		LOGGER.info("问题：" + questionStr);
		String json = JsonGenerator.generate(candidateAnswers, topN);
		LOGGER.info("答案：" + json);
		return json;

	}


	/*
	 * 问题及答案
	 */
	public QaResponseDomain getQAAnswer(QaRequestDomain qaRequestDomain) {
		QaResponseDomain qaResponse = new QaResponseDomain();
		if (qaRequestDomain.getAppkey() == null || appkeyTokenDao.getAppKeyInfo(qaRequestDomain.getAppkey()) == null
				|| !qaRequestDomain.getAppSecret().equals(Hmac.encodeHmacSHA256(
						appkeyTokenDao.getAppKeyInfo(qaRequestDomain.getAppkey()).getBytes(), qaRequestDomain.getTs()))) {
			qaResponse.setCode("403");
			qaResponse.setDesc("信息校验失败");
			qaResponse.setReqId(qaRequestDomain.getReqId());
			LOGGER.info("403:信息校验失败,reqId:" + qaRequestDomain.getReqId());
			return qaResponse;
		}
		try {
			RequestData requestData = qaRequestDomain.getData();
			int topN = requestData.getTopN();
			String questionStr = requestData.getQuestion();
			String uid = requestData.getUid();
			Question question = null;
			List<CandidateAnswer> candidateAnswers = null;
			if (questionStr != null && questionStr.trim().length() > 3) {
				question = SharedQuestionAnsweringSystem.getInstanceByDataSourceType(uid).answerQuestion(questionStr);
				if (question != null) {
					candidateAnswers = question.getAllCandidateAnswer();
				}
			}
			String json = JsonGenerator.generate(candidateAnswers, topN);
			List<CandidateAnswer> answer = new ArrayList<CandidateAnswer>();
			if (candidateAnswers != null && candidateAnswers.size() <= topN) {
				answer = candidateAnswers;
			} else {// 取前几个
				answer = candidateAnswers.subList(0, topN);

			}
			qaResponse.setCode("200");
			qaResponse.setDesc("success");
			qaResponse.setReqId(qaRequestDomain.getReqId());
			QaResponseData data=qaResponse.new QaResponseData();
			data.setCandidateAnswer(answer);
			qaResponse.setData(data);
			return qaResponse;
			
		} catch (Exception e) {
			qaResponse.setCode("500");
			qaResponse.setDesc("获取信息失败");
			qaResponse.setReqId(qaRequestDomain.getReqId());
			return qaResponse;
		}


	}

	public static void main(String args[]) {
		QAService qa = new QAService();
		qa.getQuestionResult("老聃科技的创始人是谁？", "1", "userid");
	}
}
