package com.huaxinshengyuan.socknow.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.StartNode;

@SuppressWarnings("serial")
public class PublicationField  extends KnowledgeRelation{

	@StartNode private Publication publication;
	@EndNode private Field field;
	@Indexed private String fieldValue;
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	} 
	

}
