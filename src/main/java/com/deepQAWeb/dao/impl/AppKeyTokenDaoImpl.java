package com.deepQAWeb.dao.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Repository;

import com.deepQAWeb.dao.BaseDao;
import com.deepQAWeb.domain.AppKeyTokenDomain;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.deepQAWeb.dao.AppkeyTokenDao;

@Repository
public class AppKeyTokenDaoImpl extends BaseDao implements AppkeyTokenDao {
	private static final Cache<String, AppKeyTokenDomain> docCache = CacheBuilder.newBuilder().maximumSize(50000)
			.expireAfterWrite(15, TimeUnit.MINUTES).build();

	public String getAppKeyInfo(String appkey) {
		// TODO Auto-generated method stub
		AppKeyTokenDomain keyDomain = docCache.getIfPresent(appkey);
		String key = keyDomain.getKey();
		if (key != null) {
			return key;
		} else {
			String keyToken = (String) getSqlMapClientTemplate().queryForObject("getTokenByAppkey", appkey);
			AppKeyTokenDomain appkeyDomain = new AppKeyTokenDomain();
			appkeyDomain.setKey(keyToken);
			docCache.put(appkey, appkeyDomain);
			return keyToken;
		}

	}

	public void insertAppkey(AppKeyTokenDomain key) {
		getSqlMapClientTemplate().insert("insertAppkey", key);
	}
}
