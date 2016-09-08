/**
* @author hzyuyongmao
* @version 创建时间：2016年8月27日 下午3:40:45
* 类说明
*/
package com.deepQAWeb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

public class ElasticSearchPost {
	private static HttpClient httpclient = HttpClients.createDefault();
	private static String url = "http://ldt.myqnapcloud.com:32770/";

	public static void main(String args) {
		String msg = "";
		post(url, msg);
	}

	public static String post(String url, String msg) {
		BufferedReader br = null;
		StringBuilder buf = new StringBuilder();
		HttpPost post = new HttpPost(url);
		try {
			HttpEntity entity = new StringEntity(msg, Charset.forName("UTF-8"));
			post.setEntity(entity);
			post.addHeader("Content-Type", "application/json;charset=UTF-8");
			HttpResponse response = httpclient.execute(post);

			// 打印服务器返回的状态
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() != HttpStatus.SC_OK) {
				System.err.println("请求url:" + url + "异常,异常返回码:" + statusLine.getStatusCode());
				throw new Exception("10001，请求异常");
			}
			br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
			buf = new StringBuilder();
			String line;
			while (null != (line = br.readLine())) {
				buf.append(line);
			}
			System.err.println("请求url:" + url + ",返回值:" + buf.toString());

		} catch (Exception e) {

		} finally {
			post.abort();
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
			return buf.toString();
		}
	}
}
