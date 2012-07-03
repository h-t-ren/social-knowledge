package com.huaxinshengyuan.socknow.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.StartNode;
@SuppressWarnings("serial")
public class PublicationKeyword extends KnowledgeRelation{

	@StartNode private Publication publication;
	@EndNode private Keyword keyword;
	private int seq;
	private float importance;

	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public Keyword getKeyword() {
		return keyword;
	}
	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public float getImportance() {
		return importance;
	}
	public void setImportance(float importance) {
		this.importance = importance;
	}
	
}
