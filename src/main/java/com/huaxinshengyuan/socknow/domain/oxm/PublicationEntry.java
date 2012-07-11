package com.huaxinshengyuan.socknow.domain.oxm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.huaxinshengyuan.socknow.domain.Author;
import com.huaxinshengyuan.socknow.domain.Document;
import com.huaxinshengyuan.socknow.domain.Journal;
import com.huaxinshengyuan.socknow.domain.Publication;
import com.huaxinshengyuan.socknow.domain.PublicationAuthor;
import com.huaxinshengyuan.socknow.domain.PublicationKeyword;
import com.huaxinshengyuan.socknow.domain.User;



@SuppressWarnings("serial")
public class PublicationEntry implements Serializable{
	
	private String publicationType;
	private List<Field> field;
    private List<PublicationAuthor> publicationAuthors; 
    private Publication parent;
    private User user;
    private Journal journal;
    private String bibtex;
    private String abs;
    private List<Document> documents;
    private  List<PublicationKeyword> publicationKeywords;
    
    private List<Author> authorList = new ArrayList<Author>(0);
	public void setField(List<Field> field) {
		this.field = field;
	}


	public List<Field> getField() {
		return field;
	}


	public void setPublicationType(String publicationType) {
		this.publicationType = publicationType;
	}


	public String getPublicationType() {
		return publicationType;
	}


	public String getBibtex() {
		return bibtex;
	}


	public void setBibtex(String bibtex) {
		this.bibtex = bibtex;
	}


	public List<PublicationAuthor> getPublicationAuthors() {
		return publicationAuthors;
	}


	public void setPublicationAuthors(List<PublicationAuthor> publicationAuthors) {
		this.publicationAuthors = publicationAuthors;
	}


	public Publication getParent() {
		return parent;
	}


	public void setParent(Publication parent) {
		this.parent = parent;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Journal getJournal() {
		return journal;
	}


	public void setJournal(Journal journal) {
		this.journal = journal;
	}


	public String getAbs() {
		return abs;
	}


	public void setAbs(String abs) {
		this.abs = abs;
	}


	public List<Document> getDocuments() {
		return documents;
	}


	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}


	public List<PublicationKeyword> getPublicationKeywords() {
		return publicationKeywords;
	}


	public void setPublicationKeywords(List<PublicationKeyword> publicationKeywords) {
		this.publicationKeywords = publicationKeywords;
	}


	public List<Author> getAuthorList() {
		return authorList;
	}


	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}



}
