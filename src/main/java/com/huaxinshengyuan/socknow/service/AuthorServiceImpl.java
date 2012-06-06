package com.huaxinshengyuan.socknow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.socknow.domain.Author;
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

}
