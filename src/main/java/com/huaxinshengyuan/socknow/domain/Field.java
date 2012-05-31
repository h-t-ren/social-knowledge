package com.huaxinshengyuan.socknow.domain;

import org.springframework.data.neo4j.annotation.Indexed;

@SuppressWarnings("serial")
public class Field extends KnowledgeNode{

	@Indexed private String field;
	private String description;

	
	public Field(){}
	public Field(String field,String description){
		this.field = field;
		this.description=description;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
