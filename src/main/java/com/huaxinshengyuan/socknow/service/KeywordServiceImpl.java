package com.huaxinshengyuan.socknow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.socknow.domain.Keyword;
import com.huaxinshengyuan.socknow.domain.KeywordSimilarity;
import com.huaxinshengyuan.socknow.domain.relation.RelationType;

@Service("keywordService") @Transactional(readOnly=true)
public class KeywordServiceImpl implements KeywordService {
	@Autowired private Neo4jOperations template;

	@Override @Transactional
	public void addSimmilarity(Keyword k1, Keyword k2, float similarity) {
		KeywordSimilarity keywordSimilarity =template.createRelationshipBetween(k1, k2, KeywordSimilarity.class, RelationType.KeywordSimilarity, false);
		keywordSimilarity.setSimilarity(similarity);
		template.save(keywordSimilarity);
	}
	

}
