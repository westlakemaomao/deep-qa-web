package com.deepQAWeb.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deepQAWeb.domain.AnswerDomain;
import com.deepQAWeb.domain.QaRequestDomain;
import com.deepQAWeb.domain.QaResponseDomain;
import com.deepQAWeb.service.AppkeyTokenService;
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
	@Autowired
	AppkeyTokenService appkeyTokenService;

	/**
	 * 
	 * @param q,n
	 * @return result json
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/api/ask", method = RequestMethod.GET)
	public void qaAPI(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "", value = "q") String question,
			@RequestParam(required = false, defaultValue = "", value = "n") String topN,
			@RequestParam(required = false, defaultValue = "", value = "uid") String uid) throws IOException {
		PrintWriter out = response.getWriter(); // 获取写入对象
		response.setContentType("application/json;charset=utf-8");
		// request.setCharacterEncoding("utf-8");
		LOGGER.info("ask question:" + encodeStr(question));

		String json = "";
		if (question == null || question.equals("")) {
			AnswerDomain answer = new AnswerDomain();
			answer.setAnswer("想和我聊什么呢？");
			answer.setScore(1L);
			json = "[" + JSON.toJSONString(answer) + "]";
		} else {
			json = qAService.getQuestionResult(encodeStr(question), topN, uid);
		}

		out.print(json);
		out.flush();
		// return json;
	}

	/*
	 * 验证获取接口
	 */
	@RequestMapping(value = "/api/qa-ask", method = RequestMethod.POST)
	@ResponseBody
	public void getQaAPIBytoken(HttpServletRequest request, @RequestBody JSONObject jsonObj,
			HttpServletResponse response) throws IOException {
		String jsonString = jsonObj.toString();
		LOGGER.info("qa-ask:" + jsonString);

		QaRequestDomain qaDomain = JSONObject.parseObject(jsonString, QaRequestDomain.class);

		QaResponseDomain queryCardResponse = qAService.getQAAnswer(qaDomain);
		
		response.setCharacterEncoding("UTF-8"); // 设置编码格式
		response.setContentType("application/json"); // 设置数据格式
		PrintWriter out = response.getWriter(); // 获取写入对象
		out.print(JSON.toJSONString(queryCardResponse)); // 将json数据写入流中
		out.flush();

	}

	/*
	 * spring @requestparam 传入中文乱码 中文乱码？？？
	 * 解决方法:http://luanxiyuan.iteye.com/blog/1849169
	 */
	public static String encodeStr(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
