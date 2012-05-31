package com.huaxinshengyuan.socknow.domain;

import java.util.Collection;
import java.util.Set;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedTo;
import com.huaxinshengyuan.socknow.domain.relation.RelationType;

@SuppressWarnings("serial")
public class Journal extends KnowledgeNode {
	
	@Indexed private String name;
	@Indexed private String abbreviation;
    @Indexed private String ISSN;
    
	@RelatedTo(elementClass = Publication.class, type = RelationType.JournalHasPublication,direction=Direction.OUTGOING)
    private Set<Publication> publications;
	
	public Journal(){}
	
	public Journal(String abbreviation,String name)
	{
		this.name=name;
		this.abbreviation=abbreviation;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public Collection<Publication> getPublications() {
		return publications;
	}


	public String getISSN() {
		return ISSN;
	}

	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}
}
