package com.huaxinshengyuan.socknow.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.StartNode;

import com.huaxinshengyuan.socknow.domain.enums.Permission;


@XmlRootElement(name="userSecurePublication")
@SuppressWarnings("serial")
public class UserSecurePublication extends KnowledgeRelation{

	@StartNode private User user;
	@EndNode private Publication publication;
	private Permission permission;
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
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}

}
