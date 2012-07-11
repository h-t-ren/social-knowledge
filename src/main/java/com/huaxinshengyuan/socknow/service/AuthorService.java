package com.huaxinshengyuan.socknow.service;


import java.util.List;
import com.huaxinshengyuan.socknow.domain.Author;
import com.huaxinshengyuan.socknow.domain.oxm.PublicationEntry;


public interface AuthorService {
	
	public void save(Author author);
	public  Author newInstance();
	public List<Author> findAll();
	public Author findAuthor(Long idAuthor);
	public void addAuthor(PublicationEntry pEntry, Long idAuthor);

}
