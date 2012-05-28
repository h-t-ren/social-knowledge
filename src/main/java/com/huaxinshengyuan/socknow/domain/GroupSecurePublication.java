package com.huaxinshengyuan.socknow.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.StartNode;

import com.huaxinshengyuan.socknow.domain.enums.Permission;

@XmlRootElement(name="groupSecurePublication")
@SuppressWarnings("serial")
public class GroupSecurePublication extends KnowledgeRelation{

	@StartNode private Group group;
	@EndNode private Publication publication;
	private Permission permission;

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
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}

}
