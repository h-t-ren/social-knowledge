package com.huaxinshengyuan.socknow.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.huaxinshengyuan.socknow.domain.Author;
import com.huaxinshengyuan.socknow.domain.oxm.PublicationEntry;
import com.huaxinshengyuan.socknow.repo.AuthorRepository;

@Service("authorService") @Transactional(readOnly=true)
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired private Neo4jOperations template;
	
	@Autowired private AuthorRepository authorRepository;


	@Override @Transactional
	public void save(Author author) {
		authorRepository.save(author);
		
	}

	@Override
	public Author newInstance() {
		return new Author();
	}

	@Override
	public List<Author> findAll() {
		return ListConvertertUtil.convert( authorRepository.findAll());
	}

	@Override
	public Author findAuthor(Long idAuthor) {
	    if(idAuthor==null)
	    {
	    	Author author = new Author();
	    	return author;
	    }
		
	    else return authorRepository.findOne(idAuthor);
		
	}

	@Override
	public void addAuthor(PublicationEntry pEntry, Long idAuthor) {
		pEntry.getAuthorList().add(authorRepository.findOne(idAuthor));
		
	}

}
