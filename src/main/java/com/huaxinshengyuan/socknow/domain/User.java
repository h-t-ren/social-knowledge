package com.huaxinshengyuan.socknow.domain;

import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import org.springframework.data.neo4j.template.Neo4jOperations;
import com.huaxinshengyuan.socknow.domain.enums.Role;
import com.huaxinshengyuan.socknow.domain.enums.UserType;
import com.huaxinshengyuan.socknow.domain.index.FieldIndex;
import com.huaxinshengyuan.socknow.domain.relation.RelationType;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;


@SuppressWarnings("serial")
@XmlRootElement(name="user")
public class User extends KnowledgeNode {

    @Indexed(indexName=FieldIndex.LOGIN, unique=true)
    private String login;
    private String name;
	private String password;
    private Role[] roles;
    public User() {}
    public User(String login, String name, String password, Role... role) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.roles = role;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
		this.login = login;
	}
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
		this.password = password;
	}
    public Role[] getRoles() {
        return roles;
    }
	public void setRoles(Role[] roles) {
		this.roles = roles;
	}
	@Override
	 public String toString() {
	        return String.format("%s (%s)", name, login);
	 }
    
	
	/******** Relations************/
	
    @RelatedToVia(type=RelationType.UserInGroup,direction=Direction.OUTGOING)@Fetch
    Iterable<UserInGroup> userInGroups;
    
    public Collection<UserInGroup> getUserInGroups()
    {
    	return IteratorUtil.asCollection(userInGroups);
    }

  
  


}
