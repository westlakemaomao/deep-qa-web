/**
* @author hzyuyongmao
* @version 创建时间：2016年11月6日 下午5:24:51
* 类说明
*/
package com.deepQAWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deepQAWeb.dao.AppkeyTokenDao;
import com.deepQAWeb.domain.AppKeyTokenDomain;
import com.deepQAWeb.util.Hmac;

@Service("appTokenService")
@Transactional
public class AppkeyTokenService {
	private static final String KEY = "laodant2t";
	@Autowired
	AppkeyTokenDao appkeyTokenDao;

	public AppKeyTokenDomain getAppKey(String appKey) {
		AppKeyTokenDomain keyDomain = new AppKeyTokenDomain();
		String key = appkeyTokenDao.getAppKeyInfo(appKey);
		keyDomain.setKey(key);
		return keyDomain;
	}

	private String generateAppKey() {

		return Hmac.encodeHmacSHA256(KEY.getBytes(), String.valueOf(System.currentTimeMillis())).substring(0, 16);
	}

	private String generateKey() {

		return Hmac.encodeHmacSHA256(KEY.getBytes(), String.valueOf(System.currentTimeMillis() + "test")).substring(0,
				32);
	}

	public AppKeyTokenDomain generateKeyService() {
		AppKeyTokenDomain appKey = new AppKeyTokenDomain();
		AppkeyTokenService appService = new AppkeyTokenService();
		String appToken = appService.generateAppKey();
		String key = appService.generateKey();
		appKey.setAppkey(appToken);
		appKey.setKey(key);
		appkeyTokenDao.insertAppkey(appKey);
		return appKey;

	}

	public static void main(String[] args) {
		AppkeyTokenService app = new AppkeyTokenService();
		System.out.println(app.generateAppKey());
		System.out.println(app.generateKey());
	}
}
