package com.deepQAWeb.dao.impl;

import org.springframework.stereotype.Repository;

import com.deepQAWeb.dao.BaseDao;
import com.deepQAWeb.dao.AppkeyTokenDao;

@Repository
public class AppKeyTokenDaoImpl extends BaseDao implements AppkeyTokenDao {

	public String getTopicInfo(String appkey) {
		// TODO Auto-generated method stub
		return (String) getSqlMapClientTemplate().queryForObject("getTokenByAppkey", appkey);
	}

}
