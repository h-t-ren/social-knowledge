package com.huaxinshengyuan.socknow.service;

import org.apache.commons.configuration.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.socknow.domain.Author;
import com.huaxinshengyuan.socknow.domain.Keyword;
import com.huaxinshengyuan.socknow.domain.Publication;
import com.huaxinshengyuan.socknow.domain.PublicationAuthor;
import com.huaxinshengyuan.socknow.domain.PublicationKeyword;
import com.huaxinshengyuan.socknow.domain.enums.AuthorType;
import com.huaxinshengyuan.socknow.domain.oxm.PublicationEntry;
import com.huaxinshengyuan.socknow.domain.relation.RelationType;
import com.huaxinshengyuan.socknow.repo.PublicationRepository;


@Service("publicationService") @Transactional(readOnly=true)
public class PublicationServiceImpl implements PublicationService {
	
	@Autowired private PublicationRepository publicationRepository;
	@Autowired private Neo4jOperations template;
	@Autowired private EntryConfigService entryConfigService;
	
	@Override @Transactional
	public void save(Publication publication) {
		publicationRepository.save(publication);

	}

	@Override @Transactional
	public void addAuthor(Publication publication, Author author, int seq,
			AuthorType authorType, boolean englishName) {
		PublicationAuthor publicationAuthor =template.createRelationshipBetween(publication, author, PublicationAuthor.class, RelationType.AuthorInPublication,false);
		publicationAuthor.setSeq(seq);
		publicationAuthor.setEnglishName(englishName);
		publicationAuthor.setAuthorType(authorType);
		template.save(publicationAuthor);
	}

	@Override @Transactional
	public void addKeyword(Publication publication, Keyword keyword, int seq,
			int importance) {
		PublicationKeyword publicationKeyword =template.createRelationshipBetween(publication, keyword, PublicationKeyword.class, RelationType.PublicationHasKeyword,false);
		publicationKeyword.setSeq(seq);
		publicationKeyword.setImportance(importance);
		template.save(publicationKeyword);
		keyword.setFreq(keyword.getFreq()+1);
		template.save(keyword);
		
	}



}
