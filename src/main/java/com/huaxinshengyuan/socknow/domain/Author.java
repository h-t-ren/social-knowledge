package com.huaxinshengyuan.socknow.domain;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.huaxinshengyuan.socknow.domain.relation.RelationType;


@SuppressWarnings("serial")
public class Author extends KnowledgeNode {
	
	@Indexed private String firstName;
	@Indexed private String lastName;
	private String preLast;
	private String lineage;
	@Indexed private String institution;
	@Indexed private String otherFirstName;
	@Indexed private String otherLastName;
	
	@RelatedTo(elementClass=Contact.class,type=RelationType.AuthorHasContact,direction=Direction.OUTGOING) @Fetch
	private Contact contact;
		
	
	public Author(){}
	
	public Author(String firstName,String lastName,String institution){
		
		this.firstName=firstName;
		this.lastName =lastName;
		this.institution=institution;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	
	public String getPreLast() {
		return preLast;
	}

	public void setPreLast(String preLast) {
		this.preLast = preLast;
	}

	public String getLineage() {
		return lineage;
	}

	public void setLineage(String lineage) {
		this.lineage = lineage;
	}

	
	
	@Override
	public String toString() {
		return String.format("%s %s", firstName, lastName);
	}

	public String getOtherFirstName() {
		return otherFirstName;
	}

	public void setOtherFirstName(String otherFirstName) {
		this.otherFirstName = otherFirstName;
	}

	public String getOtherLastName() {
		return otherLastName;
	}

	public void setOtherLastName(String otherLastName) {
		this.otherLastName = otherLastName;
	}


	
}
