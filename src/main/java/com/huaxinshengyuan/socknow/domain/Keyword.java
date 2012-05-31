package com.huaxinshengyuan.socknow.domain;

import java.util.Collection;

import javax.validation.constraints.Size;

import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import com.huaxinshengyuan.socknow.domain.relation.RelationType;


@SuppressWarnings("serial")
public class Keyword extends KnowledgeNode {

   
	@Indexed  
	@Size(min=2,max=64) 
	private String keyword;

	@RelatedToVia(elementClass = KeywordSimilarity.class, type = RelationType.KeywordSimilarity, direction = Direction.BOTH)
	private Iterable<KeywordSimilarity> keywordSimilarities;

	public Keyword(){}
	public Keyword(String keyword){ this.keyword=keyword;}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Collection<KeywordSimilarity> getKeywordSimilarities() {
		return IteratorUtil.asCollection(keywordSimilarities);
	}

 
}
