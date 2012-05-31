package com.huaxinshengyuan.socknow.service;

import com.huaxinshengyuan.socknow.domain.Keyword;

public interface KeywordService {

	public void addSimmilarity(Keyword k1,Keyword k2, float similarity);
}
