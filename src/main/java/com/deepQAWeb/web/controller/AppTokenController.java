/**
* @author hzyuyongmao
* @version 创建时间：2016年11月7日 下午5:47:46
* 类说明
*/
package com.deepQAWeb.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deepQAWeb.domain.QaRequestDomain;
import com.deepQAWeb.domain.QaResponseDomain;
import com.deepQAWeb.domain.ResponseUtilDomain;
import com.deepQAWeb.service.AppkeyTokenService;

public class AppTokenController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AppTokenController.class);
	@Autowired
	AppkeyTokenService appkeyTokenService;

	/*
	 * 验证获取接口
	 */
	@RequestMapping(value = "/api/getKey", method = RequestMethod.GET)
	@ResponseBody
	public void getKey(HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "", value = "appkey") String appkey,
			HttpServletResponse response) throws IOException {
		ResponseUtilDomain responseDomain = new ResponseUtilDomain();

		if (appkey == null || appkey.equals("")) {
			responseDomain.setCode("403");
			responseDomain.setDesc("需输入appkey");
		} else {
			responseDomain.setCode("200");
			responseDomain.setDesc("success");
			appkeyTokenService.getAppKey(appkey);

		}
		response.setCharacterEncoding("UTF-8"); // 设置编码格式
		response.setContentType("application/json"); // 设置数据格式
		PrintWriter out = response.getWriter(); // 获取写入对象
		out.print(JSON.toJSONString(responseDomain)); // 将json数据写入流中
		out.flush();

	}

	/*
	 * 验证获取接口
	 */
	@RequestMapping(value = "/api/generateKey", method = RequestMethod.GET)
	@ResponseBody
	public void generateKey(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ResponseUtilDomain responseDomain = new ResponseUtilDomain();
		System.out.println("generateKey start");
		LOGGER.info("generateKey start");
		responseDomain.setCode("200");
		responseDomain.setDesc("success");

		response.setCharacterEncoding("UTF-8"); // 设置编码格式
		response.setContentType("application/json"); // 设置数据格式
		PrintWriter out = response.getWriter(); // 获取写入对象
		out.print(JSON.toJSONString(responseDomain)); // 将json数据写入流中
		out.flush();

	}

}
