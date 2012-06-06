package com.huaxinshengyuan.socknow.service;
import com.huaxinshengyuan.socknow.domain.Author;
import com.huaxinshengyuan.socknow.domain.Journal;


public interface JournalService {
	
	public void save(Journal journal);
	public  Journal newInstance();

}
