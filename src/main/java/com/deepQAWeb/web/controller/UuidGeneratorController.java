/**
* @author hzyuyongmao
* @version 创建时间：2016年9月8日 下午4:47:03
* uuid生成器
*/
package com.deepQAWeb.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.deepQAWeb.domain.ResponseDomain;
import com.deepQAWeb.domain.UuidResponseDataDomain;
import com.deepQAWeb.util.UuidGeneratorUtil;

@Controller

public class UuidGeneratorController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UuidGeneratorController.class);

	/**
	 * 
	 * @return result json
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/api/tools/getUuid", method = RequestMethod.GET)
	public void getUuidApi(HttpServletRequest request, HttpServletResponse response) {

		PrintWriter out=null;
		ResponseDomain responseDomain = new ResponseDomain();
		try {
			out = response.getWriter();
			response.setContentType("application/json;charset=utf-8");
			String uuid = UuidGeneratorUtil.getUUID();
			responseDomain.setCode("200");
			responseDomain.setMsg("success");
			UuidResponseDataDomain uuidDataDomain = new UuidResponseDataDomain();
			uuidDataDomain.setUuid(uuid);
			responseDomain.setData(uuidDataDomain);
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
