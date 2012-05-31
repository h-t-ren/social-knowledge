package com.huaxinshengyuan.socknow.domain;

import org.springframework.data.neo4j.annotation.EndNode;

import org.springframework.data.neo4j.annotation.StartNode;

import com.huaxinshengyuan.socknow.domain.enums.AuthorTypes;


@SuppressWarnings("serial")
public class PublicationAuthor  extends KnowledgeRelation {

	@StartNode private Publication publication;
	@EndNode  private Author author;

	private int seq;
	
	//English name?
	private boolean EnglishName;

	private AuthorTypes authorType;
	
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public Publication getPublication() {
		return publication;
	}

	public Author getAuthor() {
		return author;
	}

	public AuthorTypes getAuthorType() {
		return authorType;
	}

	public void setAuthorType(AuthorTypes authorType) {
		this.authorType = authorType;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public boolean isEnglishName() {
		return EnglishName;
	}

	public void setEnglishName(boolean englishName) {
		EnglishName = englishName;
	}
}
