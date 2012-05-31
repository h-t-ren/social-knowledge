package com.huaxinshengyuan.socknow.domain;

import java.util.Date;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedTo;
import com.huaxinshengyuan.socknow.domain.relation.RelationType;


@SuppressWarnings("serial")
public class Comment extends KnowledgeNode{
	@RelatedTo(type=RelationType.PublicationHasComment, direction = Direction.INCOMING)
	private Publication publication;
	private String comment;
    @Indexed private Date created;
    private Date lastModified;
	@RelatedTo(type=RelationType.UserCommentOn, direction = Direction.INCOMING)
    private User user;
	@RelatedTo(type=RelationType.ParentComment, direction = Direction.OUTGOING)
	private Comment parent;
	
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public Comment getParent() {
		return parent;
	}
	public void setParent(Comment parent) {
		this.parent = parent;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
