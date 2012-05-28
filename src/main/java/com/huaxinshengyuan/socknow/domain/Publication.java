package com.huaxinshengyuan.socknow.domain;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.fieldaccess.DynamicProperties;

import org.springframework.data.neo4j.support.index.IndexType;
import com.huaxinshengyuan.socknow.domain.index.FieldIndex;
import com.huaxinshengyuan.socknow.domain.relation.RelationType;

@SuppressWarnings("serial")
@XmlRootElement(name="publication")
public class Publication extends KnowledgeNode
{

    @Indexed(indexName=FieldIndex.BIBTEX_ID, unique=true) private String bibtexId;
    @Indexed(indexName = FieldIndex.PUBL_FULL_INDEX,fieldName="title",indexType=IndexType.FULLTEXT)
    private String title;
    @Indexed(indexName = FieldIndex.PUBL_FULL_INDEX,fieldName="abs",indexType=IndexType.FULLTEXT)
    private String abs;
    private Date created;
    private Date lastModified;
    private String bib;
    private DynamicProperties dynamicProperties;
    
	@RelatedTo(type=RelationType.UserOwnedPublication, direction = Direction.INCOMING)
    private User user;
	
	@RelatedTo(type=RelationType.UserModifyPublication, direction = Direction.INCOMING)
    private User modifier;

	

	public Publication(){}



	public String getBibtexId() {
		return bibtexId;
	}



	public void setBibtexId(String bibtexId) {
		this.bibtexId = bibtexId;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAbs() {
		return abs;
	}



	public void setAbs(String abs) {
		this.abs = abs;
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



	public String getBib() {
		return bib;
	}



	public void setBib(String bib) {
		this.bib = bib;
	}



	public DynamicProperties getDynamicProperties() {
		return dynamicProperties;
	}



	public void setDynamicProperties(DynamicProperties dynamicProperties) {
		this.dynamicProperties = dynamicProperties;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public User getModifier() {
		return modifier;
	}



	public void setModifier(User modifier) {
		this.modifier = modifier;
	}
    



	

}
