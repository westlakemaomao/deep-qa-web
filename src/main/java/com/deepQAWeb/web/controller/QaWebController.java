package com.deepQAWeb.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.deepQAWeb.domain.AnswerDomain;
import com.deepQAWeb.service.QAService;


/**
 * 
 * @author yym
 * 
 */
@Controller

public class QaWebController {
	private static final Logger LOGGER = LoggerFactory.getLogger(QaWebController.class);
	@Autowired
	QAService qAService;

	/**
	 * 
	 * @param q,n
	 * @return result json
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/api/ask", method = RequestMethod.GET)
	public void spaminfo(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "", value = "q") String question,
			@RequestParam(required = false, defaultValue = "", value = "n") String topN) throws IOException {
		PrintWriter out = response.getWriter(); // 获取写入对象
		response.setContentType("application/json;charset=utf-8");
		String json="";
		if(question==null||question.equals("")){
			AnswerDomain answer= new AnswerDomain();
			answer.setAnswer("想和我聊什么呢？");
			answer.setScore(1L);
			json="["+JSON.toJSONString(answer)+"]";
		}else{
			 json = qAService.getQuestionResult(question, topN);
		}
		
		out.print(json);
		out.flush();
//		return json;
	}

}
