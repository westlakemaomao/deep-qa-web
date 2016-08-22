package com.deepQAWeb.service;

import java.io.PrintWriter;
import java.util.List;

import org.apdplat.qa.SharedQuestionAnsweringSystem;
import org.apdplat.qa.model.CandidateAnswer;
import org.apdplat.qa.model.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deepQAWeb.util.JsonGenerator;

import edu.stanford.nlp.util.StringUtils;

@Service("qAService")
@Transactional
public class QAService {
	private static final Logger LOGGER = LoggerFactory.getLogger(QAService.class);
/*
 * 问题及答案
 */
	public  String getQuestionResult(String questionStr, String n,String uid) {
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
		LOGGER.info("问题："+questionStr);
		String json = JsonGenerator.generate(candidateAnswers, topN);
		LOGGER.info("答案："+json);
		return json;

	}
	public static void main(String args[]){
		QAService qa= new QAService();
		qa.getQuestionResult("中国的面积有多大？", "1","userid");
	}
}
