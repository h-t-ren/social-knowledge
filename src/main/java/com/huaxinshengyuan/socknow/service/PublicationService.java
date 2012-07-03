package com.huaxinshengyuan.socknow.service;

import com.huaxinshengyuan.socknow.domain.Author;
import com.huaxinshengyuan.socknow.domain.Keyword;
import com.huaxinshengyuan.socknow.domain.Publication;
import com.huaxinshengyuan.socknow.domain.enums.AuthorType;


public interface PublicationService {
	
	public void save(Publication publication);
	public void addAuthor(Publication publication,Author author, int seq, AuthorType authorType, boolean englishName);
	public void addKeyword(Publication publication,Keyword keyword, int seq, int importance);

}
