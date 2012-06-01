package com.huaxinshengyuan.socknow.domain;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.data.neo4j.annotation.Indexed;
import com.huaxinshengyuan.socknow.domain.enums.Role;

@SuppressWarnings("serial")
@XmlRootElement(name="group")
public class Group extends KnowledgeNode {
	
	@Indexed(unique=true) private String name;
	private String description;
    private Role[] roles;
    

	public Group(){}
	public Group(String name,Role ... role)
	{
		this.name=name;
		this.roles= role;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public Role[] getRoles() {
		return roles;
	}

	public void setRoles(Role[] roles) {
		this.roles = roles;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	


}
