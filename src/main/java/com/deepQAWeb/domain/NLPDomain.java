/**
* @author hzyuyongmao
* @version 创建时间：2016年9月8日 下午7:22:49
* 类说明
*/
package com.deepQAWeb.domain;

import java.util.List;

public class NLPDomain implements ResponseDataDomain {

	private List<TextClassfiy> textClassify;
	private List<KeywordsDomain> keyword;
	private List<ArticleAbstractDomain> summary;

	public List<TextClassfiy> getTextClassify() {
		return textClassify;
	}

	public void setTextClassify(List<TextClassfiy> textClassify) {
		this.textClassify = textClassify;
	}

	public List<KeywordsDomain> getKeyword() {
		return keyword;
	}

	public void setKeyword(List<KeywordsDomain> keyword) {
		this.keyword = keyword;
	}

	public List<ArticleAbstractDomain> getSummary() {
		return summary;
	}

	public void setSummary(List<ArticleAbstractDomain> summary) {
		this.summary = summary;
	}

}
