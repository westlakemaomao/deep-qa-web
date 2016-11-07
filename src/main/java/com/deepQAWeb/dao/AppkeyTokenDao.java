package com.deepQAWeb.dao;

import com.deepQAWeb.domain.AppKeyTokenDomain;

public interface AppkeyTokenDao {

	public String getAppKeyInfo(String appkey);
    public void insertAppkey(AppKeyTokenDomain key);
    
	
}
