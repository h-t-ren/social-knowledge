package com.huaxinshengyuan.socknow.domain;

import java.util.Date;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.RelatedTo;
import com.huaxinshengyuan.socknow.domain.relation.RelationType;


@SuppressWarnings("serial")
public class Document extends KnowledgeNode {
	
	private Date created;
	private String fileName;
	private String orgName;
	@RelatedTo(elementClass = User.class,type=RelationType.UserOwnedDocument, direction = Direction.INCOMING)
	private User user;
	@RelatedTo(elementClass = Publication.class,type=RelationType.PublicationHasDocument, direction = Direction.INCOMING)
	private Publication publication;
	
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}

		
}
