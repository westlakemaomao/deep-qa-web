package com.deepQAWeb.web.controller;

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

import com.deepQAWeb.service.QAService;

import edu.stanford.nlp.io.EncodingPrintWriter.out;

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
	 */
	@ResponseBody
	@RequestMapping(value = "/api/ask", method = RequestMethod.GET)
	public void spaminfo(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "", value = "q") String question,
			@RequestParam(required = false, defaultValue = "", value = "n") String topN) {
		LOGGER.info(question);
		response.setContentType("application/json;charset=utf-8");
		String json = qAService.getQuestionResult(question, topN);
		out.print(json);

	}

}
