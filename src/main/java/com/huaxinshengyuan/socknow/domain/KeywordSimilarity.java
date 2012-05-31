package com.huaxinshengyuan.socknow.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.StartNode;


@SuppressWarnings("serial")
public class KeywordSimilarity extends KnowledgeRelation{
	
	@StartNode Keyword keyword1;
	@EndNode Keyword keyword2;
	private float similarity;
	
	public Keyword getKeyword1() {
		return keyword1;
	}
	public void setKeyword1(Keyword keyword1) {
		this.keyword1 = keyword1;
	}
	public Keyword getKeyword2() {
		return keyword2;
	}
	public void setKeyword2(Keyword keyword2) {
		this.keyword2 = keyword2;
	}
	public float getSimilarity() {
		return similarity;
	}
	public void setSimilarity(float similarity) {
		this.similarity = similarity;
	}
	
}
