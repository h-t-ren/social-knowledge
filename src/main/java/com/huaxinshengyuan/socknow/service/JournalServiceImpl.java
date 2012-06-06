package com.huaxinshengyuan.socknow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.socknow.domain.Author;
import com.huaxinshengyuan.socknow.domain.Journal;
import com.huaxinshengyuan.socknow.repo.AuthorRepository;
import com.huaxinshengyuan.socknow.repo.JournalRepository;

@Service("journalService") @Transactional(readOnly=true)
public class JournalServiceImpl implements JournalService {
	
	@Autowired private Neo4jOperations template;
	
	@Autowired private JournalRepository journalRepository;

	@Override
	public Journal newInstance() {
		return new Journal();
	}

	@Override  @Transactional
	public void save(Journal journal) {
		journalRepository.save(journal);
		
	}

}
