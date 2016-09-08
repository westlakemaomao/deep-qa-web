/**
* @author hzyuyongmao
* @version 创建时间：2016年9月8日 下午7:28:27
* 类说明
*/
package com.deepQAWeb.web.controller;

/**
* @author hzyuyongmao
* @version 创建时间：2016年9月8日 下午4:47:03
* uuid生成器
*/

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.deepQAWeb.domain.ArticleAbstractDomain;
import com.deepQAWeb.domain.KeywordsDomain;
import com.deepQAWeb.domain.ResponseDomain;
import com.deepQAWeb.domain.TextClassfiy;
import com.deepQAWeb.domain.NLPDomain;
import com.deepQAWeb.domain.UuidResponseDataDomain;
import com.deepQAWeb.util.UuidGeneratorUtil;

import tools.nlp.articleabstract.GetArticleAbstract;
import tools.nlp.keywords.GetArticleKeywords;
import tools.nlp.textclassify.TextClasify;

@Controller

public class NLPController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UuidGeneratorController.class);

	/**
	 * 
	 * @return result json
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/api/tools/getArticleNlpInfo", method = RequestMethod.GET)
	public void getArticleCategory(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "", value = "text") String text) {

		PrintWriter out = null;
		ResponseDomain responseDomain = new ResponseDomain();
		NLPDomain textDomain = new NLPDomain();
		List<TextClassfiy> textlist = new ArrayList<TextClassfiy>();
		List<KeywordsDomain> keywordsList = new ArrayList<KeywordsDomain>();
		List<ArticleAbstractDomain> summaryList = new ArrayList<ArticleAbstractDomain>();

		try {
			text = QaWebController.encodeStr(text);
			out = response.getWriter();
			response.setContentType("application/json;charset=utf-8");
			// 类别
			Map<String, Float> map = TextClasify.getClassfiy(text);
			responseDomain.setCode("200");
			responseDomain.setMsg("success");
			for (String key : map.keySet()) {
				TextClassfiy tc = new TextClassfiy();
				tc.setClassName(key);
				tc.setValue(map.get(key));
				textlist.add(tc);
			}
			// 关键词
			List<String> keywords = GetArticleKeywords.getKeywords(text);
			for (String keyword : keywords) {
				KeywordsDomain kw = new KeywordsDomain();
				kw.setKeyword(keyword);
				keywordsList.add(kw);
			}
			// 文章摘要
			List<String> summarys = GetArticleAbstract.getArticleAbstract(text);
			for (String summary : summarys) {
				ArticleAbstractDomain articleSummaryDomain = new ArticleAbstractDomain();
				articleSummaryDomain.setSummary(summary);
				summaryList.add(articleSummaryDomain);
			}
			textDomain.setTextClassify(textlist);
			textDomain.setKeyword(keywordsList);
			textDomain.setSummary(summaryList);
			responseDomain.setData(textDomain);
			out.print(JSON.toJSONString(responseDomain));
			out.flush();
		} catch (IOException e) {
			responseDomain.setCode("500");
			responseDomain.setMsg("Internal Server Error");
			out.print(JSON.toJSONString(responseDomain));
			out.flush();
			e.printStackTrace();

		}
	}

}
