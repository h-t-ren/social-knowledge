package com.huaxinshengyuan.socknow.domain;

import java.io.Serializable;

import org.springframework.data.neo4j.annotation.GraphId;

@SuppressWarnings("serial")
public abstract class KnowledgeEntity implements Serializable {

	@GraphId Long id;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		KnowledgeEntity knowledgeNode = (KnowledgeEntity) o;
		if (id == null)
			return super.equals(o);
		return id.equals(knowledgeNode.id);

	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public int hashCode() {

		return id != null ? id.hashCode() : super.hashCode();
	}



}
